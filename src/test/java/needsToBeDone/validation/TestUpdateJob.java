package needsToBeDone.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import needsToBeDone.model.Job;
import needsToBeDone.services.JobService;
import needsToBeDone.services.exceptions.ServiceException;

public class TestUpdateJob {

	@Test
	public void testInvalidjobId() {
		try {
			JobService jobService = new JobService();
			Job job1 = new Job(10000, "128718a6-b34c-4557-abb6-61f5175d8a85ff", "Updated");

			assertFalse(jobService.UpdateJobs(job1));

		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidUpdateJob() {
		try {
			JobService jobService = new JobService();
			Job job1 = new Job(10000, "128718a6-b34c-4557-abb6-61f5175d8a85", "UpdatedNew");

			assertFalse(jobService.UpdateJobs(job1));

		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
