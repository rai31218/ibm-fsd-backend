package com.servlet.filter;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filtering implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String host=(String)request.getRemoteHost();
		System.out.println("Req recvd frm: "+host+" at "+ LocalDateTime.now());
		chain.doFilter(request, response);
		
	}

}
