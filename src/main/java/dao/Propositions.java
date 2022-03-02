package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Proposition;

public class Propositions {
	private DaoFactory daoFactory;
	
	public Propositions(DaoFactory daofactory) {
		this.daoFactory = daofactory;
	}

	public ArrayList<Proposition> getListproposition() {
		ArrayList<Proposition> listproposition = new ArrayList<>();
		 Connection connexion = null;
         Statement statement = null;
         ResultSet resultat = null;
         try {
             connexion = daoFactory.getConnection();
             statement = connexion.createStatement();
             resultat = statement.executeQuery("SELECT `Réponse` FROM propositions;");

             while (resultat.next()) {
                Integer reponse = resultat.getInt("Réponse");

                 Proposition propos = new Proposition(reponse);

                 listproposition.add(propos);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return listproposition;
	}

	public void ajouterProposition(Proposition proposition) {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO propositions(`Réponse`) VALUES(?);");
            preparedStatement.setInt(1, proposition.getPossible());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}
