package needsToBeDone.services;

import com.fssa.needstobedone.model.Job;
import com.fssa.needstobedone.services.JobService;

public class TestCreateJob {
	public static void main(String[] args) {

		Job job1 = new Job("FrontEnd", 200000, "kikamakles@gmail.com");
		JobService jobService = new JobService();

		try {
			jobService.createJob(job1);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
