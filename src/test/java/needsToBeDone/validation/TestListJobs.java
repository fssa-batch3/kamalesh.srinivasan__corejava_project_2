package needsToBeDone.validation;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import needsToBeDone.services.JobService;
import needsToBeDone.services.exceptions.ServiceException;

public class TestListJobs {

	@Test
	public void testValidListData(){
		try {
       	 JobService jobService = new JobService();
		   assertTrue(jobService.listJobs("128718a6-b34c-4557-abb6-61f5175d8a85"));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	
	@Test
	public void testInvalidJobId(){
		try {
       	 JobService jobService = new JobService();
		   assertFalse(jobService.listJobs("128718a6-b34c-4557-abb6-61f5175d8a85dfs"));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}	
}
