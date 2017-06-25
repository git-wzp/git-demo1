package utils;

import java.lang.reflect.InvocationTargetException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class beanFactory {
	public static Object getBean(String sid) throws Exception{
		Object result = null;
		//接收参数 
		// 从xml中获取对应的全类名路径
		SAXReader reader = new SAXReader();
		try {
			Document dom = reader.read(beanFactory.class.getClassLoader().getResourceAsStream("application-config.xml"));
			Element beans = dom.getRootElement();
			Element element = (Element) beans.selectSingleNode("//beans[@id'"+sid+"']");
			String classStr = element.attributeValue("class");
			//处理数据 反射
			Class clazz = Class.forName(classStr);
			 result = clazz.getConstructor().newInstance();
		
		
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
		
		
		return result;
	}
}
