package needsToBeDone.services;

import com.fssa.needstobedone.exception.ServiceException;
import com.fssa.needstobedone.model.Job;
import com.fssa.needstobedone.services.JobService;

public class TestDeleteJob {
	public static void main(String[] args) {
		try {
			JobService jobService = new JobService();
			Job job1 = new Job("128718a6-b34c-4557-abb6-61f5175d8a85", true);
			jobService.DeleteJobs(job1);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
