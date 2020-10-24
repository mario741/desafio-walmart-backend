package com.walmart.desafio.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.walmart.desafio.BaseResponse;
import com.walmart.desafio.Utils;
import com.walmart.desafio.data.model.Product;
import com.walmart.desafio.data.repository.ProductRepository;

@Component
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private Utils utils;

	@Value("${walmart.discount.palindrome}")
	private double palindromeDiscount;

	public BaseResponse searchProduct(String searchBy, HttpServletResponse httpResponse) {
		try {
			List<Product> products = new ArrayList<Product>();

			if (utils.isInteger(searchBy)) {
				products.add(productRepository.findById(Integer.parseInt(searchBy)));
			} else {
				products = productRepository.findByBrandContainsOrDescriptionContains(searchBy.toLowerCase(),
						searchBy.toLowerCase());
			}

			if (products.size() == 0) {
				httpResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
				return null;
			}

			double discount = getDiscount(searchBy);

			List<ProductResponse> productsResponse = products.stream().map(p -> new ProductResponse(p, discount))
					.collect(Collectors.toList());

			httpResponse.setStatus(HttpServletResponse.SC_OK);
			return new BaseResponse("OK", productsResponse, null);
		} catch (NoSuchElementException e) {
			httpResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
			return null;
		} catch (Exception e) {
			httpResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return new BaseResponse("ERROR", null, e.getMessage());
		}
	}

	private double getDiscount(String searchBy) {
		return utils.isPalindrome(searchBy) ? palindromeDiscount : 0;
	}
}
