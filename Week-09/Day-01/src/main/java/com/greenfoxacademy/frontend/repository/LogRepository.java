package com.greenfoxacademy.frontend.repository;

import com.greenfoxacademy.frontend.models.Log;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Log, Long> {
    @Query(value = "SELECT id, endpoint, data FROM log", nativeQuery = true)
    Iterable<Object[]> findAllIdAndEndpointAndData();
}
