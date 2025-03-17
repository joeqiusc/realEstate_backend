package com.aneasy.realestate.dto;

import com.aneasy.realestate.model.*;

public class ContactRequestDTO {
    private ContactInfo contactInfo;
    private BuyingInquiry buyingInquiry;
    private SellingInquiry sellingInquiry;
    private LandlordInquiry landlordInquiry;
    private TenantInquiry tenantInquiry;

    public LandlordInquiry getLandlordInquiry() {
        return landlordInquiry;
    }

    public void setLandlordInquiry(LandlordInquiry landlordInquiry) {
        this.landlordInquiry = landlordInquiry;
    }

    public TenantInquiry getTenantInquiry() {
        return tenantInquiry;
    }

    public void setTenantInquiry(TenantInquiry tenantInquiry) {
        this.tenantInquiry = tenantInquiry;
    }
// Getters and Setters

    public SellingInquiry getSellingInquiry() {
        return sellingInquiry;
    }

    public void setSellingInquiry(SellingInquiry sellingInquiry) {
        this.sellingInquiry = sellingInquiry;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public BuyingInquiry getBuyingInquiry() {
        return buyingInquiry;
    }

    public void setBuyingInquiry(BuyingInquiry buyingInquiry) {
        this.buyingInquiry = buyingInquiry;
    }
}