package calculoNotas;

import java.util.Arrays;

import calculoNotas.models.Aluno;
import calculoNotas.models.Disciplina;

public class Main {

	public static void main(String[] args) {
		Aluno aluno1 = new Aluno("William Dias", 27);
		
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setDisciplina("Java POO");
		disciplina1.setNota(90);
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("Banco de Dados");
		disciplina2.setNota(80);
		
		Disciplina disciplina3 = new Disciplina();
		disciplina3.setDisciplina("Gestão de Projetos");
		disciplina3.setNota(90);
		
		aluno1.getDisciplinas().addAll(Arrays.asList(disciplina1, disciplina2, disciplina3));
		
		System.out.println(aluno1.getDisciplinas());
		System.out.println(aluno1.getMediaNota());
		System.out.println(aluno1.getSituacao());	
	}

}
