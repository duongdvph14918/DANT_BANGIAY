package com.fourmen.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fourmen.dao.BrandDao;
import com.fourmen.dao.NewsDao;
import com.fourmen.dao.ProductDao;
import com.fourmen.service.BrandService;
import com.fourmen.service.ColorService;
import com.fourmen.service.NewsService;
import com.fourmen.service.ProductService;
import com.fourmen.service.SizeService;

@Controller
public class HomeController {
	@Autowired
	ProductService productService;
	@Autowired
	ProductDao pdao;

	@Autowired
	NewsDao ndao;
	@Autowired
	NewsService newsService;

	@Autowired
	BrandDao bdao;
	@Autowired
	BrandService brandService;
	
	@Autowired
	ColorService colorSv;
	
	@Autowired
	SizeService sizeSV;
	
	@Autowired 
    HttpSession session;
	
	//home người admin
	@GetMapping({"/","/admin","/admin/4MEN"})
	public String homeAmin(Model model) {
		return "redirect:/assets/admin/main/homeAdmin.html";
	}
	
	//Home người dùng
	@GetMapping({"/4MEN","/4MEN/home"})
	public String homeClient(Model model) {
		try {
//			List<Product> list = productService.findTop6Img();
//			model.addAttribute("items", list);
//			List<Color> colors = colorSv.findAll();
//			model.addAttribute("colors", colors);
//			List<Size> sizes = sizeSV.findAll();
//			model.addAttribute("sizes",sizes);
//			
//			List<Brand> listBrand = brandService.findAll();
//			model.addAttribute("brands", listBrand);
//			
//			
//			List<Brand> list2 = brandService.findTop4Img();
//			model.addAttribute("items2", list2);
//
//			List<News> list3 = newsService.findAll();
//			model.addAttribute("items3", list3);
//
//			List<News> list1= newsService.findAll();
//			model.addAttribute("news", list1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return "/layout/homeClient";	
	}
}
