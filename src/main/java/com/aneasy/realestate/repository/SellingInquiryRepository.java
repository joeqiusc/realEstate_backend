package com.aneasy.realestate.repository;

import com.aneasy.realestate.model.SellingInquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellingInquiryRepository extends JpaRepository<SellingInquiry, Long> {
}