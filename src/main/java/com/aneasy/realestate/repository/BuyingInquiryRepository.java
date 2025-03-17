package com.aneasy.realestate.repository;

import com.aneasy.realestate.model.BuyingInquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyingInquiryRepository extends JpaRepository<BuyingInquiry, Long> {
}