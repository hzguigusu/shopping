package com.guigu.pojo;

import java.util.List;

public class MainCategory {
    private Integer id;

    private String categoryName;

    private Integer del;
   private List<ChildCategory>  childList;
   
    public List<ChildCategory> getChildList() {
	return childList;
}

public void setChildList(List<ChildCategory> childList) {
	this.childList = childList;
}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }
}