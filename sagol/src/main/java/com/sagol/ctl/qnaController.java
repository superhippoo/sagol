package com.sagol.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sagol.dto.qnaVO;
import com.sagol.svc.qnaSvc;

@RestController
@RequestMapping("/qna")
public class qnaController {
	
	@Autowired
	private qnaSvc qnasvc;


    @RequestMapping(value = "/selectqnalist",method = RequestMethod.POST)
    @ResponseBody
    public List<qnaVO> selectQnaList(@RequestBody qnaVO qnavo){
        return qnasvc.selectQnaList(qnavo);
    }
    
    @RequestMapping(value = "/selectqnalistbyuid",method = RequestMethod.POST)
    @ResponseBody
    public List<qnaVO> selectQnaListByUid(@RequestBody qnaVO qnavo){
        return qnasvc.selectQnaListByUid(qnavo);
    }


    @RequestMapping(value = "/selectqna",method = RequestMethod.POST)
    @ResponseBody
    public qnaVO selectQna(@RequestBody qnaVO qnavo){
        return qnasvc.selectQna(qnavo);
    }
    
    @RequestMapping(value = "/insertqna",method = RequestMethod.POST)
    @ResponseBody
    public int insertQna(@RequestBody qnaVO qnavo){
        return qnasvc.insertQna(qnavo);
    }
    
    @RequestMapping(value = "/updateqna",method = RequestMethod.POST)
    @ResponseBody
    public int updateQna(@RequestBody qnaVO qnavo){
        return qnasvc.updateQna(qnavo);
    }
    
    @RequestMapping(value = "/deleteqna",method = RequestMethod.POST)
    @ResponseBody
    public int deleteQna(@RequestBody qnaVO qnavo){
        return qnasvc.deleteQna(qnavo);
    }   
}
