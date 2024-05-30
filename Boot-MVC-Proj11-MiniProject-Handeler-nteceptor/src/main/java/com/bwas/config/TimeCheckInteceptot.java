package com.bwas.config;

import java.time.LocalDateTime;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeCheckInteceptot implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TimeCheckInteceptot.preHandle()");
		if(request.getServletPath().equalsIgnoreCase("/")) {
			return true;
		}
		LocalDateTime ldt = LocalDateTime.now();
		int hour = ldt.getHour();
		if(hour<16 || hour>17) {
			RequestDispatcher rd = request.getRequestDispatcher("/timeout.jsp");
			rd.forward(request, response);
			return false;
		}
		return true;
	}
}
