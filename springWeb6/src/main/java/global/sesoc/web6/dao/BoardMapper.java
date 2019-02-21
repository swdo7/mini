package global.sesoc.web6.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;

import global.sesoc.web6.vo.BoardVO;
import global.sesoc.web6.vo.ReplyCountVO;
import global.sesoc.web6.vo.ReplyVO;

public interface BoardMapper {

	public ArrayList<BoardVO> selectAll(RowBounds rb, String searchText);

	public int insertBoard(BoardVO vo);

	public int deleteBoard(BoardVO vo);

	public BoardVO selectOne(BoardVO voo);

	public int getTotal(String searchText);

	public int updateBoard(BoardVO vo);

	public int insertReply(ReplyVO reply);

	public ArrayList<ReplyVO> selectReply(int number);

	public ArrayList<ReplyCountVO> countReply();


}
