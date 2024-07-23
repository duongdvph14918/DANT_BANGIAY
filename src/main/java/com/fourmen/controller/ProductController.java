package com.fourmen.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fourmen.entity.Brand;
import com.fourmen.entity.Color;
import com.fourmen.entity.Product;
import com.fourmen.entity.ProductDetail;
import com.fourmen.entity.ShoeType;
import com.fourmen.entity.Size;
import com.fourmen.entity.UserAcounts;
import com.fourmen.service.BrandService;
import com.fourmen.service.ColorService;
import com.fourmen.service.FeedbackService;
import com.fourmen.service.ImageProductService;
import com.fourmen.service.ProductDetailService;
import com.fourmen.service.ProductService;
import com.fourmen.service.ShoeTypeService;
import com.fourmen.service.SizeService;

@Controller
public class ProductController {
	
	@Autowired
	public  BrandService brandService;

	@Autowired
	public  ShoeTypeService shoeTypeService;

	@Autowired
	public  ProductService productService;
	
	@Autowired
	public  ProductDetailService productDetailService;
	
	@Autowired
	ImageProductService imageProductService;
	@Autowired
	FeedbackService feedbackService;
	@Autowired
	ColorService colorService;
	
	@Autowired
	SizeService sizeSV;
	
	 List<ShoeType> categories;
	 List<Brand> brands;
	 List<Product> productBest;
	 List<Color> colors;
	 List<Size> sizes;
	 
	 double price1 = 0;
		double price2 = 0;
		private Page<Product> products;
		String the;
	public void dulieu(HttpServletRequest request,Model model) {
		 HomeController homeme= new HomeController();
		 homeme.innitBrandsCate(request, model);
	}
	
	
	
	//seacher price
	@GetMapping("4MEN/product/price/{value}")
	public String searchPrice(HttpServletRequest request,Model model, @PathVariable("value") String value, @RequestParam("p") Optional<Integer> p) {
		dulieu(request,model);
		Pageable pageable = PageRequest.of(p.orElse(0), 8);
		
		Page<ProductDetail> page = productDetailService.getProducDetailByPirce(value,pageable);
		
		model.addAttribute("listproduct", page);
		model.addAttribute("number",page.getNumber());
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("size",page.getTotalElements());
		model.addAttribute("amount",value);
		return "/user/product/childSanPham";
	}
	
	//search size
	@GetMapping("4MEN/product/size/{value}")
	public String searchSize(HttpServletRequest request,Model model, @PathVariable("value") String value, @RequestParam("p") Optional<Integer> p) {
		dulieu(request,model);
		Pageable pageable = PageRequest.of(p.orElse(0), 8);
		Page<ProductDetail> page = productDetailService.getProducDetailBySize(value,pageable);
		model.addAttribute("listproduct", page);
		model.addAttribute("number",page.getNumber());
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("size",page.getTotalElements());
		model.addAttribute("sizeA",value);
		return "/user/product/childSanPham";
	}
	
	@GetMapping("/4MEN/product/color/{id}")
	public String tags(HttpServletRequest request,Model model, @PathVariable("id") String id,@RequestParam("p") Optional<Integer> p) {
		dulieu(request,model);
		Pageable pageable = PageRequest.of(p.orElse(0), 8);
		Page<ProductDetail> page = productDetailService.getProducDetailByColor(id,pageable);
		model.addAttribute("listproduct", page);
		model.addAttribute("number",page.getNumber());
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("size",page.getTotalElements());
		model.addAttribute("colorA",id);
		return "/user/product/childSanPham";
	}
	
