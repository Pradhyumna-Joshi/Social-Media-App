package com.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class PostImage extends PostInterface {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	private String postTitle ;
	private String postContent ;
	private String postImageURL ;
	private Date date = new Date();
	private Long likes = 0l;
	public PostImage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostImage(int postId, String postTitle, String postContent, String postImageURL, Date date, Long likes) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postImageURL = postImageURL;
		this.date = date;
		this.likes = likes;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostImageURL() {
		return postImageURL;
	}
	public void setPostImageURL(String postImageURL) {
		this.postImageURL = postImageURL;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getLikes() {
		return likes;
	}
	public void setLikes(Long likes) {
		this.likes = likes;
	}
	@Override
	public String toString() {
		return "PostImage [postId=" + postId + ", postTitle=" + postTitle + ", postContent=" + postContent
				+ ", postImageURL=" + postImageURL + ", date=" + date + ", likes=" + likes + "]";
	}
	
	
	
	
}
