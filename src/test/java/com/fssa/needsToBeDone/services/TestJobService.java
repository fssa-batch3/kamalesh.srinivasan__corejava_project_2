package com.fssa.needsToBeDone.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.needstobedone.exception.ServiceException;
import com.fssa.needstobedone.model.Job;
import com.fssa.needstobedone.services.JobService;

class TestJobService {

	private JobService jobService;

	@BeforeEach
	void setUp() { 
		jobService = new JobService();
	}

	@Test
	void testCreateValidJob() {
		Job validJob = new Job("FrontEnd", 200000, "kishor@gmail.com");
		try {
			assertTrue(jobService.createJob(validJob));
		} catch (ServiceException e) {
			fail("ServiceException occurred: " + e.getMessage());
		}
	}

	@Test 
	void testCreateInvalidJob() {
		Job invalidJob = new Job("FrontEnd", 200000, "kamaleshInvalidE.srinivasan@fssa.freshworks.com");
		ServiceException result = assertThrows(ServiceException.class, () -> jobService.createJob(invalidJob));
		assertEquals("Email is not found",result.getMessage());
	} 

	@Test
	void testListValidJobs() {
		String validJobId = "08b09556-5de1-4b9e-bbd8-1d7fddd7809c";
		try {
			Job result = jobService.listJobs(validJobId);
			assertNotNull(result);
		} catch (ServiceException e) {
			fail("ServiceException occurred: " + e.getMessage());
		}
		
	}

	@Test
	void testListInvalidJobs() {
		String invalidJobId = "0bdfa607-c773-4705-a379-c1e9b4f2b281InvalidJobId";			
			ServiceException result = assertThrows(ServiceException.class, () -> jobService.listJobs(invalidJobId));
			assertEquals("Job Not Found",result.getMessage());
	}

	@Test
	void testUpdateValidJob() {
		Job validJobToUpdate = new Job(1000,"08b09556-5de1-4b9e-bbd8-1d7fddd7809c","UpdatedJob");
		try {
			assertTrue(jobService.updateJobs(validJobToUpdate));
		} catch (ServiceException e) {
			fail("ServiceException occurred: " + e.getMessage());
		}
	} 

	@Test
	void testUpdateInvalidJob() {
		Job invalidJobToUpdate = new Job(1000,"0bdfa607-c773-4705-a379-c1e9b4f2b281invalidJobToUpdate","UpdatedJob");
		ServiceException result = assertThrows(ServiceException.class, () -> jobService.updateJobs(invalidJobToUpdate));
		assertEquals("JobId is not valid",result.getMessage());
	}

	@Test
    void testDeleteValidJob() {
        String validJobIdToDelete = "0bdfa607-c773-4705-a379-c1e9b4f2b281";
        try {
            assertTrue(jobService.deleteJobs(validJobIdToDelete));
        } catch (ServiceException e) {
            fail("ServiceException occurred: " + e.getMessage());
        }
    }

	@Test
    void testDeleteInvalidJob() {
        String invalidJobIdToDelete = "0bdfa607-c773-4705-a379-c1e9b4f2b281InvalidJobId";
    		ServiceException result = assertThrows(ServiceException.class, () -> jobService.deleteJobs(invalidJobIdToDelete));
    		System.out.println(result.getMessage());
    		assertEquals("Job id is not exists",result.getMessage());
        
    }
	
	@Test 
	void testListValidJobsByEmail() {
		String validEmail = "kamalesh.srinivasan@fssa.freshworks.com";
		try {
			List<Job> result = jobService.listJobsByEmail(validEmail);
			assertNotNull(result);
		} catch (ServiceException e) {
			fail("ServiceException occurred: " + e.getMessage());
		}
		
	} 
	
	
	@Test
	void testListInvalidJobsbyEmail() {
		String invalidEmail = "invalidemail@fssa.freshworks.com";			
			ServiceException result = assertThrows(ServiceException.class, () -> jobService.listJobsByEmail(invalidEmail));
			assertEquals("No Jobs Found",result.getMessage());
	}
	
	
}
