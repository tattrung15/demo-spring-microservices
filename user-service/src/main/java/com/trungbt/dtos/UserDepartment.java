package com.trungbt.dtos;

import com.trungbt.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDepartment {

    private User user;
    private Department department;
}
