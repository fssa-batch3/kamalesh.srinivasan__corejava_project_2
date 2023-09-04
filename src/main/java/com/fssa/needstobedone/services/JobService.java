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
			if (result != null) {
				return result;
			} else {
				throw new ServiceException("No Jobs Found");
			}

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	
	public List<Job> listJobsByEmail(String email) throws ServiceException {
		JobDAO jobDAO = new JobDAO();

		try {
			List<Job> result = jobDAO.listJobsByEmail(email);
			if (result != null) {
				return result;
			} else {
				throw new ServiceException("No Jobs Found");
			}

		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public boolean UpdateJobs(Job job) throws ServiceException {
		JobDAO jobDAO = new JobDAO();
		try {
			
			JobValidator.validateJobid(job.getJobid());
			jobDAO.updateJob(job);
			return true;

		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public boolean DeleteJobs(String jobId) throws ServiceException {
		JobDAO jobDAO = new JobDAO();

		try {
			JobValidator.validateJobid(jobId);
			jobDAO.deleteJob(jobId);
			return true;
		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e);
		}
	}
}
