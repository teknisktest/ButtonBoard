package com.soprasteria.boot.util;

import au.com.bytecode.opencsv.CSVReader;
import com.soprasteria.boot.domain.Konsulent;
import com.soprasteria.boot.domain.Stilling;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olovholm on 16.04.2015.
 */


public class GenerateKonsulentData {

    public GenerateKonsulentData() {

    }



    public List<Konsulent> getKonsulentList() {
        List<Konsulent> konsulenter = new ArrayList<Konsulent>();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("konsulenter.csv").getFile());

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            CSVReader reader = new CSVReader(fileReader,';','\"');
            String [] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                Konsulent k = new Konsulent();
                k.setNavn(nextLine[0]);
                k.setId(Integer.parseInt(nextLine[1]));
                k.setEpost(nextLine[2]);
                k.setImage_url(nextLine[3]);
                k.setPris(Integer.parseInt(nextLine[4]));
                k.setStilling(Stilling.valueOf(nextLine[5]));
                konsulenter.add(k);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }



        return konsulenter;

    }


}
