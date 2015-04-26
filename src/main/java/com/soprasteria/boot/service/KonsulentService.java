package com.soprasteria.boot.service;

import java.util.ArrayList;
import java.util.List;

import com.soprasteria.boot.util.GenerateKonsulentData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.soprasteria.boot.domain.Konsulent;

import javax.annotation.PostConstruct;



@Service
public class KonsulentService {

	@Autowired
	GenerateKonsulentData generateKonsulentData;

	private List<Konsulent> konsulenter;



	public KonsulentService() {
		this.konsulenter = new ArrayList<Konsulent>();

	}

	@PostConstruct
	public void initData() {

		this.konsulenter = generateKonsulentData.getKonsulentList();
	}
	

	
	public List<Konsulent> hentAlleKonsulenter() {
		return this.konsulenter;
	}
	
	public Konsulent hentMedId(int id) {
		for(Konsulent konsulent : konsulenter) {
			if(konsulent.getId() == id) {
				return konsulent;
			}
		}

		return null;
	}
	
	public int lagre(Konsulent konsulent){

		konsulenter.add(konsulent);
		return konsulenter.indexOf(konsulent);
	}
	
	public int endre(Konsulent konsulent){
		for(Konsulent k : konsulenter) {
			if(k.getId() == konsulent.getId()) {
				int p = konsulenter.indexOf(k);
				konsulenter.set(p, konsulent);
				return p;
			}
		}
		return -1;
	}
	
	public boolean slett(Konsulent konsulent){

		for(Konsulent k : konsulenter) {
			if(konsulent.getId() == konsulent.getId()) {
				konsulenter.remove(k);
				return true;
			}
		}

		return false;

	}
	
	

}
