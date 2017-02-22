package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Article;
import pojo.Product;
import service.ArticleService;
import service.ProductService;
import util.DateUtil;
import util.ImgUtil;
import util.StringUtil;

@Controller
public class ArticleController {
	@Resource
	private ArticleService articleService;

	@Resource
	private ProductService productService;

	@RequestMapping("/article/getProduct")
	public String getProduct(Model mod, int pid) {
		List<Article> find = articleService.getArticleByPid(pid);
		mod.addAttribute("list", find);
		return "jsp/table_data_tables.jsp";

	}

	@RequestMapping("/article/getKp")
	public String getProduct2(Model mod) {
		List<Article> find = articleService.getArticleByKp();
		mod.addAttribute("list", find);
		return "jsp/kp_table_data_tables.jsp";

	}

	// 删除文章
	@RequestMapping("/article/delete")
	public String delete(int aid, Integer pid, HttpServletRequest request) {
		Article article = articleService.get(aid);
		articleService.delete(aid);

		final String realPath = request.getSession().getServletContext()
				.getRealPath("");
		final String img = article.getImg();
		if (img != null && !img.isEmpty()) {
			// 删除本地图片
			new Thread(new Runnable() {
				@Override
				public void run() {
					ImgUtil.deleteImg(img, realPath);
				}
			}).start();
		}
		if (pid == null) {
			return "/article/getKp.action";
		} else {
			return "article/getProduct.action?pid=" + pid;
		}

	}

	// 发布
	@RequestMapping("/article/add")
	public String send2(Article article, String product) {
		String[] split = null;
		if (article.getType() == 0) {
			split = product.split(",");
			article.setPid(Integer.parseInt(split[0]));
			article.setPname(split[1]);
			article.setAdate(DateUtil.getSqlDate());
		}

		// 文章图片
		List<String> imageSrc = util.ImgUtil.getImageSrc(article.getAcontent());
		String listToString = StringUtil.listToString(imageSrc, ",");
		article.setImg(listToString);
		if (article.getAuthor().isEmpty()) {
			article.setAuthor("管理员");
		}
		articleService.insert(article);
		if (article.getType() == 0) {
			return "article/getProduct.action?pid="
					+ Integer.parseInt(split[0]);
		} else {
			return "/article/getKp.action";
		}

	}

	// 获取简介内容
	@RequestMapping("/article/getJj")
	public String getJj(Model mod) {
		Article find = articleService.getJj();
		mod.addAttribute("content", find);
		return "jsp/mail_compose.jsp";

	}

	// 更新文章跳转
	@RequestMapping("/article/updatePre")
	public String getJj3(Model mod, int aid) {
		Article find = articleService.get(aid);

		if (find.getType() == 0) {
			System.out.println("进来了");
			mod.addAttribute("list", productService.find());
		}
		mod.addAttribute("article", find);
		return "jsp/update_form_basic.jsp";

	}

	// 更新文章
	@RequestMapping("/article/update")
	public String getJj4(Model mod, Article article, String product,
			HttpServletRequest request) {
		String[] split = null;
		if (article.getType() == 0) {
			split = product.split(",");
			article.setPid(Integer.parseInt(split[0]));
			article.setPname(split[1]);
		}

		// 新图片的地址
		final List<String> imageSrc = util.ImgUtil.getImageSrc(article
				.getAcontent());
		String listToString = StringUtil.listToString(imageSrc, ",");
		article.setImg(listToString);

		final String oldImg = articleService.get(article.getAid()).getImg();

		articleService.update(article);

		// 删除以前的图片
		final String realPath = request.getSession().getServletContext()
				.getRealPath("");

		if (oldImg != null && !oldImg.isEmpty()) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					ImgUtil.deleteImg(oldImg, imageSrc, realPath);
				}
			}).start();
		}
		if (article.getType() == 0) {
			return "article/getProduct.action?pid="
					+ Integer.parseInt(split[0]);
		} else {
			return "/article/getKp.action";
		}

	}

	// 更新简介内容
	@RequestMapping("/article/updateJj")
	public String updateJj(String info, Model mod, HttpServletRequest request) {
		// 旧的文章
		Article find = articleService.getJj();
		if (find == null) {
			// 新增文章
			Article article = new Article();
			article.setAcontent(info);
			final List<String> imageSrc = util.ImgUtil.getImageSrc(info);
			String img = StringUtil.listToString(imageSrc, ",");
			article.setImg(img);
			article.setType(1);
			articleService.insertJj(article);
			return "/article/getJj.action";
		}
		final String oldimg = find.getImg();

		// 更新图片
		final List<String> imageSrc = util.ImgUtil.getImageSrc(info);
		String listToString = StringUtil.listToString(imageSrc, ",");
		Map map = new HashMap<String, String>();
		map.put("img", listToString);
		map.put("info", info);

		articleService.updateJj(map);
		find.setAcontent(info);
		System.out.println(request);
		// 删除以前的图片
		final String realPath = request.getSession().getServletContext()
				.getRealPath("");
		System.out.println(realPath);
		if (oldimg != null && !oldimg.isEmpty()) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					ImgUtil.deleteImg(oldimg, imageSrc, realPath);
				}
			}).start();
		}

		mod.addAttribute("content", find);
		return "jsp/mail_compose.jsp";

	}
}
