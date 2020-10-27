package com.walmart.desafio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

	@SuppressWarnings("unchecked")
	@Test
	void searchProduct_WITH_DISCOUNT_OK() {
		Product product = new Product(null, 36, "adda", "tblb uñccrvup",
				"http://www.lider.cl/catalogo/images/bedRoomIcon.svg", 813504);

		List<ProductResponse> productsResponse = new ArrayList<ProductResponse>();
		productsResponse.add(new ProductResponse(product, 0.5));
		HttpServletResponse httpResponse = new MockHttpServletResponse();

		Mockito.when(productServiceMock.searchProduct("adda", httpResponse))
				.thenReturn(new BaseResponse("OK", productsResponse, null));

		BaseResponse baseResponse = productServiceMock.searchProduct("adda", httpResponse);

		assertEquals(200, httpResponse.getStatus());
		assertEquals("OK", baseResponse.getMensajeRespuesta());
		assertNull(baseResponse.getError());

		List<ProductResponse> lstProductsResponse = (List<ProductResponse>) baseResponse.getData();

		assertEquals(36, lstProductsResponse.get(0).getId());
		assertEquals("adda", lstProductsResponse.get(0).getBrand());
		assertEquals("tblb uñccrvup", lstProductsResponse.get(0).getDescription());
		assertEquals("http://www.lider.cl/catalogo/images/bedRoomIcon.svg", lstProductsResponse.get(0).getImage());
		assertEquals(813504, lstProductsResponse.get(0).getPrice());
		assertEquals(406752, lstProductsResponse.get(0).getPriceDiscount());
		assertEquals(0.5, lstProductsResponse.get(0).getDiscount());
	}

	@SuppressWarnings("unchecked")
	@Test
	void searchProduct_WITHOUT_DISCOUNT_OK() {
		Product product = new Product(null, 67, "asf", "lzet scsdqzfp",
				"http://www.lider.cl/catalogo/images/toysIcon.svg", 9268);

		List<ProductResponse> productsResponse = new ArrayList<ProductResponse>();
		productsResponse.add(new ProductResponse(product, 0));
		HttpServletResponse httpResponse = new MockHttpServletResponse();

		Mockito.when(productServiceMock.searchProduct("asf", httpResponse))
				.thenReturn(new BaseResponse("OK", productsResponse, null));

		BaseResponse baseResponse = productServiceMock.searchProduct("asf", httpResponse);

		assertEquals(200, httpResponse.getStatus());
		assertEquals("OK", baseResponse.getMensajeRespuesta());
		assertNull(baseResponse.getError());

		List<ProductResponse> lstProductsResponse = (List<ProductResponse>) baseResponse.getData();

		assertEquals(67, lstProductsResponse.get(0).getId());
		assertEquals("asf", lstProductsResponse.get(0).getBrand());
		assertEquals("lzet scsdqzfp", lstProductsResponse.get(0).getDescription());
		assertEquals("http://www.lider.cl/catalogo/images/toysIcon.svg", lstProductsResponse.get(0).getImage());
		assertEquals(9268, lstProductsResponse.get(0).getPrice());
		assertEquals(9268, lstProductsResponse.get(0).getPriceDiscount());
		assertEquals(0, lstProductsResponse.get(0).getDiscount());
	}
}
