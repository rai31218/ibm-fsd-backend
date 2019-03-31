package com.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filtering2 implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out= response.getWriter();
		String username=(String)request.getParameter("username");
		if(username!=null)
		{
		chain.doFilter(request, response);
		out.print(" "+username);
		}
		else
		{
			
			out.print("Invalid User");
		}
		
	}

}
