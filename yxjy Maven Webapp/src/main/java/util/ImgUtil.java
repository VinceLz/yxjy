package util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class ImgUtil {
	/*
	 * 这是一个工具类，来ueditor中获取图片的地址保存到数据库中用的
	 */
	public static List<String> getImageSrc(String htmlCode) {
		List<String> imageSrcList = new ArrayList<String>();
		Pattern p = Pattern
				.compile(
						"<img\\b[^>]*\\bsrc\\b\\s*=\\s*('|\")?([^'\"\n\r\f>]+(\\.jpg|\\.bmp|\\.eps|\\.gif|\\.mif|\\.miff|\\.png|\\.tif|\\.tiff|\\.svg|\\.wmf|\\.jpe|\\.jpeg|\\.dib|\\.ico|\\.tga|\\.cut|\\.pic)\\b)[^>]*>",
						Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(htmlCode);
		String quote = null;
		String src = null;
		while (m.find()) {
			quote = m.group(1);
			src = (quote == null || quote.trim().length() == 0) ? m.group(2)
					.split("\\s+")[0] : m.group(2);
			for(int i=0;i<3;i++){
				src=src.substring(src.indexOf("/")+1);
			}
			System.out.println(src);
			imageSrcList.add("/"+src);
		}
		return imageSrcList;
	}

	/*
	 * 根据传入的路径删除本地图片
	 */
	public static void deleteImg(String img, List<String> imageSrc,
			String realPath) {
		System.out.println("进来了");
		List<String> asList = Arrays.asList(img.split(","));
		ArrayList<String> array = new ArrayList<String>(asList);

		array.removeAll(imageSrc);

		for (String ar : array) {
			File file = new File(realPath + ar);
			System.out.println(file.getAbsolutePath()+"-----------------");
			if (file.exists()) {
				System.out.println("存在的，删除了");
				file.delete();
			}
		}
	}

	public static void deleteImg(String img, String path) {
		String[] split = img.split(",");
		for (String str : split) {
			File file = new File(path + str);
			System.out.println(file.getAbsolutePath());
			if (file.exists()) {
				file.delete();
			}
		}
	}
}
