package com.emall.dataobject;

public class NavigationItemDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_navigation_item.id
     *
     * @mbg.generated Sun Mar 31 22:16:43 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_navigation_item.item_id
     *
     * @mbg.generated Sun Mar 31 22:16:43 CST 2019
     */
    private String itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_navigation_item.source_url
     *
     * @mbg.generated Sun Mar 31 22:16:43 CST 2019
     */
    private String sourceUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_navigation_item.item_status
     *
     * @mbg.generated Sun Mar 31 22:16:43 CST 2019
     */
    private Boolean itemStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_navigation_item.id
     *
     * @return the value of em_navigation_item.id
     *
     * @mbg.generated Sun Mar 31 22:16:43 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_navigation_item.id
     *
     * @param id the value for em_navigation_item.id
     *
     * @mbg.generated Sun Mar 31 22:16:43 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_navigation_item.item_id
     *
     * @return the value of em_navigation_item.item_id
     *
     * @mbg.generated Sun Mar 31 22:16:43 CST 2019
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_navigation_item.item_id
     *
     * @param itemId the value for em_navigation_item.item_id
     *
     * @mbg.generated Sun Mar 31 22:16:43 CST 2019
     */
    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_navigation_item.source_url
     *
     * @return the value of em_navigation_item.source_url
     *
     * @mbg.generated Sun Mar 31 22:16:43 CST 2019
     */
    public String getSourceUrl() {
        return sourceUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_navigation_item.source_url
     *
     * @param sourceUrl the value for em_navigation_item.source_url
     *
     * @mbg.generated Sun Mar 31 22:16:43 CST 2019
     */
    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl == null ? null : sourceUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_navigation_item.item_status
     *
     * @return the value of em_navigation_item.item_status
     *
     * @mbg.generated Sun Mar 31 22:16:43 CST 2019
     */
    public Boolean getItemStatus() {
        return itemStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_navigation_item.item_status
     *
     * @param itemStatus the value for em_navigation_item.item_status
     *
     * @mbg.generated Sun Mar 31 22:16:43 CST 2019
     */
    public void setItemStatus(Boolean itemStatus) {
        this.itemStatus = itemStatus;
    }
}