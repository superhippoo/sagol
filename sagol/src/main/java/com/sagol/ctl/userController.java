package com.sagol.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagol.dto.userVO;
import com.sagol.svc.userSvc;

@RestController
@RequestMapping("/user")
public class userController {
	
	@Autowired
	private userSvc usersvc;


    @RequestMapping(value = "/selectuserlist",method = RequestMethod.POST)
    @ResponseBody
    public List<userVO> selectUserList(@RequestBody userVO uservo){
        return usersvc.selectUserList(uservo);
    }
 
    @RequestMapping(value = "/selectuser",method = RequestMethod.POST)
    @ResponseBody
    public userVO selectUser(@RequestBody userVO uservo){
        return usersvc.selectUser(uservo);
    }
    
    @RequestMapping(value = "/insertuser",method = RequestMethod.POST)
    @ResponseBody
    public int insertUser(@RequestBody userVO uservo){
        return usersvc.insertUser(uservo);
    }
    
    @RequestMapping(value = "/updateuser",method = RequestMethod.POST)
    @ResponseBody
    public int updateUser(@RequestBody userVO uservo){
        return usersvc.updateUser(uservo);
    }
    
    @RequestMapping(value = "/deleteuser",method = RequestMethod.POST)
    @ResponseBody
    public int deleteUser(@RequestBody userVO uservo){
        return usersvc.deleteUser(uservo);
    }
    
    @RequestMapping(value = "/sendauthmail",method = RequestMethod.POST)
    @ResponseBody
    public int sendAuthMail(@RequestBody userVO uservo){
        return usersvc.sendAuthMail(uservo);
    }
    
    @RequestMapping(value = "/checkauthcd",method = RequestMethod.POST)
    @ResponseBody
    public boolean checkAuthCd(@RequestBody userVO uservo){
        return usersvc.checkAuthCd(uservo);
    }
    
}
