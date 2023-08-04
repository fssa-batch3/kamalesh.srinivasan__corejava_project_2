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
}
