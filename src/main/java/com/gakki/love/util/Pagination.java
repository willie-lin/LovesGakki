package com.gakki.love.util;

/*
分页工具类
 */


import java.util.List;

@SuppressWarnings("unused")
public class Pagination<T>{

    /*
    总页数
     */
    private int totalPages;
    /*
    总记录数
     */
    private int totalNumber;
    /*
    下一页
     */
    private int nextPage;
    /*
    最后一页
     */
    private int lastPage;
    /*
    是否还有下一页
     */
    private boolean hasNext;
    /*
    是否有上一页
     */
    private boolean hasLast;
    /*
    当前页号从1开始
     */
    private int number;
    /*
    每页大小
     */
    private int pageSize;
    /*
    用于存放满足条件的用户信息
     */
    private List<T> content;

    public Pagination(List<T> ts , int page,int size,int count){

        setTotalNumber(count);
        setPageSize(size);
        setTotalPages();
        setNumber(page);
        setContent(ts);
    }


    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages() {

        double d = Math.ceil(totalNumber * 1.0 /pageSize );
        this.totalPages = (int) d;

    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getNextPage() {
        if (number >= totalPages){
            return totalPages;
        }
        return totalPages + 1;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getLastPage() {
        if (number <= 0){
            return 0;
        }
        return totalPages - 1;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public boolean getHasNext() {
        return number < totalPages ? true : false;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public int getHasLast() {
        return number > totalPages ? totalPages : pageSize < 1 ? 1 : pageSize;
    }

    public void setHasLast(boolean hasLast) {
        this.hasLast = hasLast;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPageSize() {
        return pageSize > totalPages ? totalPages : pageSize < 1 ? 1 : pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
