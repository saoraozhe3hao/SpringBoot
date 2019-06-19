package com.xianqingzao.yequxiaoquan.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Query implements Serializable {
    private int pageNum;
    private int pageSize;
    private String search;
    private String status;
    private String category;

    public Query(int pageNum, int pageSize, String search, String status) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.search = search;
        this.status = status;
    }

    public Query(int pageNum, int pageSize, String search) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.search = search;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
