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
import com.sagol.dto.searchVO;
import com.sagol.enums.statusEnum;
import com.sagol.exception.BadRequestException;
import com.sagol.svc.qnaSvc;

@RestController
@RequestMapping("/qna")
public class qnaController {
	
	@Autowired
	private qnaSvc qnasvc;


    @RequestMapping(value = "/selectqnalist",method = RequestMethod.POST)
    public ResponseEntity<message> selectQnaList(@RequestBody qnaVO qnavo){
    	
		message ms = new message();
		List<qnaVO> resultvo = new ArrayList<qnaVO>();
		resultvo = qnasvc.selectQnaList(qnavo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
		ms.setTotalcount(Integer.toString(resultvo.size()));
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/selectqnalistbyuid",method = RequestMethod.POST)
    public ResponseEntity<message> selectQnaListByUid(@RequestBody qnaVO qnavo){
    	
    	if (qnavo.getUid() == null || qnavo.getUid() == "") {
    		throw new BadRequestException("Uid Required");
		}
    	
		message ms = new message();
		List<qnaVO> resultvo = new ArrayList<qnaVO>();
		resultvo = qnasvc.selectQnaListByUid(qnavo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
		ms.setTotalcount(Integer.toString(resultvo.size()));
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }


    @RequestMapping(value = "/selectqna",method = RequestMethod.POST)
    public ResponseEntity<message> selectQna(@RequestBody qnaVO qnavo){
    	if (qnavo.getQna_id() == null || qnavo.getQna_id() == "") {
    		throw new BadRequestException("Qnaid Required");
		}
    	message ms = new message();
    	qnaVO resultvo = new qnaVO();
    	resultvo = qnasvc.selectQna(qnavo);
    	ms.setStatus(statusEnum.OK.getStatusCode());
    	ms.setData(resultvo);
    	ms.setReturnmessage("Success");
    	if (resultvo == null) {
        	ms.setReturnmessage("Data Not Found");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/insertqna",method = RequestMethod.POST)
    public ResponseEntity<message> insertQna(@RequestBody qnaVO qnavo){
    	message ms = new message();
    	int result = qnasvc.insertQna(qnavo);
    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Already Resist Qna");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Insert Qna Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/updateqna",method = RequestMethod.POST)
    public ResponseEntity<message> updateQna(@RequestBody qnaVO qnavo){
    	if (qnavo.getQna_id() == null || qnavo.getQna_id() == "") {
    		throw new BadRequestException("Qnaid Required");
		}
    	message ms = new message();
    	
    	int result = qnasvc.updateQna(qnavo);
    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Qna not found");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Update Qna Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deleteqna",method = RequestMethod.POST)
    public ResponseEntity<message> deleteQna(@RequestBody qnaVO qnavo){
    	if (qnavo.getQna_id() == null || qnavo.getQna_id() == "") {
    		throw new BadRequestException("Qnaid Required");
		}
    	
    	int result = qnasvc.deleteQna(qnavo);
    	
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
    
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ResponseEntity<message> search(@RequestBody searchVO searchvo){
    	message ms = new message();
    	List<searchVO> resultvo = new ArrayList<searchVO>();
    	resultvo = qnasvc.search(searchvo);
    	ms.setStatus(statusEnum.OK.getStatusCode());
    	ms.setData(resultvo);
    	ms.setTotalcount(Integer.toString(resultvo.size()));
    	ms.setReturnmessage("Success");
    	if (resultvo.isEmpty()) {
        	ms.setReturnmessage("Data Not Found");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
}
