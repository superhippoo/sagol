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
import com.sagol.exception.BadRequestException;
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
    	ms.setReturnmessage("Success");
    	if (resultvo.isEmpty()) {
        	ms.setReturnmessage("Data Not Found");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }

    
    @RequestMapping(value = "/selectuser",method = RequestMethod.POST)
    public ResponseEntity<message> selectUser(@RequestBody userVO uservo){
    	if (uservo.getUid() == null || uservo.getUid() == "") {
    		throw new BadRequestException("Uid Required");
		}
    	message ms = new message();
    	userVO resultvo = new userVO();
    	resultvo = usersvc.selectUser(uservo);
    	ms.setStatus(statusEnum.OK.getStatusCode());
    	ms.setData(resultvo);
    	ms.setReturnmessage("Success");
    	if (resultvo == null) {
        	ms.setReturnmessage("Data Not Found");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/insertuser",method = RequestMethod.POST)
    public ResponseEntity<message> insertUser(@RequestBody userVO uservo){
    	
    	message ms = new message();
    	
    	int result = usersvc.insertUser(uservo);
    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Already Resist Email");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Insert User Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
     }
    
    @RequestMapping(value = "/updateuser",method = RequestMethod.POST)
    public ResponseEntity<message> updateUser(@RequestBody userVO uservo){
    	if (uservo.getUid() == null || uservo.getUid() == "") {
    		throw new BadRequestException("Uid Required");
		}
    	message ms = new message();
    	
    	int result = usersvc.updateUser(uservo);
    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("User not found");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Update User Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    

    
    @RequestMapping(value = "/deleteuser",method = RequestMethod.POST)
    public ResponseEntity<message> deleteUser(@RequestBody userVO uservo){
    	if (uservo.getUid() == null || uservo.getUid() == "") {
    		throw new BadRequestException("Uid Required");
		}
    	int result = usersvc.deleteUser(uservo);

    	message ms = new message();

    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("User not found");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Delete User Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/sendauthmail",method = RequestMethod.POST)
    public ResponseEntity<message> sendAuthMail(@RequestBody userVO uservo){
    	if (uservo.getComp_email() == null || uservo.getComp_email() == "") {
    		throw new BadRequestException("Comp_email Required");
		}
    	int result = usersvc.sendAuthMail(uservo);

    	message ms = new message();

    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Send mail Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/checkauthcd",method = RequestMethod.POST)
    public ResponseEntity<message> checkAuthCd(@RequestBody userVO uservo){
    	if (uservo.getUid() == null || uservo.getUid() == "") {
    		throw new BadRequestException("Uid Required");
		}    	
    	
    	boolean result = usersvc.checkAuthCd(uservo);
    	message ms = new message();

    	ms.setData(null);
    	if (result) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else {
        	ms.setStatus(statusEnum.OK.getStatusCode());
			ms.setReturnmessage("Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }

}
