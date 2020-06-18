package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
	public ArrayList<Ville> findAllVilles();
	
	public Ville findVille(String name);
	
	public void creerVille(Ville ville);
	
	public void supprimerVille(Ville ville);
	
	public void modifierVille(Ville ville, String codecommu);
	
	public ArrayList<Ville> trouverVilles(Ville ville);

}
