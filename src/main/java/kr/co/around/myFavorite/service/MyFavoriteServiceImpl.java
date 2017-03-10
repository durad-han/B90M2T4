package kr.co.around.myFavorite.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.around.repository.mapper.MyFavoriteMapper;
import kr.co.around.repository.vo.MyFavoriteVO;
import kr.co.around.repository.vo.PageResultVO;
import kr.co.around.repository.vo.SearchVO;

@Service
public class MyFavoriteServiceImpl implements MyFavoriteService {

	@Autowired
	private MyFavoriteMapper dao;
	
    public Map<String, Object> myFavoriteList(SearchVO search, int userSeq) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("list", dao.myFavoriteList(search));
        result.put("pageResult", new PageResultVO(search.getPageNo(), dao.myFavoriteCount(search.getUserSeq())));
        return result;
    }
    
    public MyFavoriteVO myFavoriteDetail(int mySeq) throws Exception {
    	return dao.myFavoriteDetail(mySeq);
    
    }
    
    public MyFavoriteVO myFavoriteUpdateForm(int mySeq) throws Exception {
    	return dao.myFavoriteDetail(mySeq);
    }

    public String myFavoriteUpdate(MyFavoriteVO myFavorite) throws Exception {
    	return dao.myFavoriteUpdate(myFavorite);
    }
    
    public String myFavoriteDelete(int mySeq) throws Exception {
    	return dao.myFavoriteDelete(mySeq);
    }
}
