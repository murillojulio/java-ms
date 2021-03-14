package net.juliomurillo.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.juliomurillo.product.entity.Category;
import net.juliomurillo.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findByCategory(Category category);

}
