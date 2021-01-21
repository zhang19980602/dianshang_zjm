package com.example.zjm.model.po;

public class DSShopValues {
    private Integer id;

    private Integer proId;

    private String attrData;

    private Integer storcks;

    private Integer price;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getAttrData() {
        return attrData;
    }

    public void setAttrData(String attrData) {
        this.attrData = attrData;
    }

    public Integer getStorcks() {
        return storcks;
    }

    public void setStorcks(Integer storcks) {
        this.storcks = storcks;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DSShopValues{" +
                "id=" + id +
                ", proId=" + proId +
                ", attrData='" + attrData + '\'' +
                ", storcks=" + storcks +
                ", price=" + price +
                '}';
    }
}
