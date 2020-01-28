package com.wipro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.wipro.daoImpl.LoginDaoImpl;
import com.wipro.form.CommonForm;
import com.wipro.service.LoginService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	
	CommonForm commonform=new CommonForm();
	LoginService loginService=new LoginService();
	LoginDaoImpl logindaoimpl = new LoginDaoImpl();
	
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
				
		commonform.setCustomerid(req.getParameter("customerid"));
		commonform.setPassword(req.getParameter("password"));
		
		System.out.println("uname  "+commonform.getCustomerid());
		System.out.println("Pass  "+commonform.getPassword());
		 	
		
		loginService.customervalidation(commonform);	 
		System.out.println("after validation>>>>");
		if(commonform.isFlag())
		  {
			System.out.println("the flag is "+commonform.isFlag());
			HttpSession session= req.getSession();
			session.setAttribute("balance", commonform.getBalance());
			res.sendRedirect("offerpage.jsp");
		  }
		  else
		  {
			  System.out.println("again index page");
			  res.sendRedirect("index.jsp");
		  }
		
	}

}
