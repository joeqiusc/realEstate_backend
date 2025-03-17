package com.aneasy.realestate.controller;

import com.aneasy.realestate.dto.ContactRequestDTO;
import com.aneasy.realestate.model.BuyingInquiry;
import com.aneasy.realestate.model.SellingInquiry;
import com.aneasy.realestate.model.LandlordInquiry;
import com.aneasy.realestate.model.TenantInquiry;
import com.aneasy.realestate.model.ContactInfo;
import com.aneasy.realestate.service.ContactInfoService;
import com.aneasy.realestate.service.BuyingInquiryService;
import com.aneasy.realestate.service.SellingInquiryService;
import com.aneasy.realestate.service.LandlordInquiryService;
import com.aneasy.realestate.service.TenantInquiryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contact-form")
public class ContactInfoController {

    @Autowired
    private ContactInfoService contactInfoService;

    @Autowired
    private BuyingInquiryService buyingInquiryService;

    @Autowired
    private SellingInquiryService sellingInquiryService;

    @Autowired
    private LandlordInquiryService landlordInquiryService;

    @Autowired
    private TenantInquiryService tenantInquiryService;

    @PostMapping
    public ContactInfo createContactInfo(@RequestBody ContactRequestDTO contactRequestDTO, HttpServletRequest request) {
        ContactInfo contactInfo = contactRequestDTO.getContactInfo();

        // Capture IP and System Date
        String clientIp = request.getRemoteAddr();
        contactInfo.setIpAddress(Optional.ofNullable(clientIp).orElse(""));
        contactInfo.setSystemDate(LocalDateTime.now());

        // Save Contact Info
        ContactInfo savedContactInfo = contactInfoService.createContactInfo(contactInfo);

        // Handle Buying Inquiry
        if (contactRequestDTO.getBuyingInquiry() != null) {
            BuyingInquiry buyingInquiry = contactRequestDTO.getBuyingInquiry();
            buyingInquiry.setContactInfo(savedContactInfo);
            buyingInquiryService.createBuyingInquiry(buyingInquiry, savedContactInfo.getId());
        }

        // Handle Selling Inquiry
        if (contactRequestDTO.getSellingInquiry() != null) {
            SellingInquiry sellingInquiry = contactRequestDTO.getSellingInquiry();
            sellingInquiry.setContactInfo(savedContactInfo);
            sellingInquiryService.createSellingInquiry(sellingInquiry, savedContactInfo.getId());
        }

        // Handle Landlord Inquiry
        if (contactRequestDTO.getLandlordInquiry() != null) {
            LandlordInquiry landlordInquiry = contactRequestDTO.getLandlordInquiry();
            landlordInquiry.setContactInfo(savedContactInfo);
            landlordInquiryService.createLandlordInquiry(landlordInquiry, savedContactInfo.getId());
        }

        // Handle Tenant Inquiry
        if (contactRequestDTO.getTenantInquiry() != null) {
            TenantInquiry tenantInquiry = contactRequestDTO.getTenantInquiry();
            tenantInquiry.setContactInfo(savedContactInfo);
            tenantInquiryService.createTenantInquiry(tenantInquiry, savedContactInfo.getId());
        }

        return savedContactInfo;
    }

    @GetMapping("/{id}")
    public Optional<ContactInfo> getContactInfoById(@PathVariable Long id) {
        return contactInfoService.getContactInfoById(id);
    }

    @GetMapping
    public List<ContactInfo> getAllContactInfos() {
        return contactInfoService.getAllContactInfos();
    }

    @DeleteMapping("/{id}")
    public void deleteContactInfo(@PathVariable Long id) {
        contactInfoService.deleteContactInfo(id);
    }
}