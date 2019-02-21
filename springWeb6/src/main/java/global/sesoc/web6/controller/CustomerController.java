package global.sesoc.web6.controller;

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
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerDAO dao; 

	//회원가입 폼으로 이동
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinForm() {
		logger.debug("회원가입 폼으로 이동");
		return "joinForm";
	}
	//회원가입 요청정보 가져와서 저장하기
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(CustomerVO vo){
		logger.debug("가져온 회원가입 정보 : {}",vo);
		
		
		int result;
		try{
			result = dao.insert(vo);
		}
		catch (Exception e) {
			logger.debug("회원가입중 오류가 발생했습니다.");
			e.printStackTrace();
			return "joinForm";
		}
		if (result != 1){
			logger.debug("회원가입중 오류가 발생했습니다.");
			return "joinForm";
		}
		logger.debug("회원가입에 성공하였습니다.");
		
		
		return "redirect:/";
	}
	//ID중복확인 폼으로이동
	@RequestMapping(value = "/idCheck", method = RequestMethod.GET)
	public String idCheck(){
		logger.debug("id중복확인 폼으롣 이동");
		return"idCheck";
	}
	//ID중복확인 확인하기
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public String idCheck2(String searchId, Model model){
		//
		CustomerVO vo = dao.getCustomer(searchId);
		//검색결과를 Model에 저장하고 JSP로 다시 이동
		model.addAttribute("searchId", searchId);
		model.addAttribute("searchResult", vo);
		model.addAttribute("search", true);
		
		return"idCheck";
	}

}
