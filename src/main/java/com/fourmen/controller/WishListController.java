package com.fourmen.controller;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fourmen.entity.Accounts;
import com.fourmen.entity.Product;
import com.fourmen.entity.ProductDetail;
import com.fourmen.entity.UserAcounts;
import com.fourmen.entity.WishList;
import com.fourmen.service.AccountService;
import com.fourmen.service.ProductService;
import com.fourmen.service.WishListService;

@Controller
public class WishListController {
	
	@Autowired
	WishListService wishListService;
    @Autowired
    ProductService productService;
    @Autowired
    AccountService accountService;
    @Autowired 
	public  HttpSession session;
	@Autowired
	HttpServletRequest request;
	@Autowired
    UserAcounts useAcc;
	@Autowired
	HttpServletResponse response;
	
//	@GetMapping("")
//	public String findByUsername(Model model){
//		String username = request.getRemoteUser();
//		List<WishList> items = wishListService.findByUsername(username);
//		model.addAttribute("items", items);
//		return "/user/account/sanPhamYeuThich";
//	}
	
	@RequestMapping("/appLike/{id}")
	public String appLike(WishList item, @PathVariable("id") Integer id, Model model) {
	    ProductDetail Product = productService.getById(id);
	    Accounts Accounts =	useAcc.User();
	    if(Accounts==null) {
	    	return "redirect:/login";
	    }else {
	    	WishList w = new WishList();
		    w.setAccount(Accounts);
			w.setProductDetail(Product);
			w.setLikeDate(new Date());
		    
		    WishList was = wishListService.findBy(Product.getProductDetailId(),Accounts.getAccountId());
		    
		    
		    if (was == null) {
		    	System.out.println("Chưa Like" + id);
				try {
					wishListService.save(w);
					System.out.println("Like thành công !" + id);			
				} catch (Exception e) {
					System.out.println("Like thất bại " + e);
				}
			} else {
				w.setWishListId(was.getWishListId());
				wishListService.save(w);
				System.out.println("Đã Like" + id);
			}
			//return "user/product/ChiTietSP";
			//return "redirect:/4MEN/product/" + Product.getProductId();
		    return "redirect:/4MEN/account/favorite";
	    }
	    
	    
	}

}