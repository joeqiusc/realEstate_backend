package com.aneasy.realestate.controller;

import com.aneasy.realestate.model.LandlordInquiry;
import com.aneasy.realestate.model.ContactInfo;
import com.aneasy.realestate.repository.LandlordInquiryRepository;
import com.aneasy.realestate.repository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/landlord")
public class LandlordInquiryController {

    @Autowired
    private LandlordInquiryRepository landlordInquiryRepository;

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    @PostMapping
    public LandlordInquiry createListingInquiry(@RequestBody LandlordInquiry landlordInquiry) {
        ContactInfo contactInfo = landlordInquiry.getContactInfo();
        contactInfoRepository.save(contactInfo);
        return landlordInquiryRepository.save(landlordInquiry);
    }

    // Other methods...
}