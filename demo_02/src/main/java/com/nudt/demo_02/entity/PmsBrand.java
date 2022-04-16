package com.nudt.demo_02.entity;

/**
 * @Author: Lzy
 * @Time: 2022/4/12
 */
import java.io.Serializable;

public class PmsBrand implements Serializable{
    /**
     * 用于在序列化和反序列化过程中进行核验的一个版本号
     * 序列化：将一个版本号serialVersionUID与每个可序列化类相关联
     * 反序列化：该版本号用于验证序列化对象的发送方和接收方是否为该对象加载了与序列化兼容的类
     */
    private static final long serialVersionUID = 1L;

    private long id;

    private String name;

    private String firstLetter;

    private Integer sort;

    // 是否为品牌制造商, 0->不是, 1->是
    private Integer factoryStatus;

    private Integer showStatus;

    private Integer productCount;

    private Integer productCommentCount;

    private String logo;

    private String bigPic;

    private String brandStory;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFactoryStatus() {
        return factoryStatus;
    }

    public void setFactoryStatus(Integer factoryStatus) {
        this.factoryStatus = factoryStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getProductCommentCount() {
        return productCommentCount;
    }

    public void setProductCommentCount(Integer productCommentCount) {
        this.productCommentCount = productCommentCount;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", id = ").append(this.id);
        sb.append(", name= ").append(this.name);
        sb.append(", firstLetter = ").append(this.firstLetter);
        sb.append(", sort = ").append(this.sort);
        sb.append(", factoryStatus = ").append(this.factoryStatus);
        sb.append(", showStatus = ").append(this.showStatus);
        sb.append(", productCount = ").append(this.productCount);
        sb.append(", productCommentCount = ").append(this.productCommentCount);
        sb.append(", logo = ").append(this.logo);
        sb.append(", bigPic = ").append(this.bigPic);
        sb.append(", brandStory = ").append(this.brandStory);
        sb.append(", serialVersionUID = ").append(serialVersionUID);

        return sb.toString();
    }
}
