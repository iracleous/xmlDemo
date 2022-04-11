package gr.codehub.jsonservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.codehub.model.Department;

import java.io.File;
import java.io.IOException;

public class CompanyServices {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Department department = new Department(3, "Sales");
        objectMapper.writeValue(new File("json_files/department.json"), department);

    }
}
