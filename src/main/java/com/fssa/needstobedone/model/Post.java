package com.fssa.needstobedone.model;

public class Post {

	private String title;
	private User user;
	private int postId;

	public Post() {

	}

	public Post(String title, User user) {

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	} 

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "Post [title=" + title + ", user=" + user + ", postId=" + postId + "]";
	}

}
