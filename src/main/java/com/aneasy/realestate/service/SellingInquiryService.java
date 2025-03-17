package com.aneasy.realestate.service;

import com.aneasy.realestate.model.SellingInquiry;
import com.aneasy.realestate.model.ContactInfo;
import com.aneasy.realestate.repository.SellingInquiryRepository;
import com.aneasy.realestate.repository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellingInquiryService {

    @Autowired
    private SellingInquiryRepository sellingInquiryRepository;

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    // Method to create a new SellingInquiry
    public SellingInquiry createSellingInquiry(SellingInquiry sellingInquiry, Long contactInfoId) {
        ContactInfo contactInfo = contactInfoRepository.findById(contactInfoId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact info ID"));
        sellingInquiry.setContactInfo(contactInfo); // Set contactInfo in sellingInquiry
        return sellingInquiryRepository.save(sellingInquiry);
    }

    // Method to get a SellingInquiry by its ID
    public Optional<SellingInquiry> getSellingInquiryById(Long id) {
        return sellingInquiryRepository.findById(id);
    }

    // Method to get all SellingInquiries
    public List<SellingInquiry> getAllSellingInquiries() {
        return sellingInquiryRepository.findAll();
    }
}