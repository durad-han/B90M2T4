package kr.co.around.card.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.around.card.service.CardService;
import kr.co.around.repository.vo.*;

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
	public Map<String, Object> retrieveCommentList(int cardSeq, SearchVO search/*, HttpSession session*/) throws Exception {
		search.setCardSeq(cardSeq);
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
	
	@RequestMapping("/insertComment.do")
	public void insertComment(@RequestParam(value="cardSeq", required=false)int cardSeq, CommentVO commentVO, HttpSession session) throws Exception {
		System.out.println("insertComment");
		commentVO.setCardSeq(cardSeq);
		UserVO user = (UserVO)session.getAttribute("user");
		commentVO.setUserSeq(user.getUserSeq());
//		System.out.println("--------------------------------");
//		System.out.println("cardseq "+commentVO.getCardSeq());
//		System.out.println("content "+commentVO.getCommentContent());
//		System.out.println("userseq "+commentVO.getUserSeq());
//		System.out.println("--------------------------------");
		cs.insertComment(commentVO);
	}	
		
	@RequestMapping("/insertForm.do")
	public void insertCardForm() throws Exception {
		System.out.println("insertCardForm");
		cs.insertCardForm();
	}
	
	@RequestMapping("/insert.do")
	@ResponseBody
	public void insertCard(MultipartHttpServletRequest mRequest, RedirectAttributes attr, HttpSession session) throws Exception {
		UserVO user = (UserVO)session.getAttribute("user");
		Map<String, Object> param = new HashMap<>();
		
		String savePath= "";
		if (mRequest.getFile("cardImgPath") != null) {
			ServletContext context = mRequest.getServletContext();
			String path = context.getRealPath("/upload/");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String datePath = sdf.format(new Date());
			savePath = path + datePath;
			File f = new File(savePath);
			if (!f.exists()) f.mkdirs();
		}
		
		CardVO cardVO = new CardVO();
		cardVO.setCardContent(mRequest.getParameter("cardContent"));
		cardVO.setCardFeeling(mRequest.getParameter("cardFeeling"));
		cardVO.setCardHashtag(mRequest.getParameter("cardHashtag"));
		cardVO.setCardLongitude(mRequest.getParameter("cardLongitude"));
		cardVO.setCardLatitude(mRequest.getParameter("cardLatitude"));
		cardVO.setUserSeq(12);
		
		// user.getUserSeq()
		
		System.out.println(cardVO.getCardContent());
		System.out.println(cardVO.getCardFeeling()); 
		System.out.println(cardVO.getCardHashtag()); 
		System.out.println(cardVO.getCardLongitude());
		System.out.println(cardVO.getCardLatitude()); 
		System.out.println(cardVO.getUserSeq());
		
//		System.out.println(mRequest.getFile("cardImgPath"));
		if (mRequest.getFile("cardImgPath") != null) {
			MultipartFile file = mRequest.getFile("cardImgPath");
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
				cardVO.setCardImgPath(savePath + "/" + systemName);			
		} 
			param.put("card", cardVO);
		}
		cs.insertCard(cardVO);
		attr.addFlashAttribute("msg", "글 등록이 완료되었습니다.");
		
		
		/* 
		 * websocket 서버 호출
		 * */
		URL url = new URL("http://around.com:10001/regOk.do");
	    URLConnection con = url.openConnection();
	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    String inputLine;
	    while ((inputLine = in.readLine()) != null)
	    	System.out.println(inputLine);
	    in.close();
	}
	
	@RequestMapping("/retrieveHashtag.do")
	@ResponseBody
	public List<HashtagVO> retrieveHashtag(HttpServletRequest request) throws Exception {
		
		String hashtagInput = request.getParameter("hashtagInput");
		
		if(hashtagInput.startsWith("#")) {
			hashtagInput = hashtagInput.substring(1);
		}
		
		List<HashtagVO> list = cs.retrieveHashtag(hashtagInput);
		return list;
	}
}
