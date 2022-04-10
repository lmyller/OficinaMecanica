package myller.trabalho1.oficina;

import java.util.ArrayList;
import java.util.List;

/**
 * Define os método, atributos e construtores da classe <code>OrdemDeServico</code>
 * 
 * @author Luiz Myller Vidal
 * @version 0.1
 */
public class OrdemDeServico {
	
	//Atributos da classe
	private String numeroOrdemDeServico, data, hora, valorTotal;
	private Cliente cliente;
	private List<Peca> pecaList;
	private List<Servico> servicoList;
	
	/**
	 * Constrói uma ordem de serviço com valores default 
	 */
	public OrdemDeServico() {
		
		//Cria lista que armazena as peças e os serviços
		pecaList = new ArrayList<>();
		servicoList = new ArrayList<>();
	}
	
	/**
	 * Constrói uma ordem de serviço com os valores especificados nos parâmetros
	 * 
	 * @param numeroOrdemDeServico Número da ordem de serviço 
	 * @param data Data em que a ordem de serviço é gerada
	 * @param hora Hora em que a ordem de serviço é gerada 
	 * @param valorTotal Valor total da ordem de serviço
	 * @param cliente Cliente a quem está vinculada a ordem de serviço 
	 */
	public OrdemDeServico(String numeroOrdemDeServico, String data, String hora, String valorTotal, Cliente cliente) {
		this();
		this.numeroOrdemDeServico = numeroOrdemDeServico;
		this.data = data;
		this.hora = hora;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
	}

	/**
	 * Obtém a data da ordem de serviço
	 * 
	 * @return Retorna uma <code>String</code> contendo a data da ordem de serviço
	 */
	public String getData() {
		return data;
	}

	/**
	 * Obtém a data da ordem de serviço 
	 * 
	 * @return Retorna uma <code>String</code> contendo a hora
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * Obtém o valor total da ordem de serviço
	 * 
	 * @return Retorna uma <code>String</code> contendo o valor total da ordem de serviço 
	 */
	public String getValorTotal() {
		return valorTotal;
	}

	/**
	 * Altera o valor total da ordem de serviço 
	 * 
	 * @param valorTotal Uma <code>String</code> contendo o valor total
	 */
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	/**
	 * Altera o número da ordem de serviço 
	 * 
	 * @param numeroOrdemDeServico Uma <code>String</code> contendo o número da ordem de serviço 
	 */
	public void setNumeroOrdemDeServico(String numeroOrdemDeServico) {
		this.numeroOrdemDeServico = numeroOrdemDeServico;
	}

	/**
	 * Obtém o núemro da ordem de serviço 
	 * 
	 * @return Retorna uma <code>String</code> contendo o número da ordem de serviço 
	 */
	public String getNumeroOrdemDeServico() {
		return numeroOrdemDeServico;
	}

	/**
	 * Obtém a referência de um objeto <code>Cliente</code> vinculado à ordem de serviço 
	 * 
	 * @return Retorna uma referência do <code>Cliente</code>
	 */
	public Cliente getCliente() {
		return cliente;
	}
	
	/**
	 * Adiciona um serviço na ordem de serviço
	 * 
	 * @param servico Referência de um objeto <code>Servico</code>
	 */
	public void adicionarServico(Servico servico) {
		servicoList.add(servico);
	}
	
	/**
	 * Obtém a referência de um objeto <code>Serviço</code> na posição especificada
	 * 
	 * @param posicao Posição onde está o serviço a ser encontrado
	 * @return Retorna uma referência de um objeto <code>Servico</code>
	 */
	public Servico obterServico(int posicao) {
		return servicoList.get(posicao);
	}
	
	/**
	 * Obtém a quantidade de serviços cadastrados na ordem de serviço 
	 * 
	 * @return Retorna um inteiro contendo a quantidade de serviços cadastrados
	 */
	public int obterQuantidadeServico() {
		return servicoList.size();
	}
	
	/**
	 * Adiciona uma peça na ordem de serviço
	 * 
	 * @param peca Referência de um objeto <code>Peca</code>
	 */
	public void adicionarPeca(Peca peca) {
		pecaList.add(peca);
	}
	
	/**
	 * Obtém uma referência de um objeto <code>Peca</code>
	 * 
	 * @param posicao Posição onde está a peça a ser encontrado
	 * @return Retorna Retorna uma referência de um objeto <code>peca</code>
	 */
	public Peca obterPeca(int posicao) {
		return pecaList.get(posicao);
	}
	
	/**
	 * Obtém a quantidade de peças cadastrado na ordem de serviço 
	 * 
	 * @return Retorna um inteiro contendo a quantidade de peças cadastrados
	 */
	public int obterQuantidadePeca() {
		return pecaList.size();
	}
}
