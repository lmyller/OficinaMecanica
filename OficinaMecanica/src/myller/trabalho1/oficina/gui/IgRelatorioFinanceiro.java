package myller.trabalho1.oficina.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import myller.trabalho1.oficina.Oficina;
import myller.trabalho1.oficina.OrdemDeServico;
import myller.trabalho1.oficina.Receita;

/**
 * Cria a interface gráfica e suas operações
 * 
 * @author Luiz Myller Vidal
 * @version 0.1
 */
public class IgRelatorioFinanceiro extends JDialog implements Receita{

	private static final String TITULO = "Relatório Financeiro";
	
	private final JPanel contentPanel = new JPanel();
	private JTextField dataInicialTextField;
	private JTextField dataFinalTextField;
	private JTable servicosTable;
	private JTable pecasTable;
	private JTextField receitaComServicosTextField;
	private JTextField receitaComPecasTextField;
	private JTextField receitaTotalTextField;
	private Oficina oficina;
	private DefaultTableModel defaultTableModelPecas;
	private DefaultTableModel defaultTableModelServicos;

	/**
	 * Cria e exibe a interface gráfica do relatório financeiro 
	 * 
	 * @param oficina Referência de um objeto <code>Oficina</code>
	 */
	public IgRelatorioFinanceiro(Oficina oficina) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.oficina = oficina;
		
