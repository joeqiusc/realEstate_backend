package com.aneasy.realestate.controller;

import com.aneasy.realestate.model.TenantInquiry;
import com.aneasy.realestate.model.ContactInfo;
import com.aneasy.realestate.repository.TenantInquiryRepository;
import com.aneasy.realestate.repository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tenant")
public class TenantInquiryController {

    @Autowired
    private TenantInquiryRepository tenantInquiryRepository;

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    @PostMapping
    public TenantInquiry createRentingInquiry(@RequestBody TenantInquiry tenantInquiry) {
        ContactInfo contactInfo = tenantInquiry.getContactInfo();
        contactInfoRepository.save(contactInfo);
        return tenantInquiryRepository.save(tenantInquiry);
    }

    // Other methods...
}