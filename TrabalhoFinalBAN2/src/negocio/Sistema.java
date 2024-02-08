package negocio;

import java.sql.SQLException;
import java.util.List;

import dados.Departamento;
import dados.EstudantePos;
import dados.ParticipaAluno;
import dados.ParticipaProfessor;
import dados.Professor;
import dados.Projeto;
import dados.Trabalha;
import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;
import persistencia.*;

public class Sistema {
	private static Sistema instance = null;
	private static ProfessorDAO professorDAO = null;
	private static EstudantePosDAO estudantePosDAO = null;
	private static DepartamentoDAO departamentoDAO = null;
	private static ProjetoDAO projetoDAO = null;
	private static TrabalhaDAO trabalhaDAO = null;
	private static ParticipaProfessorDAO participaProfessorDAO = null;
	private static ParticipaAlunoDAO participaAlunoDAO = null;

	public static Sistema getInstance(){
        if (instance == null) {
            try {
                instance = new Sistema();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
	private Sistema() throws ClassNotFoundException, SQLException{
		professorDAO = ProfessorDAO.getInstance();
		estudantePosDAO = EstudantePosDAO.getInstance();
		departamentoDAO = DepartamentoDAO.getInstance();
		projetoDAO = ProjetoDAO.getInstance();
		trabalhaDAO = TrabalhaDAO.getInstance();
		participaProfessorDAO = ParticipaProfessorDAO.getInstance();
		participaAlunoDAO = ParticipaAlunoDAO.getInstance();
	}
	//----------------------------Professor----------------------------//
	public void insereProfessor(Professor professor) throws SelectException, InsertException{
		professorDAO.insert(professor);
	}
	public void deletaProfessor(Professor professor) throws DeleteException {
		professorDAO.delete(professor);
	}
	public void atualizaProfessor(Professor professor) throws UpdateException {
		professorDAO.update(professor);
	}
	public Professor buscaProfessor(int matricula) throws SelectException {
		return professorDAO.select(matricula);
	}
	public List<Professor> buscaProfessores() throws SelectException{
		return professorDAO.selectAll();
	}
	//----------------------------Estudante----------------------------//
	public void insereEstudantePos(EstudantePos estudantePos) throws SelectException, InsertException, UpdateException {
		estudantePosDAO.insert(estudantePos);
	}
	public void deletaEstudantePos(EstudantePos estudantePos) throws DeleteException {
		estudantePosDAO.delete(estudantePos);
	}
	public void atualizaEstudantePos(EstudantePos estudantePos) throws UpdateException {
		estudantePosDAO.update(estudantePos);
		//usuarioDAO.update(estudantePos);
	}
	public EstudantePos buscaEstudantePos(int matricula) throws SelectException {
		return estudantePosDAO.select(matricula);
		
	}
	public List<EstudantePos> buscaEstudantesPos() throws SelectException{
		return estudantePosDAO.selectAll();
	}
	
	//----------------------------Departamento----------------------------//
	public void insereDepartamento(Departamento departamento) throws SelectException, InsertException, UpdateException {
		departamentoDAO.insert(departamento);
	}
	public void deletaDepartamento(Departamento departamento) throws DeleteException {
		departamentoDAO.delete(departamento);
	}
	public void atualizaDepartamento(Departamento departamento) throws UpdateException {
		departamentoDAO.update(departamento);
	}
	public Departamento buscaDepartamento(int numero) throws SelectException {
		return departamentoDAO.select(numero);
		
	}
	public List<Departamento> buscaDepartamentos() throws SelectException{
		return departamentoDAO.selectAll();
	}
	
	public List<Object> exibeProfDep() throws SelectException{
		return departamentoDAO.ProfDepartamento();
	}
	
//	//----------------------------Projeto----------------------------//
	public void insereProjeto(Projeto projeto) throws SelectException, InsertException, UpdateException {
		projetoDAO.insert(projeto);
	}
	public void deletaProjeto(Projeto projeto) throws DeleteException {
		projetoDAO.delete(projeto);
	}
	public void atualizaProjeto(Projeto projeto) throws UpdateException {
		projetoDAO.update(projeto);
	}
	public Projeto buscaProjeto(int numero) throws SelectException {
		return projetoDAO.select(numero);
		
	}
	public List<Projeto> buscaProjetos() throws SelectException{
		return projetoDAO.selectAll();
	}
	
	public List<Object> exibeEstProj() throws SelectException{
		return projetoDAO.EstProjeto();
	}
	
	public List<Object> exibeProfProj() throws SelectException{
		return projetoDAO.ProfProjeto();
	}
	
	
//	//----------------------------Professor Trabalha em ----------------------------//
	public void insereTrabalha(Trabalha trabalha) throws SelectException, InsertException{
		trabalhaDAO.insert(trabalha);
	}
	public void deletaTrabalha(Trabalha trabalha) throws DeleteException{
		trabalhaDAO.delete(trabalha);
	}
	public void atualizaTrabalha(Trabalha trabalha) throws UpdateException{
		trabalhaDAO.update(trabalha);
	}
	public Trabalha buscaTrabalha(int id_bloco) throws SelectException{
		return trabalhaDAO.select(id_bloco);
	}
	public List<Trabalha> buscaTrabalhos() throws SelectException{
		return trabalhaDAO.selectAll();
	}
//	//----------------------------Participa Professor----------------------------//
	public void insereParticipaProfessor(ParticipaProfessor participaProfessor) throws SelectException, InsertException{
		participaProfessorDAO.insert(participaProfessor);
	}
	public void deletaParticipaProfessor(ParticipaProfessor participaProfessor) throws DeleteException{
		participaProfessorDAO.delete(participaProfessor);
	}
	public void atualizaParticipaProfessor(ParticipaProfessor participaProfessor) throws UpdateException{
		participaProfessorDAO.update(participaProfessor);
	}
	public ParticipaProfessor buscaParticipaProfessor(int id_part_prof) throws SelectException{
		return participaProfessorDAO.select(id_part_prof);
	}
	public List<ParticipaProfessor> buscaParticipaProfessores() throws SelectException{
		return participaProfessorDAO.selectAll();
	}
//	//----------------------------Participa Aluno----------------------------//
	public void insereParticipaAluno(ParticipaAluno participaAluno) throws SelectException, InsertException{
		participaAlunoDAO.insert(participaAluno);
	}
	public void deletaParticipaAluno(ParticipaAluno participaAluno) throws DeleteException{
		participaAlunoDAO.delete(participaAluno);
	}
	public void atualizaParticipaAluno(ParticipaAluno participaAluno) throws UpdateException{
		participaAlunoDAO.update(participaAluno);
	}
	public ParticipaAluno buscaParticipaAluno(int id_part_aluno) throws SelectException{
		return participaAlunoDAO.select(id_part_aluno);
	}
	public List<ParticipaAluno> buscaParticipaAlunos() throws SelectException{
		return participaAlunoDAO.selectAll();
	}
}
