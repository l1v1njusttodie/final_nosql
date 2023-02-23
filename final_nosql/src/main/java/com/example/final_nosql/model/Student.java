package com.example.final_nosql.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Getter
@Setter
@ToString

@Document(collection = "Students")
public class Student {
    @Id
    private String id;
    private String name;
    private String lastName;
    private List<String> course;
    private String email;
    private String password;
}