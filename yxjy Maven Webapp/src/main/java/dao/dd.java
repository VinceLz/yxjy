package dao;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;
import org.w3c.dom.views.AbstractView;

import pojo.User;

public class dd extends AbstractSingleBeanDefinitionParser{

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String attribute = element.getAttribute("username");
		String attribute2 = element.getAttribute("email");
		builder.addPropertyValue("username", attribute);
		builder.addPropertyValue("email", attribute2);
	}
	@Override
	protected Class<?> getBeanClass(Element element) {
		return User.class;
	}
}
