package com.aneasy.realestate.service;

import com.aneasy.realestate.model.LandlordInquiry;
import com.aneasy.realestate.model.ContactInfo;
import com.aneasy.realestate.repository.LandlordInquiryRepository;
import com.aneasy.realestate.repository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandlordInquiryService {

    @Autowired
    private LandlordInquiryRepository landlordInquiryRepository;

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    // Method to create a new LandlordInquiry
    public LandlordInquiry createLandlordInquiry(LandlordInquiry landlordInquiry, Long contactInfoId) {
        ContactInfo contactInfo = contactInfoRepository.findById(contactInfoId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact info ID"));
        landlordInquiry.setContactInfo(contactInfo); // Set contactInfo in landlordInquiry
        return landlordInquiryRepository.save(landlordInquiry);
    }

    // Method to get a LandlordInquiry by its ID
    public Optional<LandlordInquiry> getLandlordInquiryById(Long id) {
        return landlordInquiryRepository.findById(id);
    }

    // Method to get all LandlordInquiries
    public List<LandlordInquiry> getAllLandlordInquiries() {
        return landlordInquiryRepository.findAll();
    }

    // Method to delete a LandlordInquiry by its ID
    public void deleteLandlordInquiry(Long id) {
        landlordInquiryRepository.deleteById(id);
    }
}