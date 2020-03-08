package com.liudao.pojo;

import java.util.List;

/**
 * @author:liudao
 * @company:null
 * @date: 2020/3/4 - 17:13
 */
public class Page<T> {
    public static final Integer PAGE_SIZE = 4;
    //当前页
    private Integer pageNo;
    //总页码
    private Integer pageTotal;
    //总记录数
    private Integer pageTotalCount;
    //当前页显示数量  4本书的数据
    private Integer pageSize= PAGE_SIZE;
    //当前页数据集合~ -.-## 显示所有的book数据
    //设计成泛型T 以后可以让分页通用所有的对象
    //分页条的请求地址
    private String url;
    private List<T> items;

    public static Integer getPageSize() {
        return PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        //数据边界的有效检查
        if(pageNo<1){
            pageNo=1;
        }
        if(pageNo>pageTotal){
            pageNo = pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageTotalCount=" + pageTotalCount +
                ", pageSize=" + pageSize +
                ", url='" + url + '\'' +
                ", items=" + items +
                '}';
    }
}
