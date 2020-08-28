package com.douglas.urlshortener.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Request object for POST method")
public class UrlLonger {
	
	@ApiModelProperty(required = true, notes = "Url to convert to short")
    private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
