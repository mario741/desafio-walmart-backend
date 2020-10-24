package com.walmart.desafio.product;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.desafio.BaseResponse;
import com.walmart.desafio.product.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/{searchBy}")
	public BaseResponse searchProduct(@PathVariable(name = "searchBy") String searchBy,
			HttpServletResponse httpResponse) {
		return productService.searchProduct(searchBy, httpResponse);
	}
}
