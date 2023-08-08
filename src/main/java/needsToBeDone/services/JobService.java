package needsToBeDone.services;

import needsToBeDone.DAO.JobDAO;
import needsToBeDone.DAO.exceptions.DAOException;
import needsToBeDone.model.Job;
import needsToBeDone.services.exceptions.ServiceException;
import needsToBeDone.validation.JobValidator;
import needsToBeDone.validation.exceptions.InvalidUserException;


public class JobService {
	public boolean createJob(Job job) throws ServiceException {
		JobDAO jobDAO = new JobDAO();
		try {
			JobValidator.validateJob(job);
			if (jobDAO.createJob(job)) {
				System.out.println(job.getTitle() + " Successfully created!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}
	
	public boolean listJobs(String id) throws ServiceException{
		JobDAO jobDAO = new JobDAO();
		try {

			if (jobDAO.ListJobs(id)){
				System.out.println("Job Found");
				return true;
			} else {
				return false;
			}

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	
	public boolean UpdateJobs(Job job) throws ServiceException {
		JobDAO jobDAO = new JobDAO();
		try {
			JobValidator.validateJobid(job.getJobid());
			if (jobDAO.createJob(job)) {
				System.out.println(job.getTitle() + " Successfully created!");
				return true;
			} else {
				return false;
			}

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
