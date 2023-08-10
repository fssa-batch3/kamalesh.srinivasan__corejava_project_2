package needsToBeDone.services;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import needsToBeDone.model.Job;

public class TestCreateJob {
	public static void main(String[] args) {

		Job job1 = new Job("FrontEnd",200000, "kikamakles@gmail.com");
	JobService jobService = new JobService();

		try {
			jobService.createJob(job1);

		} catch (Exception e) {
			e.printStackTrace(); 
			

		}

	}
	

	
	
	
	
	


}


