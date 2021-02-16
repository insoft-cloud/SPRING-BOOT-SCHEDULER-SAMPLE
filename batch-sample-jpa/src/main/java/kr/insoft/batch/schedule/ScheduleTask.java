package kr.insoft.batch.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.insoft.batch.jobs.sample.*;

/**
 * 배치 스케줄을 등록하는 클래스.
 * 
 * cron : cron표현식을 지원한다. "초 분 시 일 월 주 (년)"으로 표현한다. cron표현식에 쓸 수 있는 것들(특수문자 활용 포함)이 많은데 해당 내용이 핵심이 아니므로 다른 블로그에서 확인해보기를 바란다.
 * fixedDelay : milliseconds 단위로, 이전 작업이 끝난 시점으로 부터 고정된 시간을 설정한다. ex) fixedDelay = 5000
 * fixedDelayString : fixedDelay와 같은데 property의 value만 문자열로 넣는 것이다. ex) fixedDelay = "5000"
 * fixedRate : milliseconds 단위로, 이전 작업이 수행되기 시작한 시점으로 부터 고정된 시간을 설정한다. ex) fixedRate = 3000
 * fixedRateString : fixedDelay와 같은데 property의 value만 문자열로 넣는 것이다. ex) fixedRate = "3000"
 * initialDelay : 스케줄러에서 메서드가 등록되자마자 수행하는 것이 아닌 초기 지연시간을 설정하는 것이다.
 * initialDelayString : 위와 마찬가지로 문자열로 값을 표현하겠다는 의미다.
 * zone : cron표현식을 사용했을 때 사용할 time zone으로 따로 설정하지 않으면 기본적으로 서버의 time zone이다.
 * 
 * @author smlee
 *
 */
@Component
public class ScheduleTask {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SampleJob sampleJob;

	@Autowired
	private SampleJob2 sampleJob2;

	@Scheduled(fixedDelay = 5000)
	public void fixedDelay() {
		logger.debug(new StringBuilder().append("///[fixedDelay] The time is ").append((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(new Date())).toString());
	}
	
	/**
	 * 샘플 배치 실행 
	 * - 매 5분마다 실행
	 * @throws Exception
	 */
	@Scheduled(cron = "0 */2 * * * *")
	public void sampleScheduleTask() throws Exception {
		sampleJob.run("샘플 배치 실행", true);
	}
	
	/**
	 * 샘플 배치 실행 
	 * - 매 5분마다 실행
	 * @throws Exception
	 */
	@Scheduled(cron = "0 */5 * * * *")
	public void sampleScheduleTask2() throws Exception {
		sampleJob2.run("샘플 배치2 실행", true);
	}
}
