package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Niveau;
import beans.Proposition;
import beans.Question;

public class Questions {
	private DaoFactory daoFactory;
	private Niveau niveau;
	private Integer nombre;

	public Questions(DaoFactory daoFactory, Niveau niveau, Integer nombre) {
		super();
		this.daoFactory = daoFactory;
		this.niveau = niveau;
		this.nombre = nombre;
	}

	public ArrayList<Question> getListquestion(ArrayList<Proposition> propos) {
		ArrayList<Question> listquestion = new ArrayList<>();
		ArrayList<Question> thequestions = new ArrayList<>();
		 Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT `numero` ,`Enoncé`,`Réponse`, `Niveau` FROM questions "
            		+ "	WHERE `Niveau`='"+niveau.toString()+"';");

            while (resultat.next()) {
               Integer reponse = resultat.getInt("Réponse");
               String enonce = resultat.getString("Enoncé");
               Niveau niveau = Niveau.valueOf(resultat.getString("Niveau"));

               Question question = new Question(enonce, reponse, niveau);
               
               for (var i=0;i<3;i++) {
            	   var prem = Math.random()*propos.size();
            	   question.addPropos(propos.get((int) prem));
            	   propos.remove((int)prem);
               }
               Integer prem = (int)Math.random()*question.getPropos().size();
               question.addPropos(prem,question.getReponse());
               listquestion.add(question);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        for (int i = 0;i<nombre;i++) {
        	Integer j = (int)Math.random()*listquestion.size();
        	thequestions.add(listquestion.get(j));
        	listquestion.remove(listquestion.get(j));
        	if (listquestion.size()==0) break;
        }
        
        return thequestions;
	}

	public void ajouterQuestion(Question question) {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;

		try {
			connexion = daoFactory.getConnection();
			preparedStatement = connexion
					.prepareStatement("INSERT INTO questions('Enoncé','Réponse','Niveau') VALUES(?,?,?);");
			preparedStatement.setString(1, question.getEnonce());
			preparedStatement.setInt(2, question.getReponse());
			preparedStatement.setString(3, question.getDifficulte().toString());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//question doit avoir tableau de proposition non déclaré dans le constructeur
	public Niveau getNiveau() {
		return niveau;
	}

	public Integer getNombre() {
		return nombre;
	}

}
