package com.sagol.ctl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagol.dto.compVO;
import com.sagol.dto.message;
import com.sagol.dto.searchVO;
import com.sagol.enums.statusEnum;
import com.sagol.exception.BadRequestException;
import com.sagol.svc.compSvc;

@RestController
@RequestMapping("/comp")
public class compController {
	
	@Autowired
	private compSvc compsvc;
	
	@RequestMapping(value = "/selectcomplist", method = RequestMethod.POST)
	public ResponseEntity<message> selectCompList(@RequestBody compVO compvo) {

		message ms = new message();
		List<compVO> resultvo = new ArrayList<compVO>();
		resultvo = compsvc.selectCompList(compvo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
		ms.setTotalcount(Integer.toString(resultvo.size()));
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
	}

    @RequestMapping(value = "/selectcomp",method = RequestMethod.POST)
    public ResponseEntity<message> selectComp(@RequestBody compVO compvo){
    	if (compvo.getComp_cd() == null || compvo.getComp_cd() == "") {
    		throw new BadRequestException("Uid Required");
		}
    	message ms = new message();
    	compVO resultvo = new compVO();
    	resultvo = compsvc.selectComp(compvo);
    	ms.setStatus(statusEnum.OK.getStatusCode());
    	ms.setData(resultvo);
    	ms.setReturnmessage("Success");
    	if (resultvo == null) {
        	ms.setReturnmessage("Data Not Found");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/insertcomp",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<message> insertComp(@RequestBody compVO compvo){
    	
    	message ms = new message();
    	
    	int result = compsvc.insertComp(compvo);
    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Already Resist Comp");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Insert Comp Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }

    @RequestMapping(value = "/updatecomp",method = RequestMethod.POST)
    public ResponseEntity<message> updateComp(@RequestBody compVO compvo){
    	if (compvo.getComp_cd() == null || compvo.getComp_cd() == "") {
    		throw new BadRequestException("Compcd Required");
		}
    	message ms = new message();
    	
    	int result = compsvc.updateComp(compvo);
    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Comp not found");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Update Comp Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deletecomp",method = RequestMethod.POST)
    public ResponseEntity<message> deleteComp(@RequestBody compVO compvo){
    	if (compvo.getComp_cd() == null || compvo.getComp_cd() == "") {
    		throw new BadRequestException("Compcd Required");
		}
    	int result = compsvc.deleteComp(compvo);
    	message ms = new message();

    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Comp not found");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Delete Comp Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ResponseEntity<message> search(@RequestBody searchVO searchvo){
    	message ms = new message();
    	List<searchVO> resultvo = new ArrayList<searchVO>();
    	resultvo = compsvc.search(searchvo);
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
