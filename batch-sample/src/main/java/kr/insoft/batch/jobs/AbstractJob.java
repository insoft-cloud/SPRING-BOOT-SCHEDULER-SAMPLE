package kr.insoft.batch.jobs;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.insoft.batch.util.SingleTaskManageMap;

public abstract class AbstractJob<I, O, R> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private long startTime = 0L;
	private long endTime = 0L;
	
	protected String batchName;
	
	private I readedItem = null;
	private O convertedItem = null;
	private R resultItem = null;
	
	private int totalCount = 0;
	
	/**
	 * Batch Job 시작 로그 출력 
	 */
	protected void printStart() {
		startTime = System.currentTimeMillis();
		logger.debug("// Class Full Name : " + this.getClass().getName());
		logger.info("################################################################################");
		logger.info("{} Start!!!\n", batchName);
	}
	
	/**
	 * Batch Job 결과 건수 로그를 출력한다.
	 */
	protected void printResult(int successCount, int failureCount) {
		if (readedItem instanceof Collection) {
			totalCount = ((Collection) readedItem).size();
			
			logger.info("--------------------------------------------------------------------------------");
			logger.info("대상: {}건 중 성공: {}건, 실패: {}건", totalCount, successCount, failureCount);
			logger.info("--------------------------------------------------------------------------------");
		}
	}
	
	/**
	 * Batch Job 종료 로그를 출력한다.
	 */
	protected void printEnd() {
		endTime = System.currentTimeMillis();
		
		logger.info("Start Time: {}", new Timestamp(startTime));
		logger.info("End Time: {}", new Timestamp(endTime));
		logger.info("Processing Time: {} seconds\n", ((endTime - startTime) / 1000.0));
		logger.info("{} End!!!", batchName);
		logger.info("################################################################################\n\n");
	}
	
	/**
	 * 배치를 실행한다.
	 * @param batchName - 배치명
	 */
	public void run(String batchName) throws Exception {
		run(batchName, false);
	}
	
	/**
	 * 배치를 실행한다.
	 * @param batchName - 배치명
	 * @param isWrite - 쓰기 전용 여부, true 일 경우 read 에서 조회된 값이 없어도 실행
	 */
	@SuppressWarnings("unchecked")
	public void run(String batchName, boolean isWrite) throws Exception {
		SingleTaskManageMap manageMap = SingleTaskManageMap.getInstance();
		
		try {
			this.batchName = batchName;
			
			// 배치 중복 실행 방지 체크
			if(this.duplicateTaskCheck(manageMap)) {
				logger.info("[ " + batchName + " ] 기 실행 중인 배치가 있습니다.");
				return;
			}
			
			this.printStart();
			
			readedItem = this.read();
			
			// 배치 처리할 대상 데이터가 없으면 종료 
			if (isWrite || (readedItem != null && !((Collection<Map<String, Object>>) readedItem).isEmpty())) {
				convertedItem = this.process(readedItem);
				
				resultItem = this.write(convertedItem);
				
				this.notify(resultItem);
			} else {
				logger.info("처리할 데이터가 없습니다.\n");
			}
			
			this.printEnd();
		} catch (Exception e) {
			throw e;
		} finally {
			this.turnOffDuplicateTask(manageMap);
		}
	}
	
	/**
	 * 현재 인스턴스 내에서 중복 실행 방지 체크
	 * Job Class 에 @SingleTask 체크해서 현재 실행 중인지 체크
	 * @param manageMap
	 * @return
	 */
	private boolean duplicateTaskCheck(SingleTaskManageMap manageMap) {
		String taskClassName = this.getClass().getName();
		Object objSingleTask = manageMap.get(taskClassName);
		if(objSingleTask != null && Boolean.parseBoolean(objSingleTask.toString())) {
			return true;
		}
		
		manageMap.put(taskClassName, true);
		return false;
	}
	
	private void turnOffDuplicateTask(SingleTaskManageMap manageMap) {
		String taskClassName = this.getClass().getName();
		Object objSingleTask = manageMap.get(taskClassName);
		if(objSingleTask != null) {
			manageMap.put(taskClassName, false);
		}
	}
	
	/**
	 * 배치 처리할 항목을 조회한다.
	 * @return 배치 처리를 위해 조회한 항목
	 * @throws Exception
	 */
	public abstract I read() throws Exception;
	
	/**
	 * 조회한 항목을 실제 데이터 처리를 위해 변환한다. 
	 * 변환할 데이터가 없으면 아무 처리 하지 않아도 된다.
	 * 
	 * @param readedItem - 조회한 항목
	 * @return 변환된 항목
	 * @throws Exception
	 */
	public abstract O process(I readedItem) throws Exception;

	/**
	 * 변환된 항목으로 배치를 처리하고, 그 결과를 조회한다.
	 * @param convertedItem - 변환된 항목
	 * @return 처리결과 항목
	 * @throws Exception
	 */
	public abstract R write(O convertedItem) throws Exception;
	
	/**
	 * 배치처리결과를 노티한다.
	 * @param resultItem - 배치처리결과 항목
	 * @throws Exception
	 */
	public abstract void notify(R resultItem) throws Exception;
}
