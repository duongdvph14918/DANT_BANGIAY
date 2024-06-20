package com.fourmen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fourmen.entity.Accounts;
import com.fourmen.entity.Brand;
import com.fourmen.entity.Color;
import com.fourmen.entity.Product;
import com.fourmen.entity.Size;
import com.fourmen.entity.UserAcounts;
import com.fourmen.service.BrandService;
import com.fourmen.service.ColorService;
import com.fourmen.service.ProductService;
import com.fourmen.service.SizeService;

@Controller
public class LoginController {
	@Autowired 
	HttpSession session;
	@Autowired
    UserAcounts useAcc;
	@Autowired
	SizeService sizeSV;
	@Autowired
	ColorService colorSv;
	@Autowired
	BrandService brandService;
	
	@Autowired
	ProductService productSV;
	//Login
	@GetMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		Accounts acount = useAcc.User();
		if(acount!=null) {
			model.addAttribute("message", "LOCK");
			request.getSession().setAttribute("message", "LOCK");
			session.removeAttribute("User");
			session.invalidate();
		}else {
			model.addAttribute("message", "");
			request.getSession().setAttribute("message", "");
		}
		
		return"/user/login/dangNhap";
	}
	//đăng ký
	@GetMapping("/registers")
	public String dangky(Model model) {
		List<Color> colors = colorSv.findAll();
		model.addAttribute("colors", colors);
		List<Size> sizes = sizeSV.findAll();
		model.addAttribute("sizes",sizes);
		
		List<Brand> listBrand = brandService.findAll();
		model.addAttribute("brands", listBrand);
		return"/user/login/dangKyTK";
	}
	
	@GetMapping("/forgotPassword")
	public String quenMatKhau(Model model) {
		List<Color> colors = colorSv.findAll();
		model.addAttribute("colors", colors);
		List<Size> sizes = sizeSV.findAll();
		model.addAttribute("sizes",sizes);
		
		List<Brand> listBrand = brandService.findAll();
		model.addAttribute("brands", listBrand);
		return"/user/quenMK";
	}
	
	@GetMapping("/logout")
	public String dangXuat() {
		session.removeAttribute("User");
		session.invalidate();
		return"redirect:/login";
	}
		
	@GetMapping("/4MEN/chinhSachBaoHanh")
	public String chinhSachBaoHanh(Model model) {
		List<Color> colors = colorSv.findAll();
		model.addAttribute("colors", colors);
		List<Size> sizes = sizeSV.findAll();
		model.addAttribute("sizes",sizes);
		
		List<Brand> listBrand = brandService.findAll();
		model.addAttribute("brands", listBrand);
		return "/user/csbh/csbh";
	}
	
	@GetMapping("/4MEN/chinhSachDoiTra")
	public String chinhSachDoiTra(Model model) {
		List<Color> colors = colorSv.findAll();
		model.addAttribute("colors", colors);
		List<Size> sizes = sizeSV.findAll();
		model.addAttribute("sizes",sizes);
		
		List<Brand> listBrand = brandService.findAll();
		model.addAttribute("brands", listBrand);
		return "/user/csbh/csdt";
	}
	
}
