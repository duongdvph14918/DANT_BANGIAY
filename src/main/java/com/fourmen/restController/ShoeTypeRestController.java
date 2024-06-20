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

import com.fourmen.entity.ShoeType;
import com.fourmen.service.ShoeTypeService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/shoeType")
public class ShoeTypeRestController {

	@Autowired
	ShoeTypeService shoeTypeService;
	
	@GetMapping()
	public List<ShoeType> getAll(){
		return shoeTypeService.findAll();
	}
	
	@GetMapping("/getAllStatus")
	public List<ShoeType> getAllStatus(){
		return shoeTypeService.getAllStatus();
	}
	
	@PostMapping 
	public ShoeType create(@RequestBody ShoeType shoeType) {
		return shoeTypeService.save(shoeType);
	}
	
	@PutMapping("{id}")
	public ShoeType update(@PathVariable("id") Integer id, @RequestBody ShoeType shoeType) {
//		if(shoeType.getDiscount() == null) {
//			shoeType.setDiscount(null);
//		}else {
//			if(shoeType.getDiscount().getDiscountId() ==0) {
//				shoeType.setDiscount(null);
//			}
//		}
		return shoeTypeService.save(shoeType);
	}
	
	@PutMapping("/delete/{id}")
	public ShoeType deleteThai(@PathVariable("id") Integer id, @RequestBody ShoeType shoeType) {
		shoeType.setStatus(false);
		return shoeTypeService.save(shoeType);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		shoeTypeService.deleteById(id);
	}
	
	
	@GetMapping("/timKiem/{name}/{status}")
	public List<ShoeType> timKiem(@PathVariable("name") String name,@PathVariable("status") String status){
		//System.out.println("tên= "+name + " status= "+ status);
		if (status.equals("null")) {
			System.out.println("tên= "+name);
			return shoeTypeService.findByName1("%"+name+"%");
		} else {
			boolean in  = Boolean.parseBoolean(status);
			System.out.println("tên= "+name + " status="+ in);
			return shoeTypeService.findByName("%"+name+"%" , in);
		}
	}
	
	@GetMapping("/timKiem/{status}")
	public List<ShoeType> getStatus(@PathVariable("status") Boolean status){
		return shoeTypeService.findByStatus(status);
	}
	
	@GetMapping("{name}")
	public ShoeType getName(@PathVariable("name") String name) {
		return shoeTypeService.findByName2(name);
	}
	
}