		setResizable(false);
		setTitle("Relatório Financeiro");
		setBounds(100, 100, 713, 595);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel periodoPanel = new JPanel();
		periodoPanel.setBounds(6, 6, 685, 72);
		periodoPanel.setBorder(new TitledBorder(null, "Per\u00EDodo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(periodoPanel);
		periodoPanel.setLayout(null);
		
		JLabel dataInicialLabel = new JLabel("Data inicial:");
		dataInicialLabel.setDisplayedMnemonic(KeyEvent.VK_I);
		dataInicialLabel.setBounds(28, 28, 64, 16);
		periodoPanel.add(dataInicialLabel);
		
		dataInicialTextField = new JTextField();
		dataInicialTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarRelatorio();
			}
		});
		dataInicialLabel.setLabelFor(dataInicialTextField);
		dataInicialTextField.setBounds(98, 22, 122, 28);
		periodoPanel.add(dataInicialTextField);
		dataInicialTextField.setColumns(10);
		
		JLabel dataFinalLabel = new JLabel("Data final:");
		dataFinalLabel.setDisplayedMnemonic(KeyEvent.VK_F);
		dataFinalLabel.setBounds(232, 28, 55, 16);
		periodoPanel.add(dataFinalLabel);
		
		dataFinalTextField = new JTextField();
		dataFinalTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarRelatorio();
			}
		});
		dataFinalLabel.setLabelFor(dataFinalTextField);
		dataFinalTextField.setBounds(299, 22, 122, 28);
		periodoPanel.add(dataFinalTextField);
		dataFinalTextField.setColumns(10);
		
		JButton gerarRelatorioButton = new JButton("Gerar relatório");
		gerarRelatorioButton.setToolTipText("Gera um relatório da data especificada");
		gerarRelatorioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarRelatorio();
			}
		});
		gerarRelatorioButton.setMnemonic(KeyEvent.VK_G);
		gerarRelatorioButton.setBounds(433, 22, 127, 28);
		periodoPanel.add(gerarRelatorioButton);
		
		JPanel servicosPanel = new JPanel();
		servicosPanel.setBorder(new TitledBorder(null, "Servi\u00E7os", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		servicosPanel.setBounds(6, 90, 685, 133);
		contentPanel.add(servicosPanel);
		servicosPanel.setLayout(null);
		
		JScrollPane servicosScrollPane = new JScrollPane();
		servicosScrollPane.setBounds(27, 23, 634, 105);
		servicosPanel.add(servicosScrollPane);
		
		servicosTable = new JTable();
		servicosTable.setShowVerticalLines(true);
		servicosTable.setShowHorizontalLines(true);
		servicosScrollPane.setViewportView(servicosTable);
		defaultTableModelServicos = new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				/*{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},*/
			},
			new String[] {
				"Descri\u00E7\u00E3o", "Pre\u00E7o Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		servicosTable.setModel(defaultTableModelServicos);
		servicosTable.getColumnModel().getColumn(0).setResizable(false);
		servicosTable.getColumnModel().getColumn(0).setPreferredWidth(489);
		servicosTable.getColumnModel().getColumn(1).setResizable(false);
		servicosTable.getColumnModel().getColumn(1).setPreferredWidth(115);
		
		JPanel pecasPanel = new JPanel();
		pecasPanel.setBorder(new TitledBorder(null, "Pe\u00E7as", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pecasPanel.setBounds(6, 242, 685, 138);
		contentPanel.add(pecasPanel);
		pecasPanel.setLayout(null);
		
		JScrollPane pecasScrollPane = new JScrollPane();
		pecasScrollPane.setBounds(27, 25, 633, 107);
		pecasPanel.add(pecasScrollPane);
		
		pecasTable = new JTable();
		pecasScrollPane.setViewportView(pecasTable);
		pecasTable.setShowVerticalLines(true);
		pecasTable.setShowHorizontalLines(true);
		defaultTableModelPecas = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				/*{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},*/
			},
			new String[] {
				"Descri\u00E7\u00E3o", "Quantidade", "Valor Unit\u00E1rio", "Valor Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		pecasTable.setModel(defaultTableModelPecas);
		pecasTable.getColumnModel().getColumn(0).setResizable(false);
		pecasTable.getColumnModel().getColumn(0).setPreferredWidth(297);
		pecasTable.getColumnModel().getColumn(1).setResizable(false);
		pecasTable.getColumnModel().getColumn(1).setPreferredWidth(96);
		pecasTable.getColumnModel().getColumn(2).setResizable(false);
		pecasTable.getColumnModel().getColumn(2).setPreferredWidth(107);
		pecasTable.getColumnModel().getColumn(3).setResizable(false);
		pecasTable.getColumnModel().getColumn(3).setPreferredWidth(102);
		
		JPanel receitaPanel = new JPanel();
		receitaPanel.setBorder(new TitledBorder(null, "Receita", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		receitaPanel.setBounds(6, 392, 685, 130);
		contentPanel.add(receitaPanel);
		receitaPanel.setLayout(null);
		
		JLabel receitaComServicosLabel = new JLabel("Receita com serviços:");
		receitaComServicosLabel.setDisplayedMnemonic(KeyEvent.VK_S);
		receitaComServicosLabel.setBounds(31, 26, 122, 16);
		receitaPanel.add(receitaComServicosLabel);
		
		receitaComServicosTextField = new JTextField();
		receitaComServicosTextField.setEditable(false);
		receitaComServicosTextField.setBounds(155, 20, 122, 28);
		receitaPanel.add(receitaComServicosTextField);
		receitaComServicosTextField.setColumns(10);
		receitaComServicosTextField.setText("R$ 0,00");
		
		JLabel receitaComPecasLabel = new JLabel("Receita com peças:");
		receitaComPecasLabel.setDisplayedMnemonic(KeyEvent.VK_P);
		receitaComPecasLabel.setBounds(44, 59, 109, 16);
		receitaPanel.add(receitaComPecasLabel);
		
		receitaComPecasTextField = new JTextField();
		receitaComPecasTextField.setEditable(false);
		receitaComPecasTextField.setBounds(155, 53, 122, 28);
		receitaPanel.add(receitaComPecasTextField);
		receitaComPecasTextField.setColumns(10);
		receitaComPecasTextField.setText("R$ 0,00");
		
		JLabel receitaTotalLabel = new JLabel("Receita Total:");
		receitaTotalLabel.setDisplayedMnemonic(KeyEvent.VK_R);
		receitaTotalLabel.setBounds(78, 93, 75, 16);
		receitaPanel.add(receitaTotalLabel);
		
		receitaTotalTextField = new JTextField();
		receitaTotalTextField.setEditable(false);
		receitaTotalTextField.setBounds(155, 87, 122, 28);
		receitaPanel.add(receitaTotalTextField);
		receitaTotalTextField.setColumns(10);
		receitaTotalTextField.setText("R$ 0,00");
	
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.setToolTipText("Limpa os dados");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparComponentes();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.setToolTipText("Volta para o menu principal");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		cancelarButton.setActionCommand("Cancel");
		buttonPane.add(cancelarButton);
	
		setVisible(true);
	}
	
	private void cancelar() {
		this.dispose();
	}

	/**
	 * Limpa os componentes e coloca valores default para as receitas
	 */
	private void limparComponentes() {
		dataInicialTextField.setText("");
		dataFinalTextField.setText("");
		
		limparTabelaPecas();
		limparTabelaServicos();
		
		receitaComPecasTextField.setText("R$ 0,00");
		receitaComServicosTextField.setText("R$ 0,00");
		receitaTotalTextField.setText("R$ 0,00");
		
		dataInicialTextField.requestFocus();
	}
	
	/**
	 * Limpa tabela de peças
	 */
	private void limparTabelaPecas() {
		for(int linha = 0;linha < defaultTableModelPecas.getRowCount();linha++) {
			defaultTableModelPecas.setValueAt(null, linha, 0);
			defaultTableModelPecas.setValueAt(null, linha, 1);
			defaultTableModelPecas.setValueAt(null, linha, 2);
			defaultTableModelPecas.setValueAt(null, linha, 3);
		}
	}
	
	/**
	 * Limpa a tabela de serviços
	 */
	private void limparTabelaServicos() {
		for(int linha = 0;linha < defaultTableModelServicos.getRowCount();linha++) {
			defaultTableModelServicos.setValueAt(null, linha, 0);
			defaultTableModelServicos.setValueAt(null, linha, 1);
		}
	}

	/**
	 * Gera o relatório a partir das datas informadas
	 */
	private void gerarRelatorio() {
		String dataInicial = dataInicialTextField.getText().toString().trim(), dataFinal = dataFinalTextField.getText().toString().trim();
		
		//Verifica se a data inicial não é vazia e se é válida
		if(!dataInicial.isBlank() && validaData(dataInicial)) {
			
			//Verifica se a data final não é vazia e se é válida 
			if(!dataFinal.isBlank() && validaData(dataFinal)) 
				preencheDadosRelatorio(dataInicial, dataFinal);
			
			//Se a data final for vazia, a pesquisa é feita somente na data inicial, ou seja, são mostradas as ordens de serviço somente do dia da data inicial
			else if(dataFinal.isBlank())
					preencheDadosRelatorio(dataInicial, dataInicial);
		}
		
		else {
			oficina.msgError(this, "Não foi possível gerar o relatório!", TITULO);
			oficina.msgInfo(this, "É necessário a data inicial para gerar o relatório!", TITULO);
		}
	}

	/**
	 * Preenche os componentes com os dados da ordem de serviço se for encontrada
	 * 
	 * @param dataInicial Data inicial da ordem de serviço que será pesquisada
	 * @param dataFinal Data final da ordem de serviço que será pesquisada
	 */
	private void preencheDadosRelatorio(String dataInicial, String dataFinal) {
		float valorTotalServicos, valorTotalPecas;
		List<Float> valorServicosList = new ArrayList<>(); 
		List<Float> valorPecasList = new ArrayList<>();
		
		//Limpa os componentes da interface gráfica
		limparComponentes();
		
		for(int indice = 0;indice < oficina.quantidadeOrdemDeServico();indice++) {
			
			//Verifica se a data da ordem de serviço está no intervalo de datas buscadas
			if(verificaMenorData(dataInicial, oficina.obterOrdemDeServico(indice).getData().toString().trim()) && verificaMenorData(oficina.obterOrdemDeServico(indice).getData().toString().trim(), dataFinal)) {
				inserirDadosServicos(valorServicosList, oficina.obterOrdemDeServico(indice));
				inserirDadosPecas(valorPecasList, oficina.obterOrdemDeServico(indice));
			}
		}
		
		//Verifica se alguma ordem de serviço foi encontrada
		if(valorServicosList.size() == 0 && valorPecasList.size() == 0)
			oficina.msgError(this, "Nenhuma ordem de serviço cadastrada nesse período", TITULO);
		
		else{
			valorTotalServicos = receitaComServicos(valorServicosList);
			valorTotalPecas = receitaComPecas(valorPecasList);
			
			receitaComServicosTextField.setText(String.format("R$ %,.2f", valorTotalServicos));
			receitaComPecasTextField.setText(String.format("R$ %,.2f", valorTotalPecas));
			receitaTotalTextField.setText(String.format("R$ %,.2f", receitaTotal(valorTotalPecas, valorTotalServicos)));
		}
	}

	/**
	 * Insere os dados dos serviços da ordem de serviço na tabela de serviços
	 * 
	 * @param valorServicosList Lista que será armazenado o valor total de cada serviço
	 * @param ordemDeServico Referência de um objeto ordem de serviço
	 */
	private void inserirDadosServicos(List<Float> valorServicosList, OrdemDeServico ordemDeServico) {
		int posicao = 0;
		
		for(int linha = 0;linha <= defaultTableModelServicos.getRowCount();linha++) {
			
			//Verifica se posição é igual a quantidade de serviço, se for sai do loop for porque não há mais nenhum serviço a ser adicionado
			if(posicao == ordemDeServico.obterQuantidadeServico())
				break;
			
			//Verifica se a linha está vazia
			if(defaultTableModelServicos.getValueAt(linha, 0) == null) {
				defaultTableModelServicos.setValueAt(ordemDeServico.obterServico(posicao).getDescricaoServico(), linha, 0);
				defaultTableModelServicos.setValueAt(ordemDeServico.obterServico(posicao).getPrecoServico(), linha, 1);
				
				//Adicionando o valor do serviço na lista
				valorServicosList.add(Float.parseFloat(ordemDeServico.obterServico(posicao).getPrecoServico().replace(".", "").replace(',', '.').substring(3)));
				
				posicao++;
			}
		}
	}
	
	/**
	 * Insere os dados das peças da ordem de serviço na tabela de peças
	 * 
	 * @param valorPecasList Lista que será armazenado o valor total de cada peça
	 * @param ordemDeServico Referência de um objeto ordem de serviço
	 */
	private void inserirDadosPecas(List<Float> valorPecasList, OrdemDeServico ordemDeServico) {
		int posicao = 0;
		
		for(int linha = 0;linha <= defaultTableModelPecas.getRowCount();linha++) {
			
			//Verifica se posição é igual a quantidade de peça, se for sai do loop for porque não há mais nenhuma peça a ser adicionado
			if(posicao == ordemDeServico.obterQuantidadePeca())
				break;
			
			//Verifica se a linha está vazia
			if(defaultTableModelPecas.getValueAt(linha, 0) == null) {
				defaultTableModelPecas.setValueAt(ordemDeServico.obterPeca(posicao).getDescricaoPeca(), linha, 0);
				defaultTableModelPecas.setValueAt(ordemDeServico.obterPeca(posicao).getQuantidade(), linha, 1);
				defaultTableModelPecas.setValueAt(String.format("R$ %,.2f", ordemDeServico.obterPeca(posicao).getValorUnitario()), linha, 2);
				defaultTableModelPecas.setValueAt(ordemDeServico.obterPeca(posicao).getValorTotal(), linha, 3);
				
				//Adicionando o valor da peça na lista
				valorPecasList.add(Float.parseFloat(ordemDeServico.obterPeca(posicao).getValorTotal().replace(".", "").replace(',', '.').substring(3)));
				
				posicao++;
			}
		}
	}

	@Override
	public float receitaComServicos(List<Float> valorServicosList) {
		float soma = 0;
		
		for(Float valor : valorServicosList)
			soma += valor;
		
		return soma;
	}

	@Override
	public float receitaComPecas(List<Float> valorPecasList) {
		float soma = 0;
		
		for(Float valor : valorPecasList)
			soma += valor;
		
		return soma;
	}
	
	@Override
	public float receitaTotal(float valorTotalPecas, float valorTotalServicos) {
		return valorTotalPecas + valorTotalServicos;
	}

	/**
	 * Verifica se a data inicial é menor que a data final
	 * 
	 * @param dataInicial Data inicial no formato DD/MM/AAAA
	 * @param dataFinal	Data final no formato DD/MM/AAAA
	 * @return Retorna <code>true</code> se a data inicial é menor ou igual a data final, se a data inicial for maior retorna false
	 */
	public boolean verificaMenorData(String dataInicial, String dataFinal) {
		
		//Divide a data em dia, mes e ano
		String[] dataDividida1 = dataInicial.split("/"), dataDividida2 = dataFinal.split("/");
		
		int diaInicial = Integer.parseInt(dataDividida1[0]), diaFinal = Integer.parseInt(dataDividida2[0]),
			mesInicial = Integer.parseInt(dataDividida1[1]), mesFinal = Integer.parseInt(dataDividida2[1]),
			anoInicial = Integer.parseInt(dataDividida1[2]), anoFinal = Integer.parseInt(dataDividida2[2]);
		
		//Verifica se o ano inicial é menor que o ano final
		if(anoInicial < anoFinal)
			return true;
		
		//Verifica se o ano inicial é igual ao ano final e se o mes inicial é menor que o mes final
		if(anoInicial == anoFinal && mesInicial < mesFinal)
			return true;
		
		//Verifica se o ano inicial é igual ao ano final, se o mes inicial é igual ao mes final e se o dia inicial é menor ou igual ao dia final
		if(anoInicial == anoFinal && mesInicial == mesFinal && diaInicial <= diaFinal)
			return true;
		
		return false;
	}

	/**
	 * Verifica se uma data no formato DD/MM/AAAA é válida
	 * 
	 * @param data Data no formato DD/MM/AAAA
	 * @return Retorna <code>true</code> se for uma data válida
	 */
	public boolean validaData(String data) {
		String[] dataDivida;
		int dia, mes, ano;
		
		//Verifica com expressão regular se a data está no formato DD/MM/AAAA
		if(data.matches("\\d{2}\\/\\d{2}\\/\\d{4}")) {
			dataDivida = data.split("/");
			
			dia = Integer.parseInt(dataDivida[0]);
			mes = Integer.parseInt(dataDivida[1]);
			ano = Integer.parseInt(dataDivida[2]);
			
			//Verifica se o ano está entre 2000 e o ano atual
			if(ano > 2000 && ano <= LocalDate.now().getYear()) {
				
				//Verifica se o mês está entre 1 e 12 e se o dia é maior ou igual a zero
				if(mes >= 1 && mes <= 12 && dia >= 1) {
					
					//Verifica os meses de 31 dias
					if((mes % 2 != 0 && mes <= 7) || (mes % 2 == 0 && mes >= 8))
						if(dia <= 31)
							return true;
					
					//Verifica fevereiro
					if(mes == 2) {
						if(dia <= 28)
							return true;
							
						//Verifica fevereiro em ano bissexto
						else if((ano % 4 == 0) && (ano % 100 != 0 || ano % 400 == 0) && dia <= 29)
							return true;
					}
					
					//Verifica os meses de 30 dias
					if((mes % 2 == 0 && mes <= 6) || (mes % 2 != 0 && mes >= 9))
						if(dia <= 30)
							return true;
				}
			}
		}
		
		oficina.msgError(this, "Data Inválida", TITULO);
		return false;
	}
}
