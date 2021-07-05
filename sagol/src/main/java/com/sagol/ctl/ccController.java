package com.sagol.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagol.dto.ccVO;
import com.sagol.svc.ccSvc;

@RestController
@RequestMapping("/cc")
public class ccController {
	
	@Autowired
	private ccSvc ccsvc;


    @RequestMapping(value = "/selectcclist",method = RequestMethod.POST)
    public List<ccVO> selectCclist(@RequestBody ccVO ccvo){
        return ccsvc.selectCcList(ccvo);
    }
    
    @RequestMapping(value = "/selectcclistbycompcd",method = RequestMethod.POST)
    public List<ccVO> selectCclistbycompcd(@RequestBody ccVO ccvo){
        return ccsvc.selectCcListByCompCd(ccvo);
    }

    @RequestMapping(value = "/selectcc",method = RequestMethod.POST)
    public ccVO selectCc(@RequestBody ccVO ccvo){
        return ccsvc.selectCc(ccvo);
    }
    
    @RequestMapping(value = "/insertcc",method = RequestMethod.POST)
    public int insertCc(@RequestBody ccVO ccvo){
        return ccsvc.insertCc(ccvo);
    }
    
    @RequestMapping(value = "/updatecc",method = RequestMethod.POST)
    public int updateCc(@RequestBody ccVO ccvo){
        return ccsvc.updateCc(ccvo);
    }
    
    @RequestMapping(value = "/deletecc",method = RequestMethod.POST)
    public int deleteCc(@RequestBody ccVO ccvo){
        return ccsvc.deleteCc(ccvo);
    }
   
}
