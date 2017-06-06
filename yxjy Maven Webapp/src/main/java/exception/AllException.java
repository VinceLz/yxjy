package exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import pojo.User;

public class AllException implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String pathInfo = request.getRequestURI();
		if (pathInfo.contains("/front") || pathInfo.contains("/login")||pathInfo.contains("/logout")) {
			return true;
		} else {
			User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				// 没有登录重定向到登录页面
				response.sendRedirect("/jsp/login.jsp");
				return false;
			} else {
				// 放行
				return true;
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
