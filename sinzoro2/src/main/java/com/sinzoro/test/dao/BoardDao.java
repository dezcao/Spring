package com.sinzoro.test.dao;

import com.sinzoro.test.vo.BoardVO;

public interface BoardDao extends CommonDao<BoardVO> {
    public int checkPassword(BoardVO vo);
}
