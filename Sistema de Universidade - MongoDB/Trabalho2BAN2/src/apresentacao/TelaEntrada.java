package apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import negocio.Principal;

import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEntrada extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Window".equals(info.getName())) {
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
					TelaEntrada frame = new TelaEntrada();
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
	public TelaEntrada() {
		setTitle("Sistema de Controle de Universidade");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(3, 14, 73));
		panel.setBounds(0, 0, 304, 401);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Bem-Vindo, Administrador!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));

		lblNewLabel_1.setBounds(10, 56, 284, 44);
		panel.add(lblNewLabel_1);

		JButton btnAcessar = new JButton("Acessar Sistema");
		btnAcessar.setForeground(Color.WHITE);
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal.abrirTelaPrincipal();

			}
		});
		btnAcessar.setBackground(new Color(0, 0, 23));
		btnAcessar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAcessar.setBounds(0, 267, 304, 56);
		btnAcessar.setFocusable(false);
		btnAcessar.setBorderPainted(false);
		btnAcessar.setFocusPainted(false);
		btnAcessar.setBackground(new Color(4, 16, 83));
		panel.add(btnAcessar);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaEntrada.class.getResource("/imagens/imagem1 (1).png")));
		lblNewLabel.setBounds(309, 68, 401, 352);
		contentPane.add(lblNewLabel);
	}
}
