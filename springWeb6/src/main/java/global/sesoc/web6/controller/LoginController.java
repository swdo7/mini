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
public class LoginController {
private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	CustomerDAO dao; 

	//로그인 폼으로 이동
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		logger.debug("로그인 폼으로 이동");
		return "loginForm";
	}
	//로그인 처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String id, String password, Model model, HttpSession session){
		CustomerVO vo = dao.getCustomer(id);
		//사용자가 입력한 id로 검색
		if(vo != null){
			logger.debug("id존재");
			//비밀번호도 확인
			if(password.equals(vo.getPassword())){
				logger.debug("로그인 성공");
				//id비번 맞으면 세션에 login id 로 저장 loginname으로 이름저장
				model.addAttribute("msg","로그인에 성공했습니다. 홈화면으로 돌아갑니다.");
				session.setAttribute("id", id);
				return "redirect:/";
			}
			else{
				logger.debug("비밀번호가 틀립니다. 로그인 실패. 로그인 폼으로 되돌아갑니다.");
				model.addAttribute("msg","비밀번호가 틀립니다. 로그인 화면으로 돌아갑니다.");
				return "loginForm";
			}
		}
		else{
			logger.debug("존재하지 않는 ID 로그인 실패");
			model.addAttribute("msg","해당 id가 존재하지 않습니다. 로그인 화면으로 돌아갑니다.");
			return "loginForm";
		}
		
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session){
		logger.debug("로그아웃 완료");
		session.removeAttribute("id");	//하나하나 이름 대 가면서 지우는 방법

		return "redirect:/";
	}
}		
		


