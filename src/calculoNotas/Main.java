package calculoNotas;

import java.util.Arrays;

import javax.swing.JOptionPane;

import calculoNotas.models.Aluno;
import calculoNotas.models.Disciplina;

public class Main {

	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("Digite o nome do aluno: ");
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno: "));
		
		Aluno aluno1 = new Aluno(name, idade);
		
		for(int i = 1; i <= 4; i++) {
			String nomeDisciplina = JOptionPane.showInputDialog("Digite o nome da disciplina "+i+"?");
			double nota = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota "+i+"?")); 
			
			Disciplina disciplina = new Disciplina();
			disciplina.setDisciplina(nomeDisciplina);
			disciplina.setNota(nota);		
			
			aluno1.getDisciplinas().add(disciplina);
		}
		
		int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover algum disciplina ?");
		
		if(escolha == 0) {
			String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4 ?");
			aluno1.getDisciplinas().remove(Integer.parseInt(disciplinaRemover) - 1);
		}
		
		System.out.println(aluno1.getDisciplinas());
		System.out.println(aluno1.getMediaNota());
		System.out.println(aluno1.getSituacao());	
	}

}
