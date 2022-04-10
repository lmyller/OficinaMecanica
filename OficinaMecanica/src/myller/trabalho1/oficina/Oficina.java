package myller.trabalho1.oficina;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import myller.trabalho1.oficina.gui.IgMenu;

/**
 * Define os métodos da classe oficina
 * 
 * @author Luiz Myller Vidal
 * @version 0.1
 */
public class Oficina {

	private List<Cliente> clienteList;
	private List<OrdemDeServico> ordemDeServicoList;
	
	/**
	 * Construtor default da classe oficina
	 */
	public Oficina() {
		//Cria um ArrayList de clientes
		clienteList = new ArrayList<>();
		
		//Cria um ArrayList de ordem de serviç
		ordemDeServicoList = new ArrayList<>();
		
		//Inicia a interface do menu principal
		new IgMenu(this);
	}
	
	/**
	 * Inicia o aplicativo
	 * 
	 * @param args Este programa não utiliza parâmetros de linha de comando
	 */
	public static void main(String[] args) {
		new Oficina();
	}

	/**
	 * Cadastra um cliente
	 * 
	 * @param cliente Referência de um objeto <code>Cliente</code>
	 * @param componente Componente onde será apresentado a mensagem
	 */
	public void cadastrarCliente(Cliente cliente, Component componente) {
		
		//Adiciona o cliente na lista
		clienteList.add(cliente);
		showMessageDialog(componente, "Cliente cadastrado com sucesso", "Cadastro", INFORMATION_MESSAGE);
	}
	
	/**
	 * Altera um cliente
	 * 
	 * @param cliente Referência de um objeto <code>Cliente</code>
	 * @param posicao Posição na lista do <code>Cliente</code>
	 * @param componente Componente onde será apresentado a mensagem
	 * 
	 * @see #obterPosicaoCliente(Cliente)
	 */
	public void alterarCliente(Cliente cliente, int posicao, Component componente) {
		//Altera os dados do cliente
		clienteList.set(posicao, cliente);
		showMessageDialog(componente, "Cliente alterado com sucesso", "Alteração", INFORMATION_MESSAGE);
	}
	
	/**
	 * Obtém a quantidade de clientes cadastrados
	 * 
	 * @return Retorna um <code>int</code> contendo a quantidade de clientes cadastrados
	 */
	public int quantidadeCliente() {
		return clienteList.size();
	}
	
	/**
	 * Obtém o cliente na posição recebida
	 * 
	 * @param posicao Um <code>int</code> contendo a posiçao do cliente  
	 * @return Retorna a referência de um objeto <code>Cliente</code>
	 */
	public Cliente obterCliente(int posicao) {
		return clienteList.get(posicao);
	}
	
	/**
	 * Obtém a posição do cliente
	 * 
	 * @param cliente Referência de um objeto <code>Cliente</code>
	 * @return Retorna um <i>int</i> com a posição do cliente, se encontrar retorn um número >= 0
	 */
	public int obterPosicaoCliente(Cliente cliente) {
		int indice = ordenaListaCliente(cliente);
		
		//Retorna o índice
		return indice;
	}
	
	/**
	 * Ordena a lista de clientes
	 * 
	 * @param cliente Referência de um objeto <code>Cliente</code>
	 * @return Retorna um <code>int</code> contendo a posição do cliente, se não for encontrado retorna -1
	 */
	private int ordenaListaCliente(Cliente cliente) {
		int indice;
		
		//Ordena a lista de cliente de acordo com o cpf
		clienteList.sort(new Comparator<Cliente>() {

			@Override
			public int compare(Cliente o1, Cliente o2) {
				return o1.getCpf().compareTo(o2.getCpf());
			}
			
		});
		
		//Recebe o indice do cliente
		indice = Collections.binarySearch(clienteList, cliente, new Comparator<Cliente>() {

			@Override
			public int compare(Cliente o1, Cliente o2) {
				return o1.getCpf().compareTo(o2.getCpf());
			}
			
		});
		
		//Retorna o índice
		return indice;
	}

	/**
	 * Obtém o cliente pelo nome
	 * 
	 * @param cliente Referência de um objeto <code>Cliente</code>
	 * @return Retorna a referência de um objeto <code>Cliente</code> com o nome especificado, se não for encontrado retorna null
	 */
	public Cliente obterClientePorNome(Cliente cliente) {
		int indice;
		
		//Organiza a lista de cliente de acordo com o nome
		clienteList.sort(new Comparator<Cliente>() {

			@Override
			public int compare(Cliente o1, Cliente o2) {
				return	o1.getNome().compareTo(o2.getNome());
			}
			
		});
		
		//Recebe o indice onde está o cliente na lista
		indice = Collections.binarySearch(clienteList, cliente, new Comparator<Cliente>() {

			@Override
			public int compare(Cliente o1, Cliente o2) {
				return o1.getNome().compareToIgnoreCase(o2.getNome());
			}
			
		});
		
		//Se o indice for menor que 0 retorna null, senão retorna o cliente
		if(indice < 0)
			return null;
					
		return clienteList.get(indice);
	}
	
	/**
	 * Obtém o cliente pelo cpf
	 * 
	 * @param cliente Referência de um objeto <code>Cliente</code>
	 * @return Retorna a referência de um objeto <code>Cliente</code> com o cpf especificado, se não for encontrado retorna null 
	 */
	public Cliente obterClientePorCpf(Cliente cliente) {
		
		//Recebe o índice do cliente pesquisado
		int indice = ordenaListaCliente(cliente);
		
		//Se o índice for menor que 0 retorna null, senão retorna o cliente
		if(indice < 0)
			return null;
		
		return clienteList.get(indice);	
	}
	
