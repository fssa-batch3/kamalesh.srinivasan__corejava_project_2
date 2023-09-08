package com.fssa.needstobedone.model;

/**
 * The Job class represents job-related data.
 */
public class Job {

	private String title;
	private int price;
	private String email;
	private String jobid;
	private Boolean isDeleted;

	/**
	 * Default constructor for the Job class.
	 */
	public Job() {
		// Default Constructor
	}

	/**
	 * Constructs a new Job with the specified title, price, and email.
	 *
	 * @param title The title of the job.
	 * @param price The price of the job.
	 * @param email The email associated with the job.
	 */
	public Job(String title, int price, String email) {
		this.title = title;
		this.price = price;
		this.email = email;
	}

	/**
	 * Constructs a new Job with the specified price, job ID, and title.
	 *
	 * @param price The price of the job.
	 * @param jobid The unique job ID.
	 * @param title The title of the job.
	 */
	public Job(int price, String jobid, String title) {
		this.title = title;
		this.price = price;
		this.jobid = jobid;
	}

	/**
	 * Gets the value of the "isDeleted" flag, indicating whether the job is
	 * deleted.
	 *
	 * @return true if the job is deleted, false otherwise.
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	/**
	 * Sets the "isDeleted" flag to indicate whether the job is deleted.
	 *
	 * @param isDeleted true if the job is deleted, false otherwise.
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * Gets the job ID.
	 *
	 * @return The job ID.
	 */
	public String getJobid() {
		return jobid;
	}

	/**
	 * Sets the job ID.
	 *
	 * @param jobid The job ID to set.
	 */
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	/**
	 * Gets the job title.
	 *
	 * @return The job title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the job title.
	 *
	 * @param title The job title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the job price.
	 *
	 * @return The job price.
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Sets the job price.
	 *
	 * @param price The job price to set.
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Gets the email associated with the job.
	 *
	 * @return The email associated with the job.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email associated with the job.
	 *
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Generates a string representation of the Job object.
	 *
	 * @return A string representation of the Job object.
	 */
	@Override
	public String toString() {
		return "Job [title=" + title + ", price=" + price + ", email=" + email + ", jobid=" + jobid + ", isDeleted="
				+ isDeleted + "]";
	}
}
