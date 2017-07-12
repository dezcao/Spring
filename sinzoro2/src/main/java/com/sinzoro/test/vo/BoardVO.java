package com.sinzoro.test.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardVO {
	
	int id;
	String board_content;
	String password;
	String writer;
	Date insDate;
	
    @Override
    public String toString() {
        return "BoardVO [id=" + id + ", board_content=" + board_content + ", password=" + password + ", writer="
                + writer + ", insDate=" + insDate + "]";
    }
}
