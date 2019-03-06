package com.ptaku.jascms.repository;

import org.hibernate.cache.spi.entry.CacheEntry;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<CacheEntry, Long> {
}
