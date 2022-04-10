package myller.trabalho1.oficina.gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import myller.trabalho1.oficina.Automovel;
import myller.trabalho1.oficina.Cliente;
import myller.trabalho1.oficina.Oficina;

/**
 * Cria a interface gráfica e suas operações
 * 
 * @author Luiz Myller Vidal
 * @version 0.1
 */
public class IgClienteEAutomovel extends JDialog {
	private static final String TITULO = "Cliente e Automovel",
								NOME_INVALIDO = "Nome Inválido!",
								CPF_INVALIDO = "CPF Inválido!",
								EMAIL_INVALIDO = "E-mail Inválido!",
								TELEFONE_INVALIDO = "Telefone Inválido!",
								ENDERECO_INVALIDO = "Endereço Inválido",
								PLACA_INVALIDA = "Placa Inválida!",
								QUILOMETRAGEM_INVALIDA = "Quilometragem Inválida!",
								MODELO_INVALIDO = "Modelo do automóvel inválido!";
	
	private JTextField nomeTextField;
	private JTextField emailTextField;
	private JTextField telefoneTextField;
	private JTextField quilometragemTextField;
	private JTextField placaTextField;
	private JTextArea enderecoTextArea;
	private JComboBox<String> anoModeloComboBox;
	private JComboBox<String> combustivelComboBox;
	private JTextField cpfTextField;
	private Oficina oficina;
	private JComboBox<String> marcaComboBox;
	private JTextField modeloTextField;
	private Cliente cliente;
	private JComboBox<String> codigoComboBox;
	private List<Automovel> automovelList;
	
	//Esta variável armazena a posição do automóvel que está selecionado pela "codigoComboBox"
	private int posicaoAutomovel;
	
