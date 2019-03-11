package com.ptaku.jascms.repository;

import com.ptaku.jascms.entity.RepairEntity;
import org.springframework.data.repository.CrudRepository;

public interface RepairRepository extends CrudRepository<RepairEntity, Long> {

    Iterable<RepairEntity> findRepairEntitiesByCarEntityId(Long id);
}
