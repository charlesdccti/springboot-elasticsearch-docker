package com.volkspace.springbootelasticsearch.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.Data;

@Data
@Document(indexName = "customer", type = "article")
public class Customer {
    @Id
    private String id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private Integer age;

    @NotNull
    private String email;
  
}
