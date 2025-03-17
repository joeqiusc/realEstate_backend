package com.aneasy.realestate.service;

import com.aneasy.realestate.dto.ContactRequestDTO;
import com.aneasy.realestate.model.BuyingInquiry;
import com.aneasy.realestate.model.SellingInquiry;
import com.aneasy.realestate.model.ContactInfo;
import com.aneasy.realestate.model.LandlordInquiry;
import com.aneasy.realestate.model.TenantInquiry;
import com.aneasy.realestate.repository.BuyingInquiryRepository;
import com.aneasy.realestate.repository.SellingInquiryRepository;
import com.aneasy.realestate.repository.LandlordInquiryRepository;
import com.aneasy.realestate.repository.TenantInquiryRepository;
import com.aneasy.realestate.repository.ContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactInfoService {

    @Autowired
    private BuyingInquiryRepository buyingInquiryRepository;

    @Autowired
    private SellingInquiryRepository sellingInquiryRepository;

    @Autowired
    private LandlordInquiryRepository landlordInquiryRepository;

    @Autowired
    private TenantInquiryRepository tenantInquiryRepository;

    @Autowired
    private ContactInfoRepository contactInfoRepository;

    public void processContactForm(ContactRequestDTO contactRequestDTO) {
        ContactInfo contactInfo = contactRequestDTO.getContactInfo();
        contactInfoRepository.save(contactInfo);

        if (contactRequestDTO.getBuyingInquiry() != null) {
            BuyingInquiry buyingInquiry = contactRequestDTO.getBuyingInquiry();
            buyingInquiry.setContactInfo(contactInfo);
            buyingInquiryRepository.save(buyingInquiry);
        }

        if (contactRequestDTO.getSellingInquiry() != null) {
            SellingInquiry sellingInquiry = contactRequestDTO.getSellingInquiry();
            sellingInquiry.setContactInfo(contactInfo);
            sellingInquiryRepository.save(sellingInquiry);
        }

        if (contactRequestDTO.getLandlordInquiry() != null) {
            LandlordInquiry landlordInquiry = contactRequestDTO.getLandlordInquiry();
            landlordInquiry.setContactInfo(contactInfo);
            landlordInquiryRepository.save(landlordInquiry);
        }

        if (contactRequestDTO.getTenantInquiry() != null) {
            TenantInquiry tenantInquiry = contactRequestDTO.getTenantInquiry();
            tenantInquiry.setContactInfo(contactInfo);
            tenantInquiryRepository.save(tenantInquiry);
        }
    }

    public ContactInfo createContactInfo(ContactInfo contactInfo) {
        return contactInfoRepository.save(contactInfo);
    }

    public Optional<ContactInfo> getContactInfoById(Long id) {
        return contactInfoRepository.findById(id);
    }

    public List<ContactInfo> getAllContactInfos() {
        return contactInfoRepository.findAll();
    }

    public void deleteContactInfo(Long id) {
        contactInfoRepository.deleteById(id);
    }
}