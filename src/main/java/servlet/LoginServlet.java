package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//创建shiro中的subject
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token  = new UsernamePasswordToken(username,password);
		
		String msg = null;
		try {
			
			subject.login(token);
			
		} catch (UnknownAccountException e) {
			msg = "用户名出错";
		}catch (IncorrectCredentialsException e) {
			msg ="密码出错";
		}catch (AuthenticationException e){
			msg = "其他异常"+e.getMessage();
		}
		
		if(msg != null) {
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		}
		
		resp.sendRedirect(req.getContextPath()+"/");
	}
}
