package myller.trabalho1.oficina.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import myller.trabalho1.oficina.Cliente;
import myller.trabalho1.oficina.Oficina;
import myller.trabalho1.oficina.OrdemDeServico;
import myller.trabalho1.oficina.Peca;
import myller.trabalho1.oficina.Servico;

/**
 * Cria a interface gráfica e suas operações
 * 
 * @author Luiz Myller Vidal
 * @version 0.1
 */
public class IgOrdemDeServico extends JDialog {

	private static final String TITULO = "Ordem de Serviço";

	private final JPanel contentPanel = new JPanel();
	private JTextField numeroTextField;
	private JTextField dataTextField;
	private JTextField horaTextField;
	private JTextField cpfTextField;
	private JTextField nomeTextField;
	private JTextField modeloTextField;
	private JTable servicosTable;
	private JTable pecasTable;
	private JTextField valorOrdemDeServicoTextField;
	private Oficina oficina;
	private Cliente cliente;
	private DefaultTableModel defaultTableModelPecas;
	private DefaultTableModel defaultTableModelServicos;
	private JComboBox<String> carroComboBox;
	
	/**
	 * Cria e exibe a interface gráfica da Ordem de Serviço sem os dados do <code>Cliente</code>
	 * 
	 * @param oficina Referência de um objeto <code>Oficina</code>
	 * @wbp.parser.constructor
	 */
	public IgOrdemDeServico(Oficina oficina) {
	
		this.oficina = oficina;
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		setTitle("Ordem de Serviço");
		setResizable(false);
		
		setBounds(50, 50, 715, 646);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel ordemDeServicoPanel = new JPanel();
		ordemDeServicoPanel.setBorder(new TitledBorder(null, "Ordem de Servi\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ordemDeServicoPanel.setBounds(6, 16, 303, 146);
		contentPanel.add(ordemDeServicoPanel);
		ordemDeServicoPanel.setLayout(null);
		
		JLabel numeroLabel = new JLabel("Número:");
		numeroLabel.setDisplayedMnemonic(KeyEvent.VK_R);
		numeroLabel.setBounds(18, 30, 55, 16);
		ordemDeServicoPanel.add(numeroLabel);
		
		numeroTextField = new JTextField();
		numeroTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarOrdemDeServico();
			}
		});
		numeroLabel.setLabelFor(numeroTextField);
		numeroTextField.setBounds(70, 24, 97, 28);
		ordemDeServicoPanel.add(numeroTextField);
		numeroTextField.setColumns(10);
		
