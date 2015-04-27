package com.soprasteria.boot.util;

import au.com.bytecode.opencsv.CSVReader;
import com.soprasteria.boot.domain.Konsulent;
import com.soprasteria.boot.domain.Prosjekt;
import com.soprasteria.boot.domain.Stilling;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olovholm on 27.04.2015.
 */
@Component
public class GenerateProsjektData {

    public GenerateProsjektData() {

    }


    //TODO implementer gjenstående funksjonalitet for å mappe input fra fil til objekt
    public List<Prosjekt> getProsjektList() {
        List<Prosjekt> prosjekter = new ArrayList<Prosjekt>();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("prosjekter.csv").getFile());

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            CSVReader reader = new CSVReader(fileReader,';','\"');
            String [] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                Prosjekt p = new Prosjekt();
                prosjekter.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        return prosjekter;

    }



}
