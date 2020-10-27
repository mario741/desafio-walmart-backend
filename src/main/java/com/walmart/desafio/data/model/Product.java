package com.walmart.desafio.data.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
	@Id
	private ObjectId _id;

	private int id;
	private String brand;
	private String description;
	private String image;
	private long price;

	public Product() {
	}

	public Product(ObjectId _id, int id, String brand, String description, String image, long price) {
		this._id = _id;
		this.id = id;
		this.brand = brand;
		this.description = description;
		this.image = image;
		this.price = price;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getDescription() {
		return description;
	}

	public String getImage() {
		return !image.contains("http://") ? "http://" + image : image;
	}

	public long getPrice() {
		return price;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", brand=" + brand + ", desc=" + description + ", price=" + price + "]";
	}
}
