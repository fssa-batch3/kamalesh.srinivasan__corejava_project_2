package com.fssa.needstobedone.model;

public class AllModal {
	@Override
	public String toString() {
		return "[" + user + job + notification + "]";
	}

	private User user;
	private Job job;
	private Notification notification;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}
}
