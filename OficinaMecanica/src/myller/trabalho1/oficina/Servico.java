package myller.trabalho1.oficina;

/**
 * Define os método, atributos e construtores da classe <code>Servico</code>
 * 
 * @author Luiz Myller Vidal
 * @version 0.1
 */
public class Servico {

	//Atributos da classe
	private int numeroServico;
	private String descricaoServico, precoServico;
	
	/**
	 * Constrói um <code>Servico</code> com os valores especificados nos parâmetros
	 * 
	 * @param numeroServico Número do serviço
	 * @param precoServico Preço do serviço
	 * @param descricaoServico Descrição do serviço
	 */
	public Servico(int numeroServico, String precoServico, String descricaoServico) {
		this.numeroServico = numeroServico;
		this.precoServico = precoServico;
		this.descricaoServico = descricaoServico;
	}
	
	/**
	 * Altera a descrição do serviço
	 * 
	 * @param descricaoServico Uma <code>String</code> contendo a descrição do serviço
	 */
	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	/**
	 * Altera o preço do serviço
	 * 
	 * @param precoServico Uma <code>String</code> contendo o preço do serviço
	 */
	public void setPrecoServico(String precoServico) {
		this.precoServico = precoServico;
	}

	/**
	 * Retorna o número do serviço
	 * 
	 * @return Retorna um <code>int</code> contendo o número do serviço
	 */
	public int getNumeroServico() {
		return numeroServico;
	}

	/**
	 * Retorna o preço do serviço
	 * 
	 * @return Retorna uma <code>String</code> contendo o preço do serviço
	 */
	public String getPrecoServico() {
		return precoServico;
	}

	/**
	 * Retorna a descrição do serviço
	 * 
	 * @return Retorna uma <code>String</code> contendo a descrição do serviço
	 */
	public String getDescricaoServico() {
		return descricaoServico;
	}
}
