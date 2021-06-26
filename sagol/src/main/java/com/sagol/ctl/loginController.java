package com.sagol.ctl;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagol.dto.userVO;
import com.sagol.svc.loginSvc;

@RestController
@RequestMapping("/login")
public class loginController {

	private Logger logger = LoggerFactory.getLogger(loginController.class);

	@Autowired
	private loginSvc loginsvc;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public userVO login(@RequestBody userVO uservo,HttpServletRequest request){
    	
    	userVO resultvo = new userVO();
    	resultvo = loginsvc.login(uservo);
    	
    	if ("Login ok".equals(resultvo.getMessage())) {
			request.getSession().setAttribute("userVO", resultvo);
			logger.info(resultvo.getNikname()+"/"+resultvo.getUid());
		}    	

        return loginsvc.login(uservo);
    }
 
}
