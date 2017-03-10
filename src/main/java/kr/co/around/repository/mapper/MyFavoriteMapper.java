package kr.co.around.repository.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.around.repository.vo.MyFavoriteVO;
import kr.co.around.repository.vo.SearchVO;

@Repository
public interface MyFavoriteMapper {
	
    public List<MyFavoriteVO> myFavoriteList(SearchVO search) throws Exception;
    
    public int myFavoriteCount(int userSeq) throws Exception;

    public MyFavoriteVO myFavoriteDetail(int mySeq) throws Exception;
    
    public String myFavoriteUpdate(MyFavoriteVO myFavorite) throws Exception;
    
    public String myFavoriteDelete(int mySeq) throws Exception;
    
    
	
	
	
}
