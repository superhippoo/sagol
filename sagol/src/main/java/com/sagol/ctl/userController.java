package com.sagol.ctl;

import java.util.ArrayList;
import java.util.List;

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
import com.sagol.svc.userSvc;

@RestController
@RequestMapping("/user")
public class userController {
	
	@Autowired
	private userSvc usersvc;


    @RequestMapping(value = "/selectuserlist",method = RequestMethod.POST)
    public ResponseEntity<message> selectUserList(@RequestBody userVO uservo){
    	message ms = new message();
    	List<userVO> resultvo = new ArrayList<userVO>();
    	resultvo = usersvc.selectUserList(uservo);
    	ms.setStatus(statusEnum.OK.getStatusCode());
    	ms.setData(resultvo);
    	ms.setReturnmessage("success");
    	if (resultvo == null) {
        	ms.setReturnmessage("no data");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
//        return usersvc.selectUserList(uservo);
    }
    
    @RequestMapping(value = "/selectuser",method = RequestMethod.POST)
    public ResponseEntity<message> selectUser(@RequestBody userVO uservo){
    	message ms = new message();
    	userVO resultvo = new userVO();
    	resultvo = usersvc.selectUser(uservo);
    	ms.setStatus(statusEnum.OK.getStatusCode());
    	ms.setData(resultvo);
    	ms.setReturnmessage("success");
    	if (resultvo == null) {
        	ms.setReturnmessage("no data");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/insertuser",method = RequestMethod.POST)
    public int insertUser(@RequestBody userVO uservo){
        return usersvc.insertUser(uservo);
    }
    
    @RequestMapping(value = "/updateuser",method = RequestMethod.POST)
    public int updateUser(@RequestBody userVO uservo){
        return usersvc.updateUser(uservo);
    }
    
    @RequestMapping(value = "/deleteuser",method = RequestMethod.POST)
    public int deleteUser(@RequestBody userVO uservo){
        return usersvc.deleteUser(uservo);
    }
    
    @RequestMapping(value = "/sendauthmail",method = RequestMethod.POST)
    public int sendAuthMail(@RequestBody userVO uservo){
        return usersvc.sendAuthMail(uservo);
    }
    
    @RequestMapping(value = "/checkauthcd",method = RequestMethod.POST)
    public boolean checkAuthCd(@RequestBody userVO uservo){
        return usersvc.checkAuthCd(uservo);
    }
    
}
