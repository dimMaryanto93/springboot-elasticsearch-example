package com.maryanto.dimas.example;

import com.maryanto.dimas.example.elasticsearch.document.Product;
import com.maryanto.dimas.example.elasticsearch.repository.ProductDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.UUID;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class ExampleApplicationTests extends TestCase {

    @Autowired
    private ProductDao dao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSaveToElasticsearch() {
        Product product = new Product(UUID.randomUUID().toString(), "Product 1", new BigDecimal(2500), false);

        product = dao.save(product);
        assertNotNull(product.getId());

        dao.deleteById(product.getId());

        Product emptyProduct = dao.findById(product.getId());
        assertNull(emptyProduct);
    }

}

