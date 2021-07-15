package com.sagol.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sagol.dto.userVO;

public class sessionUtil {
	public static userVO getSession(HttpServletRequest request) {

		HttpSession session = request.getSession();
		userVO resultvo = (userVO) session.getAttribute("userVO");
		return resultvo;
	}
}
