package com.FawrySystem.FawrySystemService.models.Services;

public class InternetService extends Services {
    private static Float internetDiscount = 0.0F;
   String name="Internet Payment services";
    private String mobile_num;

    public void updateDiscount(Float amount) {
        internetDiscount = internetDiscount + amount;
    }

    public Float getDiscount() {
        return internetDiscount;
    }

    public String getMobile_num() {
        return mobile_num;
    }

    public void setMobile_num(String mobile_num) {
        this.mobile_num = mobile_num;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name=name;
    }
}
