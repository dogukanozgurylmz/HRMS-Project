package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

}
