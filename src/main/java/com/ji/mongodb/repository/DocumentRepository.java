package com.ji.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ji.mongodb.model.Document;

public interface  DocumentRepository  extends MongoRepository<Document,String>{

}
