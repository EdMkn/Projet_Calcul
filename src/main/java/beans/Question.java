package beans;

import java.util.ArrayList;

public class Question {
	private String Enonce;
	private int Reponse;
	private Niveau Difficulte;
	private ArrayList<Integer> propos;
	
	public Question(String enonce, int reponse, Niveau difficulte) {
		super();
		Enonce = enonce;
		Reponse = reponse;
		this.Difficulte = difficulte;
		propos = new ArrayList<>();
	}
	public String getEnonce() {
		return Enonce;
	}
	public void setEnonce(String enonce) {
		Enonce = enonce;
	}
	public int getReponse() {
		return Reponse;
	}
	public void setReponse(int reponse) {
		Reponse = reponse;
	}
	public Niveau getDifficulte() {
		return Difficulte;
	}
	public void setDifficulte(Niveau difficulte) {
		Difficulte = difficulte;
	}
	
	public ArrayList<Integer> getPropos() {
		return propos;
	}

	public void addPropos(Proposition propos) {
		this.propos.add(propos.getPossible());
	}
	public void addPropos(int index, Integer propos) {
		this.propos.add(index, propos);
	}
}
