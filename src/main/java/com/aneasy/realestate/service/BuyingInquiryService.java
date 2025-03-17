package com.aneasy.realestate.service;

import com.aneasy.realestate.model.BuyingInquiry;
import com.aneasy.realestate.model.ContactInfo; // Ensure ContactInfo is imported
import com.aneasy.realestate.repository.BuyingInquiryRepository;
import com.aneasy.realestate.repository.ContactInfoRepository; // Import the ContactInfo repository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyingInquiryService {

    @Autowired
    private BuyingInquiryRepository buyingInquiryRepository;

    @Autowired
    private ContactInfoRepository contactInfoRepository; // Autowire the ContactInfo repository

    // Updated method to handle contactInfoId
    public BuyingInquiry createBuyingInquiry(BuyingInquiry buyingInquiry, Long contactInfoId) {
        ContactInfo contactInfo = contactInfoRepository.findById(contactInfoId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact info ID"));
        buyingInquiry.setContactInfo(contactInfo); // Set contactInfo in buyingInquiry
        return buyingInquiryRepository.save(buyingInquiry);
    }

    public Optional<BuyingInquiry> getBuyingInquiryById(Long id) {
        return buyingInquiryRepository.findById(id);
    }

    public List<BuyingInquiry> getAllBuyingInquiries() {
        return buyingInquiryRepository.findAll();
    }
}