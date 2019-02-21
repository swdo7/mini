package global.sesoc.web6.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.web6.vo.CustomerVO;
@Repository
public class CustomerDAO {
	@Autowired
	SqlSession sqlSession;
	
	//회원정보저장
	public int insert(CustomerVO vo){
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		int result = 0;
		try {
			result = mapper.insertCustomer(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; //저장성공은 1 실패는0
	}

	public CustomerVO getCustomer(String searchId) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		CustomerVO vo = null;
		try {
			vo = mapper.searchCustomer(searchId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	public int updateCustomer(CustomerVO vo) {
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		int result = 0;
		try {
			result = mapper.updateCustomer(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
