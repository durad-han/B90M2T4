package kr.co.around.card.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.around.card.service.CardService;
import kr.co.around.repository.vo.CardVO;
import kr.co.around.repository.vo.HashtagVO;
import kr.co.around.repository.vo.SearchVO;


@Controller
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	private CardService cs;
	
//----- 카드 조회 관련 -----------------------------------------------------------------------	
	@RequestMapping("/retrieve.json")
	@ResponseBody
	public CardVO retrieveCard(int cardSeq) throws Exception {
		return cs.retrieveCard(cardSeq);
	}
	
	@RequestMapping("/retrieveList.json")
	@ResponseBody
	public Map<String, Object> retrieveCardList(SearchVO search) throws Exception {
		return cs.retrieveCardList(search);
	}
	
	@RequestMapping("/retrieveCommentList.json")
	@ResponseBody
	public Map<String, Object> retrieveCommentList(int cardSeq, int pageNo, SearchVO search/*, HttpSession session*/) throws Exception {
		search.setCardSeq(cardSeq);
		search.setPageNo(pageNo);
//		UserVO user = (UserVO)session.getAttribute("user");
		return cs.retrieveCommentList(search);
	}
	
	
//----- 카드 수정, 삭제 관련 ------------------------------------------------------------------
	@RequestMapping("/update.do")
	public void updateCard() throws Exception {
		System.out.println("updateCard");
		cs.updateCard(0);
	}
	
	@RequestMapping("/updateForm.do")
	public void updateCardForm() throws Exception {
		System.out.println("updateCardForm");
		cs.updateCardForm();
	}
	
	@RequestMapping("/delete.do")
	public void deleteCard() throws Exception {
		System.out.println("deleteCard");
		cs.deleteCard(0);
	}
	
	
//----- 카드 입력 관련 -----------------------------------------------------------------------
	
	@RequestMapping("/insertForm.do")
	public void insertCardForm() throws Exception {
		System.out.println("insertCardForm");
		cs.insertCardForm();
	}
	
	@RequestMapping("/insert.do")
	@ResponseBody
	public void insertCard(MultipartHttpServletRequest mRequest, RedirectAttributes attr) throws Exception {
		Map<String, Object> param = new HashMap<>();
		
		ServletContext context = mRequest.getServletContext();
		String path = context.getRealPath("/upload/");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String datePath = sdf.format(new Date());
		
		String savePath = path + datePath;
		File f = new File(savePath);
		if (!f.exists()) f.mkdirs();
		
		CardVO CardVO = new CardVO();
		CardVO.setCardContent(mRequest.getParameter("cardContent"));
		CardVO.setCardFeeling(mRequest.getParameter("cardFeeling"));
		CardVO.setCardHashtag(mRequest.getParameter("cardHashtag"));
		CardVO.setCardImgPath(mRequest.getParameter("cardImgpath"));
		CardVO.setCardLatitude(mRequest.getParameter("cardLatitude"));
		CardVO.setCardLongitude(mRequest.getParameter("cardLongitude"));
		
		MultipartFile file = mRequest.getFile("img");
		String oriName = file.getOriginalFilename();
		if (oriName != null && !oriName.equals("")) {
			// 확장자
			String ext = "";
			// 맨뒤 . 위치
			int index = oriName.lastIndexOf(".");
			if (index != -1) {
				ext = oriName.substring(index);
			}
			// 파일명
			String systemName = "around-" + UUID.randomUUID().toString() + ext;
			file.transferTo(new File(savePath + "/" + systemName));
			CardVO.setCardImgPath(savePath + "/" + systemName);
			param.put("card", CardVO);
		}
		cs.insertCard(CardVO);
	}
	
	@RequestMapping("/retrieveHashtag.do")
	@ResponseBody
	public List<HashtagVO> retrieveHashtag(HttpServletRequest request) throws Exception {
		System.out.println("retrieveHashtag");
		String hashtagInput = request.getParameter("hashtagInput");
		System.out.println(hashtagInput);
		if(hashtagInput.startsWith("#")) {
			hashtagInput = hashtagInput.substring(1);
		}
		System.out.println(hashtagInput);
		List<HashtagVO> list = cs.retrieveHashtag(hashtagInput);
		System.out.println(list.size());
		
		return list;
	}
}
