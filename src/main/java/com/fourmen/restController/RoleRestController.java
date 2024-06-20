package com.fourmen.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fourmen.entity.Roles;
import com.fourmen.service.RolesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RoleRestController {
	@Autowired
	RolesService roleService;
	
	@GetMapping()
	public List<Roles> getAll() {
		return roleService.findAll();
	}
}