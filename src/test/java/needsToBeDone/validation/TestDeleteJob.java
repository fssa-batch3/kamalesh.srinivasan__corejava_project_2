package needsToBeDone.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import com.fssa.needstobedone.exception.ServiceException;
import com.fssa.needstobedone.model.Job;
import com.fssa.needstobedone.services.JobService;

public class TestDeleteJob {
	@Test
	public void testInvalidjobId() {
		try {
			JobService jobService = new JobService();
			Job job1 = new Job("128718a6-b34c-4557-abb6-61f5175d8a85ff", true);
			assertFalse(jobService.DeleteJobs(job1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testValidDeleteJob() {
		try {
			JobService jobService = new JobService();
			Job job1 = new Job("246ff3e6-ed4e-4b92-a920-d7b190cc8b6b", true);
			assertTrue(jobService.DeleteJobs(job1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
}
