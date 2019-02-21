package global.sesoc.web6.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import global.sesoc.web6.dao.BoardDAO;
import global.sesoc.web6.util.FileService;
import global.sesoc.web6.util.PageNavigator;
import global.sesoc.web6.vo.BoardVO;
import global.sesoc.web6.vo.ReplyCountVO;
import global.sesoc.web6.vo.ReplyVO;

@Controller
@RequestMapping("board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	//게시판 관련 상수값
	//페이지당 글 수
	private static final int countPerPage = 10;
	//페이지 이동 링크 그룹 당 페이지 수
	private static final int pagePerGroup = 10;
	final String uploadPath = "/boardfile";
	
	@Autowired
	BoardDAO dao; 
	//게시판 첫 목록 보여주기
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String boardHome(
			@RequestParam(value="page", defaultValue="1")int page
			, @RequestParam(value="searchText", defaultValue="")String searchText
			, Model model){
		logger.debug("페이지:{}, 검색어:{}", page, searchText);
		logger.debug("게시판 홈 화면");
		int total = dao.getTotal(searchText); //현재 전체 글 개수
		PageNavigator navi =
				new PageNavigator(countPerPage, pagePerGroup, page, total);
		logger.debug("{}", total);
		ArrayList<BoardVO> boardList = null;
		ArrayList<ReplyCountVO> recntList = null;
		try {
			boardList = dao.selectAll(navi.getStartRecord(), navi.getCountPerPage(), searchText);
			recntList = dao.countReply();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(boardList == null){
			return "redirect:/";
		}
		model.addAttribute("boardList", boardList);
		model.addAttribute("recntList", recntList);
		model.addAttribute("navi", navi);
		model.addAttribute("searchText", searchText);
		return "board/boardList";
	}
	//글쓰기 창 열어주기
	@RequestMapping(value = "/newCont", method = RequestMethod.GET)
	public String newBoardCont (HttpSession session, Model model){
		logger.debug("새 글 입력 창");
		String id = (String)session.getAttribute("id");
		model.addAttribute("id", id);
		return "board/insertBoardCont";
	}
	//글 저장 처리
	@RequestMapping(value = "/saveCont", method = RequestMethod.POST)
	public String saveBoardCont (
			HttpSession session
			, Model model
			, MultipartFile upload	//글 하나에 여러개의 첨부파일일 경우, 네임을 같게 해 주고 파일을 어레이로 받으면 됨
			, BoardVO vo){
		logger.debug("업로드:{}",upload);
		String id = (String)session.getAttribute("id");
		vo.setId(id);
		//첨부파일이 있는 경우 지정된 경로에 저장하고, 원본 파일 명과 저장된 파일명
		if (upload != null && !upload.isEmpty()){ //앞 조건을 먼저 확인하지 않으면 뒤 조건을 확인하는 것 자체가 에러가 뜸
			String savedfile = FileService.saveFile(upload, uploadPath);
			vo.setOriginalfile(upload.getOriginalFilename());
			vo.setSavedfile(savedfile);
		}
		logger.debug("글 저장 처리 전달된 param : {}", vo);
		int result = 0;
		try{
			result= dao.insertBoard(vo);
		}
		catch (Exception e) {
			logger.debug("게시글 작성중 오류가 발생했습니다.");
			e.printStackTrace();
			return "board/insertBoardCont";
		}
		if (result != 1){
			logger.debug("게시글 작성 중 오류가 발생하였습니다.");
			return "board/insertBoardCont";
		}
		logger.debug("게시글 작성에 성공하였습니다.");
		return "redirect:/board/list";
	}
	//게시글 상세보기	
	@RequestMapping(value = "/viewCont", method = RequestMethod.GET)
	public String viewCont(int number, Model model){
		logger.debug("선택한 게시글 컨텐츠 출력");
		
		BoardVO vo = null;
		vo = dao.selectOne(number);
		logger.debug("{}",vo);
		int hit = vo.getHits();
		hit++;
		vo.setHits(hit);
		logger.debug("{}",vo);
		int upHits = 0;
		ArrayList<ReplyVO> replyList = null;
		try {
			replyList = dao.selectReply(number);
			logger.debug("해당 게시글 댓글 리스트 가져오기{}",replyList);
			model.addAttribute("replyList", replyList);
			upHits = dao.updateBoard(vo);
			vo = dao.selectOne(number);
			logger.debug("게시글 조회수 업 확인하기{}", vo);
			model.addAttribute("selectedVO", vo);
		} catch (Exception e) {
			logger.debug("조회수 처리 중 오류가 1발생하였습니다.");
			e.printStackTrace();
			return "board/boardList";
		}
		if (upHits != 1){
			logger.debug("조회수 증가 처리에 오류가 생겼습니다.");
			return "board/boardList";
		}
		if (vo == null){
			logger.debug("조회수 처리 중 오류가 2발생하였습니다.");
			return "board/boardList";
		}
		
		logger.debug("게시글 출력에 성공하였습니다.");
		return "board/viewBoardCont";
	}
	//게시글 삭제하기
	@RequestMapping(value = "/deleteCont", method = RequestMethod.GET)
	public String deleteBoardCont (HttpSession session, Model model, BoardVO vo){
		logger.debug("게시글 삭제 시도");
		String id = (String)session.getAttribute("id");
		vo.setId(id);
		
		int result = 0;
		try {
			result = dao.deleteBoard(vo);
		} catch (Exception e) {
			logger.debug("게시글 삭제 중 오류가 발생하였습니다.");
			e.printStackTrace();
			return "board/boardList";
		}
		if (result != 1){
			logger.debug("게시글이 1개 이상 삭제되었습니다. 데이터베이스와 sql을 확인하세요.");
			return "board/boardList";
		}
		return "redirect:board/boardHome";
	}
	//리플 저장
	@RequestMapping (value="/insertReply", method=RequestMethod.POST)
	public String replyInsert(HttpSession session
			, ReplyVO reply
			, String text
			, int boardnum
			, Model model){
		//세션에서 로그인 한 아이디를 읽는다.
		String id = (String)session.getAttribute("id");
		//아이디를 Reply객체에 추가
		reply = new ReplyVO();
		reply.setId(id);
		reply.setBoardnum(boardnum);
		//리플 정보를 테이블에 저장
		reply.setText(text);
		logger.debug("댓글 저장 처리 전달된 param : {}", reply);
		int result = dao.insertReply(reply);
		if (result == 0){
			return "redirect:list";
		}
		else{
			//저장성공하면 읽던 글 그대로 열어둠
			return "redirect:viewCont?number=" + reply.getBoardnum();
		}
	}

}
