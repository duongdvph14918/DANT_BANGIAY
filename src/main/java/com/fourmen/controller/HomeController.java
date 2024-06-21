package com.fourmen.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fourmen.dao.BrandDao;
import com.fourmen.dao.NewsDao;
import com.fourmen.dao.ProductDao;
import com.fourmen.entity.Brand;
import com.fourmen.entity.ShoeType;
import com.fourmen.service.BrandService;
import com.fourmen.service.ColorService;
import com.fourmen.service.NewsService;
import com.fourmen.service.ProductService;
import com.fourmen.service.ShoeTypeService;
import com.fourmen.service.SizeService;

@Controller
public class HomeController {
	@Autowired
	ProductService productService;
	@Autowired
	ProductDao pdao;


	@Autowired
	BrandDao bdao;
	@Autowired
	BrandService brandService;
	
	@Autowired
	ShoeTypeService shoeTypeService;
	
	@Autowired 
    HttpSession session;
	
	//home người admin
	@GetMapping({"/","/admin","/admin/4MEN"})
	public String homeAmin(Model model) {
		return "redirect:/assets/admin/main/homeAdmin.html";
	}
	
	//Home người dùng
	@GetMapping({"/4MEN","/4MEN/home"})
	public String homeClient(HttpServletRequest request,Model model) {
		try {
			List<Brand> listBrand = brandService.getAllStatus();
			model.addAttribute("brands", listBrand);
			List<ShoeType> shoeTypeList = shoeTypeService.getAllStatus();
			model.addAttribute("shoeTypes", shoeTypeList);
			request.getSession().setAttribute("brands", listBrand);
			request.getSession().setAttribute("shoeTypes", shoeTypeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/layout/homeClient";	
	}
	
	@GetMapping({"/4MEN/support/chonSize"})
	public String huongdanChonSize(HttpServletRequest request,Model model) {
		innitBrandsCate(request,model);
		return "/user/support/huongDanChonSize";	
	}
	@GetMapping({"/4MEN/support/huongDanMuaHang"})
	public String huongDanMuaHang(HttpServletRequest request,Model model) {
		innitBrandsCate(request,model);
		return "/user/support/huongDanMuaHang";	
	}
	@GetMapping({"/4MEN/support/chinhSachVanChuyen"})
	public String chinhSachVanChuyen(HttpServletRequest request,Model model) {
		innitBrandsCate(request,model);
		return "/user/support/chinhSachVanChuyen";	
	}
	@GetMapping({"/4MEN/support/chinhSachBaoHanh"})
	public String chinhSachBaoHanh(HttpServletRequest request,Model model) {
		innitBrandsCate(request,model);
		return "/user/support/chinhSachBaoHanh";	
	}
	@GetMapping({"/4MEN/support/quyDinhDoiHang"})
	public String quyDinhDoiHang(HttpServletRequest request,Model model) {
		innitBrandsCate(request,model);
		return "/user/support/quyDinhDoiHang";	
	}
	
	public void innitBrandsCate(HttpServletRequest request,Model model) {
		model.addAttribute("brands", request.getSession().getAttribute("brands"));
		model.addAttribute("shoeTypes", request.getSession().getAttribute("shoeTypes"));
	}
}
