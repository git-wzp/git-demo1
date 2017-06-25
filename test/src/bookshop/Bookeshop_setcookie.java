package bookshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Bookeshop_setcookie  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		/**
		 * 这一部分是得到物品的详细信息
		 */
		//这里不能用getAttitude  这个是取域中的数据的 用getproper
		//String id = (String) request.getAttribute("id");
		
		//获取的是用户点击链接传输的值 对应的是map的key
		String id = request.getParameter("id");
		//getAll得到数据库中的所有的map get（id)得到对应的book对象
		Book book = DB_book.getAll().get(id);
		out.println(book.getId()+"<br/>");
		out.println(book.getName()+"<br/>");
		out.println(book.getAuthor()+"<br/>");
		out.println(book.getDescription()+"<br/>");
		
		/*
		 * 这一部分给cookie存入浏览记录
		 * 分析 最新看的要在最前面 
		 */
		//创建一个cookie内容  有以前的记录 和这次的记录
		 String cookisvalue = builder_cookie(id,request.getCookies());
		 Cookie cookie = new Cookie("bookHistory", cookisvalue);
		 cookie.setMaxAge(1*30*24*3600);
		 cookie.setPath("/test");
		 response.addCookie(cookie);
		 
	}

	public String builder_cookie(String id, Cookie[] cookies) {
		//用户没有带cookie来	返回id
		//用户的cookie里有这个记录   删除以前的重新添加一个最前面
		//
		String cookievalue = null;
		for (int i = 0;cookies!=null&& i < cookies.length; i++) {
			if(cookies[i].getName().equals("bookHistory")){
				cookievalue = cookies[i].getValue();  
			}
		}
		
		
		
		//用户没有带cookie来	返回id
		if(cookievalue==null){
			return id;
		}
		
		
		//用户的cookie里有这个记录   删除以前的重新添加一个最前面
		LinkedList linkedList = new LinkedList(Arrays.asList(cookievalue.split("\\,")));
		if(linkedList.contains(id)){
			linkedList.remove(id);
			linkedList.addFirst(id);
		}else if(linkedList.size()>5){ //cookie 的长度已经满了5条
			linkedList.removeLast();
			linkedList.addFirst(id);
		}else {
			linkedList.addFirst(id);   //没满 也没重复 也有值 
		}
		//因为最后的值都是String类型的没有分隔符 为 23465这样的
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < linkedList.size()
				; i++) {
			if(i!=linkedList.size()){
			sb.append(linkedList.get(i)+",");
			}else{
				sb.append(linkedList.get(i));
			}
		}
		System.out.println(sb);
		 return sb.toString();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
