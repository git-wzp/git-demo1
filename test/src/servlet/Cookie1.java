package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookie1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			Cookie[] cookies = request.getCookies();
			String value = null ;
			for (int i = 0;cookies!=null&& i < cookies.length; i++) {
				
				if(cookies[i].getName().equals("lastAccessTime")){
					 value = cookies[i].getValue();
				}
			}
			System.out.println("最后时间"+value);
			Date date = new Date(Long.parseLong(value));
			PrintWriter writer = response.getWriter();
			
			writer.print(date.toLocaleString());
			
			Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
			cookie.setMaxAge(1*30*24*3600);
			cookie.setPath("/test");
			response.addCookie(cookie);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
