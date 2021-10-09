package com.trungbt.services;

import com.trungbt.dtos.Department;
import com.trungbt.dtos.UserDepartment;
import com.trungbt.entities.User;
import com.trungbt.properties.APIService;
import com.trungbt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    private final String baseAPIDepartment;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public UserService(APIService apiService) {
        this.baseAPIDepartment = apiService.getDepartment();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public UserDepartment getUserWithDepartment(Long userId) {
        UserDepartment userDepartment = new UserDepartment();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject(baseAPIDepartment + "/api/departments/" + user.getDepartmentId()
                        ,Department.class);

        userDepartment.setUser(user);
        userDepartment.setDepartment(department);

        return  userDepartment;
    }
}
