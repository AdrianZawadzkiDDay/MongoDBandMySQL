package pl.bykowski.mongodbh8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bykowski.mongodbh8.aspect.PersonTimer;
import pl.bykowski.mongodbh8.model.PersonMongo;
import pl.bykowski.mongodbh8.repository.PersonRepositoryMongoDB;

import java.util.List;

@Service
public class MongoDbService {

    private PersonRepositoryMongoDB personRepositoryMongoDB;

    @Autowired
    public MongoDbService(PersonRepositoryMongoDB personRepositoryMongoDB) {
        this.personRepositoryMongoDB = personRepositoryMongoDB;
    }

    @PersonTimer
    public void saveToDb(List<PersonMongo> employeeList) {
        System.out.println("--- MongoDB: Saving to DB --- ");
        personRepositoryMongoDB.saveAll(employeeList);
        System.out.println("------ MongoDB: Saving to DB finished. ------ ");
    }

    @PersonTimer
    public List<PersonMongo> readFromDb() {
        System.out.println("--- MongoDB: Reading from DB --- ");
        List<PersonMongo> employeeList = personRepositoryMongoDB.findAll();
        System.out.println("------ MongoDB: Reading from DB finished. ------ ");
        return employeeList;
    }

}
