package com.fourmen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fourmen.entity.News;
import com.fourmen.service.NewsService;

@Controller

public class NewController {
//	@Autowired
//	private NewsService vser;
//	@RequestMapping("/4MEN/blog/{newsId}")
//	//lấy thông tin từ trình duyệt gắn vào Integer id (PathValueable)
//	public String detail(Model model,@PathVariable("newsId") Integer id) {
//		News item=vser.getById(id);
//		model.addAttribute("details", item);
//		//Duyệt các bài viết mới nhất
//		List<News> list=vser.findAll();
//		model.addAttribute("news", list);
//		return "/user/news/TinTuc";
//	}
}