# BATCH-SAMPLE
  배치 서비스를 위한 기본 스케줄러 샘픔.
  
## 개발 환경
- JDK 11
- Gradle 6.7.1
- Spring Boot 2.4.2

## 패키지 설명

### kr.insoft.batch.annotation
- 프로젝트 내에서 사용하는 Annotation 등록 패키지.
- SingleTask 는 동일한 배치가 중복 실행이 되지 않도록 사용되는 Annotation

### kr.insoft.batch.controller
- 외부에서 임의로 배치를 실행 시킬경우 호출되는 controller

### kr.insoft.batch.jobs
- 배치 업무 별로 구분되어 실제 실행되는 job 등록 패키지

### kr.insoft.batch.schedule
- JOB 에 대한 스케줄 등록 클래스(ScheduleTask.java)

### kr.insoft.batch.util
- 프로젝트 내에서 공통으로 사용되는 util

## 동작 설명
1. BatchSampleApplication 에서 배치가 동시에 중복되지 말아야할 job 들을 스캔한다.
2. ScheduleTask.java 에서 각 job 들의 스케쥴을 관리한다.
3. 처리되어야 할 job 들은 kr.insoft.batch.jobs 하위에 있으며 AbstractJob 를 상속해야 한다.
4. 주기적인 실행 외에 개별 실행시에는 jobController.java 내의 api 를 구현해서 사용 할 수 있다.