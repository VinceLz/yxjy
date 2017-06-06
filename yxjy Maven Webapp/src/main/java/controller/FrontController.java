package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Address;
import pojo.Article;
import pojo.Home;
import pojo.Medid;
import pojo.Product;
import pojo.User;
import service.AddressService;
import service.ArticleService;
import service.HomeSerice;
import service.MedidService;
import service.ProductService;
import service.UserService;

@Controller
public class FrontController {

	@Resource
	private HomeSerice homeSerice;

	@Resource
	private ProductService productService;

	@Resource
	private ArticleService articleService;

	@Resource
	private MedidService medidService;

	@Resource
	private UserService userService;
	@Resource
	private AddressService addressService;

	@RequestMapping("/front/home")
	@ResponseBody
	public String getOne() {
		List<Home> home = homeSerice.getHome(0); // 文章
		List<Home> home2 = homeSerice.getHome(1); // 小图
		List<Home> home3 = homeSerice.getHome(2); // 大图
		Article ar = articleService.getJj();
		List<Product> find = productService.find();

		// 科普 sql中实现了截取140个字符
		List<Article> findByType = articleService.findByType(2);
		List<Medid> findByVideo = medidService.findByVideo();
		Address address = addressService.get();
		JSONObject json = new JSONObject();
		if (findByVideo != null) {
			json.element("video", findByVideo.get(0));
		}
		json.element("jjId", ar.getAid());
		json.element("tx1", ar.getTx1());
		json.element("tx2", ar.getTx2());
		json.element("tx3", ar.getTx3());
		json.element("notice", home);
		json.element("simage", home2);
		json.element("mimage", home3);
		json.element("product", find);
		json.element("kepu", findByType);
		json.element("address", address);
		return json.toString();
	}

	@RequestMapping("/front/getpList")
	@ResponseBody
	public String getOne2(int pid) {
		// 获取产品列表
		List<Article> findByType = articleService.getClassByPid(pid);// 产品文章
		List<Medid> findByType2 = medidService.getByPid(pid);
		JSONObject json = new JSONObject();
		json.element("list", findByType);
		json.element("imglist", findByType2);
		return json.toString();
	}

	@RequestMapping("/front/getp")
	@ResponseBody
	public String getOne3(int aid) {
		// 获取产品列表
		Article findByType = articleService.get(aid);// 产品文章
		JSONObject json = new JSONObject();
		if (findByType.getType() == 1) {
			// 简介文章
			List<Medid> find = medidService.find(MedidController.pid);
			json.element("imgList", find);
		}
		json.element("article", findByType);
		return json.toString();
	}

	@RequestMapping("/front/getjj")
	@ResponseBody
	public String getOne31() {
		// 获取产品列表
		Article findByType = articleService.getJj();
		JSONObject json = new JSONObject();
		json.element("jj", findByType);
		return json.toString();
	}

	@RequestMapping("/login")
	public String getOne321(String uname, String pswd, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 获取产品列表
		Map map = new HashMap<String, String>();
		map.put("uname", uname);
		map.put("pswd", pswd);
		User user = userService.getUser(map);

		if (user != null) {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("home.action");
			return null;
		} else {
			model.addAttribute("msg", "登录失败！请检查用户名/密码");
			return "jsp/login.jsp";
		}

	}

	@RequestMapping("/logout")
	public String getOne32221(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("jsp/login.jsp");
		return null;
	}
}