		JButton pesquisarButton = new JButton("Pesquisar");
		pesquisarButton.setToolTipText("Pesquisa uma ordem de serviço");
		pesquisarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarOrdemDeServico();
			}
		});
		pesquisarButton.setMnemonic(KeyEvent.VK_P);
		pesquisarButton.setBounds(180, 24, 90, 28);
		ordemDeServicoPanel.add(pesquisarButton);
		
		JLabel dataLabel = new JLabel("Data:");
		dataLabel.setDisplayedMnemonic(KeyEvent.VK_D);
		dataLabel.setBounds(18, 64, 55, 16);
		ordemDeServicoPanel.add(dataLabel);
		
		dataTextField = new JTextField();
		dataTextField.setEditable(false);
		dataLabel.setLabelFor(dataTextField);
		dataTextField.setBounds(70, 58, 80, 28);
		ordemDeServicoPanel.add(dataTextField);
		dataTextField.setColumns(10);
		
		JLabel horaLabel = new JLabel("Hora:");
		horaLabel.setDisplayedMnemonic(KeyEvent.VK_H);
		horaLabel.setBounds(18, 98, 46, 16);
		ordemDeServicoPanel.add(horaLabel);
		
		horaTextField = new JTextField();
		horaTextField.setEditable(false);
		horaTextField.setBounds(70, 92, 61, 28);
		ordemDeServicoPanel.add(horaTextField);
		horaTextField.setColumns(10);
		
		JPanel clientePanel = new JPanel();
		clientePanel.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		clientePanel.setBounds(314, 16, 379, 146);
		contentPanel.add(clientePanel);
		clientePanel.setLayout(null);
		
		JLabel cpfLabel = new JLabel("CPF:");
		cpfLabel.setDisplayedMnemonic(KeyEvent.VK_F);
		cpfLabel.setBounds(23, 30, 39, 16);
		clientePanel.add(cpfLabel);
		
		cpfTextField = new JTextField();
		cpfTextField.setEditable(false);
		cpfLabel.setLabelFor(cpfTextField);
		cpfTextField.setBounds(70, 24, 122, 28);
		clientePanel.add(cpfTextField);
		cpfTextField.setColumns(10);
		
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		nomeLabel.setBounds(23, 64, 45, 16);
		clientePanel.add(nomeLabel);
		
		nomeTextField = new JTextField();
		nomeTextField.setEditable(false);
		nomeLabel.setLabelFor(nomeTextField);
		nomeTextField.setBounds(70, 58, 290, 28);
		clientePanel.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		JLabel carroLabel = new JLabel("Carro:");
		carroLabel.setDisplayedMnemonic(KeyEvent.VK_C);
		carroLabel.setBounds(23, 101, 55, 16);
		clientePanel.add(carroLabel);
		
		carroComboBox = new JComboBox<>();
		carroComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicao;
				
				/*Se o cliente for diferente de null e o valor selecionado na Combo Box também não for null, vai verificar qual o valor que está no combo box e
				  e vai colocar o modelo pertencente àquele valor da combo box*/
				if(cliente != null && carroComboBox.getItemAt(carroComboBox.getSelectedIndex()) != null) {
					posicao = Integer.parseInt(carroComboBox.getItemAt(carroComboBox.getSelectedIndex()).substring(1, carroComboBox.getItemAt(carroComboBox.getSelectedIndex()).length()));
					
					modeloTextField.setText(cliente.obterAutomovel(posicao - 1).getModelo());
				}
			}
		});
		carroComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"A1"}));
		carroLabel.setLabelFor(carroComboBox);
		carroComboBox.setBounds(70, 96, 55, 26);
		clientePanel.add(carroComboBox);
		
		JLabel modeloLabel = new JLabel("Modelo:");
		modeloLabel.setDisplayedMnemonic(KeyEvent.VK_M);
		modeloLabel.setBounds(172, 101, 55, 16);
		clientePanel.add(modeloLabel);
		
		modeloTextField = new JTextField();
		modeloTextField.setEditable(false);
		modeloLabel.setLabelFor(modeloTextField);
		modeloTextField.setBounds(224, 95, 136, 28);
		clientePanel.add(modeloTextField);
		modeloTextField.setColumns(10);

		JPanel servicosPanel = new JPanel();
		servicosPanel.setBorder(new TitledBorder(null, "Servi\u00E7os", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		servicosPanel.setBounds(6, 174, 687, 159);
		contentPanel.add(servicosPanel);
		servicosPanel.setLayout(null);
		
		JScrollPane servicosScrollPane = new JScrollPane();
		servicosScrollPane.setBounds(30, 23, 626, 130);
		servicosPanel.add(servicosScrollPane);
		
		servicosTable = new JTable();
		
		/*Se o usuário clicar com o mouse na tabela ou apertar alguma tecla en quanto o cursor estiver na tabela, é realizado a mudança no formato 
		  do valor total e acrescentado o número do serviço*/
		servicosTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				alterarNumeroServico();
			}
		});
		servicosTable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				alterarNumeroServico();
			}
		});
		
		servicosScrollPane.setViewportView(servicosTable);
		servicosTable.setShowVerticalLines(true);
		servicosTable.setShowHorizontalLines(true);
		defaultTableModelServicos = new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"N\u00B0", "Descri\u00E7\u00E3o", "Pre\u00E7o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		servicosTable.setModel(defaultTableModelServicos);
		servicosTable.getColumnModel().getColumn(0).setResizable(false);
		servicosTable.getColumnModel().getColumn(1).setResizable(false);
		servicosTable.getColumnModel().getColumn(1).setPreferredWidth(452);
		servicosTable.getColumnModel().getColumn(2).setResizable(false);
		servicosTable.getColumnModel().getColumn(2).setPreferredWidth(76);
		
		JPanel pecasPanel = new JPanel();
		pecasPanel.setBorder(new TitledBorder(null, "Pe\u00E7as", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pecasPanel.setBounds(6, 341, 687, 150);
		contentPanel.add(pecasPanel);
		pecasPanel.setLayout(null);
		
		JScrollPane pecasScrollPane = new JScrollPane();
		pecasScrollPane.setBounds(30, 23, 625, 121);
		pecasPanel.add(pecasScrollPane);
		
		pecasTable = new JTable();
		
		/*Se o usuário clicar com o mouse na tabela ou apertar alguma tecla en quanto o cursor estiver na tabela, é realizado o cálculo
		  do valor total e acrescentado o número da peça*/
		pecasTable.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				calcularValorTotal();
			}
		});
		pecasTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				calcularValorTotal();
			}
		});
		
		pecasScrollPane.setViewportView(pecasTable);
		defaultTableModelPecas = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"N\u00B0", "Descri\u00E7\u00E3o", "Quantidade", "Valor Unit\u00E1rio", "Valor Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		pecasTable.setModel(defaultTableModelPecas);
		pecasTable.getColumnModel().getColumn(0).setResizable(false);
		pecasTable.getColumnModel().getColumn(0).setPreferredWidth(40);
		pecasTable.getColumnModel().getColumn(1).setResizable(false);
		pecasTable.getColumnModel().getColumn(1).setPreferredWidth(299);
		pecasTable.getColumnModel().getColumn(2).setResizable(false);
		pecasTable.getColumnModel().getColumn(3).setResizable(false);
		pecasTable.getColumnModel().getColumn(3).setPreferredWidth(100);
		pecasTable.getColumnModel().getColumn(4).setResizable(false);
		pecasTable.getColumnModel().getColumn(4).setPreferredWidth(89);
		pecasTable.setShowVerticalLines(true);
		pecasTable.setShowHorizontalLines(true);
		
		JPanel valorTotalPanel = new JPanel();
		valorTotalPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		valorTotalPanel.setBounds(6, 497, 687, 71);
		contentPanel.add(valorTotalPanel);
		valorTotalPanel.setLayout(null);
		
		JLabel valorOrdemDeServicoLabel = new JLabel("Valor total da ordem de serviço:");
		valorOrdemDeServicoLabel.setDisplayedMnemonic(KeyEvent.VK_V);
		valorOrdemDeServicoLabel.setBounds(37, 26, 179, 16);
		valorTotalPanel.add(valorOrdemDeServicoLabel);
		
		valorOrdemDeServicoTextField = new JTextField();
		valorOrdemDeServicoTextField.setEditable(false);
		valorOrdemDeServicoLabel.setLabelFor(valorOrdemDeServicoTextField);
		valorOrdemDeServicoTextField.setBounds(215, 20, 122, 28);
		valorTotalPanel.add(valorOrdemDeServicoTextField);
		valorOrdemDeServicoTextField.setColumns(10);
		valorOrdemDeServicoTextField.setText("R$ 0,00");
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		JButton gravarButton = new JButton("Gravar");
		gravarButton.setToolTipText("Gravar os dados da ordem de serviço");
		gravarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gravarDadosOrdemDeServico();
			}
		});
		gravarButton.setMnemonic(KeyEvent.VK_G);
		gravarButton.setActionCommand("Gravar");
		buttonPane.add(gravarButton);
		getRootPane().setDefaultButton(gravarButton);
	
		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.setToolTipText("Voltar ao menu principal");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		buttonPane.add(cancelarButton);
	
		setVisible(true);
	}

	/**
	 * Cria e exibe a interface gráfica da Ordem de Serviço com os dados do <code>Cliente</code>
	 * 
	 * @param oficina Referência de um objeto <code>Oficina</code>
	 * @param cliente Referência de um objeto <code>Cliente</code>
	 */
	public IgOrdemDeServico(Oficina oficina, Cliente cliente) {
		this(oficina);
		this.cliente = cliente;
		
		inserirDadosOrdemDeServico();
		inserirDadosCliente(cliente);
	}

	/**
	 * Fecha a janela do IgOrdemDeServico
	 */
	private void cancelar() {
		this.dispose();
	}

	/**
	 * Pesquisa uma ordem de serviço
	 */
	private void pesquisarOrdemDeServico() {
		
		//Cria uma instância de OrdemDeServico
		OrdemDeServico ordemDeServico = new OrdemDeServico();
	
		//Verifica se o número foi ou não informado, se não for não vai pesquisar
		if(numeroTextField.getText().isBlank())
			oficina.msgError(this, "Preencha o número da ordem de serviço para pesquisar!", TITULO);
		
		else {
		
			//Alterando o valor do numero na referência de OrdemDeServico
			ordemDeServico.setNumeroOrdemDeServico(numeroTextField.getText());
			
			//Recebendo a referência de OrdemDeServico retornada pelo método obterOrdemDeServico
			ordemDeServico = oficina.obterOrdemDeServico(ordemDeServico);
			
			//Verificando se a ordem de servico com aquele número é diferente de null, ou seja, verificando se ela existe
			if(ordemDeServico != null) {
				
				//Instância de cliente recebe o cliente referenciado na ordem de serviço
				this.cliente = ordemDeServico.getCliente();
				
				//Exibe a data em que a ordem de serviço foi criada no campo dataTextField
				dataTextField.setText(ordemDeServico.getData());
				
				//Exibe a hora em que a ordem de serviço foi criada no campo horaTextField
				horaTextField.setText(ordemDeServico.getHora());
				
				//Insere os dados do cliente na interface
				inserirDadosCliente(cliente);
				
				//Insere os dados dos serviços pertencente a ordem de serviço na tabela de serviços na interface gráfica
				inserirDadosServico(ordemDeServico);
		
				//Insere os dados das peças pertencente a ordem de serviço na tabela de peças na interface gráfica
				inserirDadosPeca(ordemDeServico);
				
				//Exibe o valor total da ordem de serviço no campo valorOrdemDeServicoTextField 
				valorOrdemDeServicoTextField.setText(ordemDeServico.getValorTotal());
			}
			
			else
				oficina.msgError(this, "Ordem de serviço não cadastrada", TITULO);
		}
	}

	/**
	 * Insere os dados na tabela de serviços
	 * 
	 * @param ordemDeServico Referência de um objeto OrdemDeServico
	 */
	private void inserirDadosServico(OrdemDeServico ordemDeServico) {
		
		//Insere os dados até acabar a lista de serviços da ordemDeServicos
		for(int linha = 0;linha < ordemDeServico.obterQuantidadeServico();linha++) {
			defaultTableModelServicos.setValueAt(ordemDeServico.obterServico(linha).getNumeroServico(), linha, 0);
			defaultTableModelServicos.setValueAt(ordemDeServico.obterServico(linha).getDescricaoServico(), linha, 1);
			defaultTableModelServicos.setValueAt(ordemDeServico.obterServico(linha).getPrecoServico(), linha, 2);
		}
	}
	
	/**
	 * Insere os dados na tabela de peças
	 * 
	 * @param ordemDeServico Referência de um objeto OrdemDeServico
	 */
	private void inserirDadosPeca(OrdemDeServico ordemDeServico) {
		
		//Insere os dados até acabar a lista de peças da ordemDeServicos
		for(int linha = 0;linha < ordemDeServico.obterQuantidadePeca();linha++) {
			defaultTableModelPecas.setValueAt(ordemDeServico.obterPeca(linha).getNumeroPeca(), linha, 0);
			defaultTableModelPecas.setValueAt(ordemDeServico.obterPeca(linha).getDescricaoPeca(), linha, 1);
			defaultTableModelPecas.setValueAt(ordemDeServico.obterPeca(linha).getQuantidade(), linha, 2);
			defaultTableModelPecas.setValueAt(ordemDeServico.obterPeca(linha).getValorUnitario(), linha, 3);
			defaultTableModelPecas.setValueAt(ordemDeServico.obterPeca(linha).getValorTotal(), linha, 4);
		}
	}

	/**
	 * Insere os dados da ordem de serviço vindo do cadastro do cliente
	 */
	private void inserirDadosOrdemDeServico() {
		
		//Recebe a data atual
		LocalDate localDate = LocalDate.now();
		
		//Recebe a hora total
		LocalTime localTime = LocalTime.now();
		
		//exibe o número da ordem de serviço
		numeroTextField.setText(String.format("%04d", oficina.quantidadeOrdemDeServico() + 1));
		
		//exibe a data atual formatada
		dataTextField.setText(String.format("%02d/%02d/%d", localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear()));
		
		//Exibe a hora atual formatada
		horaTextField.setText(String.format("%02d:%02d", localTime.getHour(), localTime.getMinute()));
	}
	
	/**
	 * Insere dados do cliente
	 * 
	 * @param cliente Referência de um objeto cliente
	 */
	private void inserirDadosCliente(Cliente cliente) {
		nomeTextField.setText(cliente.getNome());
		cpfTextField.setText(cliente.getCpf());

		for(int indice = 1;indice < cliente.obterNumeroAutomoveis();indice++)
			carroComboBox.addItem(String.format("A%d", indice + 1));
		
		modeloTextField.setText(cliente.obterAutomovel(0).getModelo());
	}
	
	/**
	 * Altera o número do serviço na tabela de servços
	 */
	private void alterarNumeroServico() {
		for(int linha = 0;linha < defaultTableModelServicos.getRowCount();linha++) {
			
			//Se a linha houver sido preenchida acrescenta o número na linha e formata o preço para "R$ valor" quando for concluída sai do método
			if(defaultTableModelServicos.getValueAt(linha, 1) != null && defaultTableModelServicos.getValueAt(linha, 2) != null) { 
				
				//Verifica se não está em branco
				if(!defaultTableModelServicos.getValueAt(linha, 1).toString().trim().isBlank() && !defaultTableModelServicos.getValueAt(linha, 2).toString().trim().isBlank() && Character.isDigit(defaultTableModelServicos.getValueAt(linha, 2).toString().trim().charAt(0))){
					
					//Recebe o número digitado pelo usuário e o formata para "R$ valor"
					defaultTableModelServicos.setValueAt(String.format("R$ %,.2f", Float.parseFloat(defaultTableModelServicos.getValueAt(linha, 2).toString().trim())), linha, 2);
					defaultTableModelServicos.setValueAt(linha + 1, linha, 0);
					
					//Convertendo o valor da variável valorOrdemDeServico para uma String formatada em "R$ valor" 
					valorOrdemDeServicoTextField.setText(String.format("R$ %,.2f", retornaValorTotalServicos()));
					
					break;
				}			
			}
		}
	}

	/**
	 * Calcula o valor total na tabela de peças
	 */
	private void calcularValorTotal() {
		float valorTotal;
		
		for(int linha = 0;linha < defaultTableModelPecas.getRowCount();linha++) {
			
			//Verificando se o valor total na linha já foi calculado e verifica se a quantida e o valor unitário foi preenchido
			if(defaultTableModelPecas.getValueAt(linha, 3) != null && defaultTableModelPecas.getValueAt(linha, 2) != null) {
				
				//Calcula o valor total com a quantidade * valor unitário
				valorTotal = Float.parseFloat(defaultTableModelPecas.getValueAt(linha, 3).toString().trim()) * Integer.parseInt(defaultTableModelPecas.getValueAt(linha, 2).toString().trim());
				
				//Verifica se o campo da tabela do valor total está preenchido e se o valor que está lá é diferente do calculado atualmente
				if(defaultTableModelPecas.getValueAt(linha, 4) == null || valorTotal != Float.parseFloat(defaultTableModelPecas.getValueAt(linha, 4).toString().trim().replace(".", "").replace(',', '.').substring(3))) {
					
					//Formata o numero para "R$ valor"
					defaultTableModelPecas.setValueAt(String.format("R$ %,.2f", valorTotal), linha, 4);
					
					//Acrescenta o número da peça
					defaultTableModelPecas.setValueAt(linha + 1, linha, 0);
					
					//Convertendo o valor da variável valorOrdemDeServico para uma String formatada em "R$ valor" 
					valorOrdemDeServicoTextField.setText(String.format("R$ %,.2f", retornaValorTotalPecas()));
					break;
				}
			}
		}
	}
	
	/**
	 * Retorna o valor total das peças da ordem de serviço
	 * 
	 * @return Retorna um float contendo contendo o resultado da soma dos valores totais das peças
	 */
	private float retornaValorTotalPecas() {
		float valorOrdemDeServico = 0;
		
		for(int linha = 0;linha < defaultTableModelPecas.getRowCount();linha++) 
			
			//Verifica se a linha está preenchida, se tiver soma os valores
			if(defaultTableModelPecas.getValueAt(linha, 4) != null)
				valorOrdemDeServico += Float.parseFloat(defaultTableModelPecas.getValueAt(linha, 4).toString().trim().replace(".", "").replace(',', '.').substring(3));
		
		return valorOrdemDeServico;
	}
	
	/**
	 * Retorna o valor total dos serviços da ordem de serviço
	 * 
	 * @return Retorna um float contendo contendo o resultado da soma dos valores totais dos serviços
	 */
	private float retornaValorTotalServicos() {
		float valorOrdemDeServico = 0;
		
		for(int linha = 0;linha < defaultTableModelServicos.getRowCount();linha++) 
			
			//Verifica se a linha está preenchida, se tiver soma os valores
			if(defaultTableModelServicos.getValueAt(linha, 2) != null)
				valorOrdemDeServico += Float.parseFloat(defaultTableModelServicos.getValueAt(linha, 2).toString().trim().replace(".", "").replace(',', '.').substring(3));
		
		return valorOrdemDeServico;
	}

	/**
	 * Grava os dados da ordem de serviço
	 */
	private boolean gravarDadosOrdemDeServico() {
		OrdemDeServico ordemDeServico = new OrdemDeServico();
		int indice;
		
		//Verificando se o número da ordem de serviço está preenchida e se a referência de cliente é diferente de null
		if(numeroTextField.getText().isBlank() || cliente == null) {
			oficina.msgError(this, "Não foi possível registrar a ordem de serviço!", TITULO);
			oficina.msgInfo(this, "Verifique o número da ordem de serviço e os dados do cliente!", TITULO);
			
			return false;
		}
		
		//Verifica se os campos do painel Ordem de Serviço está preenchido, se não tiver são preenchidos
		if(numeroTextField.getText().isBlank() || dataTextField.getText().isBlank() || horaTextField.getText().isBlank()) 
			inserirDadosOrdemDeServico();
		
		//Verifica se os campos do painel cliente está preenchido, se não tiver são preenchidos
		if(nomeTextField.getText().isBlank() || cpfTextField.getText().isBlank())
			inserirDadosCliente(cliente);
		
		//Altera a referência da odem de serviço adicionando um número, essa referência vai ser usada na pesquisa da ordem de serviço
		ordemDeServico.setNumeroOrdemDeServico(numeroTextField.getText().trim());
		
		//Recebe a posição na lista da ordem de serviço
		indice = oficina.obterPosicaoOrdemDeServico(ordemDeServico);
		
		//Se o índice for menor que 0 será criado uma nova ordem de serviço, senão seus dados serão alterados
		if(indice < 0)
			ordemDeServico = new OrdemDeServico(numeroTextField.getText().trim(), dataTextField.getText().trim(), horaTextField.getText().trim(), valorOrdemDeServicoTextField.getText().trim(), cliente);
		
		else {
			ordemDeServico = oficina.obterOrdemDeServico(indice);
			
			//Verifica se os dados da ordem de serviço já existente foram alterados
			if(!verificaDadosalterados(ordemDeServico)) {
				oficina.msgInfo(this, "Nenhuma alteração realizada", TITULO);
				limparComponentes();
				return false;
			}
			
			//Se houver alguma alteração na ordem de serviço, é alterado na lista de ordem de serviço na posiçaõ que foi aletrado
			alterarOrdemDeServico(ordemDeServico, indice);
			
			//Limpa os dados dos componentes
			limparComponentes();
			return true;
		}
		
		//Recebe os dados das tabelas
		gravarDadosServicos(ordemDeServico);
		gravarDadosPecas(ordemDeServico);
		
		//Registra a ordem de serviço
		oficina.registrarOrdemDeServico(ordemDeServico, this);
		
		//Limpa os dados dos componentes
		limparComponentes();
		
		return true;
	}

	/**
	 * Altera os dados da ordem de serviço
	 * 
	 * @param ordemDeServico Referência de um objeto ordem de serviço
	 * @param indice Posição da ordem de serviço na lista
	 */
	private void alterarOrdemDeServico(OrdemDeServico ordemDeServico, int indice) {
		alterarServicos(ordemDeServico);
		alterarPecas(ordemDeServico);
		
		oficina.alterarOrdemDeServico(ordemDeServico, indice,this);
	}

	/**
	 * Altera os serviços na ordem de serviço
	 * 
	 * @param ordemDeServico Referência de um objeto ordem de serviço
	 */
	private void alterarServicos(OrdemDeServico ordemDeServico) {
		Servico servico;
		
		for(int linha = 0;linha < defaultTableModelServicos.getRowCount();linha++) {
			
			//Se já existir um serviço nessa linha há uma alteração, se houver um serviço em uma nova linha então é criado um novo objeto serviço 
			if(linha < ordemDeServico.obterQuantidadeServico()) {
				ordemDeServico.obterServico(linha).setDescricaoServico(defaultTableModelServicos.getValueAt(linha, 1).toString().trim());
				ordemDeServico.obterServico(linha).setPrecoServico(defaultTableModelServicos.getValueAt(linha, 2).toString().trim());
			}
			
			else if(defaultTableModelServicos.getValueAt(linha, 0) != null){
				servico = criarServico(linha);
				
				ordemDeServico.adicionarServico(servico);
			}
		}
	}

	/**
	 * Altera os serviços na ordem de serviço
	 * 
	 * @param ordemDeServico Referência de um objeto ordem de serviço
	 */
	private void alterarPecas(OrdemDeServico ordemDeServico) {
		Peca peca;
		
		for(int linha = 0;linha < defaultTableModelPecas.getRowCount();linha++) {
			
			//Se já existir uma peça nessa linha há uma alteração, se houver um serviço em uma nova linha então é criado um novo objeto peça
			if(linha < ordemDeServico.obterQuantidadePeca()) {
				ordemDeServico.obterPeca(linha).setDescricaoPeca(defaultTableModelPecas.getValueAt(linha, 1).toString().trim());
				ordemDeServico.obterPeca(linha).setQuantidade(Integer.parseInt(defaultTableModelPecas.getValueAt(linha, 2).toString().trim()));
				ordemDeServico.obterPeca(linha).setValorUnitario(Float.parseFloat(defaultTableModelPecas.getValueAt(linha, 3).toString().trim()));
				ordemDeServico.obterPeca(linha).setValorTotal(defaultTableModelPecas.getValueAt(linha, 4).toString().trim());
			}
			
			else if(defaultTableModelPecas.getValueAt(linha, 0) != null){
				peca = criarPeca(linha);
			
				ordemDeServico.adicionarPeca(peca);
			}
		}
	}

	/**
	 * Verifica se os dados foram alterados
	 * 
	 * @param ordemDeServico Referência de um objeto ordem de serviço
	 * @return Retorna true se houver alguma alteração e false se não houver
	 */
	private boolean verificaDadosalterados(OrdemDeServico ordemDeServico) {
		if(verificaServicosAlterados(ordemDeServico))
			return true;
			
		if(verificaPecasAlteradas(ordemDeServico))
			return true;
		
		return false;
	}	

	/**
	 * Verifica se houve alguma alteração nas peças
	 * 
	 * @param ordemDeServico Referência de um objeto ordem de serviço
	 * @return Retorna true se houver alguma alteração e false se não houver
	 */
	private boolean verificaPecasAlteradas(OrdemDeServico ordemDeServico) {
		for(int linha = 0;linha < defaultTableModelPecas.getRowCount();linha++) {
			
			//Verifica se a linha atual é uma nova linha preenchida
			if(linha < ordemDeServico.obterQuantidadePeca()) {
				
				//Verifica se a descrição da peça é diferente
				if(!defaultTableModelPecas.getValueAt(linha, 1).toString().trim().equals(ordemDeServico.obterPeca(linha).getDescricaoPeca()))
					return true;
				
				//Verifica se a quantidade da peça é diferente
				if(Integer.parseInt(defaultTableModelPecas.getValueAt(linha, 2).toString().trim()) != ordemDeServico.obterPeca(linha).getQuantidade())
					return true;
				
				//Verifica se o valor unitário da peça é diferente
				if(Float.parseFloat(defaultTableModelPecas.getValueAt(linha, 3).toString().trim()) != ordemDeServico.obterPeca(linha).getValorUnitario())
					return true;
				
				//Verifica se o valor total da peça é diferente
				if(!defaultTableModelPecas.getValueAt(linha, 4).toString().trim().equals(ordemDeServico.obterPeca(linha).getValorTotal()))
					return true;
			}
			
			//Verifica se há uma nova linha preenchida
			else if(defaultTableModelPecas.getValueAt(linha, 1) != null)
				return true;
		}
		return false;
	}

	/**
	 * Verifica se houve alguma alteração nas peças
	 * 
	 * @param ordemDeServico Referência de um objeto ordem de serviço
	 * @return Retorna true se houver alguma alteração e false se não houver
	 */
	private boolean verificaServicosAlterados(OrdemDeServico ordemDeServico) {
		for(int linha = 0;linha < defaultTableModelServicos.getRowCount();linha++) {
			
			//Verifica se a linha atual é uma nova linha preenchida
			if(linha < ordemDeServico.obterQuantidadeServico()) {
				
				//Verifica se a descrição da serviço é diferente
				if(!defaultTableModelServicos.getValueAt(linha, 1).toString().trim().equals(ordemDeServico.obterServico(linha).getDescricaoServico()))
					return true;
				
				//Verifica se o preço do serviço é diferente
				if(!defaultTableModelServicos.getValueAt(linha, 2).toString().trim().equals(ordemDeServico.obterServico(linha).getPrecoServico()))
					return true;
			}
			
			//Verifica se há uma nova linha preenchida
			else if(defaultTableModelServicos.getValueAt(linha, 1) != null)
				return true;
		}
		
		return false;
	}

	/**
	 * Grava na ordem de serviço os dados da tabela de serviços
	 * 
	 * @param ordemDeServico Referência de objeto OrdemDeServico
	 */
	private void gravarDadosServicos(OrdemDeServico ordemDeServico) {
		Servico servico;
		
		
		for(int linha = 0;linha < defaultTableModelServicos.getRowCount();linha++) {
			
			//Verificando se a tabela na linha está preenchida
			if(defaultTableModelServicos.getValueAt(linha, 1) != null && defaultTableModelServicos.getValueAt(linha, 2) != null) {
				 
				servico = criarServico(linha);
				 
				//Adicionando o servico na ordem de serviço
				ordemDeServico.adicionarServico(servico);
			}
		}
	}
		
	private Servico criarServico(int linha) {
		Servico servico;
		int numero;
		String descricao, valorTotal;
		
		//Convertendo o número de String para int
		numero = Integer.parseInt(defaultTableModelServicos.getValueAt(linha, 0).toString().trim());
		descricao = defaultTableModelServicos.getValueAt(linha, 1).toString().trim();
		valorTotal = defaultTableModelServicos.getValueAt(linha, 2).toString().trim();
	
		//Cria uma referência de objeto serviço
		servico = new Servico(numero, valorTotal, descricao);
		
		return servico;
	}

	/**
	 * Grava na ordem de serviço os dados da tabela de peças
	 * 
	 * @param ordemDeServico Referência de objeto OrdemDeServico
	 */
	private void gravarDadosPecas(OrdemDeServico ordemDeServico) {
		Peca peca;
		
		for(int linha = 0;linha < defaultTableModelPecas.getRowCount();linha++) {
			
			//Verificando se a tabela na linha está preenchida
			if(defaultTableModelPecas.getValueAt(linha, 1) != null && defaultTableModelPecas.getValueAt(linha, 2) != null && defaultTableModelPecas.getValueAt(linha, 3) != null) {
				
				peca = criarPeca(linha);
				
				//Adicionando o servico na ordem de serviço
				ordemDeServico.adicionarPeca(peca);
			}
		}
	}
	
	private Peca criarPeca(int linha) {
		Peca peca;
		int numero, quantidade;
		float valorUnitario;
		String valorTotal, descricao;
		
		//Convertendo o número de String para int
		numero = Integer.parseInt(defaultTableModelPecas.getValueAt(linha, 0).toString().trim());
		
		//Convertendo a quantidade de String para int
		quantidade = Integer.parseInt(defaultTableModelPecas.getValueAt(linha, 2).toString().trim());
		
		//Convertendo o Valor Unitário de String para float
		valorUnitario = Float.parseFloat(defaultTableModelPecas.getValueAt(linha, 3).toString().trim());
		descricao = defaultTableModelPecas.getValueAt(linha, 1).toString().trim();
		valorTotal = defaultTableModelPecas.getValueAt(linha, 4).toString().trim();
		
		//Cria uma referência de objeto Peça
		peca = new Peca(numero, quantidade, valorUnitario, valorTotal, descricao);
		
		return peca;
	}

	/**
	 * Limpa os dados nos componentes da interface gráfica
	 */
	private void limparComponentes() {
		numeroTextField.setText("");
		dataTextField.setText("");
		horaTextField.setText("");
		nomeTextField.setText("");
		cpfTextField.setText("");
		modeloTextField.setText("");
		
		cliente = null;
		
		//Removendo os itens da combo box e adicionando o "A1"
		carroComboBox.removeAllItems();
		carroComboBox.addItem("A1");
		
		limparTabelaServicos();
		limparTablePecas();
		
		valorOrdemDeServicoTextField.setText("R$ 0,00");

		numeroTextField.requestFocus();
	}

	/**
	 * Limpa os dados na tabela de serviço
	 */
	private void limparTabelaServicos() {
		for(int linha = 0;linha < defaultTableModelServicos.getRowCount();linha++) {
			defaultTableModelServicos.setValueAt(null, linha, 0);
			defaultTableModelServicos.setValueAt(null, linha, 1);
			defaultTableModelServicos.setValueAt(null, linha, 2);
		}
	}
	
	/**
	 * Limpa os dados na tabela de peças
	 */
	private void limparTablePecas() {
		for(int linha = 0;linha < defaultTableModelPecas.getRowCount();linha++) {
			defaultTableModelPecas.setValueAt(null, linha, 0);
			defaultTableModelPecas.setValueAt(null, linha, 1);
			defaultTableModelPecas.setValueAt(null, linha, 2);
			defaultTableModelPecas.setValueAt(null, linha, 3);
			defaultTableModelPecas.setValueAt(null, linha, 4);
		}
	}
}
