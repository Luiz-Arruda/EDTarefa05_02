package controller;

public class Aluno {
	
	private int ra;
	private String nome;
	private String turma;
	private String semestre;
	public Aluno prox;
	
	
	public Aluno(int ra, String nome, String turma,String semestre) {
		this.ra = ra;
		this.nome = nome;
		this.turma = turma;
		this.semestre = semestre;
		prox = null;
	}


	public int getRa() {
		return ra;
	}


	public void setRa(int ra) {
		this.ra = ra;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTurma() {
		return turma;
	}


	public void setTurma(String turma) {
		this.turma = turma;
	}


	public String getSemestre() {
		return semestre;
	}


	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	
} 
