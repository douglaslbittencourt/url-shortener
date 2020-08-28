package com.douglas.urlshortener.repositories;

import org.springframework.data.repository.CrudRepository;

import com.douglas.urlshortener.model.Url;

public interface UrlRepository extends CrudRepository<Url, Long> {

	Url findByLongUrl(String longUrl);
	
	Url findByShortUrl(String shortUrl);
	
}
