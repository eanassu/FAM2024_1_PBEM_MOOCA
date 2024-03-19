package br.com.vemprafam.pojo;

import java.util.Date;

public class Aluno {
	private int ra;
	private String nome;
	private Date dataNascimento;
	private double renda;
	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Aluno(int ra, String nome, Date dataNascimento, double renda) {
		super();
		this.ra = ra;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.renda = renda;
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
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public double getRenda() {
		return renda;
	}
	public void setRenda(double renda) {
		this.renda = renda;
	}
	@Override
	public String toString() {
		return "Aluno [ra=" + ra + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", renda=" + renda + "]";
	}

public static void main(String[] args) {
	Aluno aluno = new Aluno();
	System.out.println(aluno);
}	
}
