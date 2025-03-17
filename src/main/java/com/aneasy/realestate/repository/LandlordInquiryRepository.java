package com.aneasy.realestate.repository;

import com.aneasy.realestate.model.LandlordInquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandlordInquiryRepository extends JpaRepository<LandlordInquiry, Long> {
}