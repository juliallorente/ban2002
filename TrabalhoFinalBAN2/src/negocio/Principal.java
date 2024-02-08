package negocio;
import javax.swing.JFrame;

import apresentacao.TelaEntrada;
import apresentacao.TelaPrincipal;
import exception.InsertException;
import exception.SelectException;
public class Principal {
	
	private static JFrame janelaAtual;

	public static void main(String[] args) throws SelectException, InsertException {
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
		
		abrirTelaEntrada();

	}
	
	public static void abrirTelaPrincipal() {
		fecharJanelaAtual();
		janelaAtual = new TelaPrincipal();
		janelaAtual.setVisible(true);
	}
	
	public static void fecharJanelaAtual() {
		if (janelaAtual != null) {
			janelaAtual.setVisible(false);
			janelaAtual.dispose();
			janelaAtual = null;
		}
	}
	
	public static void abrirTelaEntrada() {
		fecharJanelaAtual();
		janelaAtual = new TelaEntrada();
		janelaAtual.setVisible(true);
	}
}

