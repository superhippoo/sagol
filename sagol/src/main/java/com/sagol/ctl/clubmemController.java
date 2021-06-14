package com.sagol.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagol.dto.clubmemVO;
import com.sagol.svc.clubmemSvc;

@RestController
@RequestMapping("/clubmem")
public class clubmemController {
	
	@Autowired
	private clubmemSvc clubmemsvc;


    @RequestMapping(value = "/selectclubmemlist",method = RequestMethod.POST)
    @ResponseBody
    public List<clubmemVO> selectClubmemList(@RequestBody clubmemVO clubmemvo){
        return clubmemsvc.selectClubmemList(clubmemvo);
    }
    
    @RequestMapping(value = "/selectclubmemlistbyclubid",method = RequestMethod.POST)
    @ResponseBody
    public List<clubmemVO> selectClubmemListByClubId(@RequestBody clubmemVO clubmemvo){
        return clubmemsvc.selectClubmemListByClubId(clubmemvo);
    }

    @RequestMapping(value = "/selectclubmem",method = RequestMethod.POST)
    @ResponseBody
    public clubmemVO selectClubmem(@RequestBody clubmemVO clubmemvo){
        return clubmemsvc.selectClubmem(clubmemvo);
    }
    
    @RequestMapping(value = "/insertclubmem",method = RequestMethod.POST)
    @ResponseBody
    public int insertClubmem(@RequestBody clubmemVO clubmemvo){
        return clubmemsvc.insertClubmem(clubmemvo);
    }
    
    @RequestMapping(value = "/updateclubmem",method = RequestMethod.POST)
    @ResponseBody
    public int updateClubmem(@RequestBody clubmemVO clubmemvo){
        return clubmemsvc.updateClubmem(clubmemvo);
    }
    
    @RequestMapping(value = "/deleteclubmem",method = RequestMethod.POST)
    @ResponseBody
    public int deleteClubmem(@RequestBody clubmemVO clubmemvo){
        return clubmemsvc.deleteClubmem(clubmemvo);
    }
   
}
