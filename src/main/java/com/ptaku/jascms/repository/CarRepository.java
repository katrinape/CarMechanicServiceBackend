package com.ptaku.jascms.repository;

import com.ptaku.jascms.entity.CarEntity;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<CarEntity, Long> {

    Iterable<CarEntity> findCarEntitiesByCustomerEntityId(Long id);
}
