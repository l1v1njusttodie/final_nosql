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

@Document(collection = "Groups")
public class Group {
    @Id
    private String id;
    private String groupName;
    private int numberOfStudents = 0;
    private List<Student> students;
}
