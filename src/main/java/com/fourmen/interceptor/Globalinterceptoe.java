package com.fourmen.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fourmen.service.ShoeTypeService;
import com.fourmen.service.VoucherService;

@Component
public class Globalinterceptoe implements HandlerInterceptor{

	@Autowired
	ShoeTypeService shoeTypeService;
	@Autowired
	VoucherService voucherService;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("cates", shoeTypeService.findAll());
		request.setAttribute("voucher", voucherService.findAll());
	}
}