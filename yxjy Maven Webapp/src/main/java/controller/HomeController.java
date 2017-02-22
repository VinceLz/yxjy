package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Product;
import service.ProductService;

@Controller
public class HomeController {

	@Resource
	private ProductService productService;

	@RequestMapping("/home")
	public String home(Model mod) {
		List<Product> find = productService.find();
		mod.addAttribute("product", find);
		return "jsp/index.jsp";
	}
}
