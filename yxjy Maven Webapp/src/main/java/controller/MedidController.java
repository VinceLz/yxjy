package controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pojo.Medid;
import service.MedidService;
import util.DateUtil;
import util.ImgUtil;

@Controller
public class MedidController {
	public static int pid = 9999;// 基地图片pid
	@Resource
	private MedidService medidService;

	@RequestMapping("/medid/find")
	public String find(int pid, Model model, String pname)
			throws UnsupportedEncodingException {
		System.out.println(pname + "----------");
		List<Medid> find = medidService.find(pid);
		model.addAttribute("list", find);
		String str = new String(pname.getBytes("iso-8859-1"), "utf-8");
		model.addAttribute("pname", str);
		model.addAttribute("pid", pid);
		return "jsp/blueimp.jsp";
	}

	@RequestMapping("/medid/delete")
	public String delete(int mid, HttpServletRequest request)
			throws UnsupportedEncodingException {
		Medid medid = medidService.get(mid);

		// 先删除数据库数据，图片新线程删除
		medidService.delete(mid);
		final String img = medid.getUrl();
		final String realPath = request.getSession().getServletContext()
				.getRealPath("");
		if (img != null && !img.isEmpty()) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// 删除本地图片
					ImgUtil.deleteImg(img, realPath);
				}
			}).start();
		}
		String str = new String(medid.getPname().getBytes("utf-8"),
				"iso-8859-1");

		return "medid/find.action?pid=" + medid.getPid() + "&pname=" + str;
	}

	@RequestMapping("/medid/upPre")
	public String find2(int pid, Model model, String pname)
			throws UnsupportedEncodingException {
		model.addAttribute("pname", new String(pname.getBytes("iso-8859-1"),
				"utf-8"));
		model.addAttribute("pid", pid);

		return "jsp/form_webuploader.jsp";
	}

	@RequestMapping("/medid/upload")
	public @ResponseBody
	String uploda(@RequestParam("files") MultipartFile[] files,
			HttpServletRequest request, String pname, String pid) {

		String RootPath = request.getSession().getServletContext()
				.getRealPath("/img")
				+ "/";

		for (MultipartFile file : files) {
			// 获得原始文件名
			String fileName = file.getOriginalFilename();
			String newFileName = UUID.randomUUID() + fileName;
			if (!file.isEmpty()) {
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

				Medid medid = new Medid();
				medid.setPid(Integer.parseInt(pid));
				medid.setPname(pname);
				medid.setType(0);
				medid.setUrl("/img/" + newFileName);
				// 写入数据库信息
				medidService.insert(medid);
			}
		}
		return "true";

	}

	@RequestMapping("/medid/video")
	public String getMp4(Model model) {
		List<Medid> list = medidService.findByVideo();
		model.addAttribute("list", list);
		return "jsp/mp4_table_data_tables.jsp";
	}

	@RequestMapping("/medid/addvideo")
	public String getMp4(Medid medid) {
		medid.setMdate(DateUtil.getSqlDate());
		medid.setType(1);
		medidService.insertVideo(medid);
		return "medid/video.action";
	}

	@RequestMapping("/medid/deletevideo")
	public String getMp5(Model model, int mid) {
		medidService.delete(mid);
		return "medid/video.action";
	}

}
