package kr.co.around.myFavorite.service;

import java.util.Map;

import kr.co.around.repository.vo.MyFavoriteVO;
import kr.co.around.repository.vo.SearchVO;

public interface MyFavoriteService {
    public Map<String, Object> myFavoriteList(SearchVO search, int userSeq) throws Exception;

    public MyFavoriteVO myFavoriteDetail(int mySeq) throws Exception;
    
    public MyFavoriteVO myFavoriteUpdateForm(int mySeq) throws Exception;
    
    public String myFavoriteUpdate(MyFavoriteVO myFavorite) throws Exception;
    
    public String myFavoriteDelete(int mySeq) throws Exception;
    
    }
