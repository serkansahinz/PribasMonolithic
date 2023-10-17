package com.pribas.pribasmonolithic.repository;

import com.pribas.pribasmonolithic.model.Moment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMomentRepository extends MongoRepository<Moment, String> {

//  public Optional<Moment> findByTitle(String title);
//
//    public void deleteByTitle(String title);
//
//    public List<Moment> findByTimelineTitle(String title);
}