	//search header
	@GetMapping("/4MEN/search")
	public String Search(HttpServletRequest request,Model model, @RequestParam("nameSearch") String name, Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0), 8);	
		dulieu(request,model);
		Page<Product> page = null;
		model.addAttribute("listproduct", page);
		model.addAttribute("number",page.getNumber());
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("size",page.getTotalElements());
		model.addAttribute("name",name);
		return "/user/product/childSanPham";
	}
	@Autowired
	UserAcounts useAcc;
	
	// Product
	@GetMapping("/4MEN/product")
	public String sanpham(HttpServletRequest request,Model model, @RequestParam("p") Optional<Integer> p) {
			Pageable pageable = PageRequest.of(p.orElse(0), 8);
			dulieu(request,model);
			String selectSapXep = request.getParameter("selectSapXep");
			Page<ProductDetail> page = null;
			if(selectSapXep!="" && selectSapXep!="null" && selectSapXep!=null) {
				if("1".equals(selectSapXep)) {
					page = productDetailService.selectRandom1(pageable);
				}else if("2".equals(selectSapXep)) {
					page = productDetailService.selectDateNew(pageable);
				}else if("3".equals(selectSapXep)) {
					page = productDetailService.selectBanChayNhat(pageable);
				}
			}else {
				page = productDetailService.findAll(pageable);
			}
			model.addAttribute("selectSapXep",selectSapXep); 
			model.addAttribute("listproduct", page);
			model.addAttribute("number",page.getNumber());
			model.addAttribute("totalPages",page.getTotalPages());
			model.addAttribute("size",page.getTotalElements());
			return "/user/product/childSanPham";
	}
	

	

	@GetMapping({"/4MEN/product/{id}"})
	public String loaiSp(Model model, @PathVariable("id") Integer id, @RequestParam("p") Optional<Integer> p) {
		//dulieu();
		Pageable pageable = PageRequest.of(p.orElse(0), 8);
//		Page<Product> page = productService.selectProductSpIdShoeType(id, pageable);
//		model.addAttribute("listproduct", page);
//		model.addAttribute("brands", brands);
//		model.addAttribute("colors", colors);
//		model.addAttribute("sizes",sizes);
//		model.addAttribute("listShoeType", categories);
//		model.addAttribute("productBest", productBest);
//		model.addAttribute("number",page.getNumber());
//		model.addAttribute("totalPages",page.getTotalPages());
//		model.addAttribute("totalElements",page.getTotalElements());
//		model.addAttribute("size",page.getSize());
//		System.out.println("toanf 09876: "+page.getSize());
		return "/user/product/childSanPham";
	}
	
	@GetMapping({"/4MEN/brand/{id}"})
	public String thuonghieu(HttpServletRequest request,Model model, @PathVariable("id") String id, @RequestParam("p") Optional<Integer> p) {
			dulieu(request,model);
				Pageable pageable = PageRequest.of(p.orElse(0), 8);
				Page<ProductDetail> page = productDetailService.findAllbyBranch(Integer.parseInt(id),pageable);
				model.addAttribute("listproduct", page);
				model.addAttribute("number",page.getNumber());
				model.addAttribute("totalPages",page.getTotalPages());
				model.addAttribute("totalElements",page.getTotalElements());
				model.addAttribute("size",page.getSize());
				model.addAttribute("branchIdMap", Integer.parseInt(id));
		return "/user/product/childSanPham";
	}
	
	@GetMapping({"/4MEN/product/shoeType/{id}"})
	public String loaisp2(HttpServletRequest request,Model model, @PathVariable("id") String id, @RequestParam("p") Optional<Integer> p) {
		System.out.println("id: " + id);
		products = null;
		dulieu(request,model);
		Pageable pageable = PageRequest.of(p.orElse(0), 8);
		Page<ProductDetail> page = productDetailService.selectProductByShoeType(Integer.parseInt(id),pageable);
		model.addAttribute("listproduct", page);
		model.addAttribute("colors", colors);
		model.addAttribute("sizes",sizes);
		model.addAttribute("listShoeType", categories);
		model.addAttribute("productBest", productBest);
		model.addAttribute("number",page.getNumber());
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("totalElements",page.getTotalElements());
		model.addAttribute("size",page.getSize());
		return "/user/product/childSanPham";
	}

	
	@PostMapping("/4MEN/product/search")
	public String search(Model model, @RequestParam("bran") String bran, @RequestParam("cate") String cate,
			@RequestParam("pric") String pric, @RequestParam("p") Optional<Integer> p) {
		
		return "/user/product/childSanPham";
	}

	
	
	//ChitietSp
			@GetMapping({"/4MEN/product/detail/{id}","/4MEN/product/tags/detail/{id}"
				,"/4MEN/product/tags/detail/detail/{id}","/4MEN/detail/{id}",
				"/4MEN/brand/detail/{id}","/4MEN/shoeType/detail/{id}","/4MEN/product/price/detail/{id}",
				"/4MEN/product/color/detail/{id}","/4MEN/account/detail/{id}","/chitietDH/4MEN/product/detail/{id}"})
			public String chitietSp(HttpServletRequest request,Model model ,@PathVariable("id") Integer id) {
				dulieu(request,model);
				ProductDetail item = productDetailService.getById(id);
				model.addAttribute("item", item);
				return "user/product/ChiTietSP";
			}
	
	
	

}
