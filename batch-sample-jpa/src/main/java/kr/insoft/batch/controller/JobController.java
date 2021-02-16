package kr.insoft.batch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.insoft.batch.jobs.sample.*;

@RestController
@RequestMapping("job")
public class JobController {

	@Autowired
	private SampleJob sampleJob;

	@Autowired
	private SampleJob2 sampleJob2;

	@RequestMapping(value = "/sampleJob")
	public void runSampleJob() throws Exception {
		sampleJob.run("샘플배치 수동 실행", true);
	}

	@RequestMapping(value = "/sampleJob2")
	public void runSampleJob2() throws Exception {
		sampleJob2.run("샘플배치2 수동 실행", true);
	}
}
