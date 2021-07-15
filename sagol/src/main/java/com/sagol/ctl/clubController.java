package com.sagol.ctl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sagol.dto.clubVO;
import com.sagol.dto.message;
import com.sagol.enums.statusEnum;
import com.sagol.exception.BadRequestException;
import com.sagol.svc.clubSvc;

@RestController
@RequestMapping("/club")
public class clubController {
	
	@Autowired
	private clubSvc clubsvc;


    @RequestMapping(value = "/selectclublist",method = RequestMethod.POST)
    public ResponseEntity<message> selectClubList(@RequestBody clubVO clubvo){
    	if (clubvo.getClub_type() == null || clubvo.getClub_type() == "") {
    		throw new BadRequestException("Clubtype Required");
		}
		message ms = new message();
		List<clubVO> resultvo = new ArrayList<clubVO>();
		resultvo = clubsvc.selectClubList(clubvo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/selectclublistbyccid",method = RequestMethod.POST)
    public ResponseEntity<message> selectCclistbycompcd(@RequestBody clubVO clubvo){
		if (clubvo.getClub_type() == null || clubvo.getClub_type() == "" 
				|| clubvo.getCc_id() == null || clubvo.getCc_id() == "") {
			throw new BadRequestException("Clubid or CCid Required");
		}
		message ms = new message();
		List<clubVO> resultvo = new ArrayList<clubVO>();
		resultvo = clubsvc.selectClubListByCcId(clubvo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }

    @RequestMapping(value = "/selectclub",method = RequestMethod.POST)
    public ResponseEntity<message> selectClub(@RequestBody clubVO clubvo){
    	if (clubvo.getClub_id() == null || clubvo.getClub_id() == "") {
    		throw new BadRequestException("Clubid Required");
		}
    	message ms = new message();
    	clubVO resultvo = new clubVO();
    	resultvo = clubsvc.selectClub(clubvo);
    	ms.setStatus(statusEnum.OK.getStatusCode());
    	ms.setData(resultvo);
    	ms.setReturnmessage("Success");
    	if (resultvo == null) {
        	ms.setReturnmessage("Data Not Found");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/insertclub",method = RequestMethod.POST)
    public ResponseEntity<message> insertClub(@RequestBody clubVO clubvo,HttpServletRequest request){
    	int result = clubsvc.insertClub(clubvo,request);
    	message ms = new message();

    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Already Resist club");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Insert club Fail");
		}
    	//to-do
    	//클럽을 만들면서 생성자를 바로 멤버로 넣는것을 서비스단에 같이 녹일지 ??
        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/updateclub",method = RequestMethod.POST)
    public ResponseEntity<message> updateClub(@RequestBody clubVO clubvo){
    	if (clubvo.getClub_id() == null || clubvo.getClub_id() == "") {
    		throw new BadRequestException("Clubid Required");
		}
    	int result = clubsvc.updateClub(clubvo);
    	message ms = new message();

    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Club not found");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Update club Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deleteclub",method = RequestMethod.POST)
    public ResponseEntity<message> deleteClub(@RequestBody clubVO clubvo){
    	if (clubvo.getClub_id() == null || clubvo.getClub_id() == "") {
    		throw new BadRequestException("Clubid Required");
		}
    	int result = clubsvc.deleteClub(clubvo);
    	message ms = new message();

    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Club not found");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Delete club Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
   
}
