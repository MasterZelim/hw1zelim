package com.example2.hw2zelim.dao;

import com.example2.hw2zelim.exception.CSVQuestionException;
import com.example2.hw2zelim.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.dozer.CsvDozerBeanReader;
import org.supercsv.io.dozer.ICsvDozerBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.beans.ConstructorProperties;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
@PropertySource("classpath:application.properties")
@Repository
public class QuestionDaoImpl implements QuestionDao {

    private final String pathCsv;

    private static final String[] FIELD_MAPPING = new String[]{

            "number",
            "question",
            "answers[0]",
            "answers[1]",
            "answers[2]",
            "answers[3]"
    };


    @Autowired
    public QuestionDaoImpl(@Value("${pathCsv}") String pathCsv) {
        this.pathCsv = pathCsv;
    }

    private static final CellProcessor[] processors = new CellProcessor[]{
            new Optional(new ParseInt()),
            new Optional(),
            new Optional(),
            new Optional(),
            new Optional(),
            new Optional()

    };


    @Override
    public List<Question> readQuestionsFromSource() {

        List<Question> questions = new ArrayList<>();
        InputStream inputStream = getFileFromResourceAsStream(pathCsv);

        try (ICsvDozerBeanReader readerCsv = new CsvDozerBeanReader(new InputStreamReader(inputStream), CsvPreference.STANDARD_PREFERENCE)) {

            readerCsv.getHeader(true);
            readerCsv.configureBeanMapping(Question.class, FIELD_MAPPING);

            Question question;

            while ((question = readerCsv.read(Question.class, processors)) != null) {

                questions.add(question);

            }
        } catch (IOException e) {

            System.out.println(e.getMessage() + " Не удается получить список вопросов!");
            throw new CSVQuestionException("Не удается получить список вопросов!", e);
        }
        return questions;
    }


    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }
}
