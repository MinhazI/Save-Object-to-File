package com.minhaz;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Main newMain = new Main();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter person's name: ");
        String name = sc.nextLine();

        System.out.println("Enter person's age: ");
        String age = sc.nextLine();

        System.out.println("Enter person's number: ");
        String number = sc.nextLine();

//        System.out.println("Enter the document format you want to save the file in: ");
//        String documentFormat = sc.nextLine();

        Person newPerson = new Person(name, age, number);

//        newMain.writePersonToFile(newPerson, documentFormat);

        newMain.writePersonToJSON(newPerson);
        newMain.writePersonToJSONMethodTwo(newPerson);
    }

    public void writePersonToFile(Object person, String documentExtension) {

        final String filePath = "./personFile." + documentExtension;


        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(person);
            objectOut.close();
            System.out.println("Successfully wrote to file in the extension: ." + documentExtension);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Couldn't write object to file because:" + e);

        }

    }

    public void writePersonToJSON(Person person){

        File jsonFile = new File("person.json");
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonGenerator g = mapper.getFactory().createGenerator(new FileOutputStream(jsonFile));

            mapper.writeValue(g, new Person(person.getPersonalName(), person.getPersonalAge(), person.getPersonalNumber()));
            g.close();
            System.out.println("Successfully wrote to inputs to a JSON file using method one");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Couldn't write input to JSON file using method one because:" + e);
        }
    }

    public void writePersonToJSONMethodTwo(Person person) throws IOException {
        try {
            File jsonFile = new File("personFromMethodTwo.json");
            ObjectMapper mapper = new ObjectMapper();

            List<Person> tests = mapper.readValue(jsonFile, new TypeReference<List<Person>>() {
            });


            tests.add(new Person(person.getPersonalName(), person.getPersonalAge(), person.getPersonalName()));

            
            mapper.writeValue(jsonFile, tests);
        } catch (IOException e){
            System.out.println("Couldn't write input to JSON file using method two because: " + e);
            e.printStackTrace();
        }
    }
}
