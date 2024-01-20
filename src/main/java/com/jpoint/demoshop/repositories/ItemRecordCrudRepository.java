package com.jpoint.demoshop.repositories;

import com.jpoint.demoshop.model.ItemRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRecordCrudRepository extends CrudRepository<ItemRecord, Long> {
}
