package global.sesoc.web6.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.web6.dao.CustomerDAO;
import global.sesoc.web6.vo.CustomerVO;

@Controller
public class InfoController {
	private static final Logger logger = LoggerFactory.getLogger(InfoController.class);
	
	@Autowired
	CustomerDAO dao;
	
	//개인정보 수정 폼으로 이동
	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(HttpSession session, Model model){
		//로그인 되어있는 세션정보 필요함
		//그 아이디로  DB에서 개인정보 컴색하여 VO객체로 리턴
		String id = (String)session.getAttribute("id");
		CustomerVO vo = dao.getCustomer(id);
		//VO객체를 모델에 저장하고 수정폼JSP로 포워딩
		model.addAttribute("logCustomer", vo);
		logger.debug("회원정보 업데이트 폼으로 이동");
		return "updateForm";
	}
	//사용자가 수정입력한 정보를 DB에 ㅕupdate
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpSession session, CustomerVO vo){
		//아이디는 jsp 에서 가져오지 않으므로 세션에서 따오기
		String id = (String)session.getAttribute("id");
		//세션에서 따온 아이디를 vo에 넣어주기
		vo.setCustid(id);
		//로그인된 아이디 정보를 포함한 vo객체를 다오에서 처리해주기
		int cnt;
		try {
			cnt = dao.updateCustomer(vo);
		} catch (Exception e) {
			logger.debug("정보 업데이트 중 오류가 발생했습니다.");
			e.printStackTrace();
			return "updateForm";
		}
		if (cnt != 1) {
			logger.debug("정보 업데이트 중 오류가 발생했습니다.");
			return "updateForm";
		}
		logger.debug("수정에 성공하였습니다. 홈으로 돌아갑니다.");
		//수정에 성공하면 세션의 로그인 사용자 이름도 수정
		//결과 출력페이지로 이동
		
		return "redirect:/";
	}
	
}
