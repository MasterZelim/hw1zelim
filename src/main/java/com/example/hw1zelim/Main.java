package com.example.hw1zelim;


import com.example.hw1zelim.service.PrintServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        PrintServiceImpl service = context.getBean(PrintServiceImpl.class);
        service.print();
    }

}
