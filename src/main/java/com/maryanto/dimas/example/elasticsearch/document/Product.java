package com.maryanto.dimas.example.elasticsearch.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "products", createIndex = true)
public class Product {

    @Id
    private String id;
    private String name;
    private BigDecimal price;
    private boolean available;
}
