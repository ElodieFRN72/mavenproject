package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {

	public ArrayList<Ville> getInfoVilles();
	
	public ArrayList<Ville> trouverVilles(Ville ville);
	
	public Ville getInfoVille(String name);
	
	public void creerVille(Ville ville);
	
	public void supprimerVille(String codeville);
	
	public void modifierVille(Ville ville, String code);
	
}
