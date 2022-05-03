package calculoNotas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import calculoNotas.constants.StatusAluno;
import calculoNotas.models.Aluno;
import calculoNotas.models.Disciplina;

public class Main {

	public static void main(String[] args) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		List<Aluno> alunosAprovados = new ArrayList<Aluno>();
		List<Aluno> alunosReprovados = new ArrayList<Aluno>();
		List<Aluno> alunosRecuperacao = new ArrayList<Aluno>();

		for (int qtd = 1; qtd <= 3; qtd++) {
			String name = JOptionPane.showInputDialog("Digite o nome do aluno " + qtd + ": ");
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do aluno " + qtd + ": "));

			Aluno aluno = new Aluno(name, idade);

			for (int i = 1; i <= 3; i++) {
				String nomeDisciplina = JOptionPane.showInputDialog("Digite o nome da disciplina " + i + "?");
				double nota = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota " + i + "?"));

				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(nomeDisciplina);
				disciplina.setNota(nota);

				aluno.getDisciplinas().add(disciplina);
			}

			int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover algum disciplina ?");

			if (escolha == 0) {
				int continuarRemover = 0;
				int posicao = 1;

				while (continuarRemover == 0) {
					String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4 ?");
					aluno.getDisciplinas().remove(Integer.parseInt(disciplinaRemover) - posicao);
					posicao++;
					continuarRemover = JOptionPane.showConfirmDialog(null, "Deseja continuar removendo disciplinas ?");
				}
			}

			alunos.add(aluno);
		}

		// remove o aluno william
//		for (Aluno aluno : alunos) {
//			if (aluno.getNome().equalsIgnoreCase("William")) {
//				alunos.remove(aluno);
//				break;
//			}
//		}
//		
//		// recupera aluno pelo index
//		for(int pos = 0; pos < alunos.size(); pos++) {
//			Aluno aluno = alunos.get(1);
//		}
//		
		// trocando um aluno

//		for(int pos = 0; pos < alunos.size(); pos++) {
//			Aluno aluno = alunos.get(pos);
//			if(aluno.getNome().equalsIgnoreCase("William")) {
//				Aluno troca = new Aluno("Marcos", 27);
//				
//				Disciplina disciplina = new Disciplina();
//				disciplina.setDisciplina("Banco");
//				disciplina.setNota(5);
//				
//				troca.getDisciplinas().add(disciplina);
//				
//				alunos.set(pos, troca);
//			}
//		}
//		
		for (Aluno aluno : alunos) {
			if (aluno.getSituacao().equalsIgnoreCase(StatusAluno.APROVADO)) {
				alunosAprovados.add(aluno);
			} else if (aluno.getSituacao().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				alunosRecuperacao.add(aluno);
			} else {
				alunosReprovados.add(aluno);
			}
		}

		for (Aluno aln : alunos) {
			System.out.println("Aluno: " + aln.getNome());
			System.out.println("Idade: " + aln.getIdade());
			System.out.println("Média: " + aln.getMediaNota());
			System.out.println("Situação: " + aln.getSituacao());
			System.out.println("-------------------------------------------");
		}

		// LISTA ALUNOS APROVADOS
		System.out.println("*** Alunos aprovados ***");
		for (Aluno aluno : alunosAprovados) {
			System.out.println("Aluno: " + aluno.getNome());
			System.out.println("Idade: " + aluno.getIdade());
			System.out.println("Situação: " + aluno.getSituacao());
		}

		// LISTA ALUNOS RECUPERAÇÃO
		System.out.println("*** Alunos Recuperação ***");
		for (Aluno aluno : alunosRecuperacao) {
			System.out.println("Aluno: " + aluno.getNome());
			System.out.println("Idade: " + aluno.getIdade());
			System.out.println("Situação: " + aluno.getSituacao());
		}

		// LISTA ALUNOS REPROVADOS
		System.out.println("*** Alunos Reprovados ***");
		for (Aluno aluno : alunosReprovados) {
			System.out.println("Aluno: " + aluno.getNome());
			System.out.println("Idade: " + aluno.getIdade());
			System.out.println("Situação: " + aluno.getSituacao());
		}

	}

}
