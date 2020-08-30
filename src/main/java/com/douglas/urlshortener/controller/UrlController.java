package com.douglas.urlshortener.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.douglas.urlshortener.dto.UrlLonger;
import com.douglas.urlshortener.service.UrlService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/")
public class UrlController {

	@Autowired
	UrlService service;
	
	@ApiOperation(value = "Convert url", notes = "Converts long url to short url")
	@PostMapping(value = "/shortenUrl")
	public ResponseEntity<?> getShortenUrl(@RequestBody UrlLonger longUrl, UriComponentsBuilder uriBuilder) {
		try {
			String shorterUrl = service.convertToShortUrl(longUrl.getUrl());
			return ResponseEntity.ok().body(uriBuilder.toUriString() + "/r/" + shorterUrl);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Redirect", notes = "Finds original url from short url and redirects")
	@GetMapping(value = "/r/{shortUrl}")
	public void getFullUrlAndRedirect(@PathVariable String shortUrl, HttpServletResponse response) {
		try {
			String fullUrl = service.convertToLongUrl(shortUrl);
			response.sendRedirect(fullUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
