package com.kh.spring.board.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.dao.BoardDao;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.Reply;
import com.kh.spring.common.vo.PageInfo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
 
	@Autowired
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	private final BoardDao boardDao;
	
	public int selectListCount() {
		return boardDao.selectListCount(sqlSession);
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		
		return boardDao.selectList(sqlSession, pi);
	}

	public int increaseCount(int bno) {
		return boardDao.increaseCount(sqlSession, bno);
	}

	public Board selectBoard(int bno) {
		return boardDao.selectBoard(sqlSession, bno);
	}

	public int insertBoard(Board b) {
		
		return boardDao.insertBoard(sqlSession, b);
	}

	public int updateBoard(Board b) {
		
		return boardDao.updateBoard(sqlSession, b);
	}

	public ArrayList<Reply> selectReply(int bno) {
		return boardDao.selectReply(sqlSession, bno);
	}

	public int insertReply(Reply r) {
		return boardDao.insertReply(sqlSession, r);
	}

	public ArrayList<Board> selectTopBoardList() {
		return boardDao.selectTopBoardList(sqlSession);
	}

}
