package com.str.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.str.cdi.BeanTypeEnum;
import com.str.model.SimpleBean;
import com.str.service.BeanService;

@WebServlet("/fails")
public class AppScopedServlet extends HttpServlet {

	@Inject
	BeanService<SimpleBean> beanService;
	
	public AppScopedServlet() {
		// For CDI
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SimpleBean bean = beanService.lookup(BeanTypeEnum.ONE);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.write(bean.getMessage());
	}

}


