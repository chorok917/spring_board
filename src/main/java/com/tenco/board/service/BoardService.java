package com.tenco.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.board.dto.BoardDTO;
import com.tenco.board.repository.interfaces.BoardRepository;
import com.tenco.board.repository.model.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	@Autowired
	private final BoardRepository boardRepository;

	@Transactional
	public void createBoard(BoardDTO dto) {
		int result = 0;
		boardRepository.insert(dto.toBoard());
	};

	public List<Board> readAllBoardList(int size,int offset) {
		List<Board> boardListEntity = null;
		boardListEntity = boardRepository.readAllBoardList(size,offset);
		return boardListEntity;
	};
	
	public Board viewBoard(Integer boardId) {
		Board board = null;
		board = boardRepository.viewBoardById(boardId);
		return board;
	}
	
	@Transactional
	public void updateBoard(BoardDTO dto) {
		int result = 0;
		boardRepository.update(dto.toBoard());
	};
	
	public void deleteBoard(Integer id) {
		boardRepository.deleteById(id);
	}
	
	public int countAllBoard() {
		int result = 0;
		result = boardRepository.countAllBoard();
		return result;
	}
}
