package com.FawrySystem.FawrySystemService.models.Services;

public class MobileRecharge extends Services {
    private static double mobileDiscount = 0.0;
    String name="Mobile recharge services";
    private String mobile_num;

    public void updateDiscount(double amount) {
        mobileDiscount = mobileDiscount + amount;
    }

    public double getDiscount() {
        return mobileDiscount;
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
