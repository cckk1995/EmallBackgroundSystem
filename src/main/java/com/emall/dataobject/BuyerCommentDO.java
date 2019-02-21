package com.emall.dataobject;

import java.util.Date;

public class BuyerCommentDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_buyer_comment.buyer_comment_id
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    private String buyerCommentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_buyer_comment.order_item_id
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    private String orderItemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_buyer_comment.user_id
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_buyer_comment.comment
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    private String comment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_buyer_comment.comment_type
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    private Byte commentType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_buyer_comment.create_time
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_buyer_comment.update_time
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column em_buyer_comment.comment_img_url
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    private String commentImgUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_buyer_comment.buyer_comment_id
     *
     * @return the value of em_buyer_comment.buyer_comment_id
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public String getBuyerCommentId() {
        return buyerCommentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_buyer_comment.buyer_comment_id
     *
     * @param buyerCommentId the value for em_buyer_comment.buyer_comment_id
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public void setBuyerCommentId(String buyerCommentId) {
        this.buyerCommentId = buyerCommentId == null ? null : buyerCommentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_buyer_comment.order_item_id
     *
     * @return the value of em_buyer_comment.order_item_id
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public String getOrderItemId() {
        return orderItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_buyer_comment.order_item_id
     *
     * @param orderItemId the value for em_buyer_comment.order_item_id
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId == null ? null : orderItemId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_buyer_comment.user_id
     *
     * @return the value of em_buyer_comment.user_id
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_buyer_comment.user_id
     *
     * @param userId the value for em_buyer_comment.user_id
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_buyer_comment.comment
     *
     * @return the value of em_buyer_comment.comment
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_buyer_comment.comment
     *
     * @param comment the value for em_buyer_comment.comment
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_buyer_comment.comment_type
     *
     * @return the value of em_buyer_comment.comment_type
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public Byte getCommentType() {
        return commentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_buyer_comment.comment_type
     *
     * @param commentType the value for em_buyer_comment.comment_type
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public void setCommentType(Byte commentType) {
        this.commentType = commentType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_buyer_comment.create_time
     *
     * @return the value of em_buyer_comment.create_time
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_buyer_comment.create_time
     *
     * @param createTime the value for em_buyer_comment.create_time
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_buyer_comment.update_time
     *
     * @return the value of em_buyer_comment.update_time
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_buyer_comment.update_time
     *
     * @param updateTime the value for em_buyer_comment.update_time
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column em_buyer_comment.comment_img_url
     *
     * @return the value of em_buyer_comment.comment_img_url
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public String getCommentImgUrl() {
        return commentImgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column em_buyer_comment.comment_img_url
     *
     * @param commentImgUrl the value for em_buyer_comment.comment_img_url
     *
     * @mbg.generated Thu Feb 21 10:15:21 CST 2019
     */
    public void setCommentImgUrl(String commentImgUrl) {
        this.commentImgUrl = commentImgUrl == null ? null : commentImgUrl.trim();
    }
}