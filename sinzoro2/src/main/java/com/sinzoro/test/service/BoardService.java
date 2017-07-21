package com.sinzoro.test.service;

import com.sinzoro.test.vo.BoardVO;

public interface BoardService extends CommonService<BoardVO> {
    public int checkPassword(BoardVO vo);
}
