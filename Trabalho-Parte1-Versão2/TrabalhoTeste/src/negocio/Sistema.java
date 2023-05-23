package negocio;

import java.sql.SQLException;
import java.util.List;

import dados.Departamento;
import dados.EstudantePos;
import dados.Professor;
import dados.Projeto;
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
//	private static BlocoDAO blocoDAO = null;
//	private static QuadraDAO quadraDAO = null;
//	private static AgendamentoDAO agendamentoDAO = null;
//	private static EquipamentoDAO equipamentoDAO = null;
//	private static EventoDAO eventoDAO = null;
//	private static ReservaDAO reservaDAO = null;
	
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
//		blocoDAO = BlocoDAO.getInstance();
//		quadraDAO = QuadraDAO.getInstance();
//		agendamentoDAO = AgendamentoDAO.getInstance();
//		equipamentoDAO = EquipamentoDAO.getInstance();
//		reservaDAO = ReservaDAO.getInstance();
//		eventoDAO = EventoDAO.getInstance();
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
	public List<EstudantePos> buscaEstudantePos() throws SelectException{
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
//	//----------------------------Projeto----------------------------//
	public void insereProjeto(Projeto projeto) throws SelectException, InsertException, UpdateException {
		projetoDAO.insert(projeto);
	}
	public void deletaProjeto(Projeto projeto) throws DeleteException {
		projetoDAO.delete(projeto);
	}
	public void atualizaProjeto(Projeto projeto) throws UpdateException {
		projetoDAO.update(projeto);
	//	usuarioDAO.update(responsavel);
	}
	public Projeto buscaProjeto(int numero) throws SelectException {
		return projetoDAO.select(numero);
		
	}
	public List<Projeto> buscaProjetos() throws SelectException{
		return projetoDAO.selectAll();
	}
//	//----------------------------Bloco----------------------------//
//	public void insereBloco(Bloco bloco) throws SelectException, InsertException{
//		blocoDAO.insert(bloco);
//	}
//	public void deletaBloco(Bloco bloco) throws DeleteException{
//		blocoDAO.delete(bloco);
//	}
//	public void atualizaBloco(Bloco bloco) throws UpdateException{
//		blocoDAO.update(bloco);
//	}
//	public Bloco buscaBloco(int id_bloco) throws SelectException{
//		return blocoDAO.select(id_bloco);
//	}
//	public List<Bloco> buscaBlocos() throws SelectException{
//		return blocoDAO.selectAll();
//	}
//	//----------------------------Quadra----------------------------//
//	public void insereQuadra(Quadra quadra) throws SelectException, InsertException{
//		quadraDAO.insert(quadra);
//	}
//	public void deletaQuadra(Quadra quadra) throws DeleteException{
//		quadraDAO.delete(quadra);
//	}
//	public void atualizaQuadra(Quadra quadra) throws UpdateException{
//		quadraDAO.update(quadra);
//	}
//	public Quadra buscaQuadra(int id_quadra) throws SelectException{
//		return quadraDAO.select(id_quadra);
//	}
//	public List<Quadra> buscaQuadras() throws SelectException{
//		return quadraDAO.selectAll();
//	}
//	//----------------------------Agendamento----------------------------//
//	public void insereAgendamento(Reserva reserva) throws SelectException, InsertException{
//		int id = agendamentoDAO.insert(reserva.getAgendamento());
//		reserva.getAgendamento().setId_agendamento(id);
//		reservaDAO.insert(reserva);
//	}
//	public void deletaAgendamento(Reserva reserva) throws DeleteException{
//		reservaDAO.delete(reserva);
//		agendamentoDAO.delete(reserva.getAgendamento());
//	}
//	public void atualizaAgendamento(Agendamento agendamento) throws UpdateException{
//		agendamentoDAO.update(agendamento);
//	}
//	public Agendamento buscaAgendamento(int id_agendamento) throws SelectException{
//		return agendamentoDAO.select(id_agendamento);
//	}
//	public List<Agendamento> buscaAgendamentos() throws SelectException{
//		return agendamentoDAO.selectAll();
//	}
//	//----------------------------Equipamento----------------------------//
//	public void insereEquipamento(Equipamento equipamento) throws SelectException, InsertException {
//		equipamentoDAO.insert(equipamento);
//	}
//	public void deletaEquipamento(Equipamento equipamento) throws DeleteException{
//		equipamentoDAO.delete(equipamento);
//	}
//	public void atualizaEquipamento(Equipamento equipamento) throws UpdateException{
//		equipamentoDAO.update(equipamento);
//	}
//	public Equipamento buscaEquipamento(int id_equipamento) throws SelectException{
//		return equipamentoDAO.select(id_equipamento);
//	}	
//	public List<Equipamento> buscaEquipamentos() throws SelectException{
//		return equipamentoDAO.selectAll();
//	}
//	//----------------------------Evento----------------------------//
//	public void insereEvento(Evento evento) throws InsertException, SelectException{
//		int id = eventoDAO.insert(evento);
//		evento.setId_evento(id);
//		List<Quadra> quadras = evento.getQuadras();
//		for(Quadra q : quadras) {
//			System.out.println(q);
//			eventoDAO.insertQuadraEvento(evento, q);
//		}
//	}
//	public void deleteEvento(Evento evento) throws DeleteException{
//		List<Quadra> quadras = evento.getQuadras();
//		for(Quadra q : quadras) {
//			
//			eventoDAO.deleteQuadraEvento(evento, q);
//		}
//		eventoDAO.delete(evento);
//	}
//	public void deleteQuadraEvento(Evento evento, Quadra quadra) throws DeleteException{
//		eventoDAO.deleteQuadraEvento(evento, quadra);
//	}
//	public void atualizaEvento(Evento evento) throws UpdateException {
//		eventoDAO.update(evento);
//	}
//	public Evento buscaEvento(int id_evento) throws SelectException{
//		return eventoDAO.select(id_evento);
//	}
//	public List<Evento> buscaEventos() throws SelectException{
//		return eventoDAO.selectAll();
//	}
}
