package view;

import javax.swing.JOptionPane;

import controller.ListaAlunos;

public class Main_Aluno {

	public static void main(String[] args) {
		int ra;
		String nome;
		String turma;
		String semestre;
		int pos;
		int ops = 0;

		ListaAlunos alunos = new ListaAlunos();
		
		while (ops != 99) {
			ops = Integer.parseInt(JOptionPane.showInputDialog("Selecione \n1-Status Fila \n2-Adi��o final lista \n3-Adi��o inicio da lista \n4-Adi��o em qualquer posi��o \n5-Remover do final \n6-Remover Inicio \n7-Remover qualquer posi��o \n8-Ver Lila \n99-Sair  "));

			switch (ops) {
			case 1:   // status de lista
				if (alunos.ListaVazia() == true) {
					System.out.println("Lista est� vazia");
				} else {
					System.out.println("Lista cont�m dados");					
				}
				break;

			case 2:    // adiciona no final 
				ra = Integer.parseInt(JOptionPane.showInputDialog("Informe a RA: "));
				nome = JOptionPane.showInputDialog("Informe a Nome: ");
				turma = JOptionPane.showInputDialog("Informe a Turma: ");
				semestre = JOptionPane.showInputDialog("Informe a Semestre: ");
				alunos.AdicionaFinal(ra, nome, turma, semestre);
				break;
			
			case 3:		// adiciona no inicio
				ra = Integer.parseInt(JOptionPane.showInputDialog("Informe a RA: "));
				nome = JOptionPane.showInputDialog("Informe a Nome: ");
				turma = JOptionPane.showInputDialog("Informe a Turma: ");
				semestre = JOptionPane.showInputDialog("Informe a Semestre: ");
				alunos.AdicionaInicio(ra, nome, turma, semestre);
				break;
				
			case 4:
				ra = Integer.parseInt(JOptionPane.showInputDialog("Informe a RA: "));
				nome = JOptionPane.showInputDialog("Informe a Nome: ");
				turma = JOptionPane.showInputDialog("Informe a Turma: ");
				semestre = JOptionPane.showInputDialog("Informe a Semestre: ");			
				pos = Integer.parseInt(JOptionPane.showInputDialog("Informe a posi��o de inser��o: "));
				alunos.EscolherPosi��o(ra, nome, turma, semestre, pos);
				break;
				
			case 5:   // remove no final
				System.out.println("O elemento removido foi: " + alunos.RemoveFinal());
				break;
				
			case 6:  // remove no inicio
				System.out.println("O elemento removido foi: " +alunos.RemoverInicio());
				break;
				
			case 7:  // remover em qualquer posi��o
				pos = Integer.parseInt(JOptionPane.showInputDialog("Informe a posi��o de remo��o: "));
				System.out.println("O elemento removido foi: " +alunos.EscolheRemover(pos));
				break;
			
			case 8:   // apresentar lista
				alunos.PercorreLista();
				break;
				
			case 99:
				System.out.println("saindo");
				break;
				
			default:
				break;
			}
			
		} // fim while
		
		
	} // fim main
} // fim classe
