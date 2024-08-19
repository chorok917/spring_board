package com.tenco.board.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.board.repository.model.Board;

@Mapper
public interface BoardRepository {
	public int insert(Board board);
	public int update(Board board);
	public void deleteById(Integer boardId);
	public List<Board> readAllBoardList(@Param("size") int size, @Param("offset")int offset);
	public int countAllBoard();
	public Board viewBoardById(Integer boardId);
}
