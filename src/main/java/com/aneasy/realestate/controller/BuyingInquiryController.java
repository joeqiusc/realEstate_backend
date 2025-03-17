package com.aneasy.realestate.controller;

import com.aneasy.realestate.model.BuyingInquiry;
import com.aneasy.realestate.model.ContactInfo;
import com.aneasy.realestate.service.BuyingInquiryService;
import com.aneasy.realestate.service.ContactInfoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/buying-inquiries")
public class BuyingInquiryController {

    @Autowired
    private BuyingInquiryService buyingInquiryService;

    @Autowired
    private ContactInfoService contactInfoService;

    @PostMapping
    public BuyingInquiry createBuyingInquiry(@RequestBody BuyingInquiry buyingInquiry, @RequestParam Long contactInfoId, HttpServletRequest request) { // Updated to include contactInfoId
        // Capture IP and System Date
        String clientIp = request.getRemoteAddr();
        ContactInfo contactInfo = buyingInquiry.getContactInfo();
        contactInfo.setIpAddress(Optional.ofNullable(clientIp).orElse(""));
        contactInfo.setSystemDate(LocalDateTime.now());

        // Save Contact Info
        ContactInfo savedContactInfo = contactInfoService.createContactInfo(contactInfo);

        // Link the saved ContactInfo to the BuyingInquiry
        buyingInquiry.setContactInfo(savedContactInfo);

        // Save Buying Inquiry
        return buyingInquiryService.createBuyingInquiry(buyingInquiry, contactInfoId); // Updated to pass contactInfoId
    }

    @GetMapping("/{id}")
    public Optional<BuyingInquiry> getBuyingInquiryById(@PathVariable Long id) {
        return buyingInquiryService.getBuyingInquiryById(id);
    }

    @GetMapping
    public List<BuyingInquiry> getAllBuyingInquiries() {
        return buyingInquiryService.getAllBuyingInquiries();
    }
}