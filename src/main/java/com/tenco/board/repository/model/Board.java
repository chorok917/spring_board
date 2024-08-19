package com.tenco.board.repository.model;

import java.sql.Timestamp;

import com.tenco.board.utils.ValueFormatter;

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
public class Board extends ValueFormatter{
	private Integer id;
	private String title;
	private String content;
	private String writer;
	private Timestamp createdAt;
}
