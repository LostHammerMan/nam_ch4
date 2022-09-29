package com.fastcampus.ch4.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class PageHandler {

//    private int page; // 현재 페이지
//    private int pageSize; // 한 페이지의 크기
//    private String option;
//    private String keyword;

        private int totalCnt; // 총 게시물의 개수
    private SearchCondition sc;

    private int naviSize = 10; // 페이지 네이게이션의 크기
    private int totalPage; // 전체 페이지의 수

    private int beginPage; // 네비게이션의 첫번째 페이지
    private int endPage; // 네이게이션의 마지막 페이지
    private boolean showPrev; // 이전 페이지로 이동하는 링크를 보여줄 것인지
    private boolean showNext; // 다음 페이지로 이동하는 링크를 보여줄 것인지

    public PageHandler(int totalCnt, SearchCondition sc){
        this.totalCnt = totalCnt;
        this.sc = sc;

        doPaging(totalCnt, sc);
    }


    public void doPaging(int totalCnt, SearchCondition sc) {
        this.totalCnt = totalCnt;


        totalPage = (int)Math.ceil(totalCnt / (double)sc.getPageSize());
        beginPage = (sc.getPage()-1) / naviSize * naviSize + 1;
        endPage = Math.min(beginPage + naviSize -1, totalPage);
        showPrev = beginPage!=1;
        showNext = endPage!=totalPage;
    }

    void print(){
        System.out.println("page=" + sc.getPage());
        System.out.println(showPrev ? "[prev] " : "");
        for (int i = beginPage ; i <= endPage; i++){
            System.out.println(i + "  ");
        }
        System.out.println(showNext ? "[next]" : "");
    }



    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }


    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }



    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public SearchCondition getSc() {
        return sc;
    }

    public void setSc(SearchCondition sc) {
        this.sc = sc;
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "totalCnt=" + totalCnt +
                ", sc=" + sc +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}