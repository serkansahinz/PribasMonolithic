package com.pribas.pribasmonolithic.repository;

import com.pribas.pribasmonolithic.model.Timeline;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITimelineRepository extends MongoRepository<Timeline, String> {



    @Query("{ $or: [ { 'info.title': { $regex: ?0, $options: 'i' } }, { 'info.description': { $regex: ?0, $options: 'i' } } ] }")
    List<Timeline> findTimelinesByTitleOrDescriptionContaining(String keyword);
}
