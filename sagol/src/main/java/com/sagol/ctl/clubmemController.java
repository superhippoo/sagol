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

import com.sagol.dto.clubmemVO;
import com.sagol.dto.message;
import com.sagol.dto.searchVO;
import com.sagol.enums.statusEnum;
import com.sagol.exception.BadRequestException;
import com.sagol.svc.clubmemSvc;

@RestController
@RequestMapping("/clubmem")
public class clubmemController {
	
	@Autowired
	private clubmemSvc clubmemsvc;


    @RequestMapping(value = "/selectclubmemlist",method = RequestMethod.POST)
    public ResponseEntity<message> selectClubmemList(@RequestBody clubmemVO clubmemvo){
		message ms = new message();
		List<clubmemVO> resultvo = new ArrayList<clubmemVO>();
		resultvo = clubmemsvc.selectClubmemList(clubmemvo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/selectclubmemlistbyclubid",method = RequestMethod.POST)
    public ResponseEntity<message> selectClubmemListByClubId(@RequestBody clubmemVO clubmemvo){
    	if (clubmemvo.getClub_id() == null || clubmemvo.getClub_id() == "") {
			throw new BadRequestException("Clubid Required");
		}
    	message ms = new message();
		List<clubmemVO> resultvo = new ArrayList<clubmemVO>();
		resultvo = clubmemsvc.selectClubmemListByClubId(clubmemvo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }

    @RequestMapping(value = "/selectclubmem",method = RequestMethod.POST)
    public ResponseEntity<message> selectClubmem(@RequestBody clubmemVO clubmemvo){
    	if (clubmemvo.getClub_id() == null || clubmemvo.getClub_id() == "" 
    			|| clubmemvo.getUid() == null || clubmemvo.getUid() == "") {
    		throw new BadRequestException("Uid or Clubid Required");
		}
    	message ms = new message();
    	clubmemVO resultvo = new clubmemVO();
    	resultvo = clubmemsvc.selectClubmem(clubmemvo);
    	ms.setStatus(statusEnum.OK.getStatusCode());
    	ms.setData(resultvo);
    	ms.setReturnmessage("Success");
    	if (resultvo == null) {
        	ms.setReturnmessage("Data Not Found");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/insertclubmem",method = RequestMethod.POST)
    public ResponseEntity<message> insertClubmem(@RequestBody clubmemVO clubmemvo){
    	int result = clubmemsvc.insertClubmem(clubmemvo);
    	message ms = new message();

    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Already Resist clubmember");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Insert clubmember Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/updateclubmem",method = RequestMethod.POST)
    public ResponseEntity<message> updateClubmem(@RequestBody clubmemVO clubmemvo){
    	if (clubmemvo.getClub_id() == null || clubmemvo.getClub_id() == "" 
    			|| clubmemvo.getUid() == null || clubmemvo.getUid() == ""
    			|| clubmemvo.getOwner_yn() == null || clubmemvo.getOwner_yn() == "") {
    		throw new BadRequestException("Uid or Clubid Required");
		}
    	int result = clubmemsvc.updateClubmem(clubmemvo);
    	message ms = new message();

    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Clubmem not found");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Update clubmem Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deleteclubmem",method = RequestMethod.POST)
    public ResponseEntity<message> deleteClubmem(@RequestBody clubmemVO clubmemvo){
    	if (clubmemvo.getClub_id() == null || clubmemvo.getClub_id() == "" 
    			|| clubmemvo.getUid() == null || clubmemvo.getUid() == ""
    			|| clubmemvo.getOwner_yn() == null || clubmemvo.getOwner_yn() == "") {
    		throw new BadRequestException("Uid or Clubid Required");
		}
    	int result = clubmemsvc.deleteClubmem(clubmemvo);
    	message ms = new message();

    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Clubmem not found");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Delete clubmem Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ResponseEntity<message> search(@RequestBody searchVO searchvo){
    	message ms = new message();
    	List<searchVO> resultvo = new ArrayList<searchVO>();
    	resultvo = clubmemsvc.search(searchvo);
    	ms.setStatus(statusEnum.OK.getStatusCode());
    	ms.setData(resultvo);
    	ms.setReturnmessage("Success");
    	if (resultvo.isEmpty()) {
        	ms.setReturnmessage("Data Not Found");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
   
}
