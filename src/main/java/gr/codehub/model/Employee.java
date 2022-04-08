package gr.codehub.model;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String name;
    private Department dept;
}
