package com.tenco.board.dto;

import com.tenco.board.repository.model.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BoardDTO {
	private Integer id;
	private String title;
	private String content;
	private String writer;
	
	public Board toBoard() {
		return Board.builder()
				.id(id)
				.title(title)
				.content(content)
				.writer(writer)
				.build();
	}
}
