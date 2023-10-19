package com.pribas.pribasmonolithic.repository;

import com.pribas.pribasmonolithic.model.Moment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMomentRepository extends MongoRepository<Moment, String> {

    //todo sor
    @Query("{ $or: [ { 'info.title': { $regex: ?0, $options: 'i' } }, { 'info.description': { $regex: ?0, $options: 'i' } } ] }")
    List<Moment> findMomentsByTitleOrDescriptionContaining(String keyword);
}
