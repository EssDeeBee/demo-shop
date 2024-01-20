package com.jpoint.demoshop.repositories;

import com.jpoint.demoshop.model.CountryRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRecordRepository extends JpaRepository<CountryRecord, Long> {
}
