package apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.*;
import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;
import negocio.Sistema;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	Sistema sistema = Sistema.getInstance();
	private JTextField mat_prof;
	private JTextField nome_prof;
	private JTextField idade_prof;
	private JTextField sala_prof;
	private JTextField especialidade_prof;
	private JTextField mat_excluir;
	private JTextField mat_prof_at;
	private JTextField nome_prof_at;
	private JTextField idade_prof_at;
	private JTextField sala_prof_at;
	private JTextField especialidade_prof_at;
	private JTextField mat_prof_dep;
	private JTextField num_dep_prof;
	private JTextField prof_tempo;
	private JTextField mat_profP;
	private JTextField num_projP;
	private JTextField mat_estP;
	private JTextField num_projE;
	private JTextField mat_prof_supervisor;
	private JTextField textBuscarDep;
	private JTextField textNumDep;
	private JTextField textEscDep;
	private JTextField textNomeDep;
	private JTextField textMatLiderDep;
	private JTextField textSelecionarDep;
	private JTextField textEscrDepAT;
	private JTextField textNomeDepAT;
	private JTextField textMatLiderAT;
	private JTextField textExcluirDep;
	private JTextField textBuscarEst;
	private JTextField textMatEst;
	private JTextField textNomeEst;
	private JTextField textTipoCursoEst;
	private JTextField textIdadeEst;
	private JTextField textDepEst;
	private JTextField textAconEst;
	private JTextField textNomeEstAT;
	private JTextField TextCursoEstAT;
	private JTextField textIdadeEstAT;
	private JTextField textDepEstAT;
	private JTextField textAconEstAT;
	private JTextField textExcluirEst;
	private JTextField textBuscarNum;
	private JTextField textNumProj;
	private JTextField textNomeProj;
	private JTextField textFinanciadorProj;
	private JTextField textOrcamentoProj;
	private JTextField textInicioProj;
	private JTextField textFimProj;
	private JTextField textPesquisadorProj;
	private JTextField textNumProjExcluir;
	private JTextField textBuscarAT;
	private JTextField textNomeProjAT;
	private JTextField textFinanciadorProjAT;
	private JTextField textOrcamentoProjAT;
	private JTextField textInicioProjAT;
	private JTextField textFimProjAT;
	private JTextField textProfPrincAT;
	private JTextField textSelecionarEst;
	private JTextField excluirParticipacao;
	private JTextField textField_3;
	private JTextField excluirTrabalha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			System.err.println(ex);
		} catch (InstantiationException ex) {
			System.err.println(ex);
		} catch (IllegalAccessException ex) {
			System.err.println(ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			System.err.println(ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setResizable(false);
		setTitle("Sistema de Controle de Universidade");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 500);

		// menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu1 = new JMenu("Ajuda");
		menuBar.add(menu1);

		JMenuItem mntmComoFunciona = new JMenuItem("Como funciona?");
		menu1.add(mntmComoFunciona);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		// Aba 1: Painel do departamento
		JPanel panel_dep = new JPanel();
		tabbedPane.addTab("Departamentos", null, panel_dep, null);
		panel_dep.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane_Dep = new JTabbedPane(JTabbedPane.TOP);
		panel_dep.add(tabbedPane_Dep, BorderLayout.CENTER);

		JPanel panel_buscarD = new JPanel();
		tabbedPane_Dep.addTab("Buscar", null, panel_buscarD, null);
		panel_buscarD.setLayout(null);

		JLabel lblBuscarDep = new JLabel("Você está na aba de buscar um departamento");
		lblBuscarDep.setVerticalAlignment(SwingConstants.CENTER);
		lblBuscarDep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBuscarDep.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarDep.setBounds(10, 10, 408, 33);
		panel_buscarD.add(lblBuscarDep);

		JLabel lblBuscarDep1 = new JLabel("Para buscar um departamento é necessário inserir a id dele.");
		lblBuscarDep1.setVerticalAlignment(SwingConstants.CENTER);
		lblBuscarDep1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarDep1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscarDep1.setBounds(10, 56, 408, 23);
		panel_buscarD.add(lblBuscarDep1);

		JLabel lblBuscarDep2 = new JLabel("Id do departamento:");
		lblBuscarDep2.setVerticalAlignment(SwingConstants.CENTER);
		lblBuscarDep2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarDep2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscarDep2.setBounds(10, 89, 408, 23);
		panel_buscarD.add(lblBuscarDep2);

		textBuscarDep = new JTextField();
		textBuscarDep.setBounds(154, 131, 115, 33);
		panel_buscarD.add(textBuscarDep);
		textBuscarDep.setColumns(10);

		JButton btnBuscarDep = new JButton("Buscar");
		btnBuscarDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Departamento departamentoBuscado = sistema
							.buscaDepartamento(Integer.valueOf(textBuscarDep.getText()));
					if (departamentoBuscado != null) {
						JOptionPane.showMessageDialog(null, departamentoBuscado, "Buscar Departamento no Banco",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"Não foi possivel buscar o departamento, verifique se ele está cadastrado no banco.",
								"Buscar Departamento no Banco", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possivel buscar o departamento.",
							"Buscar Departamento do Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnBuscarDep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBuscarDep.setBounds(154, 184, 115, 33);
		panel_buscarD.add(btnBuscarDep);

		JLabel lblNewLabel_1 = new JLabel("Lembre-se: Para buscar um departamento é necessário que ele");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 287, 408, 16);
		panel_buscarD.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("já esteja cadastrado no sistema.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 313, 408, 23);
		panel_buscarD.add(lblNewLabel_2);

		JPanel panel_inserirD = new JPanel();
		tabbedPane_Dep.addTab("Inserir", null, panel_inserirD, null);
		panel_inserirD.setLayout(null);

		JLabel lblInserirDep = new JLabel("Você está na aba de cadastrar um novo Departamento");
		lblInserirDep.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirDep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInserirDep.setBounds(10, 10, 408, 24);
		panel_inserirD.add(lblInserirDep);

		JLabel lblInserirDep2 = new JLabel("Número:");
		lblInserirDep2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirDep2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirDep2.setBounds(10, 44, 408, 24);
		panel_inserirD.add(lblInserirDep2);

		textNumDep = new JTextField();
		textNumDep.setBounds(157, 76, 114, 31);
		panel_inserirD.add(textNumDep);
		textNumDep.setColumns(10);

		JLabel lblIserirDep3 = new JLabel("Escritório:");
		lblIserirDep3.setHorizontalAlignment(SwingConstants.CENTER);
		lblIserirDep3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIserirDep3.setBounds(10, 117, 408, 24);
		panel_inserirD.add(lblIserirDep3);

		textEscDep = new JTextField();
		textEscDep.setBounds(157, 153, 114, 31);
		panel_inserirD.add(textEscDep);
		textEscDep.setColumns(10);

		JLabel lblInserirDep4 = new JLabel("Nome do Departamento: ");
		lblInserirDep4.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirDep4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirDep4.setBounds(10, 194, 408, 24);
		panel_inserirD.add(lblInserirDep4);

		textNomeDep = new JTextField();
		textNomeDep.setBounds(157, 228, 114, 31);
		panel_inserirD.add(textNomeDep);
		textNomeDep.setColumns(10);

		JLabel lblInserirDep5 = new JLabel("Matrícula do Líder do Departamento:");
		lblInserirDep5.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirDep5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirDep5.setBounds(10, 269, 408, 24);
		panel_inserirD.add(lblInserirDep5);

		textMatLiderDep = new JTextField();
		textMatLiderDep.setBounds(157, 303, 114, 31);
		panel_inserirD.add(textMatLiderDep);
		textMatLiderDep.setColumns(10);

		JButton btnCadastrarDep = new JButton("Cadastrar");
		btnCadastrarDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Departamento d = new Departamento();
				d.setNumero(Integer.valueOf(textNumDep.getText()));
				d.setEscritorio_princ(textEscDep.getText());
				d.setNome(textNomeDep.getText());
				d.setLider(Integer.valueOf(textMatLiderDep.getText()));
				try {
					sistema.insereDepartamento(d);
					JOptionPane.showMessageDialog(null, "Departamento Cadastrado com sucesso",
							"Cadastrar Departamento no Banco", JOptionPane.INFORMATION_MESSAGE);

				} catch (InsertException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar esse departamento",
							"Cadastrar Departamento no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar esse departamento",
							"Cadastrar Departamento no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar esse departamento",
							"Cadastrar Departamento no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnCadastrarDep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrarDep.setBounds(304, 336, 114, 31);
		panel_inserirD.add(btnCadastrarDep);

		JPanel panel_atualizarD = new JPanel();
		tabbedPane_Dep.addTab("Atualizar", null, panel_atualizarD, null);
		panel_atualizarD.setLayout(null);

		JLabel lblAtualizarDep = new JLabel("Você está na aba para atualizar dados de um Departamento");
		lblAtualizarDep.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarDep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAtualizarDep.setBounds(10, 10, 408, 22);
		panel_atualizarD.add(lblAtualizarDep);

		JLabel lblAtualizarDep2 = new JLabel("Insira a id do departamento a ser atualizado:");
		lblAtualizarDep2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarDep2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarDep2.setBounds(10, 39, 408, 22);
		panel_atualizarD.add(lblAtualizarDep2);

		textSelecionarDep = new JTextField();
		textSelecionarDep.setBounds(97, 71, 96, 29);
		panel_atualizarD.add(textSelecionarDep);
		textSelecionarDep.setColumns(10);

		JButton btnSelecionarDep = new JButton("Selecionar");
		btnSelecionarDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Departamento departamentoBuscado;
				try {
					departamentoBuscado = sistema.buscaDepartamento(Integer.valueOf(textSelecionarDep.getText()));
					if (departamentoBuscado != null) {
						JOptionPane.showMessageDialog(null, departamentoBuscado, "Visualizar Departamento",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"Não foi possível selecionar esse departamento, verifique se ele está cadastrado no banco",
								"Selecionar Departamento no Banco", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível selecionar esse departamento",
							"Selecionar Departamento no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnSelecionarDep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSelecionarDep.setBounds(203, 71, 113, 29);
		panel_atualizarD.add(btnSelecionarDep);

		JLabel lblAtualizarDep3 = new JLabel("Insira os dados a serem atualizados:");
		lblAtualizarDep3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarDep3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarDep3.setBounds(10, 120, 408, 22);
		panel_atualizarD.add(lblAtualizarDep3);

		JLabel lblAtualizarDep4 = new JLabel("Escritório: ");
		lblAtualizarDep4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarDep4.setBounds(10, 164, 83, 28);
		panel_atualizarD.add(lblAtualizarDep4);

		textEscrDepAT = new JTextField();
		textEscrDepAT.setBounds(97, 163, 113, 29);
		panel_atualizarD.add(textEscrDepAT);
		textEscrDepAT.setColumns(10);

		JLabel lblAtualizarDep5 = new JLabel("Nome: ");
		lblAtualizarDep5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarDep5.setBounds(10, 223, 74, 29);
		panel_atualizarD.add(lblAtualizarDep5);

		textNomeDepAT = new JTextField();
		textNomeDepAT.setBounds(97, 223, 113, 29);
		panel_atualizarD.add(textNomeDepAT);
		textNomeDepAT.setColumns(10);

		JLabel lblAtualizarDep6 = new JLabel("Lider:");
		lblAtualizarDep6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarDep6.setBounds(10, 290, 83, 28);
		panel_atualizarD.add(lblAtualizarDep6);

		textMatLiderAT = new JTextField();
		textMatLiderAT.setBounds(97, 289, 113, 29);
		panel_atualizarD.add(textMatLiderAT);
		textMatLiderAT.setColumns(10);

		JButton btnAtualizarEsc = new JButton("Atualizar");
		btnAtualizarEsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Departamento departamentoBuscado;
				try {
					departamentoBuscado = sistema.buscaDepartamento(Integer.valueOf(textSelecionarDep.getText()));
					departamentoBuscado.setEscritorio_princ(textEscrDepAT.getText());
					sistema.atualizaDepartamento(departamentoBuscado);
					JOptionPane.showMessageDialog(null, "Dados do departamento atualizado com sucesso",
							"Atualizar Departamento", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse departamento",
							"Atualizar Departamento", JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarEsc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarEsc.setBounds(220, 163, 96, 29);
		panel_atualizarD.add(btnAtualizarEsc);

		JButton btnAtualizarNome = new JButton("Atualizar");
		btnAtualizarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Departamento departamentoBuscado;
				try {
					departamentoBuscado = sistema.buscaDepartamento(Integer.valueOf(textSelecionarDep.getText()));
					departamentoBuscado.setNome(textNomeDepAT.getText());
					sistema.atualizaDepartamento(departamentoBuscado);
					JOptionPane.showMessageDialog(null, "Dados do departamento atualizado com sucesso",
							"Atualizar Departamento", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse departamento",
							"Atualizar Departamento", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse departamento",
							"Atualizar Departamento", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarNome.setBounds(220, 221, 96, 29);
		panel_atualizarD.add(btnAtualizarNome);

		JButton btnAtualizarLider = new JButton("Atualizar");
		btnAtualizarLider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Departamento departamentoBuscado;
				try {
					departamentoBuscado = sistema.buscaDepartamento(Integer.valueOf(textSelecionarDep.getText()));
					departamentoBuscado.setLider(Integer.valueOf(textMatLiderAT.getText()));
					sistema.atualizaDepartamento(departamentoBuscado);
					JOptionPane.showMessageDialog(null, "Dados do departamento atualizado com sucesso",
							"Atualizar Departamento", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse departamento",
							"Atualizar Departamento", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse departamento",
							"Atualizar Departamento", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarLider.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarLider.setBounds(220, 289, 96, 28);
		panel_atualizarD.add(btnAtualizarLider);

		JPanel panel_excluirD = new JPanel();
		tabbedPane_Dep.addTab("Excluir", null, panel_excluirD, null);
		panel_excluirD.setLayout(null);

		JLabel lblExcluirDep = new JLabel("Você está na aba de excluir um departamento");
		lblExcluirDep.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirDep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExcluirDep.setBounds(10, 10, 412, 33);
		panel_excluirD.add(lblExcluirDep);

		JLabel lblExcluirDep2 = new JLabel("Digite o número do departamento que deseja excluir");
		lblExcluirDep2.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirDep2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExcluirDep2.setBounds(10, 53, 412, 33);
		panel_excluirD.add(lblExcluirDep2);

		textExcluirDep = new JTextField();
		textExcluirDep.setBounds(141, 96, 133, 33);
		panel_excluirD.add(textExcluirDep);
		textExcluirDep.setColumns(10);

		JButton btnExcluirDep = new JButton("Excluir");
		btnExcluirDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Departamento departamentoSelecionado;
				try {
					departamentoSelecionado = sistema.buscaDepartamento(Integer.valueOf(textExcluirDep.getText()));
					if (departamentoSelecionado != null) {
						sistema.deletaDepartamento(departamentoSelecionado);
						JOptionPane.showMessageDialog(null, "Departamento apagado com sucesso",
								"Apagar Departamento do Banco", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"Não foi possível apagar esse departamento, verifique se esse departamento está cadastrado no banco.",
								"Apagar Departamento do Banco", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException | SelectException | DeleteException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível apagar esse departamento.",
							"Apagar Departamento do Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnExcluirDep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluirDep.setBounds(141, 144, 133, 33);
		panel_excluirD.add(btnExcluirDep);

		JPanel panel_exibirD = new JPanel();
		tabbedPane_Dep.addTab("Exibir", null, panel_exibirD, null);
		panel_exibirD.setLayout(null);

		JLabel lblExibirDep = new JLabel("Você está na aba para exibir todos os Departamentos");
		lblExibirDep.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExibirDep.setHorizontalAlignment(SwingConstants.CENTER);
		lblExibirDep.setBounds(10, 10, 408, 31);
		panel_exibirD.add(lblExibirDep);

		JLabel lblExibirDep1 = new JLabel("Clique no botão para exibir todos os Departamentos");
		lblExibirDep1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExibirDep1.setHorizontalAlignment(SwingConstants.CENTER);
		lblExibirDep1.setBounds(10, 67, 419, 31);
		panel_exibirD.add(lblExibirDep1);

		JButton btnExibirDep = new JButton("Exibir");
		btnExibirDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Departamento> departamentos;
				try {
					departamentos = sistema.buscaDepartamentos();
					JTextPane textPane = new JTextPane();
					textPane.setBounds(33, 154, 373, 185);
					panel_exibirD.add(textPane);
					textPane.setText(departamentos.toString());
				} catch (SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível exibir dados do departamento.",
							"Exibir Departamentos do Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnExibirDep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExibirDep.setBounds(154, 108, 98, 31);
		panel_exibirD.add(btnExibirDep);

		JPanel panel_profD = new JPanel();
		tabbedPane_Dep.addTab("Exibir Professores", null, panel_profD, null);
		panel_profD.setLayout(null);

		JLabel lblExibirDepProf = new JLabel("Você está na aba Exibir Professores");
		lblExibirDepProf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExibirDepProf.setHorizontalAlignment(SwingConstants.CENTER);
		lblExibirDepProf.setBounds(10, 10, 408, 26);
		panel_profD.add(lblExibirDepProf);

		JLabel lblExibirDepProf2 = new JLabel("Clique no botão abaixo para exibir todos os professores");
		lblExibirDepProf2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExibirDepProf2.setHorizontalAlignment(SwingConstants.CENTER);
		lblExibirDepProf2.setBounds(10, 46, 415, 28);
		panel_profD.add(lblExibirDepProf2);

		JLabel lblExibirDepProf3 = new JLabel("e os departamentos que eles trabalham");
		lblExibirDepProf3.setHorizontalAlignment(SwingConstants.CENTER);
		lblExibirDepProf3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExibirDepProf3.setBounds(3, 70, 415, 28);
		panel_profD.add(lblExibirDepProf3);

		JButton btnExibirDepProf = new JButton("Exibir");
		btnExibirDepProf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExibirDepProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				List<Object> lista;
				try {
					lista = sistema.exibeProfDep();
					for (Object linha : lista) {
						Object[] arrayLinha = (Object[]) linha;
						for (Object valor : arrayLinha) {
							sb.append("- ").append(valor);
						}
						sb.append("\n");
					}
					JTextPane textPane = new JTextPane();
					textPane.setBounds(33, 154, 373, 185);
					panel_profD.add(textPane);
					textPane.setText(sb.toString());
				} catch (SelectException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnExibirDepProf.setBounds(160, 108, 98, 27);
		panel_profD.add(btnExibirDepProf);

		// painel prof
		JPanel panel_prof = new JPanel();
		tabbedPane.addTab("Professores", null, panel_prof, null);
		panel_prof.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane_prof = new JTabbedPane(JTabbedPane.TOP);
		panel_prof.add(tabbedPane_prof, BorderLayout.CENTER);
		// buscar
		JPanel panel_buscar = new JPanel();
		tabbedPane_prof.addTab("Buscar", null, panel_buscar, null);
		panel_buscar.setLayout(null);
		JLabel lblBuscarProf = new JLabel("Você está na aba de buscar um professor\r\n");
		lblBuscarProf.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarProf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBuscarProf.setBounds(10, 10, 408, 37);
		panel_buscar.add(lblBuscarProf);
		JLabel lblBuscarProf2 = new JLabel("Para buscar um professor é necessário inserir a matrícula dele.");
		lblBuscarProf2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscarProf2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarProf2.setBounds(10, 56, 408, 26);
		panel_buscar.add(lblBuscarProf2);

		JTextField txtBuscarProf = new JTextField();
		txtBuscarProf.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscarProf.setBounds(152, 137, 120, 37);
		panel_buscar.add(txtBuscarProf);
		txtBuscarProf.setColumns(10);
		JButton btnBuscarProf = new JButton("Buscar");
		btnBuscarProf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Professor professorBuscado = sistema.buscaProfessor(Integer.valueOf(txtBuscarProf.getText()));
					if (professorBuscado != null) {
						JOptionPane.showMessageDialog(null, professorBuscado, "Buscar Professores no Banco",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Não foi possível buscar esse professor.",
								"Buscar Professores no Banco", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível buscar esse professor.",
							"Buscar Professores no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnBuscarProf.setBounds(152, 195, 120, 31);
		panel_buscar.add(btnBuscarProf);

		JLabel lblBuscarProf3 = new JLabel("Matrícula:");
		lblBuscarProf3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarProf3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscarProf3.setBounds(10, 101, 408, 26);
		panel_buscar.add(lblBuscarProf3);

		JLabel lblBuscarProf4 = new JLabel("Lembre-se: Para buscar um professor é necessário que ele");
		lblBuscarProf4.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarProf4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBuscarProf4.setBounds(10, 281, 408, 26);
		panel_buscar.add(lblBuscarProf4);

		JLabel lblBuscarProf5 = new JLabel("já esteja cadastrado no sistema.");
		lblBuscarProf5.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarProf5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBuscarProf5.setBounds(10, 305, 408, 26);
		panel_buscar.add(lblBuscarProf5);

		JPanel panel_inserir = new JPanel();
		tabbedPane_prof.addTab("Inserir", null, panel_inserir, null);
		panel_inserir.setLayout(null);

		JLabel lblInserirProf = new JLabel("Você está na aba de cadastrar um novo Professor");
		lblInserirProf.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirProf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInserirProf.setBounds(10, 10, 408, 27);
		panel_inserir.add(lblInserirProf);

		JLabel lblInserirProf2 = new JLabel("Matrícula:");
		lblInserirProf2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirProf2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirProf2.setBounds(127, 47, 143, 26);
		panel_inserir.add(lblInserirProf2);

		JLabel lblInserirProf3 = new JLabel("Nome:");
		lblInserirProf3.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirProf3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirProf3.setBounds(127, 102, 143, 27);
		panel_inserir.add(lblInserirProf3);

		JLabel lblInserirProf4 = new JLabel("Idade:");
		lblInserirProf4.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirProf4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirProf4.setBounds(127, 165, 143, 27);
		panel_inserir.add(lblInserirProf4);

		JLabel lblInserirProf5 = new JLabel("Sala:");
		lblInserirProf5.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirProf5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirProf5.setBounds(127, 226, 143, 27);
		panel_inserir.add(lblInserirProf5);

		JLabel lblInserirProf6 = new JLabel("Especialidade:");
		lblInserirProf6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirProf6.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirProf6.setBounds(132, 283, 138, 27);
		panel_inserir.add(lblInserirProf6);

		mat_prof = new JTextField();
		mat_prof.setBounds(127, 72, 143, 27);
		panel_inserir.add(mat_prof);
		mat_prof.setColumns(10);

		nome_prof = new JTextField();
		nome_prof.setBounds(127, 128, 143, 27);
		panel_inserir.add(nome_prof);
		nome_prof.setColumns(10);

		idade_prof = new JTextField();
		idade_prof.setBounds(127, 190, 143, 27);
		panel_inserir.add(idade_prof);
		idade_prof.setColumns(10);

		sala_prof = new JTextField();
		sala_prof.setBounds(127, 251, 143, 27);
		panel_inserir.add(sala_prof);
		sala_prof.setColumns(10);

		especialidade_prof = new JTextField();
		especialidade_prof.setBounds(127, 307, 143, 27);
		panel_inserir.add(especialidade_prof);
		especialidade_prof.setColumns(10);

		JButton bntCadastrarProf = new JButton("Cadastrar");
		bntCadastrarProf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bntCadastrarProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor p = new Professor();
				p.setMatricula(Integer.valueOf(mat_prof.getText()));
				p.setNome(nome_prof.getText());
				p.setIdade(Integer.valueOf(idade_prof.getText()));
				p.setSala(sala_prof.getText());
				p.setEspecialidade(especialidade_prof.getText());
				try {
					sistema.insereProfessor(p);
					JOptionPane.showMessageDialog(null, "professor Cadastrado com sucesso",
							"Buscar Professores no Banco", JOptionPane.INFORMATION_MESSAGE);

				} catch (InsertException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar esse professor",
							"Cadastrar Professores no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar esse professor",
							"Cadastrar Professores no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		bntCadastrarProf.setBounds(287, 340, 131, 27);
		panel_inserir.add(bntCadastrarProf);

		JPanel panel_atualizar = new JPanel();
		tabbedPane_prof.addTab("Atualizar", null, panel_atualizar, null);
		panel_atualizar.setLayout(null);

		JLabel lblAtualizarProf = new JLabel("Você está na aba para atualizar dados de um Professor");
		lblAtualizarProf.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarProf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAtualizarProf.setBounds(14, 10, 401, 30);
		panel_atualizar.add(lblAtualizarProf);

		JLabel lblAtualizarProf2 = new JLabel("Insira a matricula do professor a ser atualizado:\r\n");
		lblAtualizarProf2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarProf2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarProf2.setBounds(14, 50, 401, 19);
		panel_atualizar.add(lblAtualizarProf2);

		mat_prof_at = new JTextField();
		mat_prof_at.setBounds(112, 79, 111, 26);
		panel_atualizar.add(mat_prof_at);
		mat_prof_at.setColumns(10);

		JButton btnSelecionarProf = new JButton("Selecionar");
		btnSelecionarProf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSelecionarProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor professorSelecionado;
				try {
					professorSelecionado = sistema.buscaProfessor(Integer.valueOf(mat_prof_at.getText()));
					if (professorSelecionado != null) {
						JOptionPane.showMessageDialog(null, professorSelecionado, "Visualizar Professor",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"Não foi possível buscar esse professor, verifique se ele está cadastrado no banco.",
								"Buscar Professores no Banco", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível buscar esse professor.",
							"Buscar Professores no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnSelecionarProf.setBounds(233, 79, 96, 26);
		panel_atualizar.add(btnSelecionarProf);

		JLabel lblAtualizarProf3 = new JLabel("Insira os dados a serem atualizados:");
		lblAtualizarProf3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarProf3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarProf3.setBounds(10, 121, 405, 19);
		panel_atualizar.add(lblAtualizarProf3);

		JLabel lblAtualizarProf4 = new JLabel("Nome:");
		lblAtualizarProf4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarProf4.setBounds(10, 166, 102, 23);
		panel_atualizar.add(lblAtualizarProf4);

		nome_prof_at = new JTextField();
		nome_prof_at.setBounds(112, 166, 111, 25);
		panel_atualizar.add(nome_prof_at);
		nome_prof_at.setColumns(10);

		JButton btnAtualizarNomeProf = new JButton("Atualizar");
		btnAtualizarNomeProf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarNomeProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor professorSelecionado;
				try {
					professorSelecionado = sistema.buscaProfessor(Integer.valueOf(mat_prof_at.getText()));
					professorSelecionado.setNome(nome_prof_at.getText());
					sistema.atualizaProfessor(professorSelecionado);
					JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso.", "Atualizar Professor",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse professor.",
							"Atualizar Professor", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse professor.",
							"Atualizar Professor", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarNomeProf.setBounds(233, 163, 96, 26);
		panel_atualizar.add(btnAtualizarNomeProf);

		JLabel lblAtualizarProf5 = new JLabel("Idade: ");
		lblAtualizarProf5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarProf5.setBounds(10, 218, 102, 25);
		panel_atualizar.add(lblAtualizarProf5);

		idade_prof_at = new JTextField();
		idade_prof_at.setBounds(112, 217, 111, 26);
		panel_atualizar.add(idade_prof_at);
		idade_prof_at.setColumns(10);

		JButton btnAtualizarIdadeProf = new JButton("Atualizar");
		btnAtualizarIdadeProf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarIdadeProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor professorSelecionado;
				try {
					professorSelecionado = sistema.buscaProfessor(Integer.valueOf(mat_prof_at.getText()));
					professorSelecionado.setIdade(Integer.valueOf(idade_prof_at.getText()));
					sistema.atualizaProfessor(professorSelecionado);
					JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso", "Atualizar Professor",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse professor.",
							"Atualizar Professor", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse professor.",
							"Atualizar Professor", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarIdadeProf.setBounds(233, 218, 96, 25);
		panel_atualizar.add(btnAtualizarIdadeProf);

		JLabel lblAtualizarProf6 = new JLabel("Sala: ");
		lblAtualizarProf6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarProf6.setBounds(10, 267, 102, 25);
		panel_atualizar.add(lblAtualizarProf6);

		sala_prof_at = new JTextField();
		sala_prof_at.setBounds(112, 266, 111, 26);
		panel_atualizar.add(sala_prof_at);
		sala_prof_at.setColumns(10);

		JButton btnAtualizarSalaProf = new JButton("Atualizar");
		btnAtualizarSalaProf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarSalaProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor professorSelecionado;
				try {
					professorSelecionado = sistema.buscaProfessor(Integer.valueOf(mat_prof_at.getText()));
					professorSelecionado.setSala(sala_prof_at.getText());
					sistema.atualizaProfessor(professorSelecionado);
					JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso", "Atualizar Professor",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse professor.",
							"Atualizar Professor", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse professor.",
							"Atualizar Professor", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarSalaProf.setBounds(233, 263, 96, 27);
		panel_atualizar.add(btnAtualizarSalaProf);

		JLabel lblAtualizarProf7 = new JLabel("Especialidade: ");
		lblAtualizarProf7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarProf7.setBounds(14, 317, 111, 26);
		panel_atualizar.add(lblAtualizarProf7);

		especialidade_prof_at = new JTextField();
		especialidade_prof_at.setBounds(112, 317, 111, 26);
		panel_atualizar.add(especialidade_prof_at);
		especialidade_prof_at.setColumns(10);

		JButton btnAtualizarEspProf = new JButton("Atualizar");
		btnAtualizarEspProf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarEspProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor professorSelecionado;
				try {
					professorSelecionado = sistema.buscaProfessor(Integer.valueOf(mat_prof_at.getText()));
					professorSelecionado.setEspecialidade(especialidade_prof_at.getText());
					sistema.atualizaProfessor(professorSelecionado);
					JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso", "Atualizar Professor",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse professor.",
							"Atualizar Professor", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse professor.",
							"Atualizar Professor", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnAtualizarEspProf.setBounds(233, 317, 96, 26);
		panel_atualizar.add(btnAtualizarEspProf);

		JPanel panel_excluir = new JPanel();
		tabbedPane_prof.addTab("Excluir", null, panel_excluir, null);
		panel_excluir.setLayout(null);

		JLabel lblExcluirProf = new JLabel("Você está na aba de excluir um professor");
		lblExcluirProf.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirProf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExcluirProf.setBounds(14, 10, 400, 31);
		panel_excluir.add(lblExcluirProf);

		JLabel lblExcluirProf2 = new JLabel("Digite a matrícula do professor que deseja excluir.");
		lblExcluirProf2.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirProf2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExcluirProf2.setBounds(11, 51, 407, 22);
		panel_excluir.add(lblExcluirProf2);

		mat_excluir = new JTextField();
		mat_excluir.setBounds(151, 93, 109, 31);
		panel_excluir.add(mat_excluir);
		mat_excluir.setColumns(10);

		JButton btnExcluirProf = new JButton("Excluir");
		btnExcluirProf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluirProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor professorSelecionado;
				try {
					professorSelecionado = sistema.buscaProfessor(Integer.valueOf(mat_excluir.getText()));
					if (professorSelecionado != null) {
						sistema.deletaProfessor(professorSelecionado);
						JOptionPane.showMessageDialog(null, "Professor apagado com sucesso",
								"Apagar Professor do Banco", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"Não foi possível apagar esse professor, verifique se ele está cadastrado no banco.",
								"Apagar Professor do banco", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException | SelectException | DeleteException e1) {
					JOptionPane.showMessageDialog(null,
							"Não foi possivel apagar professor, verifique se ele ainda possui alguma relação de trabalho ou participação",
							"Apagar Professor do Banco", JOptionPane.ERROR_MESSAGE);

					e1.printStackTrace();
				}
			}
		});
		btnExcluirProf.setBounds(151, 134, 109, 31);
		panel_excluir.add(btnExcluirProf);

		JPanel panel_exibir = new JPanel();
		tabbedPane_prof.addTab("Exibir", null, panel_exibir, null);
		panel_exibir.setLayout(null);

		JLabel lblExibirProf = new JLabel("Você está na aba para exibir todos os Professores\r\n");
		lblExibirProf.setHorizontalAlignment(SwingConstants.CENTER);
		lblExibirProf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExibirProf.setBounds(10, 10, 410, 21);
		panel_exibir.add(lblExibirProf);

		JLabel lblExibirProf2 = new JLabel("Clique no botão para exibir todos os Professores.");
		lblExibirProf2.setHorizontalAlignment(SwingConstants.CENTER);
		lblExibirProf2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExibirProf2.setBounds(7, 43, 413, 26);
		panel_exibir.add(lblExibirProf2);

		JButton btnNewButton_1 = new JButton("Exibir");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Professor> professores;
				try {
					professores = sistema.buscaProfessores();
					JTextPane textPane = new JTextPane();
					textPane.setBounds(33, 154, 373, 185);
					panel_exibir.add(textPane);
					textPane.setText(professores.toString());
				} catch (SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível exibir professores.", "Exibir Professores",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(159, 84, 93, 27);
		panel_exibir.add(btnNewButton_1);

		JPanel panel_departamento = new JPanel();
		tabbedPane_prof.addTab("Departamento", null, panel_departamento, null);
		panel_departamento.setLayout(null);

		JLabel lblDepProf = new JLabel("Você está na aba Departamento");
		lblDepProf.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepProf.setVerticalAlignment(SwingConstants.CENTER);
		lblDepProf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDepProf.setBounds(10, 10, 408, 34);
		panel_departamento.add(lblDepProf);

		JLabel lblDepProf2 = new JLabel("Insira os dados para inserir um professor a um departamento.");
		lblDepProf2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepProf2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepProf2.setBounds(10, 42, 408, 24);
		panel_departamento.add(lblDepProf2);

		JLabel lblDepProf3 = new JLabel("Matricula do professor:");
		lblDepProf3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepProf3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepProf3.setBounds(11, 89, 160, 20);
		panel_departamento.add(lblDepProf3);

		mat_prof_dep = new JTextField();
		mat_prof_dep.setBounds(181, 89, 100, 25);
		panel_departamento.add(mat_prof_dep);
		mat_prof_dep.setColumns(10);

		JLabel lblDepProf4 = new JLabel("Departamento:");
		lblDepProf4.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepProf4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepProf4.setBounds(10, 129, 160, 20);
		panel_departamento.add(lblDepProf4);

		num_dep_prof = new JTextField();
		num_dep_prof.setBounds(181, 124, 100, 25);
		panel_departamento.add(num_dep_prof);
		num_dep_prof.setColumns(10);

		JLabel lblDepProf5 = new JLabel("Carga-horária:");
		lblDepProf5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepProf5.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepProf5.setBounds(10, 159, 160, 24);
		panel_departamento.add(lblDepProf5);

		prof_tempo = new JTextField();
		prof_tempo.setBounds(181, 159, 100, 25);
		panel_departamento.add(prof_tempo);
		prof_tempo.setColumns(10);

		JButton btnInserirDepProf = new JButton("Inserir");
		btnInserirDepProf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInserirDepProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trabalha t = new Trabalha();
				t.setDep_num(Integer.valueOf(num_dep_prof.getText()));
				t.setMatricula_prof(Integer.valueOf(mat_prof_dep.getText()));
				t.setTempo(Float.valueOf(prof_tempo.getText()));
				try {
					sistema.insereTrabalha(t);
					JOptionPane.showMessageDialog(null, "Relação trabalha cadastrada com sucesso",
							"Relação trabalha em Departamento", JOptionPane.INFORMATION_MESSAGE);

				} catch (InsertException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar essa relação",
							"Relação trabalha em Departamento", JOptionPane.ERROR_MESSAGE);
					// e1.printStackTrace();
				} catch (SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar essa relação",
							"Relação trabalha em Departamento", JOptionPane.ERROR_MESSAGE);
					// e1.printStackTrace();
				}

			}
		});
		btnInserirDepProf.setBounds(318, 190, 100, 25);
		panel_departamento.add(btnInserirDepProf);

		JLabel lblInsiraOsDados_2 = new JLabel("Remover um professor de um departamento.");
		lblInsiraOsDados_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInsiraOsDados_2.setBounds(10, 234, 408, 24);
		panel_departamento.add(lblInsiraOsDados_2);

		JLabel lblIdDaParticipao = new JLabel("Id da participação do professor:");
		lblIdDaParticipao.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdDaParticipao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdDaParticipao.setBounds(10, 268, 408, 20);
		panel_departamento.add(lblIdDaParticipao);

		excluirTrabalha = new JTextField();
		excluirTrabalha.setColumns(10);
		excluirTrabalha.setBounds(155, 298, 100, 25);
		panel_departamento.add(excluirTrabalha);

		JButton btnExcluir_2 = new JButton("Excluir");
		btnExcluir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Trabalha trabalhaSelecionada;
				try {
					trabalhaSelecionada = sistema.buscaTrabalha(Integer.valueOf(excluirTrabalha.getText()));
					if (trabalhaSelecionada != null) {
						JOptionPane.showMessageDialog(null, trabalhaSelecionada, "Visualizar relação trabalha",
								JOptionPane.INFORMATION_MESSAGE);
						sistema.deletaTrabalha(trabalhaSelecionada);
						JOptionPane.showMessageDialog(null, "Relação apagada com sucesso.", "Apagar Relação Trabalha",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Não foi possível excluir essa relação",
								"Relação trabalha em Departamento", JOptionPane.ERROR_MESSAGE);
					}

				} catch (NumberFormatException | SelectException | DeleteException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível excluir essa relação",
							"Relação trabalha em Departamento", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();

				}

			}
		});
		btnExcluir_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir_2.setBounds(155, 333, 100, 25);
		panel_departamento.add(btnExcluir_2);

//		JTextPane textPane = new JTextPane();
//		textPane.setBounds(33, 154, 373, 185);
//		panel_exibir.add(textPane);

		// painel estudante
		JPanel panel_estudante = new JPanel();
		tabbedPane.addTab("Estudantes", null, panel_estudante, null);
		panel_estudante.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane_Estudante = new JTabbedPane(JTabbedPane.TOP);
		panel_estudante.add(tabbedPane_Estudante, BorderLayout.CENTER);

		JPanel panel_buscar2 = new JPanel();
		tabbedPane_Estudante.addTab("Buscar", null, panel_buscar2, null);
		panel_buscar2.setLayout(null);

		JLabel lblBuscarEst = new JLabel("Você está na aba de buscar um estudante");
		lblBuscarEst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBuscarEst.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarEst.setBounds(9, 9, 413, 28);
		panel_buscar2.add(lblBuscarEst);

		JLabel lblBuscarEst1 = new JLabel("Para buscar um estudante é necessário inserir a matrícula dele\r\n");
		lblBuscarEst1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarEst1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscarEst1.setBounds(9, 49, 409, 23);
		panel_buscar2.add(lblBuscarEst1);

		textBuscarEst = new JTextField();
		textBuscarEst.setBounds(153, 130, 116, 33);
		panel_buscar2.add(textBuscarEst);
		textBuscarEst.setColumns(10);

		JButton btnBuscarEst = new JButton("Buscar");
		btnBuscarEst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					EstudantePos estudantePosBuscado = sistema
							.buscaEstudantePos(Integer.valueOf(textBuscarEst.getText()));
					if (estudantePosBuscado != null) {
						JOptionPane.showMessageDialog(null, estudantePosBuscado, "Buscar Estudante no Banco",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Não foi possível buscar estudante no Banco",
								"Buscar Estudante no Banco", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível buscar estudante no Banco",
							"Buscar Estudante no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnBuscarEst.setBounds(153, 186, 116, 28);
		panel_buscar2.add(btnBuscarEst);

		JLabel lblBuscarEst2 = new JLabel("Matrícula:");
		lblBuscarEst2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarEst2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscarEst2.setBounds(9, 88, 409, 23);
		panel_buscar2.add(lblBuscarEst2);

		JLabel lblBuscarEst3 = new JLabel("Lembre-se: Para buscar um estudante é necessário que ele");
		lblBuscarEst3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarEst3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBuscarEst3.setBounds(9, 286, 409, 23);
		panel_buscar2.add(lblBuscarEst3);

		JLabel lblBuscarEst4 = new JLabel("já esteja cadastrado no sistema.");
		lblBuscarEst4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBuscarEst4.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarEst4.setBounds(9, 309, 409, 23);
		panel_buscar2.add(lblBuscarEst4);

		JPanel panel_inserir2 = new JPanel();
		tabbedPane_Estudante.addTab("Inserir", null, panel_inserir2, null);
		panel_inserir2.setLayout(null);

		JLabel lblInserirEst = new JLabel("Você está na aba de cadastrar um novo Estudante");
		lblInserirEst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInserirEst.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirEst.setBounds(10, 10, 408, 25);
		panel_inserir2.add(lblInserirEst);

		textMatEst = new JTextField();
		textMatEst.setBounds(150, 68, 100, 25);
		panel_inserir2.add(textMatEst);
		textMatEst.setColumns(10);

		textNomeEst = new JTextField();
		textNomeEst.setBounds(150, 120, 100, 25);
		panel_inserir2.add(textNomeEst);
		textNomeEst.setColumns(10);

		textTipoCursoEst = new JTextField();
		textTipoCursoEst.setBounds(150, 169, 100, 25);
		panel_inserir2.add(textTipoCursoEst);
		textTipoCursoEst.setColumns(10);

		textIdadeEst = new JTextField();
		textIdadeEst.setBounds(150, 214, 100, 25);
		panel_inserir2.add(textIdadeEst);
		textIdadeEst.setColumns(10);

		textDepEst = new JTextField();
		textDepEst.setBounds(150, 263, 100, 25);
		panel_inserir2.add(textDepEst);
		textDepEst.setColumns(10);

		textAconEst = new JTextField();
		textAconEst.setBounds(150, 316, 100, 25);
		panel_inserir2.add(textAconEst);
		textAconEst.setColumns(10);

		JButton bntCadastrarEst = new JButton("Cadastrar");
		bntCadastrarEst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bntCadastrarEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstudantePos est = new EstudantePos();
				est.setMatricula(Integer.valueOf(textMatEst.getText()));
				est.setNome(textNomeEst.getText());
				est.setTipo_curso(textTipoCursoEst.getText());
				est.setIdade(Integer.valueOf(textIdadeEst.getText()));
				est.setDep(Integer.valueOf(textDepEst.getText()));
				est.setAconselhador(Integer.valueOf(textAconEst.getText()));
				try {
					sistema.insereEstudantePos(est);
					JOptionPane.showMessageDialog(null, "Estudante Cadastrado com sucesso",
							"Cadastrar Estudante no Banco", JOptionPane.INFORMATION_MESSAGE);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Cadastrar Estudante no Banco",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		bntCadastrarEst.setBounds(318, 342, 100, 25);
		panel_inserir2.add(bntCadastrarEst);

		JLabel lblInserirEst2 = new JLabel("Matricula:");
		lblInserirEst2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirEst2.setBounds(10, 68, 100, 20);
		panel_inserir2.add(lblInserirEst2);

		JLabel lblInserirEst3 = new JLabel("Nome:");
		lblInserirEst3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirEst3.setBounds(10, 125, 100, 20);
		panel_inserir2.add(lblInserirEst3);

		JLabel lblInserirEst4 = new JLabel("Tipo do curso:");
		lblInserirEst4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirEst4.setBounds(10, 174, 100, 20);
		panel_inserir2.add(lblInserirEst4);

		JLabel lblInserirEst5 = new JLabel("Idade:");
		lblInserirEst5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirEst5.setBounds(10, 219, 100, 20);
		panel_inserir2.add(lblInserirEst5);

		JLabel lblInserirEst6 = new JLabel("Departamento:");
		lblInserirEst6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirEst6.setBounds(10, 268, 100, 20);
		panel_inserir2.add(lblInserirEst6);

		JLabel lblInserirEst7 = new JLabel("Aconselhador:");
		lblInserirEst7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirEst7.setBounds(10, 321, 100, 20);
		panel_inserir2.add(lblInserirEst7);

		JPanel panel_atualizar2 = new JPanel();
		tabbedPane_Estudante.addTab("Atualizar", null, panel_atualizar2, null);
		panel_atualizar2.setLayout(null);

		JLabel lblAtualizarEst = new JLabel("Você está na aba de atualizar dados de um Estudante");
		lblAtualizarEst.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarEst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAtualizarEst.setBounds(10, 10, 399, 30);
		panel_atualizar2.add(lblAtualizarEst);

		JLabel lblAtualizarEst2 = new JLabel("Nome:");
		lblAtualizarEst2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarEst2.setBounds(10, 142, 100, 25);
		panel_atualizar2.add(lblAtualizarEst2);

		textNomeEstAT = new JTextField();
		textNomeEstAT.setBounds(109, 144, 100, 25);
		panel_atualizar2.add(textNomeEstAT);
		textNomeEstAT.setColumns(10);

		JButton btnAtualizarNomeEst = new JButton("Atualizar");
		btnAtualizarNomeEst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarNomeEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstudantePos estudanteSelecionado;
				try {
					estudanteSelecionado = sistema.buscaEstudantePos(Integer.valueOf(textSelecionarEst.getText()));
					estudanteSelecionado.setNome(textNomeEstAT.getText());
					sistema.atualizaEstudantePos(estudanteSelecionado);
					JOptionPane.showMessageDialog(null, "Dados do estudante atualizado com sucesso",
							"Atualizar Estudante", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse estudante",
							"Atualizar Estudante", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse estudante",
							"Atualizar Estudante", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarNomeEst.setBounds(219, 142, 100, 25);
		panel_atualizar2.add(btnAtualizarNomeEst);

		JLabel lblAtualizarEst3 = new JLabel("Tipo do Curso:");
		lblAtualizarEst3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarEst3.setBounds(10, 187, 100, 25);
		panel_atualizar2.add(lblAtualizarEst3);

		TextCursoEstAT = new JTextField();
		TextCursoEstAT.setBounds(109, 189, 100, 25);
		panel_atualizar2.add(TextCursoEstAT);
		TextCursoEstAT.setColumns(10);

		JButton btnAtualizarCursoEst = new JButton("Atualizar");
		btnAtualizarCursoEst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarCursoEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstudantePos estudanteSelecionado;
				try {
					estudanteSelecionado = sistema.buscaEstudantePos(Integer.valueOf(textSelecionarEst.getText()));
					estudanteSelecionado.setTipo_curso(TextCursoEstAT.getText());
					sistema.atualizaEstudantePos(estudanteSelecionado);
					JOptionPane.showMessageDialog(null, "Dados do estudante atualizado com sucesso",
							"Atualizar Estudante", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse estudante",
							"Atualizar Estudante", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse estudante",
							"Atualizar Estudante", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarCursoEst.setBounds(219, 187, 100, 25);
		panel_atualizar2.add(btnAtualizarCursoEst);

		JLabel lblAtualizarEst4 = new JLabel("Idade:");
		lblAtualizarEst4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarEst4.setBounds(10, 234, 100, 25);
		panel_atualizar2.add(lblAtualizarEst4);

		textIdadeEstAT = new JTextField();
		textIdadeEstAT.setBounds(109, 234, 100, 25);
		panel_atualizar2.add(textIdadeEstAT);
		textIdadeEstAT.setColumns(10);

		JButton btnAtualizarIdadeEst = new JButton("Atualizar");
		btnAtualizarIdadeEst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarIdadeEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstudantePos estudanteSelecionado;
				try {
					estudanteSelecionado = sistema.buscaEstudantePos(Integer.valueOf(textSelecionarEst.getText()));
					estudanteSelecionado.setIdade(Integer.valueOf(textIdadeEstAT.getText()));
					sistema.atualizaEstudantePos(estudanteSelecionado);
					JOptionPane.showMessageDialog(null, "Dados do estudante atualizado com sucesso",
							"Atualizar Estudante", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse estudante",
							"Atualizar Estudante", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse estudante",
							"Atualizar Estudante", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarIdadeEst.setBounds(219, 234, 100, 25);
		panel_atualizar2.add(btnAtualizarIdadeEst);

		JLabel lblAtualizarEst5 = new JLabel("Departamento:");
		lblAtualizarEst5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarEst5.setBounds(10, 277, 100, 25);
		panel_atualizar2.add(lblAtualizarEst5);

		textDepEstAT = new JTextField();
		textDepEstAT.setBounds(109, 279, 100, 25);
		panel_atualizar2.add(textDepEstAT);
		textDepEstAT.setColumns(10);

		JButton btnAtualizarDepEst = new JButton("Atualizar");
		btnAtualizarDepEst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarDepEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstudantePos estudanteSelecionado;
				try {
					estudanteSelecionado = sistema.buscaEstudantePos(Integer.valueOf(textSelecionarEst.getText()));
					estudanteSelecionado.setDep(Integer.valueOf(textDepEstAT.getText()));
					sistema.atualizaEstudantePos(estudanteSelecionado);
					JOptionPane.showMessageDialog(null, "Dados do estudante atualizado com sucesso",
							"Atualizar Estudante", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse estudante",
							"Atualizar Estudante", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse estudante",
							"Atualizar Estudante", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarDepEst.setBounds(219, 279, 100, 25);
		panel_atualizar2.add(btnAtualizarDepEst);

		JLabel lblAtualizarEst6 = new JLabel("Aconselhador:");
		lblAtualizarEst6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarEst6.setBounds(10, 322, 100, 25);
		panel_atualizar2.add(lblAtualizarEst6);

		textAconEstAT = new JTextField();
		textAconEstAT.setBounds(109, 322, 100, 25);
		panel_atualizar2.add(textAconEstAT);
		textAconEstAT.setColumns(10);

		JButton btnAtualizarAconEst = new JButton("Atualizar");
		btnAtualizarAconEst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarAconEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstudantePos estudanteSelecionado;
				try {
					estudanteSelecionado = sistema.buscaEstudantePos(Integer.valueOf(textSelecionarEst.getText()));
					estudanteSelecionado.setAconselhador(Integer.valueOf(textAconEstAT.getText()));
					sistema.atualizaEstudantePos(estudanteSelecionado);
					JOptionPane.showMessageDialog(null, "Dados do estudante atualizado com sucesso",
							"Atualizar Estudante", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse estudante",
							"Atualizar Estudante", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse estudante",
							"Atualizar Estudante", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarAconEst.setBounds(219, 322, 100, 25);
		panel_atualizar2.add(btnAtualizarAconEst);

		JLabel lblAtualizarEst7 = new JLabel("Insira a matrícula do estudante a ser atualizado:");
		lblAtualizarEst7.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarEst7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarEst7.setBounds(10, 42, 408, 30);
		panel_atualizar2.add(lblAtualizarEst7);

		textSelecionarEst = new JTextField();
		textSelecionarEst.setBounds(109, 76, 100, 25);
		panel_atualizar2.add(textSelecionarEst);
		textSelecionarEst.setColumns(10);

		JButton btnAtualizarEst = new JButton("Selecionar");
		btnAtualizarEst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstudantePos estudanteSelecionado;
				try {
					estudanteSelecionado = sistema.buscaEstudantePos(Integer.valueOf(textSelecionarEst.getText()));
					JOptionPane.showMessageDialog(null, estudanteSelecionado, "Visualizar Estudante",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null,
							"Não foi selecionar esse estudante, verifique se ele está cadastrado no banco.",
							"Atualizar Estudante", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarEst.setBounds(219, 74, 100, 25);
		panel_atualizar2.add(btnAtualizarEst);

		JLabel lblNewLabel_3 = new JLabel("Insira os dados a serem atualizados:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 111, 408, 21);
		panel_atualizar2.add(lblNewLabel_3);

		JPanel panel_excluir2 = new JPanel();
		tabbedPane_Estudante.addTab("Excluir", null, panel_excluir2, null);
		panel_excluir2.setLayout(null);

		JLabel lblExcluirEst = new JLabel("Você está na aba de excluir um estudante");
		lblExcluirEst.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirEst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExcluirEst.setBounds(10, 10, 408, 26);
		panel_excluir2.add(lblExcluirEst);

		JLabel lblExcluirEst2 = new JLabel("Digite a matrícula do estudante que deseja excluir:");
		lblExcluirEst2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExcluirEst2.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirEst2.setBounds(10, 40, 408, 26);
		panel_excluir2.add(lblExcluirEst2);

		textExcluirEst = new JTextField();
		textExcluirEst.setBounds(153, 76, 100, 25);
		panel_excluir2.add(textExcluirEst);
		textExcluirEst.setColumns(10);

		JButton btnExcluirEst = new JButton("Excluir");
		btnExcluirEst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluirEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstudantePos estudanteSelecionado;
				try {
					estudanteSelecionado = sistema.buscaEstudantePos(Integer.valueOf(textExcluirEst.getText()));
					if (estudanteSelecionado != null) {
						sistema.deletaEstudantePos(estudanteSelecionado);
						JOptionPane.showMessageDialog(null, "Estudante apagado com sucesso",
								"Apagar Estudante do Banco", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"Não foi possivel apagar estudante, verifique se ele está cadastrado no banco de dados",
								"Apagar Estudante do Banco", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException | SelectException | DeleteException e1) {
					JOptionPane.showMessageDialog(null,
							"Não foi possivel apagar estudante, verifique se ele ainda possui alguma relação de trabalho ou participação",
							"Apagar Estudante do Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnExcluirEst.setBounds(153, 111, 100, 25);
		panel_excluir2.add(btnExcluirEst);

		JPanel panel_exibir2 = new JPanel();
		tabbedPane_Estudante.addTab("Exibir", null, panel_exibir2, null);
		panel_exibir2.setLayout(null);

		JLabel lblExibirEst = new JLabel("Você está na aba para exibir todos os Estudantes");
		lblExibirEst.setHorizontalAlignment(SwingConstants.CENTER);
		lblExibirEst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExibirEst.setBounds(10, 10, 408, 28);
		panel_exibir2.add(lblExibirEst);

		JLabel lblExibirEst2 = new JLabel("Clique no botão para exibir todos os Estudantes");
		lblExibirEst2.setHorizontalAlignment(SwingConstants.CENTER);
		lblExibirEst2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExibirEst2.setBounds(10, 58, 408, 28);
		panel_exibir2.add(lblExibirEst2);

		JButton btnExibirEst = new JButton("Exibir");
		btnExibirEst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExibirEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<EstudantePos> estudantes;
				try {
					estudantes = sistema.buscaEstudantesPos();
					JTextPane textPane = new JTextPane();
					textPane.setBounds(33, 154, 373, 185);
					panel_exibir2.add(textPane);
					textPane.setText(estudantes.toString());
				} catch (SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível exibir estudantes", "Exibir Estudantes",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnExibirEst.setBounds(159, 98, 100, 25);
		panel_exibir2.add(btnExibirEst);

		// painel proj
		JPanel panel_proj = new JPanel();
		tabbedPane.addTab("Projetos", null, panel_proj, null);
		panel_proj.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		panel_proj.add(tabbedPane_1, BorderLayout.CENTER);

		JPanel panel_buscar3 = new JPanel();
		tabbedPane_1.addTab("Buscar", null, panel_buscar3, null);
		panel_buscar3.setLayout(null);

		JLabel lblBuscarProj = new JLabel("Você está na aba buscar um projeto");
		lblBuscarProj.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarProj.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBuscarProj.setBounds(10, 10, 408, 29);
		panel_buscar3.add(lblBuscarProj);

		JLabel lblBuscarProj2 = new JLabel("Para buscar um projeto é necessário inserir a id dele.");
		lblBuscarProj2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarProj2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscarProj2.setBounds(10, 49, 410, 21);
		panel_buscar3.add(lblBuscarProj2);

		textBuscarNum = new JTextField();
		textBuscarNum.setBounds(157, 126, 122, 30);
		panel_buscar3.add(textBuscarNum);
		textBuscarNum.setColumns(10);

		JButton btnBuscarProj = new JButton("Buscar");
		btnBuscarProj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscarProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Projeto projetoBuscado = sistema.buscaProjeto(Integer.valueOf(textBuscarNum.getText()));
					if (projetoBuscado != null) {
						JOptionPane.showMessageDialog(null, projetoBuscado, "Buscar Projeto no Banco",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"Não foi possível buscar esse projeto, verifique se ele está cadastrado no banco.",
								"Buscar Projeto", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível buscar esse projeto.", "Buscar Projeto",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnBuscarProj.setBounds(157, 180, 122, 30);
		panel_buscar3.add(btnBuscarProj);

		JLabel lblBuscarProj3 = new JLabel("Id do projeto:");
		lblBuscarProj3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarProj3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuscarProj3.setBounds(10, 85, 413, 21);
		panel_buscar3.add(lblBuscarProj3);

		JLabel lblBuscarProj4 = new JLabel("Lembre-se: Para buscar um projeto é necessário que ele");
		lblBuscarProj4.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarProj4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBuscarProj4.setBounds(10, 292, 408, 21);
		panel_buscar3.add(lblBuscarProj4);

		JLabel lblBuscarProj5 = new JLabel("já esteja cadastrado no sistema.");
		lblBuscarProj5.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarProj5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBuscarProj5.setBounds(10, 315, 408, 21);
		panel_buscar3.add(lblBuscarProj5);

		JPanel panel_inserir3 = new JPanel();
		tabbedPane_1.addTab("Inserir", null, panel_inserir3, null);
		panel_inserir3.setLayout(null);

		JLabel lblInserirProj = new JLabel("Você está na aba de cadastrar um novo Projeto");
		lblInserirProj.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblInserirProj.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirProj.setBounds(10, 10, 408, 26);
		panel_inserir3.add(lblInserirProj);

		JLabel lblInserirProj2 = new JLabel("Numero:");
		lblInserirProj2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirProj2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirProj2.setBounds(10, 57, 140, 20);
		panel_inserir3.add(lblInserirProj2);

		textNumProj = new JTextField();
		textNumProj.setBounds(155, 57, 100, 25);
		panel_inserir3.add(textNumProj);
		textNumProj.setColumns(10);

		JLabel lblInserirProj3 = new JLabel("Nome: ");
		lblInserirProj3.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirProj3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirProj3.setBounds(10, 99, 140, 20);
		panel_inserir3.add(lblInserirProj3);

		textNomeProj = new JTextField();
		textNomeProj.setBounds(155, 99, 100, 25);
		panel_inserir3.add(textNomeProj);
		textNomeProj.setColumns(10);

		JLabel lblInserirProj4 = new JLabel("Financiador:");
		lblInserirProj4.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirProj4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirProj4.setBounds(10, 141, 140, 20);
		panel_inserir3.add(lblInserirProj4);

		textFinanciadorProj = new JTextField();
		textFinanciadorProj.setBounds(155, 141, 100, 25);
		panel_inserir3.add(textFinanciadorProj);
		textFinanciadorProj.setColumns(10);

		JLabel lblInserirProj5 = new JLabel("Orçamento:");
		lblInserirProj5.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirProj5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirProj5.setBounds(10, 181, 140, 25);
		panel_inserir3.add(lblInserirProj5);

		textOrcamentoProj = new JTextField();
		textOrcamentoProj.setBounds(155, 183, 100, 25);
		panel_inserir3.add(textOrcamentoProj);
		textOrcamentoProj.setColumns(10);

		JLabel lblInserirProj6 = new JLabel("Data Inicial:");
		lblInserirProj6.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirProj6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirProj6.setBounds(10, 228, 140, 20);
		panel_inserir3.add(lblInserirProj6);

		textInicioProj = new JTextField();
		textInicioProj.setBounds(155, 228, 100, 25);
		panel_inserir3.add(textInicioProj);
		textInicioProj.setColumns(10);

		JLabel lblInserirProj7 = new JLabel("Data Final:");
		lblInserirProj7.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirProj7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirProj7.setBounds(10, 272, 140, 20);
		panel_inserir3.add(lblInserirProj7);

		textFimProj = new JTextField();
		textFimProj.setBounds(155, 272, 100, 25);
		panel_inserir3.add(textFimProj);
		textFimProj.setColumns(10);

		JLabel lblInserirProj8 = new JLabel("Pesquisador Principal:\r\n");
		lblInserirProj8.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserirProj8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInserirProj8.setBounds(10, 317, 140, 20);
		panel_inserir3.add(lblInserirProj8);

		textPesquisadorProj = new JTextField();
		textPesquisadorProj.setBounds(155, 315, 100, 25);
		panel_inserir3.add(textPesquisadorProj);
		textPesquisadorProj.setColumns(10);

		JButton btnCadastrarProj = new JButton("Cadastrar");
		btnCadastrarProj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrarProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto proj = new Projeto();
				proj.setNumero(Integer.valueOf(textNumProj.getText()));
				proj.setNome_proj(textNomeProj.getText());
				proj.setFinanciador(textFinanciadorProj.getText());
				proj.setOrcamento(Double.valueOf(textOrcamentoProj.getText()));
				proj.setData_inicio(textInicioProj.getText());
				proj.setData_final(textFimProj.getText());
				proj.setPesquisador_principal(Integer.valueOf(textPesquisadorProj.getText()));

				try {
					sistema.insereProjeto(proj);
					JOptionPane.showMessageDialog(null, "Projeto cadastrado com sucesso", "Buscar Professores no Banco",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (InsertException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar esse projeto",
							"Cadastrar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar esse projeto",
							"Cadastrar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar esse projeto",
							"Cadastrar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnCadastrarProj.setBounds(318, 342, 100, 25);
		panel_inserir3.add(btnCadastrarProj);

		JPanel panel_atualizar3 = new JPanel();
		tabbedPane_1.addTab("Atualizar", null, panel_atualizar3, null);
		panel_atualizar3.setLayout(null);

		JLabel lblAtualizarProj = new JLabel("Você está na aba de atualizar um projeto");
		lblAtualizarProj.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarProj.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAtualizarProj.setBounds(10, 10, 408, 27);
		panel_atualizar3.add(lblAtualizarProj);

		JLabel lblAtualizarProj2 = new JLabel("Insira o numero do projeto a ser atualizado:\r\n");
		lblAtualizarProj2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtualizarProj2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarProj2.setBounds(10, 36, 408, 27);
		panel_atualizar3.add(lblAtualizarProj2);

		textBuscarAT = new JTextField();
		textBuscarAT.setBounds(100, 70, 100, 25);
		panel_atualizar3.add(textBuscarAT);
		textBuscarAT.setColumns(10);

		JButton btnSelecionarEst = new JButton("Selecionar");
		btnSelecionarEst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSelecionarEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto projetoSelecionado;
				try {
					projetoSelecionado = sistema.buscaProjeto(Integer.valueOf(textBuscarAT.getText()));
					if (projetoSelecionado != null) {
						JOptionPane.showMessageDialog(null, projetoSelecionado, "Visualizar Projeto",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"Não foi possível selecionar esse projeto, verifique se ele está cadastrado no banco.",
								"Visualizar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					}
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível visualizar esse projeto",
							"Visualizar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnSelecionarEst.setBounds(210, 70, 100, 25);
		panel_atualizar3.add(btnSelecionarEst);

		JLabel lblAtualizarProj3 = new JLabel("Nome:");
		lblAtualizarProj3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarProj3.setBounds(10, 130, 140, 20);
		panel_atualizar3.add(lblAtualizarProj3);

		textNomeProjAT = new JTextField();
		textNomeProjAT.setBounds(155, 130, 100, 25);
		panel_atualizar3.add(textNomeProjAT);
		textNomeProjAT.setColumns(10);

		JButton btnAtualizarNomeProj = new JButton("Atualizar");
		btnAtualizarNomeProj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarNomeProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto projetoSelecionado;
				try {
					projetoSelecionado = sistema.buscaProjeto(Integer.valueOf(textBuscarAT.getText()));
					projetoSelecionado.setNome_proj(textNomeProjAT.getText());
					sistema.atualizaProjeto(projetoSelecionado);
					JOptionPane.showMessageDialog(null, "Dados do projeto atualizado com sucesso", "Atualizar Projeto",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse projeto",
							"Atualizar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse projeto",
							"Atualizar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarNomeProj.setBounds(265, 130, 100, 25);
		panel_atualizar3.add(btnAtualizarNomeProj);

		JLabel lblAtualizarProj4 = new JLabel("Financiador");
		lblAtualizarProj4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarProj4.setBounds(10, 170, 140, 20);
		panel_atualizar3.add(lblAtualizarProj4);

		textFinanciadorProjAT = new JTextField();
		textFinanciadorProjAT.setBounds(155, 170, 100, 25);
		panel_atualizar3.add(textFinanciadorProjAT);
		textFinanciadorProjAT.setColumns(10);

		JButton btnAtualizarFinanProj = new JButton("Atualizar");
		btnAtualizarFinanProj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarFinanProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto projetoSelecionado;
				try {
					projetoSelecionado = sistema.buscaProjeto(Integer.valueOf(textBuscarAT.getText()));
					projetoSelecionado.setFinanciador(textFinanciadorProjAT.getText());
					sistema.atualizaProjeto(projetoSelecionado);
					JOptionPane.showMessageDialog(null, "Dados do projeto atualizado com sucesso", "Atualizar Projeto",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse projeto",
							"Atualizar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse projeto",
							"Atualizar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarFinanProj.setBounds(265, 170, 100, 25);
		panel_atualizar3.add(btnAtualizarFinanProj);

		JLabel lblAtualizarProj5 = new JLabel("Orcamento:");
		lblAtualizarProj5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarProj5.setBounds(10, 204, 140, 20);
		panel_atualizar3.add(lblAtualizarProj5);

		textOrcamentoProjAT = new JTextField();
		textOrcamentoProjAT.setBounds(155, 210, 100, 25);
		panel_atualizar3.add(textOrcamentoProjAT);
		textOrcamentoProjAT.setColumns(10);

		JButton btnAtualizarOrcaProj = new JButton("Atualizar");
		btnAtualizarOrcaProj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarOrcaProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto projetoSelecionado;
				try {
					projetoSelecionado = sistema.buscaProjeto(Integer.valueOf(textBuscarAT.getText()));
					projetoSelecionado.setOrcamento(Double.valueOf(textOrcamentoProjAT.getText()));
					sistema.atualizaProjeto(projetoSelecionado);
					JOptionPane.showMessageDialog(null, "Dados do projeto atualizado com sucesso", "Atualizar Projeto",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse projeto",
							"Atualizar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse projeto",
							"Atualizar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarOrcaProj.setBounds(265, 210, 100, 25);
		panel_atualizar3.add(btnAtualizarOrcaProj);

		JLabel lblAtualizarProj6 = new JLabel("Data Inicial:");
		lblAtualizarProj6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarProj6.setBounds(10, 252, 140, 20);
		panel_atualizar3.add(lblAtualizarProj6);

		textInicioProjAT = new JTextField();
		textInicioProjAT.setBounds(155, 250, 100, 25);
		panel_atualizar3.add(textInicioProjAT);
		textInicioProjAT.setColumns(10);

		JButton btnAtualizarInicioProj = new JButton("Atualizar");
		btnAtualizarInicioProj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarInicioProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto projetoSelecionado;
				try {
					projetoSelecionado = sistema.buscaProjeto(Integer.valueOf(textBuscarAT.getText()));
					projetoSelecionado.setData_inicio(textInicioProjAT.getText());
					sistema.atualizaProjeto(projetoSelecionado);
					JOptionPane.showMessageDialog(null, "Dados do projeto atualizado com sucesso", "Atualizar Projeto",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse projeto",
							"Atualizar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse projeto",
							"Atualizar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarInicioProj.setBounds(265, 250, 100, 25);
		panel_atualizar3.add(btnAtualizarInicioProj);

		JLabel lblAtualizarProj7 = new JLabel("Data Final:");
		lblAtualizarProj7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarProj7.setBounds(10, 299, 140, 20);
		panel_atualizar3.add(lblAtualizarProj7);

		textFimProjAT = new JTextField();
		textFimProjAT.setBounds(155, 290, 100, 25);
		panel_atualizar3.add(textFimProjAT);
		textFimProjAT.setColumns(10);

		JButton btnAtualizarFimProj = new JButton("Atualizar");
		btnAtualizarFimProj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarFimProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto projetoSelecionado;
				try {
					projetoSelecionado = sistema.buscaProjeto(Integer.valueOf(textBuscarAT.getText()));
					projetoSelecionado.setData_final(textFimProjAT.getText());
					sistema.atualizaProjeto(projetoSelecionado);
					JOptionPane.showMessageDialog(null, "Dados do projeto atualizado com sucesso", "Atualizar Projeto",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse projeto",
							"Atualizar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse projeto",
							"Atualizar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarFimProj.setBounds(265, 290, 100, 25);
		panel_atualizar3.add(btnAtualizarFimProj);

		JLabel lblAtualizarProj8 = new JLabel("Pesquisador Principal:");
		lblAtualizarProj8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtualizarProj8.setBounds(10, 332, 140, 20);
		panel_atualizar3.add(lblAtualizarProj8);

		textProfPrincAT = new JTextField();
		textProfPrincAT.setBounds(155, 330, 100, 25);
		panel_atualizar3.add(textProfPrincAT);
		textProfPrincAT.setColumns(10);

		JButton btnAtualizarPesquisadorProj = new JButton("Atualizar");
		btnAtualizarPesquisadorProj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarPesquisadorProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto projetoSelecionado;
				try {
					projetoSelecionado = sistema.buscaProjeto(Integer.valueOf(textBuscarAT.getText()));
					projetoSelecionado.setPesquisador_principal(Integer.valueOf(textProfPrincAT.getText()));
					sistema.atualizaProjeto(projetoSelecionado);
					JOptionPane.showMessageDialog(null, "Dados do projeto atualizado com sucesso", "Atualizar Projeto",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse projeto",
							"Atualizar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (UpdateException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível atualizar esse projeto",
							"Atualizar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnAtualizarPesquisadorProj.setBounds(265, 331, 100, 25);
		panel_atualizar3.add(btnAtualizarPesquisadorProj);

		JPanel panel_excluir3 = new JPanel();
		tabbedPane_1.addTab("Excluir", null, panel_excluir3, null);
		panel_excluir3.setLayout(null);

		JLabel lblExcluirProj = new JLabel("Você está na aba para excluir um projeto");
		lblExcluirProj.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirProj.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExcluirProj.setBounds(10, 10, 408, 30);
		panel_excluir3.add(lblExcluirProj);

		textNumProjExcluir = new JTextField();
		textNumProjExcluir.setBounds(152, 90, 100, 25);
		panel_excluir3.add(textNumProjExcluir);
		textNumProjExcluir.setColumns(10);

		JLabel lblNewLabel = new JLabel("Digite o número do projeto que deseja excluir:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 50, 408, 30);
		panel_excluir3.add(lblNewLabel);

		JButton btnExcluirProj = new JButton("Excluir");
		btnExcluirProj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluirProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Projeto projetoSelecionado;
				try {
					projetoSelecionado = sistema.buscaProjeto(Integer.valueOf(textNumProjExcluir.getText()));
					if (projetoSelecionado != null) {
						sistema.deletaProjeto(projetoSelecionado);
						JOptionPane.showMessageDialog(null, "Projeto apagado com sucesso", "Apagar Projeto do Banco",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"Não foi possível apagar esse projeto, verifique se ele está cadastrado no banco.",
								"Apagar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					}

				} catch (NumberFormatException | SelectException | DeleteException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível apagar esse projeto",
							"Apagar Projeto no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnExcluirProj.setBounds(152, 125, 100, 25);
		panel_excluir3.add(btnExcluirProj);

		JPanel panel_exibir3 = new JPanel();
		tabbedPane_1.addTab("Exibir", null, panel_exibir3, null);
		panel_exibir3.setLayout(null);

		JLabel lblExibirProj = new JLabel("Você está na aba exibir dados de um Projeto\r\n");
		lblExibirProj.setHorizontalAlignment(SwingConstants.CENTER);
		lblExibirProj.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExibirProj.setBounds(10, 10, 408, 21);
		panel_exibir3.add(lblExibirProj);

		JButton btnExibirProj = new JButton("Exibir");
		btnExibirProj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExibirProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Projeto> projetos;
				try {
					projetos = sistema.buscaProjetos();
					JTextPane textPane = new JTextPane();
					textPane.setBounds(10, 206, 408, 161);
					panel_exibir3.add(textPane);
					textPane.setText(projetos.toString());
				} catch (SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível exibir projetos", "Exibir Projeto no Banco",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnExibirProj.setBounds(323, 56, 95, 27);
		panel_exibir3.add(btnExibirProj);

		JLabel lblExibirProj2 = new JLabel("Todos os projetos");
		lblExibirProj2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExibirProj2.setBounds(10, 57, 237, 26);
		panel_exibir3.add(lblExibirProj2);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 206, 408, 161);
		panel_exibir3.add(textPane);

		JLabel lblExibirProj3 = new JLabel("Alunos de um projeto");
		lblExibirProj3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExibirProj3.setBounds(10, 106, 286, 27);
		panel_exibir3.add(lblExibirProj3);

		JLabel lblExibirProj4 = new JLabel("Professores de um projeto");
		lblExibirProj4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExibirProj4.setBounds(10, 156, 237, 27);
		panel_exibir3.add(lblExibirProj4);

		JButton btnExibirEstProj = new JButton("Exibir");
		btnExibirEstProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				List<Object> lista;
				try {
					lista = sistema.exibeEstProj();
					for (Object linha : lista) {
						Object[] arrayLinha = (Object[]) linha;
						for (Object valor : arrayLinha) {
							sb.append("- ").append(valor);
						}
						sb.append("\n");
					}
					JTextPane textPane = new JTextPane();
					textPane.setBounds(10, 206, 408, 161);
					panel_exibir3.add(textPane);
					textPane.setText(sb.toString());
				} catch (SelectException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnExibirEstProj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExibirEstProj.setBounds(323, 106, 95, 27);
		panel_exibir3.add(btnExibirEstProj);

		JButton btnExibirEstProfProj = new JButton("Exibir");
		btnExibirEstProfProj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExibirEstProfProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				List<Object> lista;
				try {
					lista = sistema.exibeProfProj();
					for (Object linha : lista) {
						Object[] arrayLinha = (Object[]) linha;
						for (Object valor : arrayLinha) {
							sb.append("- ").append(valor);
						}
						sb.append("\n");
					}
					JTextPane textPane = new JTextPane();
					textPane.setBounds(10, 206, 408, 161);
					panel_exibir3.add(textPane);
					textPane.setText(sb.toString());
				} catch (SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível exibir projetos", "Exibir Projeto no Banco",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnExibirEstProfProj.setBounds(323, 156, 95, 27);
		panel_exibir3.add(btnExibirEstProfProj);

		JPanel panel_prof1 = new JPanel();
		tabbedPane_1.addTab("Professores", null, panel_prof1, null);
		panel_prof1.setLayout(null);

		JLabel lblProfProj = new JLabel("Você está na aba de Professores");
		lblProfProj.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfProj.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProfProj.setBounds(10, 10, 408, 33);
		panel_prof1.add(lblProfProj);

		JLabel lblProfProj2 = new JLabel("Insira os dados para inserir um professor a um projeto");
		lblProfProj2.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfProj2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfProj2.setBounds(10, 45, 408, 26);
		panel_prof1.add(lblProfProj2);

		JLabel lblProfProj3 = new JLabel("Matricula do professor:");
		lblProfProj3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfProj3.setBounds(10, 92, 160, 20);
		panel_prof1.add(lblProfProj3);

		mat_profP = new JTextField();
		mat_profP.setBounds(180, 92, 100, 25);
		panel_prof1.add(mat_profP);
		mat_profP.setColumns(10);

		JLabel lblProfProj4 = new JLabel("Numero do projeto:");
		lblProfProj4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfProj4.setBounds(10, 137, 140, 20);
		panel_prof1.add(lblProfProj4);

		num_projP = new JTextField();
		num_projP.setBounds(180, 137, 100, 25);
		panel_prof1.add(num_projP);
		num_projP.setColumns(10);

		JButton btnInserirProfProj = new JButton("Inserir");
		btnInserirProfProj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInserirProfProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParticipaProfessor pp = new ParticipaProfessor();
				pp.setProfessor_participante(Integer.valueOf(mat_profP.getText()));
				pp.setProjeto_numero(Integer.valueOf(num_projP.getText()));
				try {
					sistema.insereParticipaProfessor(pp);
					JOptionPane.showMessageDialog(null, "Relação participa professor cadastrada com sucesso.",
							"Buscar Professores no Banco", JOptionPane.INFORMATION_MESSAGE);

				} catch (InsertException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível adicionar o professor ao projeto.",
							"Cadastrar Relação no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível adicionar o professor ao projeto.",
							"Cadastrar Relação no Banco", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnInserirProfProj.setBounds(306, 171, 100, 25);
		panel_prof1.add(btnInserirProfProj);

		JLabel lblInsiraOsDados = new JLabel("Insira os dados para remover um professor de um projeto");
		lblInsiraOsDados.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInsiraOsDados.setBounds(10, 206, 408, 26);
		panel_prof1.add(lblInsiraOsDados);

		JLabel lblProfProj3_1 = new JLabel("Id da participação do professor:\r\n");
		lblProfProj3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfProj3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProfProj3_1.setBounds(10, 250, 408, 20);
		panel_prof1.add(lblProfProj3_1);

		excluirParticipacao = new JTextField();
		excluirParticipacao.setColumns(10);
		excluirParticipacao.setBounds(160, 280, 100, 25);
		panel_prof1.add(excluirParticipacao);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParticipaProfessor participacaoSelecionada;
				try {
					participacaoSelecionada = sistema
							.buscaParticipaProfessor(Integer.valueOf(excluirParticipacao.getText()));
					JOptionPane.showMessageDialog(null, participacaoSelecionada, "Visualizar Participação",
							JOptionPane.INFORMATION_MESSAGE);
					sistema.deletaParticipaProfessor(participacaoSelecionada);
					JOptionPane.showMessageDialog(null, "Relação apagada com sucesso", "Apagar Relação do Banco",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (NumberFormatException | SelectException | DeleteException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível apagar Relação.", "Apagar Relação no Banco",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();

				}
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir.setBounds(160, 315, 100, 25);
		panel_prof1.add(btnExcluir);

		JPanel panel_est1 = new JPanel();
		tabbedPane_1.addTab("Estudantes", null, panel_est1, null);
		panel_est1.setLayout(null);

		JLabel lblEstProj = new JLabel("Você está na aba de Estudante");
		lblEstProj.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstProj.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstProj.setBounds(10, 10, 408, 27);
		panel_est1.add(lblEstProj);

		JLabel lblEstProj2 = new JLabel("Insira os dados para inserir um estudante a um projeto");
		lblEstProj2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstProj2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstProj2.setBounds(10, 35, 408, 27);
		panel_est1.add(lblEstProj2);

		JLabel lblEstProj3 = new JLabel("Matricula do Estudante:");
		lblEstProj3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstProj3.setBounds(10, 72, 160, 20);
		panel_est1.add(lblEstProj3);

		mat_estP = new JTextField();
		mat_estP.setBounds(209, 72, 100, 25);
		panel_est1.add(mat_estP);
		mat_estP.setColumns(10);

		JLabel lblEstProj4 = new JLabel("Número do projeto:");
		lblEstProj4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstProj4.setBounds(10, 112, 160, 20);
		panel_est1.add(lblEstProj4);

		num_projE = new JTextField();
		num_projE.setBounds(209, 107, 100, 25);
		panel_est1.add(num_projE);
		num_projE.setColumns(10);

		JLabel lblEstProj5 = new JLabel("Professor supervisor:");
		lblEstProj5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstProj5.setBounds(10, 147, 160, 20);
		panel_est1.add(lblEstProj5);

		mat_prof_supervisor = new JTextField();
		mat_prof_supervisor.setBounds(209, 142, 100, 25);
		panel_est1.add(mat_prof_supervisor);
		mat_prof_supervisor.setColumns(10);

		JButton btnInserirEstProj = new JButton("Inserir");
		btnInserirEstProj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInserirEstProj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParticipaAluno pa = new ParticipaAluno();
				pa.setAluno_participante(Integer.valueOf(mat_estP.getText()));
				pa.setProjeto_numero(Integer.valueOf(num_projE.getText()));
				pa.setProf_supervisor(Integer.valueOf(mat_prof_supervisor.getText()));
				try {
					sistema.insereParticipaAluno(pa);
					JOptionPane.showMessageDialog(null, "Relação Participa Aluno cadastrada com sucesso",
							"Cadastrar Relação", JOptionPane.INFORMATION_MESSAGE);

				} catch (InsertException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível adicionar estudante ao projeto",
							"Cadastrar Relação", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (SelectException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível adicionar estudante ao projeto",
							"Cadastrar Relação", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnInserirEstProj.setBounds(318, 176, 100, 25);
		panel_est1.add(btnInserirEstProj);

		JLabel lblInsiraOsDados_1 = new JLabel("Insira os dados para excluir um estudante de um projeto");
		lblInsiraOsDados_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraOsDados_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInsiraOsDados_1.setBounds(10, 211, 408, 27);
		panel_est1.add(lblInsiraOsDados_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(167, 287, 100, 25);
		panel_est1.add(textField_3);

		JButton btnExcluir_1 = new JButton("Excluir");
		btnExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParticipaAluno participacaoSelecionada;
				try {
					participacaoSelecionada = sistema.buscaParticipaAluno(Integer.valueOf(textField_3.getText()));
					JOptionPane.showMessageDialog(null, participacaoSelecionada, "Visualizar Participação",
							JOptionPane.INFORMATION_MESSAGE);
					sistema.deletaParticipaAluno(participacaoSelecionada);
					JOptionPane.showMessageDialog(null, "Relação apagada com sucesso", "Apagar Relação do Banco",
							JOptionPane.INFORMATION_MESSAGE);

				} catch (NumberFormatException | SelectException | DeleteException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível apagar Relação.", "Apagar Relação no Banco",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();

				}
			}
		});
		btnExcluir_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluir_1.setBounds(167, 322, 100, 25);
		panel_est1.add(btnExcluir_1);

		JLabel lblEstProj3_1 = new JLabel("Id da participação do Estudante:");
		lblEstProj3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstProj3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstProj3_1.setBounds(10, 248, 408, 25);
		panel_est1.add(lblEstProj3_1);
	}
}
