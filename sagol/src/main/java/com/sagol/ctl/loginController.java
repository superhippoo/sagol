package com.sagol.ctl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sagol.dto.message;
import com.sagol.dto.userVO;
import com.sagol.enums.statusEnum;
import com.sagol.svc.loginSvc;

@RestController
@RequestMapping("/login")
public class loginController {

	private Logger logger = LoggerFactory.getLogger(loginController.class);

	@Autowired
	private loginSvc loginsvc;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<message> login(@RequestBody userVO uservo,HttpServletRequest request){
    	
    	if (request.getAttribute("userVO") != null) {//기존에 로그인한 사용자의 세션 정보 삭제
    		logger.info("Already Login user Session Destroy");
			request.getSession().invalidate();
		}
    	message ms = new message();
    	ms.setStatus(statusEnum.OK.getStatusCode());
    	
    	userVO resultvo = new userVO();
    	resultvo = loginsvc.login(uservo);//로그인 처리
    	
    	ms.setData(resultvo);
    	ms.setReturnmessage("Login Fail");
    	
    	if ("Login ok".equals(resultvo.getMessage())) {// 로그인 성공일 경우 세션에 userVO 값 생성 
			request.getSession().setAttribute("userVO", resultvo);
			logger.info("Login OK"+resultvo.getNickname()+"/"+resultvo.getUid());
			if ("Y".equals(resultvo.getAuth_yn())) {
				resultvo.setMessage(resultvo.getMessage()+";Pro");
			}else {
				resultvo.setMessage(resultvo.getMessage()+";Ama");
			}
	    	ms.setReturnmessage("Success");
		}    	
    	//login ok 일경우 에서 auth 여부를 판단해서 재분기 리턴
        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<message> logout(HttpServletRequest request) {

		logger.info("Already Login user Session Destroy");
		request.getSession().invalidate();
		
		message ms = new message();
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(null);
		ms.setReturnmessage("Success");

		return new ResponseEntity<message>(ms, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/session", method = RequestMethod.POST)
	public ResponseEntity<message> getsession(HttpServletRequest request) {

		userVO resultvo = (userVO)request.getSession().getAttribute("userVO");
		
		message ms = new message();
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
		ms.setReturnmessage("Success");
    	if (resultvo == null) {
        	ms.setReturnmessage("Session Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
	}
 
}
