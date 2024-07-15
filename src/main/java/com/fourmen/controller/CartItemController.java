package com.fourmen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fourmen.dao.OrderDetailDao;
import com.fourmen.dao.OrdersDao;
import com.fourmen.entity.Accounts;
import com.fourmen.entity.Brand;
import com.fourmen.entity.Color;
import com.fourmen.entity.Product;
import com.fourmen.entity.Size;
import com.fourmen.entity.UserAcounts;
import com.fourmen.entity.Vouchers;
import com.fourmen.service.BrandService;
import com.fourmen.service.ColorService;
import com.fourmen.service.ProductService;
import com.fourmen.service.SizeService;
import com.fourmen.service.VoucherService;

@Controller
public class CartItemController {
	@Autowired
	public VoucherService vser;
	@Autowired
	ProductService productService;
	@Autowired
	OrdersDao ordersDao;
	@Autowired
	OrderDetailDao ordersDetailService;
	 @Autowired UserAcounts useAcc;
		@Autowired
		BrandService brandService;
		
		@Autowired
		ColorService colorSv;
		
		@Autowired
		SizeService sizeSV;
	//giỏ hàng
			@GetMapping("/4MEN/cartItem")
			public String gioHang(Model model) {
				Accounts account = useAcc.User();
				if(useAcc.User()==null) {
					return "redirect:/login";
				}
//				if(account.getAccountId() != null) {
//				Orders or = ordersDao.getGanNhat1(account.getAccountId());
//						if(or !=null) {
//								ordersDetailService.deleteAll(or.getOrderDetails());
//								ordersDao.delete(or);
//								System.out.println("Xóa Ok Order");
//						}
//				}
				List<Product> list = productService.findTop6Img();
				model.addAttribute("items", list);
				List<Color> colors = colorSv.findAll();
				model.addAttribute("colors", colors);
				List<Size> sizes = sizeSV.findAll();
				model.addAttribute("sizes",sizes);
				List<Brand> listBrand = brandService.findAll();
				model.addAttribute("brands", listBrand);
			List<Vouchers> voucher=vser.findAllByDate();
			List<Product> top10 = productService.top10a();
			model.addAttribute("account", account);
		    model.addAttribute("top10", top10);
			model.addAttribute("cates", voucher);
			return"/user/GioHang";
	
			}
}