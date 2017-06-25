package bookshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 这个Servlet是用来显示 
 */
public class Bookshop extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//1 输出网站所有商品
		out.write("以下为所有商品 <br/>");
		  Map<String, Book> all = DB_book.getAll();
		  for( Map.Entry<String, Book>  al: all.entrySet()){
			  Book value = al.getValue(); 
			  out.write("<a href='/test/Bookeshop_setcookie?id="+value.getId()+"' target = '_blank'>"+value.getName()+"</a><br/>");
		  }
		  //显示用户看过的商品
		  
		  out.print("您以前看过的商品+<br/>");
		  Cookie[] cookies = request.getCookies();
		  for (int i = 0; cookies!=null&&i < cookies.length; i++) {
			if(cookies[i].getName().equals("bookHistory")){  //判断是不是名为bookHistory的cookie
				//得到cookie 的值
				String value = cookies[i].getValue(); //得到是书的号 2 ，1,3
				//得到的是每一个书号
				String[] split = value.split("\\,"); 
				//根据每一个书号得到对应的书名

				for(String s: split){
					//getAll获取到map对象 通过get（id）获取
					Book book = DB_book.getAll().get(s);
					out.println(book.getName()+"<br/>");
				}
			}
		}
		  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
