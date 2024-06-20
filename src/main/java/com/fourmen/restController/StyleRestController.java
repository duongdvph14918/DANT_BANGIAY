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

import com.fourmen.entity.Style;
import com.fourmen.service.StyleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/style")
public class StyleRestController {
	@Autowired
	StyleService styleService;

	@GetMapping
	public List<Style> getAll(){
	  return styleService.findAll();
	}
	@GetMapping("/getAllStatus")
	public List<Style> getAllStatus(){
	  return styleService.findByStatus(true);
	}
	@GetMapping("{name}")
	public Style getName(@PathVariable("name") String name) {
		return styleService.findByName(name);
	}
	
	@PostMapping
	public Style on(@RequestBody Style Style) {
		return styleService.save(Style);
	}
	
	@PutMapping("{id}")
	public Style update(@PathVariable("id") Integer id, @RequestBody Style Style) {
		return styleService.save(Style);
	}
	
	@PutMapping("/delete/{id}")
	public Style updatetrangthai(@PathVariable("id") Integer id, @RequestBody Style Style) {
		Style.setStatus(false);
		return styleService.save(Style);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		styleService.deleteById(id);
	}
	
	@GetMapping("/timKiem/{name}/{status}")
	public List<Style> timKiem(@PathVariable("name") String name,@PathVariable("status") String status){
		//System.out.println("tên= "+name + " status= "+ status);
		if (status.equals("null")) {
			System.out.println("tên= "+name);
			return styleService.findByName1("%"+name+"%");
		} else {
			boolean in  = Boolean.parseBoolean(status);
			System.out.println("tên= "+name + " status="+ in);
			return styleService.findByName("%"+name+"%" , in);
		}
	}
	
	@GetMapping("/timKiem/{status}")
	public List<Style> getStatus(@PathVariable("status") Boolean status){
		return styleService.findByStatus(status);
	}
	
	
}