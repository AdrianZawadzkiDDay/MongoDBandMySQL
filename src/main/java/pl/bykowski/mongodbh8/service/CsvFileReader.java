package pl.bykowski.mongodbh8.service;

import com.fasterxml.jackson.dataformat.csv.CsvParser;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import pl.bykowski.mongodbh8.model.PersonEntity;
import pl.bykowski.mongodbh8.model.PersonMongo;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CsvFileReader {

    public List<PersonEntity> readEntityFromCsv() {
        System.out.println("Start reading data from CSV file");
        File csvFile = new File("src/main/resources/MOCK_DATA.csv");
        List personList = null;


        try {
            MappingIterator<PersonEntity> personIterator = new CsvMapper()
                    .enable(CsvParser.Feature.IGNORE_TRAILING_UNMAPPABLE)
                    .readerWithTypedSchemaFor(PersonEntity.class)
                    .readValues(csvFile);


            personList = personIterator.readAll();
            System.out.println("Reading data from CSV file finished.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return personList;
    }

    public List<PersonMongo> readDocumentFromCsv() {
        System.out.println("Start reading data from CSV file");
        File csvFile = new File("src/main/resources/MOCK_DATA.csv");
        List personList = null;

        try {
            MappingIterator<PersonMongo> personIterator = new CsvMapper()
                    .enable(CsvParser.Feature.IGNORE_TRAILING_UNMAPPABLE)
                    .readerWithTypedSchemaFor(PersonMongo.class)
                    .readValues(csvFile);

            personList = personIterator.readAll();
            System.out.println("Reading data from CSV file finished.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return personList;
    }

}
