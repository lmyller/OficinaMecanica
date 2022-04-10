package myller.trabalho1.oficina;

/**
 * Define os método, atributos e construtores da classe <code>Peca</code>
 * 
 * @author Luiz Myller Vidal
 * @version 0.1
 */
public class Peca {
	
	//Atributos da classe
	private int numeroPeca, quantidade;
	private float valorUnitario;
	private String descricaoPeca, valorTotal;
	
	/**
	 * Constrói uma <code>Peca</code> com os valores especificados nos parâmetros
	 * 
	 * @param numeroPeca Número da peça
	 * @param quantidade Quantidade da peça
	 * @param valorUnitario Valor unitário da peça
	 * @param valorTotal Valor total da peça
	 * @param descricaoPeca Descrição da peça
	 */
	public Peca(int numeroPeca, int quantidade, float valorUnitario, String valorTotal, String descricaoPeca) {
		this.numeroPeca = numeroPeca;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
		this.descricaoPeca = descricaoPeca;
	}

	/**
	 * Altera a quantidade da peça 
	 * 
	 * @param quantidade Um <code>int</code> contendo a quantidade de peca
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Altera o valor unitário da peça
	 * 
	 * @param valorUnitario Um <code>Float</code> contendo o valor unitário da peça
	 */
	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	/**
	 * Altera a descrição da peça
	 * 
	 * @param descricaoPeca Uma <code>String</code> contendo a descrição da peça
	 */
	public void setDescricaoPeca(String descricaoPeca) {
		this.descricaoPeca = descricaoPeca;
	}

	/**
	 * Altera o valor total da peça
	 * 
	 * @param valorTotal Uma <code>String</code> contendo o valor total da peça
	 */
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	/**
	 * Retorna o número da peça
	 * 
	 * @return Retorna um <code>int</code> contendo o número da peça
	 */
	public int getNumeroPeca() {
		return numeroPeca;
	}

	/**
	 * Retorna a quantidade da peça
	 * 
	 * @return Retorna um <code>int</code> contendo a quantidade de peças
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Retorna o valor Unitário da peça
	 * 
	 * @return Retorna um <code>float</code> contendo o valor unitário
	 */
	public float getValorUnitario() {
		return valorUnitario;
	}

	/**
	 * Retorna o valor total da peça
	 * 
	 * @return Retorna uma <code>String</code> contendo o valor total
	 */
	public String getValorTotal() {
		return valorTotal;
	}
	
	/**
	 * Retorna a descrição da peça
	 * 
	 * @return Retorna uma <code>String</code> contendo a descrição da peça
	 */
	public String getDescricaoPeca() {
		return descricaoPeca;
	}
}
