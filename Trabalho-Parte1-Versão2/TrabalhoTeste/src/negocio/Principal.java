package negocio;
import java.util.*;

import dados.*;
public class Principal {

	public static void main(String[] args) {
		try { 
			Sistema sistema = Sistema.getInstance();
	          // insere
//	          Professor professor = new Professor(9, "Professor1", 50, "salaTeste", "especialidade1");
//	          sistema.insereProfessor(professor);
			  //busca
//	          Professor professorBuscado = sistema.buscaProfessor(9);
//	          System.out.println("Professor encontrado: " + professorBuscado);
//	          
//	          //atualiza
//	          professorBuscado.setNome("novoNome");
//	          sistema.atualizaProfessor(professorBuscado);
//	          System.out.println("Professor encontrado: " + professorBuscado);
//			  //lista
//	          List<Professor> professor = sistema.buscaProfessores();
//	          System.out.println("Usuários encontrados:");
//	          for (Professor u : professor) {
//	              System.out.println(u);
// 	       	  }
			  //deletar
//			sistema.deletaProfessor(professorBuscado);
			
			
			//estudantes
	          // insere'
//			  EstudantePos estudantePos = new EstudantePos(9, "nomeNovo", "tipo_curso", 12, 1, 1);
//	          sistema.insereEstudantePos(estudantePos);
			  //busca
//			  EstudantePos estudanteBuscado = sistema.buscaEstudantePos(9);
//	          System.out.println("Estudante encontrado: " + estudanteBuscado);
////	          
////	          //atualiza
//	          estudanteBuscado.setNome("novoNome");
//	          sistema.atualizaEstudantePos(estudanteBuscado);
//	          System.out.println("EStudante encontrado: " + estudanteBuscado);
			  //lista
//	          List<EstudantePos> estudantesPos = sistema.buscaEstudantePos();
//	          System.out.println("EStudantes encontrados:");
//	          for (EstudantePos u : estudantesPos) {
//	              System.out.println(u);
//	       	  }
			  //deletar
//			  sistema.deletaEstudantePos(estudanteBuscado);
			
			
			//departamento
	          // insere
//			  Departamento departamento = new Departamento(9, "escritorio", "nomeDep", 2);
//	          sistema.insereDepartamento(departamento);
			  //busca
//	          Departamento departamentoBuscado = sistema.buscaDepartamento(9);
//	          System.out.println("Departamento encontrado: " + departamentoBuscado);
////	          
////	          //atualiza
//	          departamentoBuscado.setNome("novoNomeDep");
//	          sistema.atualizaDepartamento(departamentoBuscado);
//	          System.out.println("Departamento encontrado: " + departamentoBuscado);
			  //lista
//	          List<Departamento> departamentos = sistema.buscaDepartamentos();
//	          System.out.println("Departamentos encontrados:");
//	          for (Departamento u : departamentos) {
//	              System.out.println(u);
//	       	  }
			  //deletar
//			  sistema.deletaDepartamento(departamentoBuscado);
			
			//projeto
	          // insere
//			  Projeto projeto = new Projeto(9, "FINANCIADOR", 8.0, "2023-12-31", "2024-12-30", 2);
//	          sistema.insereProjeto(projeto);
			  //busca
			  Projeto projetoBuscado = sistema.buscaProjeto(9);
//	          System.out.println("Projeto encontrado: " + projetoBuscado);
//////	          
////	      //atualiza
//			  projetoBuscado.setFinanciador("NOVOFINANCIADOR");
//	          sistema.atualizaProjeto(projetoBuscado);
//	          System.out.println("Projeto encontrado: " + projetoBuscado);
			  //lista
	          List<Projeto> projetos = sistema.buscaProjetos();
	          System.out.println("Projetos encontrados:");
	          for (Projeto u : projetos) {
	              System.out.println(u);
	       	  }
			  //deletar
//			  sistema.deletaProjeto(projetoBuscado);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
