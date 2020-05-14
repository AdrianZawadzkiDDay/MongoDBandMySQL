package pl.bykowski.mongodbh8.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.bykowski.mongodbh8.model.PersonMongo;

@Repository
public interface PersonRepositoryMongoDB extends MongoRepository<PersonMongo, String> {
}
