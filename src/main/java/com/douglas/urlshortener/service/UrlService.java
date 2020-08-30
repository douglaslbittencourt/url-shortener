package com.douglas.urlshortener.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douglas.urlshortener.model.Url;
import com.douglas.urlshortener.repositories.UrlRepository;

@Service
public class UrlService {
	
	@Autowired
	UrlRepository repository;
	
	@Transactional
	public String convertToShortUrl(String longUrl) {
		Url url = repository.findByLongUrl(longUrl);
		
		if (url != null) {
			return url.getShortUrl();
		}
		
		url = new Url();
		url.setLongUrl(longUrl);
		url.setShortUrl(RandomStringUtils.random(6,true,true));
		
		return repository.save(url).getShortUrl();
	}
	
	@Transactional(readOnly = true)
	public String convertToLongUrl(String shortUrl) {
		Url url = repository.findByShortUrl(shortUrl);
		
		if (url == null) {
			throw new RuntimeException("Url não encontrada");
		}
		
		return url.getLongUrl();
	}

}
