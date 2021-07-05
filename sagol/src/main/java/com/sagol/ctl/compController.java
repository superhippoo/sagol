package com.sagol.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagol.dto.compVO;
import com.sagol.svc.compSvc;

@RestController
@RequestMapping("/comp")
public class compController {
	
	@Autowired
	private compSvc compsvc;


    @RequestMapping(value = "/selectcomplist",method = RequestMethod.POST)
    public List<compVO> selectuserlist(@RequestBody compVO compvo){
        return compsvc.selectCompList(compvo);
    }

    @RequestMapping(value = "/selectcomp",method = RequestMethod.POST)
    public compVO selectComp(@RequestBody compVO compvo){
        return compsvc.selectComp(compvo);
    }
    
    @RequestMapping(value = "/insertcomp",method = RequestMethod.POST)
    @ResponseBody
    public int insertComp(@RequestBody compVO compvo){
        return compsvc.insertComp(compvo);
    }
    
    @RequestMapping(value = "/updatecomp",method = RequestMethod.POST)
    public int updateComp(@RequestBody compVO compvo){
        return compsvc.updateComp(compvo);
    }
    
    @RequestMapping(value = "/deletecomp",method = RequestMethod.POST)
    public int deleteComp(@RequestBody compVO compvo){
        return compsvc.deleteComp(compvo);
    }
   
}
