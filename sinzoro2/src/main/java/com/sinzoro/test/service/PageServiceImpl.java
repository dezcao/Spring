package com.sinzoro.test.service;

import com.sinzoro.test.vo.PageVO;

public class PageServiceImpl implements PageService<PageVO> {
    
    private int pageContents = 10;
    private int perPage = 10;
    
    @Override
    public PageVO pagination(int totalCount) {
        PageVO pageVO = new PageVO();
        pagination(pageVO, totalCount, this.pageContents, this.perPage);
        return pageVO;
    }

    @Override
    public void pagination(PageVO pageVO, int totalCount) {
        pagination(pageVO, totalCount, this.pageContents, this.perPage);
    }

    @Override
    public void pagination(PageVO pageVO, int totalCount, int pageContents, int perPage) {
        int requirePage = pageVO.getRequirePage();
        
        int totalPage = (totalCount%pageContents == 0 ? totalCount/pageContents : totalCount/pageContents+1);
        int beginPage = requirePage - requirePage%perPage + 1;
        int flag = beginPage + perPage - 1;
        int endPage = flag > totalPage ? totalPage : flag;
        int startContent = pageContents*requirePage-pageContents;
        
        pageVO.setPerPage(0).setBeginPage(1).setRequirePage(0);
    }
    

}
