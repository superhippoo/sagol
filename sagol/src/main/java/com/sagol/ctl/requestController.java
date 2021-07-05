package com.sagol.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagol.dto.requestVO;
import com.sagol.svc.requestSvc;

@RestController
@RequestMapping("/request")
public class requestController {
	
	@Autowired
	private requestSvc requestsvc;


    @RequestMapping(value = "/selectrequestlist",method = RequestMethod.POST)
    public List<requestVO> selectRequestList(@RequestBody requestVO requestvo){
        return requestsvc.selectRequestList(requestvo);
    }
    
    @RequestMapping(value = "/selectrequestlistbyuid",method = RequestMethod.POST)
    public List<requestVO> selectRequestListByUid(@RequestBody requestVO requestvo){
        return requestsvc.selectRequestListByUid(requestvo);
    }
    
    @RequestMapping(value = "/selectrequestlistbycompleteyn",method = RequestMethod.POST)
    public List<requestVO> selectRequestListByCompleteYn(@RequestBody requestVO requestvo){
        return requestsvc.selectRequestListByCompleteYn(requestvo);
    }
    
    @RequestMapping(value = "/selectrequestlistbyreqcd",method = RequestMethod.POST)
    public List<requestVO> selectRequestListByReqCd(@RequestBody requestVO requestvo){
        return requestsvc.selectRequestListByReqCd(requestvo);
    }

    @RequestMapping(value = "/selectrequest",method = RequestMethod.POST)
    public requestVO selectRequest(@RequestBody requestVO requestvo){
        return requestsvc.selectRequest(requestvo);
    }
    
    @RequestMapping(value = "/insertrequest",method = RequestMethod.POST)
    public int insertRequest(@RequestBody requestVO requestvo){
        return requestsvc.insertRequest(requestvo);
    }
    
    @RequestMapping(value = "/updaterequest",method = RequestMethod.POST)
    public int updateRequest(@RequestBody requestVO requestvo){
        return requestsvc.updateRequest(requestvo);
    }
    
    @RequestMapping(value = "/deleterequest",method = RequestMethod.POST)
    public int deleteRequest(@RequestBody requestVO requestvo){
        return requestsvc.deleteRequest(requestvo);
    }   
}
