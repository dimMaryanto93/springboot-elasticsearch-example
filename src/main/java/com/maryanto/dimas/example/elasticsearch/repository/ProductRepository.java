package com.maryanto.dimas.example.elasticsearch.repository;

import com.maryanto.dimas.example.elasticsearch.document.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface ProductRepository extends ElasticsearchCrudRepository<Product, String> {
}
