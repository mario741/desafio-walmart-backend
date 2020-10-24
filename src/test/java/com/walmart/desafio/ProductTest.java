package com.walmart.desafio;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;

import com.walmart.desafio.data.model.Product;
import com.walmart.desafio.product.service.ProductResponse;
import com.walmart.desafio.product.service.ProductService;

@SpringBootTest
class ProductTest {
	@Mock
	private ProductService productServiceMock;

	@Test
	void getProduct_WITH_DISCOUNT_OK() {
		Product product = new Product(null, 23, "dasad", "zyss vmcñvzwt",
				"http://www.lider.cl/catalogo/images/bedRoomIcon.svg", 370775);

		List<ProductResponse> productsResponse = new ArrayList<ProductResponse>();
		productsResponse.add(new ProductResponse(product, 0.5));
		HttpServletResponse httpResponse = new MockHttpServletResponse();

		Mockito.when(productServiceMock.searchProduct("aba", httpResponse))
				.thenReturn(new BaseResponse("OK", productsResponse, null));

	}

}
