package com.aneasy.realestate.service;

import com.aneasy.realestate.model.TenantInquiry;
import com.aneasy.realestate.model.ContactInfo;
import com.aneasy.realestate.repository.TenantInquiryRepository;
import com.aneasy.realestate.repository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TenantInquiryService {

    @Autowired
    private TenantInquiryRepository tenantInquiryRepository;

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    // Method to create a new TenantInquiry
    public TenantInquiry createTenantInquiry(TenantInquiry tenantInquiry, Long contactInfoId) {
        ContactInfo contactInfo = contactInfoRepository.findById(contactInfoId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact info ID"));
        tenantInquiry.setContactInfo(contactInfo); // Set contactInfo in tenantInquiry
        return tenantInquiryRepository.save(tenantInquiry);
    }

    // Method to get a TenantInquiry by its ID
    public Optional<TenantInquiry> getTenantInquiryById(Long id) {
        return tenantInquiryRepository.findById(id);
    }

    // Method to get all TenantInquiries
    public List<TenantInquiry> getAllTenantInquiries() {
        return tenantInquiryRepository.findAll();
    }

    // Method to delete a TenantInquiry by its ID
    public void deleteTenantInquiry(Long id) {
        tenantInquiryRepository.deleteById(id);
    }
}