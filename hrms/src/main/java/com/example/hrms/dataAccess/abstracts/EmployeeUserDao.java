package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.EmployeeUser;

public interface EmployeeUserDao extends JpaRepository<EmployeeUser, Integer> {

}
