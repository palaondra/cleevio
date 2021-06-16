package com.pala.cleevio.demo.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity for storing in H2 DB.
 */
@Entity
@Table(name = "WATCH")
public class Watch {
	
	/**
	 * Primary key.
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "TITLE", length = 50, nullable = false, unique = true)
	private String title;
	
	@Column(name = "PRICE", nullable = false, unique = false)
	private Integer price;
	
	@Column(name = "DESCRIPTION", length = 70, nullable = false, unique = false)
	private String description;
	
	/**
	 * Base64 encoded image of watches.
	 */
	@Column(name = "BASE_64_IMAGE", nullable = false, unique = false)
	private String base64Image;

	public Watch() {
		
	}

	public Watch(Long id, String title, Integer price, String description, String base64Image) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.base64Image = base64Image;
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

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	@Override
	public String toString() {
		return "Watch [title=" + title + ", price=" + price + ", description=" + description + ", base64Image="
				+ base64Image + "]";
	}
	
}
