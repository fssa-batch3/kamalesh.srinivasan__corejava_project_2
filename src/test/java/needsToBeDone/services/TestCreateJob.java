package needsToBeDone.services;

import needsToBeDone.model.Job;

public class TestCreateJob {
	public static void main(String[] args) {

		Job job1 = new Job("FrontEnd", "trichy", 200000, "test.test.test", "test.test.test", "test.test.test","kamalesh@gmail.com");
	JobService jobService = new JobService();

		try {
			jobService.createJob(job1);

		} catch (Exception e) {
			e.printStackTrace(); 
			

		}

	}
}
