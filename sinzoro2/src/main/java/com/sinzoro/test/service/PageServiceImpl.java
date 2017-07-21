package com.sinzoro.test.service;

import org.springframework.stereotype.Service;

import com.sinzoro.test.vo.PageVO;

@Service("PageService")
public class PageServiceImpl implements PageService<PageVO> {

    /**
     * default setting :
     * 페이지에 할당될 컨텐츠수 = 5, 
     * 하단에 스프레드될 페이지량 = 5
    */
    @Override
    public void pagination(PageVO pageVO, int totalCount) {
        pagination(pageVO, totalCount, 5, 5);
    }

    @Override
    public void pagination(PageVO pageVO, int totalCount, int pageContents, int perPage) {
        int requirePage = pageVO.getRequirePage(); // 요청한 페이지, PageVO 기본값 = 1.        
        int totalPage = (totalCount%pageContents == 0 ? totalCount/pageContents : totalCount/pageContents+1); // 전체 페이지 수 = (컨텐츠총수%페이지에할당된컨텐츠수 == 0 ? 나눈 몫 : 몫 +1)
        int beginPage = (requirePage == perPage ? 1 : (requirePage - requirePage%perPage + 1)); // 페이지네이션 시작번호 = 요청한페이지번호 - 요청한페이지번호를 화면에 스프레드될 페이지량으로 나눈 나머지 + 1
        int flag = beginPage + perPage - 1; // 임시값(끝번호로 짐작되는 값) = 페이지네이션 시작번호 + 스프레드될 페이지량 - 1
        int endPage = flag > totalPage ? totalPage : flag; // 페이지네이션 끝번호 = 임시값이 전체 페이지를 넘으면 전체페이지 값이 끝번호를 차지. 그렇지 않으면 임시값을 해당 페이지네이션의 끝번호로 함.
        beginPage = beginPage > endPage ? endPage : beginPage;
        int startContent = pageContents*requirePage-pageContents; // limit query 시작할 컨텐츠의 순번 = 페이지에할당된컨텐츠수*요청한페이지번호-페이지에할당된컨텐츠수
        // calculate done...
        pageVO
            .setRequirePage(requirePage)
            .setTotalPage(totalPage)
            .setBeginPage(beginPage)
            .setEndPage(endPage)
            .setStartContent(startContent)
            .setPerPage(perPage); // limit query 두번째 할당인자 = perPage
    }
    

}
