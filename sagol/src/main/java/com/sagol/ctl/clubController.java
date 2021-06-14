package com.sagol.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagol.dto.clubVO;
import com.sagol.svc.clubSvc;

@RestController
@RequestMapping("/club")
public class clubController {
	
	@Autowired
	private clubSvc clubsvc;


    @RequestMapping(value = "/selectclublist",method = RequestMethod.POST)
    @ResponseBody
    public List<clubVO> selectClubList(@RequestBody clubVO clubvo){
        return clubsvc.selectClubList(clubvo);
    }
    
    @RequestMapping(value = "/selectclublistbyccid",method = RequestMethod.POST)
    @ResponseBody
    public List<clubVO> selectCclistbycompcd(@RequestBody clubVO clubvo){
        return clubsvc.selectClubListByCcId(clubvo);
    }

    @RequestMapping(value = "/selectclub",method = RequestMethod.POST)
    @ResponseBody
    public clubVO selectClub(@RequestBody clubVO clubvo){
        return clubsvc.selectClub(clubvo);
    }
    
    @RequestMapping(value = "/insertclub",method = RequestMethod.POST)
    @ResponseBody
    public int insertClub(@RequestBody clubVO clubvo){
        return clubsvc.insertClub(clubvo);
    }
    
    @RequestMapping(value = "/updateclub",method = RequestMethod.POST)
    @ResponseBody
    public int updateClub(@RequestBody clubVO clubvo){
        return clubsvc.updateClub(clubvo);
    }
    
    @RequestMapping(value = "/deleteclub",method = RequestMethod.POST)
    @ResponseBody
    public int deleteClub(@RequestBody clubVO clubvo){
        return clubsvc.deleteClub(clubvo);
    }
   
}
