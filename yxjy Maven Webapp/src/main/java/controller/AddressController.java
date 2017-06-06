package controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import pojo.Address;
import service.AddressService;
import util.ImgUtil;

@Controller
public class AddressController {

	@Resource
	private AddressService addressService;

	@RequestMapping("/address/get")
	public String get(Model model) {
		Address address = addressService.get();
		if (address == null) {
			addressService.insert(address);
		}
		model.addAttribute("address", address);
		return "jsp/Home_address_form_basic.jsp";
	}

	@RequestMapping("/address/update")
	public String get2(Address updateAddress, MultipartFile file,
			HttpServletRequest request) {

		if (file.isEmpty()) {
			// 不更新图片
			addressService.update(updateAddress);
		} else {
			Address address = addressService.get();
			final String pimg = address.getCode();
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
			updateAddress.setCode("/img/" + newFileName);
			addressService.update(updateAddress);
			if (pimg != null && !pimg.isEmpty()) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						ImgUtil.deleteImg(pimg, path);
					}
				}).start();
			}
		}
		return "/address/get.action";
	}

}
