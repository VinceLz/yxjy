package controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import pojo.Home;
import pojo.Product;
import service.HomeSerice;
import service.ProductService;
import util.ImgUtil;

@Controller
public class HomeController {

	@Resource
	private ProductService productService;

	@Resource
	private HomeSerice homeSerice;

	@RequestMapping("/home")
	public String home(Model mod) {
		List<Product> find = productService.find();
		mod.addAttribute("product", find);
		return "jsp/index.jsp";
	}

	@RequestMapping("/home/imgPre")
	public String home2(Model mod) {
		// 获取首页图片
		List<Home> home = homeSerice.getHome(1);
		List<Home> home2 = homeSerice.getHome(2);
		home.addAll(home2);
		mod.addAttribute("list", home);
		return "jsp/Home_image_table_data_tables.jsp";
	}

	@RequestMapping("/home/imgDele")
	public String home3(int hid, HttpServletRequest request) {
		// 获取首页图片
		final Home byId = homeSerice.getById(hid);
		homeSerice.deleteImg(hid);
		// 对本地图片进行删除

		// 删除以前的图片
		final String realPath = request.getSession().getServletContext()
				.getRealPath("");

		if (byId.getContent() != null && !byId.getContent().isEmpty()) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					ImgUtil.deleteImg(byId.getContent(), realPath);
				}
			}).start();
		}
		return "/home/imgPre.action";
	}

	// 新增产品
	@RequestMapping("/home/addImg")
	public String product(Home product, MultipartFile file,
			HttpServletRequest request) {
		if (!file.isEmpty()) {

			String RootPath = request.getSession().getServletContext()
					.getRealPath("/img")
					+ "/";
			String fileName = file.getOriginalFilename();
			String newFileName = UUID.randomUUID() + fileName;

			try {
				FileOutputStream fos = new FileOutputStream(RootPath
						+ newFileName);
				InputStream in = file.getInputStream();
				int b1 = 0;
				while ((b1 = in.read()) != -1) {
					fos.write(b1);
				}
				fos.close();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 新增产品到数据库
			product.setContent("/img/" + newFileName);

			homeSerice.insert(product);
		}
		return "/home/imgPre.action";
	}

	@RequestMapping("/home/titlePre")
	public String home4(Model mod) {
		// 获取首页图片
		List<Home> home2 = homeSerice.getHome(0);

		mod.addAttribute("list", home2);
		return "jsp/Home_title_table_data_tables.jsp";
	}

	@RequestMapping("/home/titleDele")
	public String home5(int hid) {
		homeSerice.deleteImg(hid);
		return "/home/titlePre.action";
	}

	@RequestMapping("/home/addTitle")
	public String home6(Home home) {
		homeSerice.insert(home);
		return "/home/titlePre.action";
	}

}
