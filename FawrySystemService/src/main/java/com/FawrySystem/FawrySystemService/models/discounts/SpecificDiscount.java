package com.FawrySystem.FawrySystemService.models.discounts;

public class SpecificDiscount extends Discount {

    // check first if the list is not empty in order to avoid null errors
    //  check if the service can handle another discount addition without exceeding 1
    @Override
    public void setDiscount(Float amount) {
        services.get(0).updateDiscount(amount);
    }

    // remove the discount for the service specified
    @Override
    public void removeDiscount() {
        if (services.size() > 0)
            services.get(0).updateDiscount(-services.get(0).getDiscount());
    }
}
