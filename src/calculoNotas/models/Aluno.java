package calculoNotas.models;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	private String nome;
	private int idade;
	
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public Aluno() {
	}

	public Aluno(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	// CALCULA MÉDIA DO ALUNO
	public double getMediaNota() {
		double somaNotas = 0.0;
		
		for (Disciplina dis : disciplinas) {
			somaNotas += dis.getNota();
		}
		
		return somaNotas / disciplinas.size();
	}

	// VERIFICA SITUAÇÃO DO ALUNO
	public String getSituacao() {
		String situacao = "";
		if (getMediaNota() >= 7) {
			situacao = "Aprovado";
		} else if (getMediaNota() < 5) {
			situacao = "Reprovado";
		} else {
			situacao = "Recuperação";
		}
		return situacao;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
