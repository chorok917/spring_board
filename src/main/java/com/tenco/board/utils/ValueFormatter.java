package com.tenco.board.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public abstract class ValueFormatter {
	
	public String timestampToString(Timestamp timestamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		return sdf.format(timestamp);
	}
	public String timestampToStringDetail(Timestamp timestamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (HH시 mm분 ss초)");
		return sdf.format(timestamp);
	}

}
