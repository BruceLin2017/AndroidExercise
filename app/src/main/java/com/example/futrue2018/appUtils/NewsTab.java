package com.example.futrue2018.appUtils;

import java.util.Date;

/**
 * Created by Futrue2018 on 2017/1/9.
 */


public class NewsTab {
    private int nid;
    private String title;
    private String newsContent;
    private String imgUrl;
    private Date createDate;

    public NewsTab() {
        super();
    }
    public NewsTab(int nid, String title, String newsContent, String imgUrl, Date createDate) {
        super();
        this.nid = nid;
        this.title = title;
        this.newsContent = newsContent;
        this.imgUrl = imgUrl;
        this.createDate = createDate;
    }
    /**
     * @return the nid
     */
    public int getNid() {
        return nid;
    }
    /**
     * @param nid the nid to set
     */
    public void setNid(int nid) {
        this.nid = nid;
    }
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @return the newsContent
     */
    public String getNewsContent() {
        return newsContent;
    }
    /**
     * @param newsContent the newsContent to set
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
    /**
     * @return the imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }
    /**
     * @param imgUrl the imgUrl to set
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }
    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "NewsTab [nid=" + nid + ", title=" + title + ", newsContent=" + newsContent + ", imgUrl=" + imgUrl
                + ", createDate=" + createDate + "]";
    }

}
