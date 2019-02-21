package global.sesoc.web6.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.web6.vo.BoardVO;
import global.sesoc.web6.vo.ReplyCountVO;
import global.sesoc.web6.vo.ReplyVO;

@Repository
public class BoardDAO {
	@Autowired
	SqlSession sqlSession;

	public ArrayList<BoardVO> selectAll(int start, int count, String searchText) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		//검색 결과의 일부만을 가져오는 객체
		RowBounds rb = new RowBounds(start, count);
		ArrayList<BoardVO> boardList = null;
		try {
			boardList = mapper.selectAll(rb, searchText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}

	public int insertBoard(BoardVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		try{
			result = mapper.insertBoard(vo);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public BoardVO selectOne(int number) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		BoardVO voo = new BoardVO();
		voo.setBoardnum(number);
		BoardVO vo = null;
		try {
			vo = mapper.selectOne(voo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	public int deleteBoard(BoardVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		try {
			result = mapper.deleteBoard(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	//전체 글 개수
	public int getTotal(String searchText) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int cnt = mapper.getTotal(searchText);
		return cnt;
	}

	public int updateBoard(BoardVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int cnt = 0;
		try {
			cnt = mapper.updateBoard(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
		
		
	}

	public int insertReply(ReplyVO reply) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int cnt = 0;
		try {
			cnt = mapper.insertReply(reply);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public ArrayList<ReplyVO> selectReply(int number) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<ReplyVO> replyList = new ArrayList<>();
		try {
			replyList = mapper.selectReply(number);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return replyList;
	}

	public ArrayList<ReplyCountVO> countReply() {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		ArrayList<ReplyCountVO> recntList = new ArrayList<>();
		try {
			recntList = mapper.countReply();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recntList;
	}


}
