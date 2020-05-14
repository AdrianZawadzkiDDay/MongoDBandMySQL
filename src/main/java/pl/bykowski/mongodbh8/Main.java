package pl.bykowski.mongodbh8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.bykowski.mongodbh8.model.PersonEntity;
import pl.bykowski.mongodbh8.model.PersonMongo;
import pl.bykowski.mongodbh8.service.CsvFileReader;
import pl.bykowski.mongodbh8.service.MongoDbService;
import pl.bykowski.mongodbh8.service.MySQLService;

import java.util.List;

@Component
public class Main {

    private CsvFileReader csvFileReader;
    private MongoDbService mongoDbService;
    private MySQLService mySQLService;

    @Autowired
    public Main(CsvFileReader csvFileReader, MongoDbService mongoDbService, MySQLService mySQLService) {
        this.csvFileReader = csvFileReader;
        this.mongoDbService = mongoDbService;
        this.mySQLService = mySQLService;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void start(){
        List<PersonEntity> employeeList = csvFileReader.readEntityFromCsv();
//      List<PersonMongo> employeeDocumentList = csvFileReader.readDocumentFromCsv();

        //MySQL with Hiberante
        mySQLService.saveToDb(employeeList);
        mySQLService.readFromDb();


        //MongoDB
//      mongoDbService.saveToDb(employeeDocumentList);
//      mongoDbService.readFromDb();

    }


}
