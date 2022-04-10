package myller.trabalho1.oficina;

import java.util.ArrayList;
import java.util.List;

/**
 * Define os método, atributos e construtores da classe <code>Cliente</code>
 * 
 * @author Luiz Myller Vidal
 * @version 0.1
 */
public class Cliente {
	
	//Atributos da classe
	private String nome, cpf, email, telefone, endereco;
	private List<Automovel> automovelList;
	
	/**
	 *  Constrói um <code>Cliente</code> com valores default 
	 */
	public Cliente() {
		
		//Cria lista de automóveis
		automovelList = new ArrayList<>();
	}
	
	/**
	 * Constrói um <code>Cliente</code> com os valores especificados nos parâmetros  
	 * 
	 * @param nome Nome do cliente
	 * @param cpf Cpf do cliente
	 * @param email Email do cliente
	 * @param telefone Telefone do cliente
	 * @param endereco Endereço do cliente
	 */
	public Cliente(String nome, String cpf, String email, String telefone, String endereco) {
		this();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	/**
	 * Retorna o nome do cliente
	 * 
	 * @return Retorna uma <code>String</code> contendo o nome do cliente
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Altera o nome do cliente
	 * 
	 * @param nome Uma <code>String</code> contendo o novo nome do cliente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o cpf do cliente
	 * 
	 * @return Retorna uma <code>String</code> contendo o cpf do cliente
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Altera o cpf do cliente
	 * 
	 * @param cpf Uma <code>String</code> contendo o novo cpf do cliente
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Retorna o email do cliente
	 * 
	 * @return Retorna uma <code>String</code> contendo o email do cliente
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Retorna o telefone do cliente
	 * 
	 * @return Retorna uma <code>String</code> contendo o telefone do cliente
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Retorna o endereço do cliente
	 * 
	 * @return Retorna uma <code>String</code> contendo o endereço do cliente
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Adiciona um automóvel vinculado ao cliente
	 * 
	 * @param automovel Referência de um objeto <code>Automovel</code>
	 */
	public void adicionarAutomovel(Automovel automovel) {
		automovelList.add(automovel);
	}
	
	/**
	 * Obtém um automóvel na posição especificada
	 * 
	 * @param posicao Um <code>int</code> contendo a posição onde está o automóvel
	 * @return Retorna a referência de um objeto <code>Automóvel</code>
	 */
	public Automovel obterAutomovel(int posicao) {
		return automovelList.get(posicao);
	}
	
	/**
	 * Retorna a quantidade de automóveis cadastrados para o cliente
	 * 
	 * @return Retorna um <code>int</code> contendo a quantidade de automóveis cadastrados
	 */
	public int obterNumeroAutomoveis() {
		return automovelList.size();
	}
}
