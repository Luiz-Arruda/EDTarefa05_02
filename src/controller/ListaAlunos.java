package controller;

import javax.swing.JOptionPane;

public class ListaAlunos {

	private Aluno inicio;
	
	public ListaAlunos() {
		inicio = null;
	} // final do construtor
	
	public boolean ListaVazia() {	// 1 - status da lista
		if (inicio == null) {
			return true;			// lista vazia
		}
		return false;				// lista preencida
	} // fim Lista Vazia
	
		
	public void AdicionaFinal(int ra, String nome, String turma, String semestre) { // 2 -  cria metodo adicionar no final da lista
		if (inicio == null) {			// verifica se a lista está vazia
			Aluno n = new Aluno(ra, nome, turma, semestre);			// carrega o valor de "e" no nó criado
			inicio = n;					// carrega inicio com "n" - novo nó criado
		}  // fim if
		
		else {
			try {
				Aluno aux = inicio;				// cria endereço de nó "aux" e carrega com o endereço de inicio
				while (aux.prox != null) {		// prox vem da classe contructor NO
					aux = aux.prox;				// vai movendo aux para a proximo endereço
				} // fim while
				Aluno n = new Aluno(ra, nome, turma, semestre);			// carrega o valor de "e" no nó criado
				aux.prox = n;						// carrega n aux o endereço de n		
			} catch (Exception e2) {
				System.out.println("Erro de gravação");
			}
		}  // fim do else
	} // fim do metodo adicionar no final
	
	
		
	public void AdicionaInicio(int ra, String nome, String turma, String semestre) {	// 3 adicionar no inicio da lista
		Aluno n = new Aluno(ra, nome, turma, semestre);						// criando novo no "n"
		n.prox = inicio;						// carregar n com o proxima endereço
		inicio = n;								// carrecar incio n
	} // fim metodo adicionar no inicio

	
												//  4 - metodo Escolher posição
	public void EscolherPosição(int ra, String nome, String turma, String semestre, int pos) {
		Aluno novo = new Aluno(ra, nome, turma, semestre);		
		
		if (pos == 1) {
			AdicionaInicio(ra, nome, turma, semestre);
		} // fim IF
		
		else {
			Aluno aux = inicio;			// armazena posição inicio no auxiliar
			int cont = 1;				// criação contador com 1
			
			while (aux.prox != null && cont < pos-1) {  // localização da posição
				aux = aux.prox;			// armazena o endereça de proximo de aux em aux
				cont ++;
			} // fim while
			
			if (cont == pos-1) {  		// inserção na posição desejada passou a ser fora do laço
				novo.prox = aux.prox;	// liga novo indicaçao do endereço de pos-1
				aux.prox = novo;		// pos - 1 aponta para o "novo"
			} //fim IF
			else {
				JOptionPane.showConfirmDialog(null, " Posição Inválida");
			} // fim else
		} // fim else
	} // classe inserir em qualquer posição
	
	
		
	public String RemoveFinal() {					// 5 remover no final da lista
		int ra1 = -1;								// criar uma variavel 
		String nome1 = " ";
		String turma1 = " ";
		String semestre1 = " ";
		if (inicio == null ) {
			JOptionPane.showConfirmDialog(null, "Lista Vázia");
		}
		else {
			if (inicio.prox == null) {			// inicio é o primeiro elemento da lista
				ra1 = inicio.getRa();				
				nome1 = inicio.getNome();				
				turma1 = inicio.getTurma();
				semestre1 = inicio.getSemestre();			
				inicio = null;					// informa que é o ultimo elemento da lista
			} // fim IF
			else {
				Aluno aux1 = inicio;			// gerando duas varias, uma para varrer a lista
				Aluno aux2 = inicio;
				
				while (aux1.prox !=null) {  // varrendo a lista até encontrar null
					aux2 = aux1;			// guarda o endereço no utimo endereço em aux2
					aux1 = aux1.prox;		// pega o proximo endereço
				} // fim while
				
				ra1 = aux1.getRa();				
				nome1 = aux1.getNome();				
				turma1 = aux1.getTurma();
				semestre1 = aux1.getSemestre();	
				
				aux2.prox = null;			// coloca null para mostrar o fim da lista. 
			} // fim else
		} // fim else
		return "RA: " + ra1 + " Nome: " + nome1 + " Turma: " +turma1 + " Semestre: " +semestre1;
	} // fim classe
	
