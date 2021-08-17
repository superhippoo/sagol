package com.sagol.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sagol.dto.userVO;

@Configuration
public class adminInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("preHandle");
		HttpSession session = request.getSession();
		userVO uservo = (userVO) session.getAttribute("userVO");

        if("Y".equals(uservo.getAdmin_yn()) ){
        	System.out.println("preHandle true");
            return true;
        }

		System.out.println("preHandle false");
		response.setContentType("application/json");
    	response.setCharacterEncoding("UTF-8");
   	    response.getWriter().write("{\"status\":\"400\",\"returnmessage\":\"Admin Only\",\"data\":\"\",\"totalcount\":\"\"}");        	 
        return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
}
