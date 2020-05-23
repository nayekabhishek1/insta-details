package com.nayek.instadetails.model;

public class User {
	private Long id;
	private String username;
	private String email;
	private String bio;
	private String businessContact;
	private String url;
	private int followersCount;
	private int followingCount;

	public User() {
		super();
	}
	public User(Long id, String username, String email, String bio, String businessContact, String url,
			int followersCount, int followingCount) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.bio = bio;
		this.businessContact = businessContact;
		this.url = url;
		this.followersCount = followersCount;
		this.followingCount = followingCount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getBusinessContact() {
		return businessContact;
	}
	public void setBusinessContact(String businessContact) {
		this.businessContact = businessContact;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getFollowersCount() {
		return followersCount;
	}
	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}
	public int getFollowingCount() {
		return followingCount;
	}
	public void setFollowingCount(int followingCount) {
		this.followingCount = followingCount;
	}
	
}
