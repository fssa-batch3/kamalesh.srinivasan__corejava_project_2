package com.fssa.needstobedone.services;

import java.util.List;

import com.fssa.needstobedone.dao.JobDAO;
import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.exception.ServiceException;
import com.fssa.needstobedone.exception.ValidationException;
import com.fssa.needstobedone.model.Job;
import com.fssa.needstobedone.validation.JobValidator;

public class JobService {
	public boolean createJob(Job job) throws ServiceException {
		JobDAO jobDAO = new JobDAO();
		try {
			JobValidator.validateJob(job);
			if(!jobDAO.checkEmail(job.getEmail())) {
				throw new DAOException("Email is not found");
			}
			jobDAO.createJob(job);
			return true;
		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e.getMessage()); 
		}
	}

	public Job listJobs(String id) throws ServiceException {
		JobDAO jobDAO = new JobDAO();

		try {
			Job result = jobDAO.listJobs(id);
			jobDAO.checkJobId(id);
			return result;

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public List<Job> listJobsByEmail(String email) throws ServiceException {
		JobDAO jobDAO = new JobDAO();

		try {
			List<Job> result = jobDAO.listJobsByEmail(email); 
			if (result != null && !result.isEmpty()) {
				return result;
			} else {
				throw new DAOException("No Jobs Found");
			} 

		} catch (DAOException e) {
            e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}

	public boolean updateJobs(Job job) throws ServiceException {
		JobDAO jobDAO = new JobDAO();
		try { 
 
			JobValidator.validateJob(job);
			if(!jobDAO.checkJobId(job.getJobid())) {
				throw new DAOException("JobId is not valid");
			}
			jobDAO.updateJob(job); 
			return true;

		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public boolean deleteJobs(String jobId) throws ServiceException {
		JobDAO jobDAO = new JobDAO();

		try {
			if(!jobDAO.checkJobId(jobId)) {
				throw new DAOException("Job id is not exists");
			}
			jobDAO.deleteJob(jobId);
			return true;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
}