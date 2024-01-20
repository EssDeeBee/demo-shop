package com.jpoint.demoshop.repositories;

import com.jpoint.demoshop.model.SellerRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRecordCrudRepository extends CrudRepository<SellerRecord, Long> {
}
