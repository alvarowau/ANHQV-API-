package com.anhqv.apartmentservice.repository;

import com.anhqv.apartmentservice.model.ApartmentOccupancyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentOccupancyRepository extends JpaRepository<ApartmentOccupancyEntity,Long> {
}
