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
import com.sagol.dto.qnaVO;
import com.sagol.dto.requestVO;
import com.sagol.enums.statusEnum;
import com.sagol.exception.BadRequestException;
import com.sagol.svc.requestSvc;

@RestController
@RequestMapping("/request")
public class requestController {
	
	@Autowired
	private requestSvc requestsvc;


    @RequestMapping(value = "/selectrequestlist",method = RequestMethod.POST)
    public ResponseEntity<message> selectRequestList(@RequestBody requestVO requestvo){
    	message ms = new message();
		List<requestVO> resultvo = new ArrayList<requestVO>();
		resultvo = requestsvc.selectRequestList(requestvo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/selectrequestlistbyuid",method = RequestMethod.POST)
    public ResponseEntity<message> selectRequestListByUid(@RequestBody requestVO requestvo){
    	if (requestvo.getUid() == null || requestvo.getUid() == "") {
    		throw new BadRequestException("Uid Required");
		}
    	
		message ms = new message();
		List<requestVO> resultvo = new ArrayList<requestVO>();
		resultvo = requestsvc.selectRequestListByUid(requestvo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/selectrequestlistbycompleteyn",method = RequestMethod.POST)
    public ResponseEntity<message> selectRequestListByCompleteYn(@RequestBody requestVO requestvo){
    	if (requestvo.getComplete_yn() == null || requestvo.getComplete_yn() == "") {
    		throw new BadRequestException("CompleteYn Required");
		}
    	
		message ms = new message();
		List<requestVO> resultvo = new ArrayList<requestVO>();
		resultvo = requestsvc.selectRequestListByCompleteYn(requestvo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/selectrequestlistbyreqcd",method = RequestMethod.POST)
    public ResponseEntity<message> selectRequestListByReqCd(@RequestBody requestVO requestvo){
    	if (requestvo.getReq_cd() == null || requestvo.getReq_cd() == "") {
    		throw new BadRequestException("ReqCd Required");
		}
    	
		message ms = new message();
		List<requestVO> resultvo = new ArrayList<requestVO>();
		resultvo = requestsvc.selectRequestListByReqCd(requestvo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }

    @RequestMapping(value = "/selectrequest",method = RequestMethod.POST)
    public ResponseEntity<message> selectRequest(@RequestBody requestVO requestvo){
    	if (requestvo.getReq_id() == null || requestvo.getReq_id() == "") {
    		throw new BadRequestException("ReqId Required");
		}
    	message ms = new message();
    	requestVO resultvo = new requestVO();
    	resultvo = requestsvc.selectRequest(requestvo);
    	ms.setStatus(statusEnum.OK.getStatusCode());
    	ms.setData(resultvo);
    	ms.setReturnmessage("Success");
    	if (resultvo == null) {
        	ms.setReturnmessage("Data Not Found");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/insertrequest",method = RequestMethod.POST)
    public ResponseEntity<message> insertRequest(@RequestBody requestVO requestvo){
    	message ms = new message();
    	int result = requestsvc.insertRequest(requestvo);
    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Already Resist Request");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Insert Request Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/updaterequest",method = RequestMethod.POST)
    public ResponseEntity<message> updateRequest(@RequestBody requestVO requestvo){
    	if (requestvo.getReq_id() == null || requestvo.getReq_id() == "") {
    		throw new BadRequestException("ReqId Required");
		}
    	message ms = new message();
    	
    	int result = requestsvc.updateRequest(requestvo);
    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Request not found");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Update Request Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deleterequest",method = RequestMethod.POST)
    public ResponseEntity<message> deleteRequest(@RequestBody requestVO requestvo){
    	if (requestvo.getReq_id() == null || requestvo.getReq_id() == "") {
    		throw new BadRequestException("ReqId Required");
		}
    	
    	int result = requestsvc.deleteRequest(requestvo);
    	
    	message ms = new message();
    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Qna not found");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Delete Qna Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }   
}
