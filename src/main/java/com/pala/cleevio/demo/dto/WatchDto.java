package com.pala.cleevio.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.pala.cleevio.demo.dto.validators.annotations.ValidBase64;

@JacksonXmlRootElement(localName = "Watch")
public class WatchDto {
	
	private Long id;
	
	@JacksonXmlProperty
	@NotEmpty(message = "Title couldn't be empty")
	@Size(min = 5, message = "Title should has atleast 5 characters")
	@Size(max = 45, message = "Title should has max 45 characters")
	private String title;
	
	@JacksonXmlProperty
	@Min(value = 1, message = "Price should be atleast 1")
	private Integer price;
	
	@JacksonXmlProperty
	@NotEmpty(message = "Description couldn't be empty")
	@Size(min = 10, message = "Title should has atleast 10 characters")
	@Size(max = 100, message = "Title should has max 100 characters")
	private String description;
	
	/**
	 * Base64 encoded image of watches.
	 */
	@JacksonXmlProperty
	@NotEmpty(message = "Fountain couldn't be empty")
	@ValidBase64(message = "Invalid Base64 format")
	private String fountain;
	
	public WatchDto() {
		
	}

	public WatchDto(Long id, String title, Integer price, String description, String fountain) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.fountain = fountain;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFountain() {
		return fountain;
	}

	public void setFountain(String fountain) {
		this.fountain = fountain;
	}
	
}
