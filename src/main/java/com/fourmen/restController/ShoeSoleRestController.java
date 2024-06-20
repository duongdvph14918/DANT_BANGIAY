package com.fourmen.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fourmen.entity.ShoeSole;
import com.fourmen.service.ShoeSoleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/shoeSole")
public class ShoeSoleRestController {
	@Autowired
	ShoeSoleService shoeSoleService;

	@GetMapping
	public List<ShoeSole> getAll(){
	  return shoeSoleService.findAll();
	}
	
	@GetMapping("/getAllStatus")
	public List<ShoeSole> getAllStatus(){
	  return shoeSoleService.findByStatus(true);
	} 
	
	@GetMapping("{name}")
	public ShoeSole getName(@PathVariable("name") String name) {
		return shoeSoleService.findByName(name);
	}
	
	@PostMapping
	public ShoeSole on(@RequestBody ShoeSole ShoeSole) {
		return shoeSoleService.save(ShoeSole);
	}
	
	@PutMapping("{id}")
	public ShoeSole update(@PathVariable("id") Integer id, @RequestBody ShoeSole ShoeSole) {
		return shoeSoleService.save(ShoeSole);
	}
	
	@PutMapping("/delete/{id}")
	public ShoeSole updatetrangthai(@PathVariable("id") Integer id, @RequestBody ShoeSole ShoeSole) {
		ShoeSole.setStatus(false);
		return shoeSoleService.save(ShoeSole);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		shoeSoleService.deleteById(id);
	}
	
	@GetMapping("/timKiem/{name}/{status}")
	public List<ShoeSole> timKiem(@PathVariable("name") String name,@PathVariable("status") String status){
		//System.out.println("tên= "+name + " status= "+ status);
		if (status.equals("null")) {
			System.out.println("tên= "+name);
			return shoeSoleService.findByName1("%"+name+"%");
		} else {
			boolean in  = Boolean.parseBoolean(status);
			System.out.println("tên= "+name + " status="+ in);
			return shoeSoleService.findByName("%"+name+"%" , in);
		}
	}
	
	@GetMapping("/timKiem/{status}")
	public List<ShoeSole> getStatus(@PathVariable("status") Boolean status){
		return shoeSoleService.findByStatus(status);
	}
	
	
}