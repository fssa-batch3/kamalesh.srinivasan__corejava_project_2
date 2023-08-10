package needsToBeDone.services;

import needsToBeDone.services.exceptions.ServiceException;

public class TestListJobs {
	public static void main(String[] args) {
                  try {
        	 JobService jobService = new JobService();
			jobService.listJobs("128718a6-b34c-4557-abb6-61f5175d8a85");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	
}

