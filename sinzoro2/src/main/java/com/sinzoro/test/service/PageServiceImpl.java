package com.sinzoro.test.service;

import org.springframework.stereotype.Service;

import com.sinzoro.test.vo.PageVO;

@Service("PageService")
public class PageServiceImpl implements PageService<PageVO> {

    /**
     * default setting :
     * �������� �Ҵ�� �������� = 5, 
     * �ϴܿ� ��������� �������� = 5
    */
    @Override
    public void pagination(PageVO pageVO, int totalCount) {
        pagination(pageVO, totalCount, 5, 5);
    }

    @Override
    public void pagination(PageVO pageVO, int totalCount, int pageContents, int perPage) {
        int requirePage = pageVO.getRequirePage(); // ��û�� ������, PageVO �⺻�� = 1.        
        int totalPage = (totalCount%pageContents == 0 ? totalCount/pageContents : totalCount/pageContents+1); // ��ü ������ �� = (�������Ѽ�%���������Ҵ���������� == 0 ? ���� �� : �� +1)
        int beginPage = (requirePage == perPage ? 1 : (requirePage - requirePage%perPage + 1)); // ���������̼� ���۹�ȣ = ��û����������ȣ - ��û����������ȣ�� ȭ�鿡 ��������� ������������ ���� ������ + 1
        int flag = beginPage + perPage - 1; // �ӽð�(����ȣ�� ���۵Ǵ� ��) = ���������̼� ���۹�ȣ + ��������� �������� - 1
        int endPage = flag > totalPage ? totalPage : flag; // ���������̼� ����ȣ = �ӽð��� ��ü �������� ������ ��ü������ ���� ����ȣ�� ����. �׷��� ������ �ӽð��� �ش� ���������̼��� ����ȣ�� ��.
        beginPage = beginPage > endPage ? endPage : beginPage;
        int startContent = pageContents*requirePage-pageContents; // limit query ������ �������� ���� = ���������Ҵ����������*��û����������ȣ-���������Ҵ����������
        // calculate done...
        pageVO
            .setRequirePage(requirePage)
            .setTotalPage(totalPage)
            .setBeginPage(beginPage)
            .setEndPage(endPage)
            .setStartContent(startContent)
            .setPerPage(perPage); // limit query �ι�° �Ҵ����� = perPage
    }
    

}
