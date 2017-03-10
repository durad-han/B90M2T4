package kr.co.around.myFavorite.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.around.myFavorite.service.MyFavoriteService;
import kr.co.around.repository.vo.MyFavoriteVO;
import kr.co.around.repository.vo.SearchVO;

@Controller
@RequestMapping("/my")
public class MyFavoriteController {
	
	@Autowired
	private MyFavoriteService mys;
	
    @ResponseBody
    @RequestMapping("/myFavoriteList.do")
    public Map<String, Object> myFavoriteList(SearchVO search, int userSeq) throws Exception {
         return mys.myFavoriteList(search, userSeq);        
    }
    
    @ResponseBody
    @RequestMapping("/myFavoriteDetail.do")
    public MyFavoriteVO myFavoriteDetail(int mySeq) throws Exception {
    	 return mys.myFavoriteDetail(mySeq);
    }
    
    
    @ResponseBody
    @RequestMapping("/myFavoriteUpdateForm.do")
    public MyFavoriteVO myFavoriteUpdateForm(int mySeq) throws Exception {
    	return mys.myFavoriteUpdateForm(mySeq);
    }
    
    @ResponseBody
    @RequestMapping("/myFavoriteUpdate.do")
    public String myFavoriteUpdate(MyFavoriteVO myFavorite, RedirectAttributes attr) throws Exception {
    	mys.myFavoriteUpdate(myFavorite);
    	
    	attr.addFlashAttribute("msg", "게시물이 수정되었습니다.");
    	return "redirect:myFavoriteDetail.do";
    }
    
    @ResponseBody
    @RequestMapping("/myFavoriteDelete.do")
    public String myFavoriteDelete(int mySeq, RedirectAttributes attr) throws Exception {
    	mys.myFavoriteDelete(mySeq);
    	
    	attr.addFlashAttribute("msg", "게시물이 삭제되었습니다.");
    	return "redirect:myFavoriteList.do";
    }
  
}
