package com.aneasy.realestate.repository;

import com.aneasy.realestate.model.TenantInquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantInquiryRepository extends JpaRepository<TenantInquiry, Long> {
}