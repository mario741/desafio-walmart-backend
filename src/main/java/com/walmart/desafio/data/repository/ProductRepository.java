package com.walmart.desafio.data.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.walmart.desafio.data.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, ObjectId> {
	Product findById(int id);

	List<Product> findByBrandContainsOrDescriptionContains(String brand, String description);
}
