package com.douglas.urlshortener.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Url {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TEXT", unique=true)
	private String longUrl;

	@Column(unique=true)
	private String shortUrl;

	public Long getId() {
		return id;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

}
