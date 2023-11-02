package com.fssa.needsToBeDone.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


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

//	@Test
//	void testCreateValidJob() {
//		int num = (char) System.nanoTime();
//		Job validJob = new Job("FrontEnd"+num, "chennai", 10000, "develop a frontend for a project", "develop a frontend for a project", "develop a frontend for a project", "develop a frontend for a project", 5);
//		try {
//			assertTrue(jobService.createJob(validJob));
//		} catch (ServiceException e) {
//			fail("ServiceException occurred: " + e.getMessage());
//		}
//	}
//
//	@Test 
//	void testCreateInvalidJob() {
//		char num = (char) System.nanoTime();
//		Job invalidJob = new Job("FrontEnd"+num, "chennai", 10000, "develop a frontend for a project", "develop a frontend for a project", "develop a frontend for a project", "develop a frontend for a project", -10);
//		ServiceException result = assertThrows(ServiceException.class, () -> jobService.createJob(invalidJob));
//		assertEquals("Email is not found", result.getMessage());
//	}
 
	@Test
	void testListValidJobs() {
		String validJobId = "6c24043f-789f-11ee-8616-02420a00009l";
		try {
			Job result = jobService.listJobsByJobId(validJobId);
			assertNotNull(result);
		} catch (ServiceException e) {
			fail("ServiceException occurred: " + e.getMessage());
		}

	}

	@Test
	void testListInvalidJobs() {
		String invalidJobId = "0bdfa607-c773-4705-a379-c1e9b4f2b281InvalidJobId";
		ServiceException result = assertThrows(ServiceException.class, () -> jobService.listJobsByJobId(invalidJobId));
		assertEquals("No job found", result.getMessage());
	}

	@Test
	void testUpdateValidJob() {
		Job validJobToUpdate = new Job("FE", "chennai", "affc80d1-1bcc-43da-ad06-415ac59f5a86",1000,"UpdatedJob", "UpdatedJob", "UpdatedJob", "UpdatedJob", 0,"Not started");
		System.out.println(validJobToUpdate);
		try {
			assertTrue(jobService.updateJobs(validJobToUpdate));
		} catch (ServiceException e) {
			fail("ServiceException occurred: " + e.getMessage());
		}
	}

	@Test
	void testUpdateInvalidJob() {
		Job invalidJobToUpdate = new Job("FE", "Chennai", 1000, "0bdfa607-c773-4705-a379-c1e9b4f2b281invalidJobToUpdate", "UpdatedJob", "UpdatedJob", "UpdatedJob", 0);
		ServiceException result = assertThrows(ServiceException.class, () -> jobService.updateJobs(invalidJobToUpdate));
		assertEquals("JobId is not valid", result.getMessage());
	}

	@Test
	void testDeleteValidJob() {
		String validJobIdToDelete = "04b20d6c-7373-41b2-b46e-6c265eb19f9d";
		try {
			assertTrue(jobService.deleteJobs(validJobIdToDelete));
		} catch (ServiceException e) {
			fail("ServiceException occurred: " + e.getMessage());
		}
	}

	@Test
	void testDeleteInvalidJob() {
		String invalidJobIdToDelete = "0bdfa607-c773-4705-a379-c1e9b4f2b281InvalidJobId";
		ServiceException result = assertThrows(ServiceException.class,
				() -> jobService.deleteJobs(invalidJobIdToDelete));
		System.out.println(result.getMessage());
		assertEquals("Job id is not exists", result.getMessage());

	}




}
