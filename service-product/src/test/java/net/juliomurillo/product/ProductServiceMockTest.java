package net.juliomurillo.product;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import net.juliomurillo.product.entity.Category;
import net.juliomurillo.product.entity.Product;
import net.juliomurillo.product.repository.ProductRepository;
import net.juliomurillo.product.service.ProductService;
import net.juliomurillo.product.service.ProductServiceImp;

@SpringBootTest
public class ProductServiceMockTest {

	@Mock// indica que los accesos a los datos seran mockeados
	private ProductRepository productRepository;
	
	private ProductService productService;
	
	@BeforeEach //indica que el siguiente metodo se debe ejecutar antes de iniciar la prueba mock
	public void setup() {
		
		MockitoAnnotations.openMocks(this);
		productService = new ProductServiceImp(productRepository);
		Product computer = Product.builder()
				.id(1L)
				.name("computer")
				.category(Category.builder().id(1L).build())
				.price(Double.parseDouble("12.5"))
				.stock(Double.parseDouble("5"))
				.build();
		
		Mockito.when(productRepository.findById(1L))
		.thenReturn(Optional.of(computer));
		
		Mockito.when(productRepository.save(computer))
		.thenReturn(computer);
	}
	
	@Test
	public void whenValidGetID_ThenReturnProduct() {
		Product found = productService.getProduct(1L);
		Assertions.assertThat(found.getName()).isEqualTo("computer");
	}
	
	@Test
	public void whenValidUpdateStock_ThenReturnNewStock() {
		Product found = productService.updateStock(1L, Double.parseDouble("8"));
		Assertions.assertThat(found.getStock()).isEqualTo(13);
	}
	
}
