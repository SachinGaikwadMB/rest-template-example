package com.mb.api.web.model;


public class User
{
	private Integer userId;
	
	private Integer id;
	
	private String title;
	
	private String body;
	
	public User() {}
	
	public User(Integer userId, Integer id, String title, String body)
	{
		super();
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public Integer getUserId()
	{
		return userId;
	}

	public Integer getId()
	{
		return id;
	}

	public String getTitle()
	{
		return title;
	}

	public String getBody()
	{
		return body;
	}

	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setBody(String body)
	{
		this.body = body;
	}
	
	
}
