package com.fssa.needstobedone.model;

/**
 * The Job class represents job-related data.
 */
public class Job {

	private String title;
	private String location;
	private int price;
	private String description;
	private String summary;
	private String qualification;
	private String responsibilities;
	private int userId;
	private String jobid;
	private Boolean isDeleted;
	private String status;
	private String createdDate;

	/**
	 * Default constructor for the Job class.
	 */
	public Job() {
		// Default Constructor
	}

	/**
	 * Constructs a new Job with the specified title, location, price, description,
	 * summary, qualification, responsibilities, and email.
	 *
	 * @param title            The title of the job.
	 * @param location         The location of the job.
	 * @param price            The price of the job.
	 * @param description      The description of the job.
	 * @param summary          The summary of the job.
	 * @param qualification    The qualifications required for the job.
	 * @param responsibilities The responsibilities of the job.
	 * @param email            The email associated with the job.
	 */
	public Job(String title, String location, int price, String description, String summary, String qualification,
			String responsibilities, int userId) {
		this.title = title;
		this.location = location;
		this.price = price;
		this.description = description;
		this.summary = summary;
		this.qualification = qualification;
		this.responsibilities = responsibilities;
		this.userId = userId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the job location.
	 *
	 * @return The job location.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the job location.
	 *
	 * @param location The job location to set.
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the job description.
	 *
	 * @return The job description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the job description.
	 *
	 * @param description The job description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the job summary.
	 *
	 * @return The job summary.
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * Sets the job summary.
	 *
	 * @param summary The job summary to set.
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * Gets the job qualification.
	 *
	 * @return The job qualification.
	 */
	public String getQualification() {
		return qualification;
	}

	/**
	 * Sets the job qualification.
	 *
	 * @param qualification The job qualification to set.
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	/**
	 * Gets the job responsibilities.
	 *
	 * @return The job responsibilities.
	 */
	public String getResponsibilities() {
		return responsibilities;
	}

	/**
	 * Sets the job responsibilities.
	 *
	 * @param responsibilities The job responsibilities to set.
	 */
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Job [title=" + title + ", location=" + location + ", price=" + price + ", description=" + description
				+ ", summary=" + summary + ", qualification=" + qualification + ", responsibilities=" + responsibilities
				+ ", userId=" + userId + ", jobid=" + jobid + ", isDeleted=" + isDeleted + ", status=" + status + "]";
	}

}
