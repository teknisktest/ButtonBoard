package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import domain.Konsulent;


//TODO: Implementer logikk for å arbeide mot konsulentlista

@Service
public class KonsulentService {
	
	private List<Konsulent> konsulenter; 
	
	public KonsulentService() {
		konsulenter = new ArrayList<Konsulent>();
	}
	

	
	public List<Konsulent> hentAlleKonsulenter() {
		return konsulenter;
	}
	
	public Konsulent hentMedId(int id) {
		return null;
	}
	
	public int lagre(Konsulent konsulent){
		return 0; 
	}
	
	public int endre(Konsulent konsulent){
		return 0; 
	}
	
	public boolean slett(Konsulent konsulent){
		return false;
	}
	
	

}
