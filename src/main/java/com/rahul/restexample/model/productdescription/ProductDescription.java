package com.rahul.restexample.model.productdescription;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by rahulsharma on 3/25/17.
 */

public class ProductDescription
{
    @JsonProperty("title")
    private String title;
    @JsonProperty("bullet_description")
    private List<String> bulletDesc;
    @JsonProperty("general_description")
    private String generalDesc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getBulletDesc() {
        return bulletDesc;
    }

    public void setBulletDesc(List<String> bulletDesc) {
        this.bulletDesc = bulletDesc;
    }

    public String getGeneralDesc() {
        return generalDesc;
    }

    public void setGeneralDesc(String generalDesc) {
        this.generalDesc = generalDesc;
    }

    @Override
    public String toString() {
        return "ProductDescription{" +
                "title='" + title + '\'' +
                ", bulletDesc=" + bulletDesc +
                ", generalDesc='" + generalDesc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductDescription that = (ProductDescription) o;

        if (!title.equals(that.title)) return false;
        if (!bulletDesc.equals(that.bulletDesc)) return false;
        return generalDesc.equals(that.generalDesc);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + bulletDesc.hashCode();
        result = 31 * result + generalDesc.hashCode();
        return result;
    }
}
