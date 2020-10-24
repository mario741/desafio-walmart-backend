package com.walmart.desafio.product.service;

import com.walmart.desafio.data.model.Product;

public class ProductResponse {
	private final int id;
	private final String brand;
	private final String description;
	private final String image;
	private final int price;
	private final int priceDiscount;
	private final double discount;

	public ProductResponse(Product product, double discount) {
		super();
		this.id = product.getId();
		this.brand = product.getBrand();
		this.description = product.getDescription();
		this.image = product.getImage();
		this.price = (int) Math.round(product.getPrice());
		this.priceDiscount = (int) (discount != 0 ? Math.round(product.getPrice() * discount) : product.getPrice());
		this.discount = discount;
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
		return image;
	}

	public int getPrice() {
		return price;
	}

	public double getDiscount() {
		return discount;
	}

	public int getPriceDiscount() {
		return priceDiscount;
	}
}
