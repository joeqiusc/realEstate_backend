package com.aneasy.realestate.controller;

import com.aneasy.realestate.model.SellingInquiry;
import com.aneasy.realestate.model.ContactInfo;
import com.aneasy.realestate.service.SellingInquiryService;
import com.aneasy.realestate.service.ContactInfoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/selling-inquiries")
public class SellingInquiryController {

    @Autowired
    private SellingInquiryService sellingInquiryService;

    @Autowired
    private ContactInfoService contactInfoService;

    @PostMapping
    public SellingInquiry createSellingInquiry(@RequestBody SellingInquiry sellingInquiry, @RequestParam Long contactInfoId, HttpServletRequest request) {
        // Capture IP and System Date
        String clientIp = request.getRemoteAddr();
        ContactInfo contactInfo = sellingInquiry.getContactInfo();
        contactInfo.setIpAddress(Optional.ofNullable(clientIp).orElse(""));
        contactInfo.setSystemDate(LocalDateTime.now());

        // Save Contact Info
        ContactInfo savedContactInfo = contactInfoService.createContactInfo(contactInfo);

        // Link the saved ContactInfo to the SellingInquiry
        sellingInquiry.setContactInfo(savedContactInfo);

        // Save Selling Inquiry
        return sellingInquiryService.createSellingInquiry(sellingInquiry, contactInfoId);
    }

    @GetMapping("/{id}")
    public Optional<SellingInquiry> getSellingInquiryById(@PathVariable Long id) {
        return sellingInquiryService.getSellingInquiryById(id);
    }

    @GetMapping
    public List<SellingInquiry> getAllSellingInquiries() {
        return sellingInquiryService.getAllSellingInquiries();
    }
}