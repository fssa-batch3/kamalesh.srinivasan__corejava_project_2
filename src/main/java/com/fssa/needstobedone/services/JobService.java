package com.fssa.needstobedone.services;

import java.util.List;

import com.fssa.needstobedone.dao.JobDAO;
import com.fssa.needstobedone.exception.DAOException;
import com.fssa.needstobedone.exception.ServiceException;
import com.fssa.needstobedone.exception.ValidationException;
import com.fssa.needstobedone.model.AllModal;
import com.fssa.needstobedone.model.Job;
import com.fssa.needstobedone.validation.JobValidator;

/**
 * The JobService class provides business logic for job-related operations.
 */
public class JobService {

	JobValidator jobValidator = new JobValidator();

	/**
	 * Creates a new job.
	 *
	 * @param job The job to be created.
	 * @return true if the job is created successfully, false otherwise.
	 * @throws ServiceException If there is an issue creating the job.
	 */
	public boolean createJob(Job job) throws ServiceException { 
		JobDAO jobDAO = new JobDAO();
		try {
			jobValidator.validateJob(job);
			jobDAO.createJob(job);
			return true;
		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		} 
	}

	/**
	 * Lists a job by its ID.
	 *
	 * @param id The ID of the job to be listed.
	 * @return The job with the specified ID.
	 * @throws ServiceException If there is an issue listing the job.
	 */
	public Job listJobsByJobId(String id) throws ServiceException {
		JobDAO jobDAO = new JobDAO();
		try {
			List<Job> result = jobDAO.listJobsByJobId(id);
			if(!result.isEmpty()) {
 			return result.get(0);
			}else {
				throw new ServiceException("No job found");
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Lists jobs by email.
	 *
	 * @param email The email associated with the jobs to be listed.
	 * @return A list of jobs associated with the specified email.
	 * @throws ServiceException If there is an issue listing the jobs.
	 */
	public List<Job> listJobsByUserId(String id) throws ServiceException {
		JobDAO jobDAO = new JobDAO();
		try {
			List<Job> result = jobDAO.listJobs(id);
			if (result != null && !result.isEmpty()) {
				return result;
			} else {
				throw new DAOException("No Jobs Found");
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Updates a job.
	 *
	 * @param job The job to be updated.
	 * @return true if the job is updated successfully, false otherwise.
	 * @throws ServiceException If there is an issue updating the job.
	 */
	public boolean updateJobs(Job job) throws ServiceException {
		JobDAO jobDAO = new JobDAO();
		try {
			jobValidator.validateJob(job);
			if (!jobDAO.checkJobId(job.getJobid())) {
				throw new DAOException("JobId is not valid");
			}
			jobDAO.updateJob(job);
			return true;
		} catch (DAOException | ValidationException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	/**
	 * Deletes a job by its ID.
	 *
	 * @param jobId The ID of the job to be deleted.
	 * @return true if the job is deleted successfully, false otherwise.
	 * @throws ServiceException If there is an issue deleting the job.
	 */
	public boolean deleteJobs(String jobId) throws ServiceException {
		JobDAO jobDAO = new JobDAO();
		try {
			if (!jobDAO.checkJobId(jobId)) {
				throw new DAOException("Job id is not exists");
			}
			jobDAO.deleteJob(jobId);
			return true;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}

	public List<Job> listAllJobs() throws ServiceException {
		JobDAO jobDAO = new JobDAO();
		try {
			List<Job> result = jobDAO.listAllJobs();
			if (result != null && !result.isEmpty()) {
				return result;
			} else {
				throw new DAOException("No Jobs Found");
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	
	public List<AllModal> jobStatusList(String id) throws ServiceException {
		JobDAO jobDAO = new JobDAO();
		try {
			List<AllModal> result = (List<AllModal>) jobDAO.jobApplierList(id);
			if (result != null && !result.isEmpty()) {
				return result;
			} else {
				throw new DAOException("NO application for this job");
			}
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
