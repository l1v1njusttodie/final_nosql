package com.example.final_nosql.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Getter
@Setter
@ToString

@Document(collection = "Instructors")
public class Instructor
{
    @Id
    private String id;
    private String name;
    private String lastName;
    private String course;
    private String email;
}
