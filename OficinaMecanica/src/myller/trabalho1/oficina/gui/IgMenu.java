package myller.trabalho1.oficina.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import myller.trabalho1.oficina.Oficina;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.TitledBorder;

/**
 * Cria a interface gráfica e suas operações
 * 
 * @author Luiz Myller Vidal
 * @version 0.1
 */
public class IgMenu extends JDialog {

	/**
	 * Cria e exibe a interface gráfica do menu principal
	 * 
	 * @param oficina Referência de um objeto <code>Oficina</code>
	 */
	public IgMenu(Oficina oficina) {
		setResizable(false);
		setTitle("Menu");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setBounds(100, 100, 393, 271);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton sairlButton = new JButton("Sair");
		sairlButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		sairlButton.setMnemonic(KeyEvent.VK_S);
		sairlButton.setActionCommand("Cancel");
		buttonPane.add(sairlButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton clienteEAutomovelButton = new JButton("Cliente e Automóvel");
		clienteEAutomovelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IgClienteEAutomovel(oficina);
			}
		});
		clienteEAutomovelButton.setMnemonic(KeyEvent.VK_C);
		clienteEAutomovelButton.setBounds(97, 21, 183, 28);
		panel.add(clienteEAutomovelButton);
		clienteEAutomovelButton.setActionCommand("OK");
		getRootPane().setDefaultButton(clienteEAutomovelButton);
		
		JButton ordemDeServicoButton = new JButton("Ordem de Serviço");
		ordemDeServicoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IgOrdemDeServico(oficina);
			}
		});
		ordemDeServicoButton.setMnemonic(KeyEvent.VK_O);
		ordemDeServicoButton.setBounds(97, 81, 183, 28);
		panel.add(ordemDeServicoButton);
		
		JButton relatorioFinanceiroButton = new JButton("Relatório Financeiro");
		relatorioFinanceiroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IgRelatorioFinanceiro(oficina);
			}
		});
		relatorioFinanceiroButton.setMnemonic(KeyEvent.VK_R);
		relatorioFinanceiroButton.setBounds(97, 142, 183, 28);
		panel.add(relatorioFinanceiroButton);
		
		// Ativa o look-and-feel Nimbus.
		ativarLookAndFeel(new NimbusLookAndFeel());
		setVisible(true);
	}

	/**
	 *  Ativa o look-and-feel em todos os componentes da da caixa de diálogo.
	 *  Retorna true se o look-and-feel foi ativado ou false caso contrário.
	 */
	private boolean ativarLookAndFeel(LookAndFeel  lookAndFeel ) {
		try { 
			UIManager.setLookAndFeel(lookAndFeel);
			SwingUtilities.updateComponentTreeUI(this);
					
		} catch (UnsupportedLookAndFeelException e) {
			System.err.printf("Não foi possível ativar o look-and-fell %s.", lookAndFeel.getName());
			return false;
		}
		return true;
	}
}
