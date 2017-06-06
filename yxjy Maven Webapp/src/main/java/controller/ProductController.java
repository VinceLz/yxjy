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

import pojo.Article;
import pojo.Medid;
import pojo.Product;
import service.ArticleService;
import service.MedidService;
import service.ProductService;
import util.ImgUtil;

@Controller
public class ProductController {

	@Resource
	private ProductService productService;
	@Resource
	private MedidService medidService;

	@Resource
	private ArticleService articleService;

	// 发布跳转
	@RequestMapping("/product/getProduct")
	public String send(Model mod, String kp) {
		if (kp == null) {
			List<Product> find = productService.find();
			mod.addAttribute("list", find);
			mod.addAttribute("type", 0);
		} else {
			// 发布的是科普
			mod.addAttribute("type", 2);
		}
		return "jsp/form_basic.jsp";
	}

	// 产品集合
	@RequestMapping("/product/get")
	public String product(Model mod) {
		List<Product> find = productService.find();
		mod.addAttribute("list", find);
		return "jsp/product_table_data_tables.jsp";
	}

	// 产品集合
	@RequestMapping("/product/updatePre")
	public String product(Model mod, int pid) {
		Product product = productService.get(pid);

		mod.addAttribute("item", product);
		return "jsp/update_product_form_basic.jsp";
	}

	// 更新产品
	@RequestMapping("/product/update")
	public String product2(Product product, MultipartFile file,
			HttpServletRequest request) {

		if (file.isEmpty()) {
			// 不更新图片
			productService.update(product);
		} else {
			Product old = productService.get(product.getPid());
			final String pimg = old.getPimg();
			String RootPath = request.getSession().getServletContext()
					.getRealPath("/img")
					+ "/";
			final String path = request.getSession().getServletContext()
					.getRealPath("");
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
			product.setPimg("/img/" + newFileName);
			productService.update(product);
			if (pimg != null && !pimg.isEmpty()) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						ImgUtil.deleteImg(pimg, path);
					}
				}).start();
			}
		}
		return "product/get.action";
	}

	// 新增产品
	@RequestMapping("/product/add")
	public String product(Product product, MultipartFile file,
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
			product.setPimg("/img/" + newFileName);
			product.setIsOk(1);
			productService.insert(product);
		} else {
			product.setIsOk(1);
			productService.insert(product);
		}
		return "product/get.action";
	}

	// 产品删除
	// Todo 对于删除的产品,需要把产品下的文章 图片都需要删除
	@RequestMapping("/product/delete")
	public String product2(Model mod, int pid, HttpServletRequest request) {
		// 需要删除图片和文章
		final String realPath = request.getSession().getServletContext()
				.getRealPath("");
		final List<Medid> find = medidService.find(pid);
		// 需要遍历find进行删除
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (Medid m : find) {
					String img = m.getUrl();
					System.out.println(img+"-----");
					if (img != null && !img.isEmpty()) {
						ImgUtil.deleteImg(img, realPath);
					}
				}
			}
		}).start();
		medidService.deleteByPid(pid);

		// 开始删除文章
		final List<Article> articleByPid = articleService.getArticleByPid(pid);

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (Article ar : articleByPid) {
					String img = ar.getImg();
					System.out.println(img+"-----");
					if (img != null && !img.isEmpty()) {
						ImgUtil.deleteImg(img, realPath);
					}
				}
			}
		}).start();
		//删除本地文章
		articleService.deleteByPid(pid);
		Product product = productService.get(pid);
		productService.delete(pid);
		// 启动新线程删除
		final String pimg = product.getPimg();
		if(pimg!=null&&!pimg.isEmpty()){
			new Thread(new Runnable() {
				@Override
				public void run() {
					ImgUtil.deleteImg(pimg, realPath);
				}
			}).start();
		}
		

		return "product/get.action";
	}

}
