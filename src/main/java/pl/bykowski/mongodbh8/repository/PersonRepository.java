package pl.bykowski.mongodbh8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bykowski.mongodbh8.model.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
