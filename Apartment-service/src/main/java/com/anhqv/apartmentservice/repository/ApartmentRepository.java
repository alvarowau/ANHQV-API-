package com.anhqv.apartmentservice.repository;

import com.anhqv.apartmentservice.model.ApartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<ApartmentEntity, Long> {
}
