package needsToBeDone.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.needstobedone.model.Job;
import com.fssa.needstobedone.services.JobService;

public class TestCreateJob {
	@Test
	public void testvalidCreateJob() {

		Job job1 = new Job("SoftwareDevelopment", 200000, "kikamakles@gmail.com");
		JobService jobService = new JobService();

		try {
			assertTrue(jobService.createJob(job1));

		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}

	}

	@Test
	public void testInvalidEmail() {
		Job job1 = new Job("SoftwareDevelopment", 200000, "kik@gmail.com");
		JobService jobService = new JobService();

		try {
			assertFalse(jobService.createJob(job1));

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testInvalidTitle() {

		Job job1 = new Job("Software Development346345", 200000, "kikamakles@gmail.com");
		JobService jobService = new JobService();

		try {
			assertTrue(jobService.createJob(job1));

		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}

	}

	@Test
	public void testInvalidPrice() {

		Job job1 = new Job("Software Development346345", 2000000, "kikamakles@gmail.com");
		JobService jobService = new JobService();

		try {
			assertTrue(jobService.createJob(job1));

		} catch (Exception e) {
			e.printStackTrace();
			fail();

		}

	}
}
