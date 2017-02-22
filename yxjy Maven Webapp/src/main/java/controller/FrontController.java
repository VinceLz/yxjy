package controller;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Article;
import pojo.Home;
import pojo.Product;

import service.ArticleService;
import service.HomeSerice;
import service.ProductService;

@Controller
public class FrontController {

	@Resource
	private HomeSerice homeSerice;

	@Resource
	private ProductService productService;

	@Resource
	private ArticleService articleService;

	@RequestMapping("/front/home")
	@ResponseBody
	public String getOne() {
		List<Home> home = homeSerice.getHome(0); // 文章
		List<Home> home2 = homeSerice.getHome(1); // 小图
		List<Home> home3 = homeSerice.getHome(2); // 大图
		List<Product> find = productService.find();
		// 科普 sql中实现了截取140个字符
		List<Article> findByType = articleService.findByType(2);
		JSONObject json = new JSONObject();
		json.element("notice", home);
		json.element("simage", home2);
		json.element("mimage", home3);
		json.element("prodects", find);
		json.element("kepu", findByType);
		return json.toString();
	}
}
