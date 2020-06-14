package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	private static final String SQL_INSERT="INSERT INTO ville_france VALUES(?,?,?,?,?,?,?)";
	public ArrayList<Ville> findAllVilles() {
		
		Connection con = JDBCConfiguration.getConnection();
		
		Ville ville = null;
		ArrayList<Ville> villes = new ArrayList();
		try {
			String query = "SELECT * FROM ville_france";

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				ville = new Ville();
				ville.setNom_commune(rs.getString("Nom_Commune"));
				ville.setCode_commune_INSEE(rs.getString("Code_commune_INSEE"));
				ville.setCode_postal(rs.getString("Code_postal"));
				villes.add(ville);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return villes;
	}
	
	public Ville findVille(String name) {
		Connection con = JDBCConfiguration.getConnection();
		
		Ville ville = null;
		try {
			String query = "SELECT * FROM ville_france where code_postal=" + name;

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				ville = new Ville();
				ville.setNom_commune(rs.getString("Nom_Commune"));
				ville.setCode_commune_INSEE(rs.getString("Code_commune_INSEE"));
				ville.setCode_postal(rs.getString("Code_postal"));
				ville.setLatitude(rs.getString("Latitude"));
				ville.setLongitude(rs.getString("Longitude"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ville;
	}
	
	public void creerVille(Ville ville){
		
		Connection con = JDBCConfiguration.getConnection();
		try {
			
			String query = "INSERT INTO ville_france VALUES(?,?,?,?,?,?,?)" ;
			PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);


			preparedStatement.setString(1, ville.getCode_commune_INSEE());
			preparedStatement.setString(2, ville.getNom_commune());
			preparedStatement.setString(3, ville.getCode_postal());
			preparedStatement.setString(4, ville.getLibelle_acheminement());
			preparedStatement.setString(5, ville.getLigne_5());
			preparedStatement.setString(6, ville.getLatitude());
			preparedStatement.setString(7, ville.getLongitude());
			preparedStatement.executeUpdate();
			
			
			System.out.println("Ligne insérée");

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	public void supprimerVille(Ville ville) {
		Connection con = JDBCConfiguration.getConnection();
		try {
			String query = "DELETE FROM ville_france WHERE code_commune_INSEE= ?";
			PreparedStatement preparedstatement = con.prepareStatement(query);
			
			preparedstatement.setString(1, ville.getCode_commune_INSEE());
			preparedstatement.executeUpdate();
			
			System.out.println("Ligne supprimée");
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modifierVille(Ville ville) {
		Connection con = JDBCConfiguration.getConnection();
		try {
			String query = "UPDATE ville_france SET code_postal= ? WHERE code_commune_INSEE= ?";
			PreparedStatement preparedstatement = con.prepareStatement(query);
			
			preparedstatement.setString(1, ville.getCode_postal());
			preparedstatement.setString(2, ville.getCode_commune_INSEE());
			preparedstatement.executeUpdate();
			
			System.out.println("Ligne modifiée");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