	public String RemoverInicio() {			// 6 remover no inico da lista
		int ra1 = -1;								// criar as variaveis
		String nome1 = " ";
		String turma1 = " ";
		String semestre1 = " ";
		if (inicio == null) {
			JOptionPane.showConfirmDialog(null, "Lista Vazia");
		} // fim inicio 
		else {
			ra1 = inicio.getRa();				
			nome1 = inicio.getNome();				
			turma1 = inicio.getTurma();
			semestre1 = inicio.getSemestre();
			inicio = inicio.prox;			// passar para inicio o enderço do proximos endereço
		} // fim else
		return "RA: " + ra1 + " Nome: " + nome1 + " Turma: " +turma1 + " Semestre: " +semestre1;
	} // fim da classe Remove Inicio
	
	
	public String EscolheRemover(int pos) {    // 7 - remover em qualquer posição
		int ra1 = -1;								// criar uma variavel 
		String nome1 = " ";
		String turma1 = " ";
		String semestre1 = " ";		
//		int e = -1;
		int i = 1; 
		Aluno aux = inicio;	// criar um endereçamento aux com valor inicial
		
		if (inicio == null) {
			JOptionPane.showConfirmDialog(null, "Lista Vazia !");
			ra1 = inicio.getRa();				
			nome1 = inicio.getNome();				
			turma1 = inicio.getTurma();
			semestre1 = inicio.getSemestre();
			return "RA: " + ra1 + " Nome: " + nome1 + " Turma: " +turma1 + " Semestre: " +semestre1;
		} // fim IF 
		
		if (pos == 1) {  // remoção pos = 1, remoção será no inicio da lista
			ra1 = aux.getRa();
			nome1 = aux.getNome();
			turma1 = aux.getTurma();
			semestre1 = aux.getSemestre();
			RemoverInicio();
			return "RA: " + ra1 + " Nome: " + nome1 + " Turma: " +turma1 + " Semestre: " +semestre1;
		} // Fim IF
		else {
			while (aux.prox != null) {  // remover no final da lista
				aux = aux.prox;   // guarda no aux o endereço do proximo da posição
				i++;				// vai guardando os posiçoes ate encontral null
			} // fim While
			if (pos > i || pos <=0) {  // posicoes invalidas
				JOptionPane.showConfirmDialog(null, "Posição invalida");
				return "RA: " + ra1 + " Nome: " + nome1 + " Turma: " +turma1 + " Semestre: " +semestre1;
			} // fim IF
			else if (pos == i){			// Remoção no final
				ra1 = aux.getRa();
				nome1 = aux.getNome();
				turma1 = aux.getTurma();
				semestre1 = aux.getSemestre();
				RemoveFinal();
				return "RA: " + ra1 + " Nome: " + nome1 + " Turma: " +turma1 + " Semestre: " +semestre1;
			} // fim else
			else {						// remover qualquer posição
				aux = inicio;			// carrega aux com inicio
				Aluno aux2 = aux;			// cria endereçamenteo aux 2 e copia aux
				
				while(pos > 1) {
					aux2 = aux;
					aux = aux.prox;
					pos --;
				} // while
				ra1 = aux.getRa();
				nome1 = aux.getNome();
				turma1 = aux.getTurma();
				semestre1 = aux.getSemestre();
//				e = aux.dados;
				aux2.prox = aux.prox;
				return "RA: " + ra1 + " Nome: " + nome1 + " Turma: " +turma1 + " Semestre: " +semestre1;
//				return e;
			} // fim else
		} // fim else
	} // fim da classe escolha Remover
	
	public void PercorreLista() {
		if (inicio == null) {
			System.out.println("Lista vazia");
		} // if
		else {
			Aluno aux1 = inicio;	// criação de duas variaveis
			
			while (aux1 != null) {
				System.out.println("RA: " +aux1.getRa() +" Nome: " +aux1.getNome()+" Turma: "+ aux1.getTurma() + " Semstre: " + aux1.getSemestre()); 
				aux1 = aux1.prox;
			} // fim while
		} // fim else
	} // fim percorre lista
	
} // fim classe
