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

import com.fourmen.entity.Color;
import com.fourmen.service.ColorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/color")
public class ColorRestController {
	@Autowired
	ColorService colorService;

	@GetMapping
	public List<Color> getAll(){
	  return colorService.findAll();
	}
	@GetMapping("/getAllStatus")
	public List<Color> getAllStatus(){
	  return colorService.findByStatus(true);
	}
	@GetMapping("{name}")
	public Color getName(@PathVariable("name") String name) {
		return colorService.findByName(name);
	}
	
	@PostMapping
	public Color on(@RequestBody Color Color) {
		return colorService.save(Color);
	}
	
	@PutMapping("{id}")
	public Color update(@PathVariable("id") Integer id, @RequestBody Color Color) {
		return colorService.save(Color);
	}
	
	@PutMapping("/delete/{id}")
	public Color updatetrangthai(@PathVariable("id") Integer id, @RequestBody Color Color) {
		Color.setStatus(false);
		return colorService.save(Color);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		colorService.deleteById(id);
	}
	
	@GetMapping("/timKiem/{name}/{status}")
	public List<Color> timKiem(@PathVariable("name") String name,@PathVariable("status") String status){
		//System.out.println("tên= "+name + " status= "+ status);
		if (status.equals("null")) {
			System.out.println("tên= "+name);
			return colorService.findByName1("%"+name+"%");
		} else {
			boolean in  = Boolean.parseBoolean(status);
			System.out.println("tên= "+name + " status="+ in);
			return colorService.findByName("%"+name+"%" , in);
		}
	}
	
	@GetMapping("/timKiem/{status}")
	public List<Color> getStatus(@PathVariable("status") Boolean status){
		return colorService.findByStatus(status);
	}
	
	
}