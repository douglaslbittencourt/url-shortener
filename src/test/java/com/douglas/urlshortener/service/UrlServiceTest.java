package com.douglas.urlshortener.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import com.douglas.urlshortener.model.Url;
import com.douglas.urlshortener.repositories.UrlRepository;

@RunWith(MockitoJUnitRunner.class)
public class UrlServiceTest {
	
	@Mock
	UrlRepository mockRepository;
	
	@InjectMocks
	UrlService service;
	
	@Test
	public void convertoToShortUrlIfExistUrlTest() {
		String shorter = RandomStringUtils.random(6,true,true);
		String longer = "www.google.com";
		
		Url url = new Url();
		url.setId(1L);
		url.setLongUrl(longer);
		url.setShortUrl(shorter);
		
		when(mockRepository.findByLongUrl(longer)).thenReturn(url);
		
		assertEquals(shorter, service.convertToShortUrl(longer));
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void convertoToShortUrlIfNotExistUrlTest() {
		String shorter = "AbC123";
		String longer = "www.google.com";
		
		Url url = new Url();
		url.setId(1L);
		url.setLongUrl(longer);
		url.setShortUrl(shorter);
		
		when(mockRepository.findByLongUrl(longer)).thenReturn(null);
		
		when(mockRepository.save(any(Url.class))).thenReturn(url);
		
		assertEquals(shorter, service.convertToShortUrl(longer));
	}
	
	
	@Test
	public void convertToLongUrlTest() {
		String shorter = RandomStringUtils.random(6,true,true);
		String longer = "www.google.com";
		
		Url url = new Url();
		url.setId(1L);
		url.setLongUrl(longer);
		url.setShortUrl(shorter);
		
		when(mockRepository.findByShortUrl(shorter)).thenReturn(url);
		
		assertEquals(longer, service.convertToLongUrl(shorter));
		
	}

}
