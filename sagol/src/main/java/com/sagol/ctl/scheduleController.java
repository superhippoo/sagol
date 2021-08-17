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

import com.sagol.dto.message;
import com.sagol.dto.scheduleVO;
import com.sagol.dto.searchVO;
import com.sagol.enums.statusEnum;
import com.sagol.exception.BadRequestException;
import com.sagol.svc.scheduleSvc;

@RestController
@RequestMapping("/schedule")
public class scheduleController {
	
	@Autowired
	private scheduleSvc schedulesvc;


    @RequestMapping(value = "/selectschedulelist",method = RequestMethod.POST)
    public ResponseEntity<message> selectScheduleList(@RequestBody scheduleVO schedulevo){
		message ms = new message();
		List<scheduleVO> resultvo = new ArrayList<scheduleVO>();
		resultvo = schedulesvc.selectScheduleList(schedulevo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
    	ms.setTotalcount(Integer.toString(resultvo.size()));
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/selectschedulelistbyclubid",method = RequestMethod.POST)
    public ResponseEntity<message> selectScheduleListByClubId(@RequestBody scheduleVO schedulevo){
    	if (schedulevo.getClub_id() == null || schedulevo.getClub_id() == "") {
    		throw new BadRequestException("ClubId Required");
		}
    	
		message ms = new message();
		List<scheduleVO> resultvo = new ArrayList<scheduleVO>();
		resultvo = schedulesvc.selectScheduleListByClubId(schedulevo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
    	ms.setTotalcount(Integer.toString(resultvo.size()));
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/selectschedulelistbyuid",method = RequestMethod.POST)
    public ResponseEntity<message> selectScheduleListByUid(HttpServletRequest request){
    	
		message ms = new message();
		List<scheduleVO> resultvo = new ArrayList<scheduleVO>();
		resultvo = schedulesvc.selectScheduleListByUid(request);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
    	ms.setTotalcount(Integer.toString(resultvo.size()));
		ms.setReturnmessage("Success");
		if (resultvo.isEmpty()) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/selectschedule",method = RequestMethod.POST)
    public ResponseEntity<message> selectSchedule(@RequestBody scheduleVO schedulevo){
    	if (schedulevo.getClub_id() == null || schedulevo.getClub_id() == "") {
    		throw new BadRequestException("ClubId Required");
		}
    	if (schedulevo.getSchedule_id() == null || schedulevo.getSchedule_id() == "") {
    		throw new BadRequestException("ScheduleId Required");
		}
    	
		message ms = new message();
		scheduleVO resultvo = new scheduleVO();
		resultvo = schedulesvc.selectSchedule(schedulevo);
		ms.setStatus(statusEnum.OK.getStatusCode());
		ms.setData(resultvo);
		ms.setReturnmessage("Success");
		if (resultvo == null) {
			ms.setReturnmessage("Data Not Found");
		}

		return new ResponseEntity<message>(ms, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/insertschedule",method = RequestMethod.POST)
    public ResponseEntity<message> insertRequest(@RequestBody scheduleVO schedulevo){
    	message ms = new message();
    	int result = schedulesvc.insertSchedule(schedulevo);
    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Already Resist Schedule");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Insert Request Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/updateschedule",method = RequestMethod.POST)
    public ResponseEntity<message> updateRequest(@RequestBody scheduleVO schedulevo){
    	if (schedulevo.getSchedule_id() == null || schedulevo.getSchedule_id() == "") {
    		throw new BadRequestException("ScheduleId Required");
		}
    	message ms = new message();
    	
    	int result = schedulesvc.updateSchedule(schedulevo);
    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Schedule not found");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Update Schedule Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
    }
    
    @RequestMapping(value = "/deleteschedule",method = RequestMethod.POST)
    public ResponseEntity<message> deleteRequest(@RequestBody scheduleVO schedulevo){
    	if (schedulevo.getSchedule_id() == null || schedulevo.getSchedule_id() == "") {
    		throw new BadRequestException("ScheduleId Required");
		}
    	
    	int result = schedulesvc.deleteSchedule(schedulevo);
    	
    	message ms = new message();
    	ms.setData(null);
    	if (result == 1) {
        	ms.setStatus(statusEnum.OK.getStatusCode());
        	ms.setReturnmessage("Success");
		}else if(result == 2){
        	ms.setStatus(statusEnum.BAD_REQUEST.getStatusCode());
        	ms.setReturnmessage("Schedule not found");
		}else {
        	ms.setStatus(statusEnum.INTERNAL_SERER_ERROR.getStatusCode());
			ms.setReturnmessage("Delete Schedule Fail");
		}

        return new ResponseEntity<message>(ms,HttpStatus.OK);
        
        
    }   
    
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ResponseEntity<message> search(@RequestBody searchVO searchvo){
    	message ms = new message();
    	List<searchVO> resultvo = new ArrayList<searchVO>();
    	resultvo = schedulesvc.search(searchvo);
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
