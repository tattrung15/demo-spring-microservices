package com.trungbt.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("api-service")
public class APIService {
    private String department = "http://localhost:8001";

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
