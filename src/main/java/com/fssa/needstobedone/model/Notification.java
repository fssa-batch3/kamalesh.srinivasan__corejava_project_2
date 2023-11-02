package com.fssa.needstobedone.model;

public class Notification {
	private int applierId;
	private String jobId;
	private String status;
	private int notificationId;

	// Constructors
	public Notification() {
		// Default constructor
	}



	// Getters and Setters
	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public int getApplierId() {
		return applierId;
	}

	public void setApplierId(int applierId) {
		this.applierId = applierId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
