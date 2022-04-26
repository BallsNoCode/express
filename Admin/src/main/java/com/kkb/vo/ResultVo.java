package com.kkb.vo;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author APPDE
 */
public class ResultVo<T> {

    private String msg = "ok";
    private Integer code = 200;
    private T obj;
    private List<T> list;
    private PageInfo<T> pageInfo;

    public ResultVo() {
    }

    public ResultVo(T obj) {
        this.obj = obj;
    }

    public ResultVo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public ResultVo(List<T> list) {
        this.list = list;
    }

    public ResultVo(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }
}