	/**
	 * Registar uma ordem de serviço
	 * 
	 * @param ordemDeServico Referência de um objeto <code>OrdemDeServico</code>
	 * @param componente Componente onde será apresentado a mensagem
	 */
	public void registrarOrdemDeServico(OrdemDeServico ordemDeServico, Component componente) {
		
		//Adiciona a ordem de serviço na lista
		ordemDeServicoList.add(ordemDeServico);
		showMessageDialog(componente, "Ordem de serviço registrada!", "Ordem de Serviço", INFORMATION_MESSAGE);
	}
	
	/**
	 * Altera uma ordem de serviço
	 * 
	 * @param ordemDeServico Referência de um objeto <code>OrdemDeServico</code> 
	 * @param posicao Posição na lista da ordem de servico
	 * @param componente Componente onde será apresentado a mensagem
	 * 
	 * @see #obterOrdemDeServico(int)
	 */
	public void alterarOrdemDeServico(OrdemDeServico ordemDeServico, int posicao, Component componente) {
		
		//Altera a ordem de serviço
		ordemDeServicoList.set(posicao, ordemDeServico);
		showMessageDialog(componente, "Ordem de serviço alterado com sucesso", "Alteração", INFORMATION_MESSAGE);
	}
	
	/**
	 * Obtém a quantidade de ordem de servico na lista
	 * 
	 * @return Retorna a quantidade de ordem de serviço registradas
	 */
	public int quantidadeOrdemDeServico() {
		return ordemDeServicoList.size();
	}
	
	/**
	 * Obtém uma ordem de serviço na posição especificada
	 * 
	 * @param posicao Posição na lista onde está a ordem de serviço
	 * @return Retorna a referência de um objeto <code>OrdemDeServico</code>
	 * 
	 * @see #obterOrdemDeServico(OrdemDeServico)
	 */
	public OrdemDeServico obterOrdemDeServico(int posicao) {
		return ordemDeServicoList.get(posicao);
	}
	
	/**
	 * Obtém uma ordem de serviço 
	 * 
	 * @param ordemDeServico Objeto do tipo <code>OrdemDeServico</code>
	 * @return Retorna a referência de um objeto <code>OrdemDeServico</code> se existir, senão retorna null
	 */
	public OrdemDeServico obterOrdemDeServico(OrdemDeServico ordemDeServico) {
		
		//Recebe a posição da ordem de serviço na lista
		int indice = ordenaListaOrdemDeServico(ordemDeServico);
		
		//Se o indice for menor que 0 retorna null
		if(indice < 0)
			return null;
					
		return ordemDeServicoList.get(indice);
	}

	/**
	 * Obtém a posição da ordem de serviço na lista
	 * 
	 * @param ordemDeServico Referência de um objeto <code>OrdemDeServico</code> 
	 * @return Retorna um <i>int</i> com a posição da ordem de servico, se encontrar retorna um número >= 0 de acordo com a posição
	 */
	public int obterPosicaoOrdemDeServico(OrdemDeServico ordemDeServico) {
		
		//Recebe o índice da ordem de serviço na lista
		int indice = ordenaListaOrdemDeServico(ordemDeServico);
	
		//Retorna o índice
		return indice;
	}
	
	/**
	 * Ordena a lista de ordem de serviço
	 * 
	 * @param ordemDeServico Referência de um objeto <code>OrdemDeServico</code>
	 * @return Retorna um <i>int</i> com a posição da ordem de servico, se encontrar retorna um número >= 0 de acordo com a posição
	 */
	private int ordenaListaOrdemDeServico(OrdemDeServico ordemDeServico) {
		int indice;
		
		//Ordena a lista de ordem de serviço
		ordemDeServicoList.sort(new Comparator<OrdemDeServico>() {

			@Override
			public int compare(OrdemDeServico o1, OrdemDeServico o2) {
				return o1.getNumeroOrdemDeServico().compareTo(o2.getNumeroOrdemDeServico());
			}
			
		});
		
		//Recebe o índice onde está a ordem de serviço pesquisada na tabela
		indice = Collections.binarySearch(ordemDeServicoList, ordemDeServico, new Comparator<OrdemDeServico>() {

			@Override
			public int compare(OrdemDeServico o1, OrdemDeServico o2) {
				return o1.getNumeroOrdemDeServico().compareTo(o2.getNumeroOrdemDeServico());
			}
			
		});
		
		//Retorna o índice
		return indice;
	}
	
	/**
	 * Exibe uma mensagem de erro
	 * 
	 * @param componente Componte de interface gráfica
	 * @param mensagem Mensagem a ser exibida em uma caixa de diálogo
	 * @param titulo Título da caixa de diálogo
	 */
	public void msgError(Component componente, String mensagem, String titulo) {
		showMessageDialog(componente, mensagem, titulo, ERROR_MESSAGE);
	}

	/**
	 * Exibe uma mensagem informativa
	 * 
	 * @param componente Componte de interface gráfica
	 * @param mensagem Mensagem a ser exibida em uma caixa de diálogo
	 * @param titulo Título da caixa de diálogo 
	 */
	public void msgInfo(Component componente, String mensagem, String titulo) {
		showMessageDialog(componente, mensagem, titulo, INFORMATION_MESSAGE);
	}
}