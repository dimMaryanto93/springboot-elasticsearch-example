package com.maryanto.dimas.example.elasticsearch.repository;

import com.maryanto.dimas.example.elasticsearch.document.Product;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ElasticsearchTemplate elasticTemplate;

    public Product save(Product value) {
        return this.productRepository.save(value);
    }

    public void delete(Product value) {
        this.productRepository.delete(value);
    }

    public void deleteById(String id) {
        this.productRepository.delete(id);
    }

    public Iterable<Product> findAll() {
        return this.productRepository.findAll();
    }

    public List<Product> findByName(String name) {
        SearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(
                        QueryBuilders
                                .matchQuery("name", name)
                                .minimumShouldMatch("75%")
                ).build();
        return elasticTemplate.queryForList(query, Product.class);
    }

}
