package com.pribas.pribasmonolithic.repository;

import com.pribas.pribasmonolithic.model.Timeline;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITimelineRepository extends MongoRepository<Timeline, String> {
    public Optional<Timeline> findByTitle(String title);
}