	/**
	 * Cria e exibe a interface gráfica do cadastro do cliente e seus automóveis
	 * 
	 * @param oficina Referência de um objeto <code>Oficina</code>
	 */
	public IgClienteEAutomovel(Oficina oficina) {
		this.oficina = oficina;
		automovelList = new ArrayList<>();
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		setTitle(TITULO);
		setBounds(100, 100, 727, 426);
		getContentPane().setLayout(null);
		
		JPanel clientePanel = new JPanel();
		clientePanel.setBounds(12, 17, 344, 332);
		clientePanel.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(clientePanel);
		clientePanel.setLayout(null);
	
		JPanel cpfENomePanel = new JPanel();
		cpfENomePanel.setBounds(19, 23, 300, 117);
		cpfENomePanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		clientePanel.add(cpfENomePanel);
		cpfENomePanel.setLayout(null);
		
		JLabel cpfLabel = new JLabel("CPF:");
		cpfLabel.setBounds(15, 21, 33, 16);
		cpfLabel.setDisplayedMnemonic(KeyEvent.VK_F);
		cpfENomePanel.add(cpfLabel);
	
		cpfTextField = new JTextField();
		cpfTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarCliente();
			}
		});
		cpfLabel.setLabelFor(cpfTextField);
		cpfTextField.setBounds(60, 15, 116, 28);
		cpfENomePanel.add(cpfTextField);
		cpfTextField.setColumns(10);
	
		JLabel nomeLabel = new JLabel("Nome:");
		nomeLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		nomeLabel.setBounds(15, 49, 46, 16);
		cpfENomePanel.add(nomeLabel);
		
		nomeTextField = new JTextField();
		nomeTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarCliente();
			}
		});
		nomeLabel.setLabelFor(nomeTextField);
		nomeTextField.setBounds(60, 43, 220, 28);
		cpfENomePanel.add(nomeTextField);
		nomeTextField.setColumns(10);
		
		JButton pesquisarButton = new JButton("Pesquisar");
		pesquisarButton.setToolTipText("Pesquisa o cliente");
		pesquisarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarCliente();
			}
			
		});
		pesquisarButton.setMnemonic(KeyEvent.VK_P);
		pesquisarButton.setBounds(190, 83, 90, 28);
		cpfENomePanel.add(pesquisarButton);
		
		JLabel lblNewLabel = new JLabel("(Somente números)");
		lblNewLabel.setFont(new Font("SansSerif", Font.ITALIC, 11));
		lblNewLabel.setBounds(183, 21, 97, 16);
		cpfENomePanel.add(lblNewLabel);
	
	
		JLabel emailLabel = new JLabel("E-mail:");
		emailLabel.setDisplayedMnemonic(KeyEvent.VK_I);
		emailLabel.setBounds(18, 152, 55, 16);
		clientePanel.add(emailLabel);
		
		emailTextField = new JTextField();
		emailLabel.setLabelFor(emailTextField);
		emailTextField.setBounds(78, 146, 241, 28);
		clientePanel.add(emailTextField);
		emailTextField.setColumns(10);
		
		JLabel telefoneLabel = new JLabel("Telefone:");
		telefoneLabel.setDisplayedMnemonic(KeyEvent.VK_T);
		telefoneLabel.setBounds(18, 180, 55, 16);
		clientePanel.add(telefoneLabel);
		
		telefoneTextField = new JTextField();
		telefoneTextField.setText("(xx)xxxxx-xxxx");
		telefoneLabel.setLabelFor(telefoneTextField);
		telefoneTextField.setBounds(78, 174, 122, 28);
		clientePanel.add(telefoneTextField);
		telefoneTextField.setColumns(10);
		
		JLabel enderecoLabel = new JLabel("Endereço:");
		enderecoLabel.setDisplayedMnemonic(KeyEvent.VK_E);
		enderecoLabel.setBounds(19, 208, 61, 16);
		clientePanel.add(enderecoLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 227, 300, 79);
		clientePanel.add(scrollPane);
		
		enderecoTextArea = new JTextArea();
		scrollPane.setViewportView(enderecoTextArea);
		enderecoLabel.setLabelFor(enderecoTextArea);
		enderecoTextArea.setLineWrap(true);
	
		JPanel automovelPanel = new JPanel();
		automovelPanel.setBorder(new TitledBorder(null, "Autom\u00F3vel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		automovelPanel.setBounds(359, 17, 337, 332);
		getContentPane().add(automovelPanel);
		automovelPanel.setLayout(null);
		
		JLabel codigoLabel = new JLabel("Código:");
		codigoLabel.setDisplayedMnemonic(KeyEvent.VK_C);
		codigoLabel.setBounds(20, 27, 55, 16);
		automovelPanel.add(codigoLabel);
		
		codigoComboBox = new JComboBox<>();
		codigoComboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				preencherAutomovel();
			}
		});
		
		codigoComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"A1"}));
		
		codigoLabel.setLabelFor(codigoComboBox);
		codigoComboBox.setBounds(118, 22, 55, 26);
		automovelPanel.add(codigoComboBox);
		
		JLabel marcaLabel = new JLabel("Marca:");
		marcaLabel.setDisplayedMnemonic(KeyEvent.VK_R);
		marcaLabel.setBounds(20, 55, 55, 16);
		automovelPanel.add(marcaLabel);
		
		marcaComboBox = new JComboBox<>();
		marcaLabel.setLabelFor(marcaComboBox);
		marcaComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Audi", "BMW", "Citroen", "Chery", "Chevrolet", "Ford", "Fiat", "Honda", "Hyundai", "Mercedes-Benz", "Nissan", "Peugeot", "Renault", "Volkswagen"}));
		marcaComboBox.setBounds(118, 50, 130, 26);
		automovelPanel.add(marcaComboBox);
		
		JLabel modeloLabel = new JLabel("Modelo:");
		modeloLabel.setDisplayedMnemonic(KeyEvent.VK_M);
		modeloLabel.setBounds(20, 83, 55, 16);
		automovelPanel.add(modeloLabel);
		
		modeloTextField = new JTextField();
		modeloLabel.setLabelFor(modeloTextField);
		modeloTextField.setBounds(118, 77, 205, 28);
		automovelPanel.add(modeloTextField);
		modeloTextField.setColumns(10);
		
		JLabel anoModeloLabel = new JLabel("Ano modelo:");
		anoModeloLabel.setDisplayedMnemonic(KeyEvent.VK_A);
		anoModeloLabel.setBounds(20, 111, 86, 16);
		automovelPanel.add(anoModeloLabel);
		
		anoModeloComboBox = new JComboBox<>();
		anoModeloLabel.setLabelFor(anoModeloComboBox);
		anoModeloComboBox.setModel(new DefaultComboBoxModel<String>(retornaAnoModelo()));
		anoModeloComboBox.setSelectedIndex(60);
		anoModeloComboBox.setBounds(118, 106, 72, 26);
		automovelPanel.add(anoModeloComboBox);
		
		JLabel combustivelLabel = new JLabel("Combustível:");
		combustivelLabel.setDisplayedMnemonic(KeyEvent.VK_B);
		combustivelLabel.setBounds(20, 139, 86, 16);
		automovelPanel.add(combustivelLabel);
		
		combustivelComboBox = new JComboBox<>();
		combustivelLabel.setLabelFor(combustivelComboBox);
		combustivelComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Etanol e/ou Gasolina", "Diesel"}));
		combustivelComboBox.setBounds(118, 134, 182, 26);
		automovelPanel.add(combustivelComboBox);
		
		JLabel quilometragemLabel = new JLabel("Quilometragem:");
		quilometragemLabel.setDisplayedMnemonic(KeyEvent.VK_Q);
		quilometragemLabel.setBounds(20, 167, 96, 16);
		automovelPanel.add(quilometragemLabel);
		
		quilometragemTextField = new JTextField();
		quilometragemLabel.setLabelFor(quilometragemTextField);
		quilometragemTextField.setBounds(118, 161, 122, 28);
		automovelPanel.add(quilometragemTextField);
		quilometragemTextField.setColumns(10);
		
		JLabel kmLabel = new JLabel("KM");
		kmLabel.setBounds(245, 167, 55, 16);
		automovelPanel.add(kmLabel);
		
		JLabel placaLabel = new JLabel("Placa:");
		placaLabel.setDisplayedMnemonic(KeyEvent.VK_L);
		placaLabel.setBounds(20, 195, 55, 16);
		automovelPanel.add(placaLabel);
		
		placaTextField = new JTextField();
		placaLabel.setLabelFor(placaTextField);
		placaTextField.setBounds(118, 189, 122, 28);
		automovelPanel.add(placaTextField);
		placaTextField.setColumns(10);
		
		JButton adicionarAutomovelButton = new JButton("Adicionar automóvel");
		adicionarAutomovelButton.setToolTipText("Adiciona o automóvel\r\n");
		adicionarAutomovelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarAutomovel();
			}
		});
		adicionarAutomovelButton.setMnemonic(KeyEvent.VK_D);
		adicionarAutomovelButton.setBounds(166, 281, 139, 28);
		automovelPanel.add(adicionarAutomovelButton);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(12, 347, 684, 40);
		getContentPane().add(buttonPane);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton gravarButton = new JButton("Gravar");
		gravarButton.setToolTipText("Grava os dados do cliente");
		gravarButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				gravarDadosCliente();
				cliente = null;
			}
		});
		
		gravarButton.setMnemonic(KeyEvent.VK_G);
		buttonPane.add(gravarButton);
	
	
		JButton gerarOrdemDeServicoButton = new JButton("Gerar Ordem de Serviço");
		gerarOrdemDeServicoButton.setToolTipText("Gera uma ordem de serviço");
		
		gerarOrdemDeServicoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarOrdemDeServico();
			}
		});
		gerarOrdemDeServicoButton.setMnemonic(KeyEvent.VK_O);
		gerarOrdemDeServicoButton.setInheritsPopupMenu(true);
		gerarOrdemDeServicoButton.setActionCommand("OK");
		buttonPane.add(gerarOrdemDeServicoButton);
		getRootPane().setDefaultButton(gerarOrdemDeServicoButton);
	
		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.setToolTipText("Volta ao menu principal");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		cancelarButton.setActionCommand("Cancel");
		buttonPane.add(cancelarButton);

		setVisible(true);
	}
	
	/**
	 * Fecha a janela
	 */
	private void cancelar() {
		this.dispose();
	}
	
	/**
	 * Retorna os dados que preencherá o componete ano modelo
	 * 
	 * @return Retorna os anos de 1950 até o ano atual + 1
	 */
	private String[] retornaAnoModelo() {
		String[] anos = new String[(LocalDate.now().getYear() + 2) - 1950];
		
		for(int indice = 0;indice <= (LocalDate.now().getYear() + 1) - 1950;indice++) 
			anos[indice] = String.valueOf(indice + 1950);
		
		return anos;
	}
	
	/**
	 * Adiciona o automóvel na lista auxiliar de automóveis
	 * 
	 * @return Retorna true tiver sucesso e false se não tiver
	 */
	private boolean adicionarAutomovel() {			
		Automovel automovel;
		
		//Verifica se nome e o cpf foi preenchido
		if(nomeTextField.getText().trim().isBlank() && cpfTextField.getText().trim().isBlank()) {
			oficina.msgError(this, "Erro ao cadastrar o automóvel!\nPreencha o campo do CPF ou nome do cliente primeiro", TITULO);
			return false;
		}
		
		else {
			//Recebe a referência de um objeto automóvel
			automovel = criaAutomovel();
			
			//Verifica se a referência do objeto é nula
			if(automovel == null)
				return false;
			
			//Verifica se o modelo está em branco
			if(automovel.getModelo().isBlank()) {
				oficina.msgError(this, MODELO_INVALIDO, TITULO);
				return false;
			}
			
			//Verifica se a placa é válida
			if(!validaPlaca(automovel)) {
				oficina.msgError(this, PLACA_INVALIDA, TITULO);
				return false;
			}
				
			//Verifica se a quilometragem é válida
			if(!validaQuilometragem(String.valueOf(automovel.getQuilometragem())) || automovel.getQuilometragem() == -1) {
				oficina.msgError(this, QUILOMETRAGEM_INVALIDA, TITULO);
				return false;
			}
			
		}
		
		for(int indice = 0;indice < automovelList.size();indice++)
			
			//Se houver uma alteração em um automóvel existente ele será alterado 
			if(automovelList.get(indice).getCodigo().equals(automovel.getCodigo())) {
				alterarAutomovel(automovel, indice);
				return true;
			}
				
		//Adicionando o automóvel na lista
		automovelList.add(automovel);
		
		//Adiciona mais um item na comboBox do código
		codigoComboBox.addItem(String.format("A%d", automovelList.size() + 1));
		
		//Altera a seleção para o último
		codigoComboBox.setSelectedIndex(automovelList.size());
		
		//Código do automóvel mostrado é igual ao tamanho da lista, ou seja nenhum
		posicaoAutomovel = automovelList.size();
		
		//Limpa os componentes do automóvel
		limparComponentesAutomovel();
		
		return true;
	}
	
	/**
	 * Altera um automóvel na lista de automóveis
	 * 
	 * @param automovel Referência de um objeto automóvel
	 * @param indice Índice onde está o automóvel que será alterado
	 */
	private void alterarAutomovel(Automovel automovel, int indice) {
		automovelList.set(indice, automovel);
	}

	/**
	 * Cria um automóvel com os dados inseridos pelo usuário na interface
	 * 
	 * @return
	 */
	private Automovel criaAutomovel() {
		Automovel automovel;
		String codigo = codigoComboBox.getItemAt(codigoComboBox.getSelectedIndex()),
			   marca = marcaComboBox.getItemAt(marcaComboBox.getSelectedIndex()).trim(),
			   modelo = modeloTextField.getText().trim(),
			   combustivel = combustivelComboBox.getItemAt(combustivelComboBox.getSelectedIndex()).trim(),
			   placa = placaTextField.getText().trim(),
			   anoModelo = anoModeloComboBox.getItemAt(anoModeloComboBox.getSelectedIndex()).trim(),
			   quilometragem = quilometragemTextField.getText().trim();
		
		//Verifica se a quilometragem é um número se não for recebe o valor de 0
		if(!quilometragem.matches("\\d+")) {
			quilometragem = "-1";
		}
			
		//Cria a referência de um objeto automóvel
		automovel = new Automovel(codigo, marca, modelo, combustivel, placa, Integer.parseInt(anoModelo), Integer.parseInt(quilometragem));
		
		return automovel;
	}

	/**
	 * Verifica se a placa informada é válida
	 * 
	 * @param automovel Referência de um objeto automovel
	 * @return Retorna <code>true</code> se for uma placa válida, se não for válida retorna <code>false</code>
	 */
	public boolean validaPlaca(Automovel automovel) {
		
		//Verifica se há 3 letras e 4 números 
		if(automovel.getPlaca().matches("[A-Z]{3}\\-[0-9]{4}")) {
			
			//Verifica se já existe algum automóvel com esta placa
			if(verificaExistenciaAutomovel(automovel))
				return false;
			
			return true;
		}
		return false;
	}

	/**
	 * Verifica se a placa de um a automóvel já foi informada para outro automóvel 
	 * 
	 * @param automovel Referência de um objeto automóvel
	 * @return Retorna <code>true</code> se já exstir, se não existir retorna <code>false</code>
	 */
	private boolean verificaExistenciaAutomovel(Automovel automovel) {
		
		//Verifica se possui algum cliente cadastrado
		if(oficina.quantidadeCliente() > 0)
			for(int indiceCliente = 0;indiceCliente < oficina.quantidadeCliente();indiceCliente++) {
				Cliente cliente = oficina.obterCliente(indiceCliente);
				
				
				for(int indiceAutomovel = 0;indiceAutomovel < cliente.obterNumeroAutomoveis();indiceAutomovel++) {
					
					//Verifica se é o mesmo automóvel, se for a placa é aceita
					if(automovelList.get(indiceAutomovel).getCodigo().equals(automovel.getCodigo()) && automovelList.get(indiceAutomovel).getPlaca().equals(automovel.getPlaca()))
						return false;
					
					//Verificando se a placa é igual a de algum automóvel
					if(cliente.obterAutomovel(indiceAutomovel).getPlaca().equals(automovel.getPlaca()) || automovelList.get(indiceAutomovel).getPlaca().equals(automovel.getPlaca())) {
						oficina.msgError(this, "Placa já cadatrada", TITULO);
						return true;
					}
			}
		}
		
		else
			for(int indiceAutomovel = 0;indiceAutomovel < automovelList.size();indiceAutomovel++) {
				
				//Verifica se é o mesmo automóvel, se for a placa é aceita
				if(automovelList.get(indiceAutomovel).getCodigo().equals(automovel.getCodigo()) && automovelList.get(indiceAutomovel).getPlaca().equals(automovel.getPlaca()))
					return false;
					
				//Verificando se a placa é igual a de algum automóvel
				if(automovelList.get(indiceAutomovel).getPlaca().equals(automovel.getPlaca())) {
					oficina.msgError(this, "Placa já cadastrado", TITULO);
					return true;
				}
			}
		
		return false;
	}

	/**
	 * Verifica se a quilometragem é válida
	 * 
	 * @param quilometragem Uma string contendo a quilometragem informada pelo usuário
	 * @return Retorna <code>true</code> se for uma quilometragem válida, se não for válida retorna <code>false</code>
	 */
	public boolean validaQuilometragem(String quilometragem) {
		
		//Verifica se a quilometragem tem um um ou mais números
		if(quilometragem.matches("\\d+"))
			return true;
		
		return false;
	}
	
	/**
	 * Chamada da classe que vai criar e exibir a interface gráfica da ordem de serviço
	 */
	private void gerarOrdemDeServico() {
		boolean dadosCorretos = gravarDadosCliente();
		
		//Verifica se os dados estão corretos e foram gravados
		if(dadosCorretos) {
			new IgOrdemDeServico(oficina, cliente);
			this.dispose();
		}
	}
	
	/**
	 * Grava os dados do cliente 
	 * 
	 * @return Retorna <code>true</code> se todos os dados informados forem válidos, senão retorna <code>false</code>
	 */
	private boolean gravarDadosCliente() {
		if(verificarDadosCliente()) {
			
			//Cria uma referêncida de um objeto cliente	
			cliente = new Cliente();
			int indice;
			String cpf = cpfTextField.getText();
			
			//Altera o cpf para a referência ser usada na busca
			cliente.setCpf(cpf);
			
			//Verifica se o cpf é válido
			if(!validaCpf(cliente.getCpf())) {
				oficina.msgError(this, CPF_INVALIDO, TITULO);
				return false;
			}
			
			//Recebe o índice do cliente se já estiver cadastrado, senão recebe -1
			indice = oficina.obterPosicaoCliente(cliente);
			
			//Recebe o cliente com os dados informados pelo usuário
			cliente = criarCliente(cpf);
			
			//Verifica se o nome é válido
			if(!validaNome(cliente.getNome())) {
				oficina.msgError(this, NOME_INVALIDO, TITULO);
				return false;
			}
			
			//Verifica se o email é válido
			if(!validaEmail(cliente.getEmail())) {
				oficina.msgError(this, EMAIL_INVALIDO, TITULO);
				return false;
			}
			
			//Verifica se o telefone é válido
			if(!validaTelefone(cliente.getTelefone())) {
				oficina.msgError(this, TELEFONE_INVALIDO, TITULO);
				return false;
			}
			
			//Verifica se o endereço é válido
			if(cliente.getEndereco().isBlank()) {
				oficina.msgError(this, ENDERECO_INVALIDO, TITULO);
				return false;
			}
			
			//Se houver algo preenchido no modelo do automóvel é adicionado o automóvel
			if(!modeloTextField.getText().isBlank()) {
			
				//Verifica se os dados automóvel estão corretos ou se não há nenhum automóvel cadastrado
				if(!adicionarAutomovel() || automovelList.size() == 0) {
					return false;
				}
			}
				
			//Acrescenta os automóveis da lista de automóveis na lista de automóveis do cliente
			for(Automovel automovel : automovelList) 
				cliente.adicionarAutomovel(automovel);
			
			/*Se o índice for menor que 0 quer dizer que o cliente não existe e então ele será cadastrado, se for maior ou igual a zero quer dizer que já existe
			  e os dados do cliente serão alterados */
			if(indice < 0)
				oficina.cadastrarCliente(cliente, this);
			
			else
				oficina.alterarCliente(cliente, indice, this);
			
			posicaoAutomovel = 0;
		}
		
		else
			oficina.msgInfo(this, "Nenhuma alteração realizada", TITULO);
			
		//Limpa a lista de automóveis auxiliar
		automovelList.clear();
		
		//Limpa os componentes do painel do cliente
		limparComponentesCliente();
		
		return true;
	}

	/**
	 * Verifica se há alguma alteração nos dados do cliente
	 * 
	 * @return Retorna true se houve alguma alteração e retorna false se não houve alteração
	 */
	private boolean verificarDadosCliente() {
		
		//Verifica se cliente é diferente de null, se for retorna true, que quer dizer que é um novo cliente
		if(cliente != null) {
			
			//Verifica se o nome do cliente é diferente
			if(!nomeTextField.getText().toString().trim().equals(cliente.getNome()))
				return true;
			
			//Verifica se o telefone do cliente é diferente
			if(!telefoneTextField.getText().toString().trim().equals(cliente.getTelefone()))
				return true;
			
			//Verifica se o email do cliente é diferente
			if(!emailTextField.getText().toString().trim().equals(cliente.getEmail()))
				return true;
			
			//Verifica se o endereço do cliente é diferente
			if(!enderecoTextArea.getText().toString().trim().equals(cliente.getEndereco()))
				return true;
			
			//Verifica se houve alguma alteração nos automóveis
			if(verificarDadosAutomovel())
				return true;
			
			return false;
		}
		
		return true;
	}

	/**
	 * Verifica se há alguma alteração nos dados do automóvel
	 * 
	 * @return Retorna true se houve alguma alteração e retorna false se não houve alteração
	 */
	private boolean verificarDadosAutomovel() {
		
		//Verifica se a lista de automóveis é maior que o número de automóveis do cliente ou se há algo foi preenchido no modelo do automóvel, se for então os dados são alterados
		if(automovelList.size() > cliente.obterNumeroAutomoveis())
			return true;
		
		for(int indice = 0;indice < cliente.obterNumeroAutomoveis();indice++) {
			
			//Verifica se o modelo do automóvel é diferente
			if(!automovelList.get(indice).getModelo().equals(cliente.obterAutomovel(indice).getModelo()))
				return true;
			
			//Verifica se a marca do automóvel é diferente
			if(!automovelList.get(indice).getMarca().equals(cliente.obterAutomovel(indice).getMarca()))
				return true;
			
			//Verifica se o ano modelo do automóvel é diferente
			if(automovelList.get(indice).getAnoModelo() != cliente.obterAutomovel(indice).getAnoModelo())
				return true;
			
			//Verifica se o tipo de combustível do automóvel é diferente
			if(!automovelList.get(indice).getCombustivel().equals(cliente.obterAutomovel(indice).getCombustivel()))
				return true;
			
			//Verifica se a quilometragem do automóvel é diferente
			if(automovelList.get(indice).getQuilometragem() != cliente.obterAutomovel(indice).getQuilometragem())
				return true;
			
			//Verifica se a placa do automóvel é diferente
			if(!automovelList.get(indice).getPlaca().equals(cliente.obterAutomovel(indice).getPlaca()))
				return true;
		}
		
		for(int indice = 0;indice < automovelList.size(); indice++) {
			
			//Verifica se o que está no painel de automóveis é um automóvel já cadastrado
			if(modeloTextField.getText().equals(automovelList.get(indice).getModelo()) && placaTextField.getText().equals(automovelList.get(indice).getPlaca()))
				return false;
		}
		
		//Verifica se o campo modeloTextField não está vazio, se não tiver vazio e o modelo não estiver na lista de automóveis então é um novo automóvel
		if(!modeloTextField.getText().isBlank())
			return true;
		
		return false;
	}

	/**
	 * Cria a referência de um objeto cliente
	 * 
	 * @param cpf CPF do cliente
	 * @return Retorna a referência de um objeto cliente
	 */
	private Cliente criarCliente(String cpf) {
		String nome = nomeTextField.getText().trim(),
			   email = emailTextField.getText().trim(),
			   telefone = telefoneTextField.getText().trim(),
			   endereco = enderecoTextArea.getText().trim();
		
		//Cria a referência de um objeto cliente
		Cliente cliente = new Cliente(nome, cpf, email, telefone, endereco);
		
		return cliente;
	}
	
	/**
	 * Pesquisa se um cliente exsite ou não
	 * 
	 * @return Retona <code>true</code> se existir, se não existir retorna <code>false</code>
	 */
	private boolean pesquisarCliente() {
		
		//Cria uma referêncida de um objeto cliente	
		cliente = new Cliente();
		
		String cpf = cpfTextField.getText(),
			   nome = nomeTextField.getText();
		
		//Verifica se o nome ou o cpf foi preenchido, precisa de algum dos dois para fazer a pesquisa
		if(nome.isBlank() && cpf.isBlank()) {
			oficina.msgError(this, "Preencha o cpf ou o nome para pesquisar o cliente!", TITULO);
			return false;
		}
		
		//Se o cpf não estiver em branco ele será usado para a pesquisa, se o cpf estiver em branco será usado o nome
		if(!cpf.isBlank()) {
			cliente.setCpf(cpf);
			cliente = oficina.obterClientePorCpf(cliente);
		}
		
		else {
			cliente.setNome(nome);
			cliente = oficina.obterClientePorNome(cliente);
		}
		
		/*Verifica se a referência de cliente retorna da busca é igual a null, se for o clinte não está cadastrado, senão será inserido nos componentes da interface
		  os dados do cliente*/
		if(cliente == null) {
			oficina.msgError(this, "Cliente não cadastrado", TITULO);
		}
		
		else {
			
			//Limpa os componentes para acrescentar os novos dados
			limparComponentesCliente();
			
			posicaoAutomovel = 0;
			
			cpfTextField.setText(cliente.getCpf());
			nomeTextField.setText(cliente.getNome());
			telefoneTextField.setText(cliente.getTelefone());
			emailTextField.setText(cliente.getEmail());
			enderecoTextArea.setText(cliente.getEndereco());
			modeloTextField.setText(cliente.obterAutomovel(0).getModelo());
			marcaComboBox.setSelectedItem(cliente.obterAutomovel(0).getMarca());
			anoModeloComboBox.setSelectedItem(String.valueOf(cliente.obterAutomovel(0).getAnoModelo()));
			combustivelComboBox.setSelectedItem(cliente.obterAutomovel(0).getCombustivel());
			quilometragemTextField.setText(String.valueOf(cliente.obterAutomovel(0).getQuilometragem()));
			placaTextField.setText(cliente.obterAutomovel(0).getPlaca());
			
			//Adicionando os automóveis do cliente na lista de automóveis auxiliar
			automovelList.add(cliente.obterAutomovel(0));
			
			for(int indice = 1;indice < cliente.obterNumeroAutomoveis();indice++) {
				automovelList.add(cliente.obterAutomovel(indice));
				
				//Adicionando os códigos dos automóveis na combo box
				codigoComboBox.addItem(cliente.obterAutomovel(indice).getCodigo());
			}
			
			//Adicionando mais um item na combo box
			codigoComboBox.addItem(String.format("A%d", cliente.obterNumeroAutomoveis() + 1));
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Preenche os componentes do painel do automóvel se o código da combo box for alterada
	 */
	private void preencherAutomovel() {
		int posicao;
		
		//Verifica se o cliente é diferente de null, se possui automóveis cadastrados e se o item atual da combo box é diferente de null
		if(automovelList.size() > 0 && codigoComboBox.getItemAt(codigoComboBox.getSelectedIndex()) != null) {
			
			//Verifica se há algum automóvel na lista, se há algo nos componentes do painel do automóvel e sea variável codigoAutomovel é menor que a quantidade de automóvel na lista
			if(automovelList.size() > 0 && !modeloTextField.getText().isBlank() && posicaoAutomovel < automovelList.size())
				verificarAlteracaoAutomovel();
			
			//Pegando a posição na lista de automóveis a partir do código selecionado na comboBox
			posicao = Integer.parseInt(codigoComboBox.getItemAt(codigoComboBox.getSelectedIndex()).substring(1, codigoComboBox.getItemAt(codigoComboBox.getSelectedIndex()).length()));
			
			//Se posição for menor numero de automóveis preenche os componentes, senão else recebem valores default 
			if(posicao - 1 < automovelList.size()) {
				modeloTextField.setText(automovelList.get(posicao - 1).getModelo());
				marcaComboBox.setSelectedItem(automovelList.get(posicao - 1).getMarca());
				anoModeloComboBox.setSelectedItem(String.valueOf(automovelList.get(posicao - 1).getAnoModelo()));
				combustivelComboBox.setSelectedItem(automovelList.get(posicao - 1).getCombustivel());
				quilometragemTextField.setText(String.valueOf(automovelList.get(posicao - 1).getQuilometragem()));
				placaTextField.setText(automovelList.get(posicao - 1).getPlaca());				
			}
			
			else {
				modeloTextField.setText("");
				marcaComboBox.setSelectedItem(0);
				anoModeloComboBox.setSelectedItem(60);
				combustivelComboBox.setSelectedItem(0);
				quilometragemTextField.setText("");
				placaTextField.setText("");
			}
			
			//codigoAutomovel recebe -1
			posicaoAutomovel = posicao - 1;
		}
	}
	
	/**
	 * Verifica se houve alguma alteração em algum automóvel
	 */
	private void verificarAlteracaoAutomovel() {
		
		//Verifica se o modelo do automóvel é diferente, se for é alterado
		if(!automovelList.get(posicaoAutomovel).getModelo().equals(modeloTextField.getText().trim()) && !modeloTextField.getText().isBlank())
			automovelList.get(posicaoAutomovel).setModelo(modeloTextField.getText().trim());
		
		//Verifica se a marca do automóvel é diferente, se for é alterada
		if(!automovelList.get(posicaoAutomovel).getMarca().equals(marcaComboBox.getItemAt(marcaComboBox.getSelectedIndex()).trim()))
			automovelList.get(posicaoAutomovel).setMarca(marcaComboBox.getItemAt(marcaComboBox.getSelectedIndex()).trim());
		
		//Verifica se o ano modelo do automóvel é diferente, se for é alterado
		if(automovelList.get(posicaoAutomovel).getAnoModelo() != Integer.parseInt(anoModeloComboBox.getItemAt(anoModeloComboBox.getSelectedIndex()).trim()))
			automovelList.get(posicaoAutomovel).setAnoModelo(Integer.parseInt(anoModeloComboBox.getItemAt(anoModeloComboBox.getSelectedIndex()).trim()));
		
		//Verifica se o tipo de combustível do automóvel é diferente, se for é alterado
		if(!automovelList.get(posicaoAutomovel).getCombustivel().equals(combustivelComboBox.getItemAt(combustivelComboBox.getSelectedIndex()).trim()))
			automovelList.get(posicaoAutomovel).setCombustivel(combustivelComboBox.getItemAt(combustivelComboBox.getSelectedIndex()).trim());
		
		//Verifica se a quilometragem do automóvel é diferente, se for é alterado
		if(automovelList.get(posicaoAutomovel).getQuilometragem() != Integer.parseInt(quilometragemTextField.getText().trim()) && validaQuilometragem(quilometragemTextField.getText().trim()))
			automovelList.get(posicaoAutomovel).setQuilometragem(Integer.parseInt(quilometragemTextField.getText().trim()));
		
		//Verifica se a placa do automóvel é diferente, se for é alterada
		if(!automovelList.get(posicaoAutomovel).getPlaca().equals(placaTextField.getText().trim()))
			automovelList.get(posicaoAutomovel).setPlaca(placaTextField.getText().trim());
	}

	/**
	 * Limpa os componentes do painel do cliente
	 */
	private void limparComponentesCliente() {
		
		// Limpa os componentes 
		cpfTextField.setText("");
		nomeTextField.setText("");
		emailTextField.setText("");
		telefoneTextField.setText("");
		enderecoTextArea.setText("");
		
		//Limpa a lista de automóveis auxiliar
		automovelList.clear();
		
		//Remove todos os itens da combobox do código
		codigoComboBox.removeAllItems();
		
		//Adiciona o valor default para a combo box
		codigoComboBox.addItem("A1");
		
		limparComponentesAutomovel();
		
		// Colocar o cursor na caixa de texto.
		cpfTextField.requestFocus();
	}

	/**
	 * Limpa os componentes do automóvel
	 */
	private void limparComponentesAutomovel() {
		marcaComboBox.setSelectedIndex(0);
		modeloTextField.setText("");
		anoModeloComboBox.setSelectedIndex(60);
		combustivelComboBox.setSelectedIndex(0);
		quilometragemTextField.setText("");
		placaTextField.setText("");
		
		modeloTextField.requestFocus();
	}

	/**
	 * Verifica se o cpf é valido
	 * @param cpf CPF para consulta
	 * @return Retorna <code>true</code> se o CPF for válido e <code>false</code> se não for válido 
	 */
	public static boolean validaCpf(String cpf) {
		int dig_10, dig_11;
		
		//Verifica se o cpf tem nove números
		if(cpf.matches("[0-9]{11}")) {
			if(cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || 
			   cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999"))
				return false;
			
			dig_10 = verificaDigito(cpf, 10); 
			dig_11 = verificaDigito(cpf, 11);
			
			//Verifica se os cálculos para o dígito 10 e 11 confere com os dígitos do cpf
			if(dig_10 == Character.getNumericValue(cpf.charAt(9)) && dig_11 == Character.getNumericValue(cpf.charAt(10)))
				return true;
			
			else 
				return false;
		}
		return false;
	}
	
	/**
	 * Verifica os dígitos do cpf
	 * 
	 * @param cpf O cpf que será verificado os dois últimos dígitos
	 * @param numPeso Peso da multiplicaçao 
	 * @return Retorna o resto
	 */
	private static int verificaDigito(String cpf, int numPeso) {
		int resto, soma = 0, maxIndice = numPeso - 1;

		//Soma os primeiros números do cpf e multiplica por um número que vai de 9 a 2 para o dígito 1 e 10 a 2 para o dígito 2
		for(int indice = 0;indice < maxIndice;indice++) {
			soma += Character.getNumericValue(cpf.charAt(indice)) * numPeso;
			numPeso--;
		}
		
		resto = 11 - (soma % 11);
		
		//Se o resto for igual a 10 ou igual a 11 retorna 0
        if (resto == 10 || resto == 11)
            return 0;
        
        else 
        	return resto;
	}
	
	/**
	 * Verifica se o nome é válido
	 * 
	 * @param nome Nome que será verificado
	 * @return Retorna <code>true</code> se o nome for válido e <code>false</code> se não for válido
	 */
	public static boolean validaNome(String nome) {
		
		//Verifica se o nome corresponde à expressão regular
		if(nome.matches("[A-Za-záàâãéêíóôõúçÁÂÃÉÍÓÔÕÚÇ]+(\\s[a-zA-ZáàâãéêíóôõúçÁÂÃÉÍÓÔÕÚÇ]+)*")) 
			return true;
		
		return false;
	}

	/**
	 * Verifica se o email é válido
	 * 
	 * @param email Email a ser verificado
	 * @return Retorna <code>true</code> se o email for válido e <code>false</code> se não for válido
	 */
	public static boolean validaEmail(String email) {
		String regex = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        
        //Verifica se o email corresponde à expressão regular
        if(matcher.matches())
        	return true;
		
        return false;
	}
	
	/**
	 * Verifica se o telefone é válido
	 * 
	 * @param telefone Telefone a ser verificado
	 * @return Retorna <code>true</code> se for válido e <code>false</code> se não for válido
	 */
	public boolean validaTelefone(String telefone) {
		//Verifica se o telefone corresponde à expressão regular
		if(telefone.matches("\\([0-9]{2}\\)[0-9]{4,5}-[0-9]{4}"))
			return true;
		
		return false;
	}
}
