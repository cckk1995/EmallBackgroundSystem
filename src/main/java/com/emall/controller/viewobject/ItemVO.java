package com.emall.controller.viewobject;

/**
 * 用于在前端select中显示
 */
public class ItemVO {
    private String itemId;
    private String title;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
