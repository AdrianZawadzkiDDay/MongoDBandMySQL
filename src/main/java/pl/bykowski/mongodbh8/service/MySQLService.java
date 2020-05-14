package pl.bykowski.mongodbh8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bykowski.mongodbh8.aspect.PersonTimer;
import pl.bykowski.mongodbh8.model.PersonEntity;
import pl.bykowski.mongodbh8.repository.PersonRepository;

import java.util.List;

@Service
public class MySQLService {

    private PersonRepository personRepository;

    @Autowired
    public MySQLService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PersonTimer
    public void saveToDb(List<PersonEntity> employeeList) {
        System.out.println("--- Saving to DB ---");
        personRepository.saveAll(employeeList);
        System.out.println("------ Saving to DB finished. ------");
    }

    @PersonTimer
    public List<PersonEntity> readFromDb() {
        System.out.println("--- Reading from DB ---");
        List<PersonEntity> employeeList = personRepository.findAll();
        System.out.println("------ Reading from DB finished. ------");
        return employeeList;
    }

}
