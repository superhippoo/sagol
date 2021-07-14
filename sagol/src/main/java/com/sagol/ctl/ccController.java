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

import com.sagol.dto.ccVO;
import com.sagol.dto.compVO;
import com.sagol.dto.message;
import com.sagol.enums.statusEnum;
import com.sagol.exception.BadRequestException;
import com.sagol.svc.ccSvc;

@RestController
@RequestMapping("/cc")
public class ccController {
	
	@Autowired
	private ccSvc ccsvc;


    @RequestMapping(value = "/selectcclist",method = RequestMethod.POST)
    public ResponseEntity<message> selectCclist(@RequestBody ccVO ccvo){
		message ms = new message();
		List<ccVO> resultvo = new ArrayList<ccVO>();
		resultvo = ccsvc.selectCcList(ccvo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
		ms.setReturnmessage("Success");
		if (resultvo == null) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/selectcclistbycompcd",method = RequestMethod.POST)
    public ResponseEntity<message> selectCclistbycompcd(@RequestBody ccVO ccvo){
    	if (ccvo.getComp_cd() == null || ccvo.getComp_cd() == "") {
    		throw new BadRequestException("Uid Required");
		}
    	
    	message ms = new message();
		List<ccVO> resultvo = new ArrayList<ccVO>();
		resultvo = ccsvc.selectCcListByCompCd(ccvo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
		ms.setReturnmessage("Success");
		if (resultvo == null) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }

    @RequestMapping(value = "/selectcc",method = RequestMethod.POST)
    public ResponseEntity<message> selectCc(@RequestBody ccVO ccvo){
    	if (ccvo.getCc_id() == null || ccvo.getCc_id() == "") {
    		throw new BadRequestException("Uid Required");
		}
    	message ms = new message();
    	ccVO resultvo = new ccVO();
    	resultvo = ccsvc.selectCc(ccvo);
    	ms.setStatus(statusEnum.OK.getStatusCode());
    	ms.setData(resultvo);
    	ms.setReturnmessage("Success");
    	if (resultvo == null) {
        	ms.setReturnmessage("Data Not Found");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/insertcc",method = RequestMethod.POST)
    public ResponseEntity<message> insertCc(@RequestBody ccVO ccvo){
    	message ms = new message();
    	
    	int result = ccsvc.insertCc(ccvo);
    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Already Resist cc");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Insert cc Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/updatecc",method = RequestMethod.POST)
    public ResponseEntity<message> updateCc(@RequestBody ccVO ccvo){
    	if (ccvo.getCc_id() == null || ccvo.getCc_id() == "") {
    		throw new BadRequestException("CCid Required");
		}
    	message ms = new message();
    	
    	int result = ccsvc.updateCc(ccvo);
    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("CC not found");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Update CC Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deletecc",method = RequestMethod.POST)
    public ResponseEntity<message> deleteCc(@RequestBody ccVO ccvo){
    	if (ccvo.getCc_id() == null || ccvo.getCc_id() == "") {
    		throw new BadRequestException("CCid Required");
		}
    	message ms = new message();
    	
    	int result = ccsvc.deleteCc(ccvo);
    	ms.setData(null);
    	
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("CC not found");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Update CC Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
   
}
