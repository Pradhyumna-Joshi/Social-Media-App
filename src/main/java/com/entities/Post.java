package com.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Post extends PostInterface {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	private String postTitle ;
	private String postContent ;
	private Date date = new Date();
	private Long likes = 0l;
	
	@Override
	public String toString() {
		return "Post [postTitle=" + postTitle + ", postContent=" + postContent + ", date=" + date + ", likes=" + likes
				+ "]";
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getpostContent() {
		return postContent;
	}

	public void setpostContent(String postContent) {
		this.postContent = postContent;
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

	public Post(String postTitle, String postContent, Date date, Long likes) {
		super();
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.date = date;
		this.likes = likes;
	}

	public Post() {
		// TODO Auto-generated constructor stub
	}
	
	
}
