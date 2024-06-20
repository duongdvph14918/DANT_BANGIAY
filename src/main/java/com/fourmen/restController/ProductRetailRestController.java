package com.fourmen.restController;

import java.util.List;
import java.util.Optional;

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

import com.fourmen.dao.ProductDetailDao;
import com.fourmen.entity.ProductDetail;
import com.fourmen.service.ProductDetailService;




@CrossOrigin("*")
@RestController
@RequestMapping("/rest/productsDetail")
public class ProductRetailRestController {
	@Autowired
	ProductDetailService productService;
	@Autowired
	ProductDetailDao productDao;
	
	//Load toàn bộ sản phẩm
	@GetMapping()
	public List<ProductDetail> getAll() {
//		return productService.findAll();
		return productDao.getAllProductDetail();
	}

	@GetMapping("{productId}")
	public Optional<ProductDetail> getOne(@PathVariable("productId") Integer productId) {
		return productService.findById(productId);
	}

	@PostMapping()
	public ProductDetail create(@RequestBody ProductDetail product) {
		//product.setCreateDate(new Date());
		return productService.save(product);
	}
	
	@PutMapping("{id}")
	public ProductDetail update(@PathVariable("id") Integer id,@RequestBody ProductDetail product) {
		//product.setUpdateDate(new Date());
		return productService.save(product);
	}
	
	@PutMapping("/delete/{id}")
	public ProductDetail updatetrangthai(@PathVariable("id") Integer id,@RequestBody ProductDetail product) {
		product.setStatus(false);
		return productService.save(product);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		 productService.deleteById(id);
	}
	
	@GetMapping("/timKiem/{name}/{status}")
	public List<ProductDetail> timKiem(@PathVariable("name") String name,@PathVariable("status") String status){
		//System.out.println("tên= "+name + " status= "+ status);
		if (status.equals("null")) {
			System.out.println("tên= "+name);
			return productService.findByName1("%"+name+"%");
		} else {
			boolean in  = Boolean.parseBoolean(status);
			System.out.println("tên= "+name + " status="+ in);
			return productService.findByName("%"+name+"%" , in);
		}
	}

	@GetMapping("/timKiem/{status}")
	public List<ProductDetail> getStatus(@PathVariable("status") Boolean status){
		return productService.findByStatus(status);
	}
	
	@PostMapping("/checkName")
	public ProductDetail checkName(@RequestBody ProductDetail product){
		return productService.checkName(product.getName());
	}
}