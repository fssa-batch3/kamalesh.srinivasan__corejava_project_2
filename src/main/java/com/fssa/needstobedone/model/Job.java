package com.fssa.needstobedone.model;

public class Job {

	private String title;
	private int price;
	private String email;
	private String jobid;
	private Boolean isDeleted;

	public Job() {
		// Default Constructor
	}

	public Job(String title, int price, String email) {
		this.title = title;
		this.price = price;
		this.email = email;
	}

	public Job(int price, String jobid, String title) {
		this.title = title;
		this.price = price;
		this.jobid = jobid;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Job [title=" + title + ", price=" + price + ", email=" + email + ", jobid=" + jobid + ", isDeleted="
				+ isDeleted + "]";
	}

}
