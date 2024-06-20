package com.fourmen.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fourmen.entity.Roles;
@Repository
public interface RolesDao extends JpaRepository<Roles, Integer>{
	Roles findByName(String name);
}
