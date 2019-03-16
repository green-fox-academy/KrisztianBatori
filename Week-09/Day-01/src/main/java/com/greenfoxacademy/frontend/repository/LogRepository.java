package com.greenfoxacademy.frontend.repository;

import com.greenfoxacademy.frontend.models.Log;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LogRepository extends CrudRepository<Log, Long> {
    @Query(value = "SELECT id, endpoint, data FROM log WHERE data LIKE CONCAT('%',:#{#search},'%') ORDER BY id DESC LIMIT :#{#count} OFFSET :#{#page}", nativeQuery = true)
    Iterable<Object[]> findAllIdAndEndpointAndData(@Param("count") int count,
                                                   @Param("page") int page,
                                                   @Param(value = "search") String search);
}
