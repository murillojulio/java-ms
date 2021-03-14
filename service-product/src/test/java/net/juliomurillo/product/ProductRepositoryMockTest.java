package net.juliomurillo.product;

import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import net.juliomurillo.product.entity.Category;
import net.juliomurillo.product.entity.Product;
import net.juliomurillo.product.repository.ProductRepository;

@DataJpaTest
public class ProductRepositoryMockTest {

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void when() {
		Product product_01 = Product.builder()
				.name("computer")
				.category(Category.builder().id(1L).build())
				.description("")
				.stock(Double.parseDouble("10"))
				.price(Double.parseDouble("1240.99"))
				.status("Created")
				.create_at(new Date())
				.update_at(null)
				.delete_at(null)
				.build();
		productRepository.save(product_01);
		
		List<Product> founds = productRepository.findByCategory(product_01.getCategory());
		
		Assertions.assertThat(founds.size()).isEqualTo(3);
	}
}
