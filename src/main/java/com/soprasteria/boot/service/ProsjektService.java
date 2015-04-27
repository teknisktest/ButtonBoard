package com.soprasteria.boot.service;

import com.soprasteria.boot.domain.Prosjekt;
import com.soprasteria.boot.util.GenerateProsjektData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olovholm on 21.04.2015.
 */


//TODO skriv tester, og verifiser at service fungerer (inneholder lik funksjonalitet som konsulentService)
@Service
public class ProsjektService {

    @Autowired
    GenerateProsjektData generateProsjektData;

    private List<Prosjekt> prosjekter;



    public ProsjektService() {
        this.prosjekter = new ArrayList<Prosjekt>();


    }

    @PostConstruct
    public void initData() {

        this.prosjekter = generateProsjektData.getProsjektList();
    }



    public List<Prosjekt> hentAlle() {
        return this.prosjekter;
    }

    public Prosjekt hentMedId(int id) {
        for(Prosjekt prosjekt : prosjekter) {
            if(prosjekt.getId() == id) {
                return prosjekt;
            }
        }

        return null;
    }

    public int lagre(Prosjekt prosjekt){

        prosjekter.add(prosjekt);
        return prosjekter.indexOf(prosjekt);
    }

    public int endre(Prosjekt Prosjekt){
        for(Prosjekt k : prosjekter) {
            if(k.getId() == Prosjekt.getId()) {
                int p = prosjekter.indexOf(k);
                prosjekter.set(p, Prosjekt);
                return p;
            }
        }
        return -1;
    }

    public boolean slett(Prosjekt Prosjekt){

        for(Prosjekt k : prosjekter) {
            if(Prosjekt.getId() == Prosjekt.getId()) {
                prosjekter.remove(k);
                return true;
            }
        }

        return false;

    }

    public int antall(){
        return prosjekter.size();
    }

    public int getNextId(){
        int run = 0;
        for(Prosjekt k : prosjekter){
            if (run<k.getId()){
                run = k.getId() + 1;
            }
        }
        return run;
    }





}
