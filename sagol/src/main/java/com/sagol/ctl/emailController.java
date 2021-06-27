package com.sagol.ctl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagol.dto.emailVO;
import com.sagol.util.emailUtil;

@RestController
@RequestMapping("/email")
public class emailController {
	private static Logger logger = LoggerFactory.getLogger(emailController.class);
	
	@Autowired
	emailUtil emailutil;

	@RequestMapping(value = "/sendmail", method = RequestMethod.POST)
    @ResponseBody
	public boolean saveLocation(@RequestBody emailVO emailvo) {
		logger.info("address : "+emailvo.getToAddress()+"  subject : "+emailvo.getSubject()+"   body : "+emailvo.getBody() );
		emailutil.sendEmail(emailvo);
		return true;
	}
}