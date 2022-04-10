package myller.trabalho1.oficina;

/**
 * Define os método, atributos e construtores da classe <code>Automovel</code>
 * 
 * @author Luiz Myller Vidal
 * @version 0.1
 */
public class Automovel{
	
	//Atributos da classe
	private String codigo, marca, modelo, combustivel, placa;
	private int quilometragem, anoModelo;
	
	/**
	 *  Constrói um <code>Automovel</code> com valores default 
	 */
	public Automovel() {
		codigo = marca = modelo = combustivel = placa = "";
	}

	/**
	 * Constrói um <code>Automovel</code> com os valores especificados nos parâmetros  
	 * 
	 * @param codigo Código do automóvel
	 * @param marca Marca do automóvel
	 * @param modelo Modelo do automóvel
	 * @param combustivel Combustível do automóvel
	 * @param placa Placa do automóvel
	 * @param anoModelo Ano modelo do automóvel
	 * @param quilometragem Quilometragem do automóvel
	 */
	public Automovel(String codigo, String marca, String modelo, String combustivel, String placa, int anoModelo,
			int quilometragem) {
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.combustivel = combustivel;
		this.placa = placa;
		this.quilometragem = quilometragem;
	}

	/**
	 * Obtém o código do automóvel
	 * 
	 * @return Retorna uma <code>String</code> contendo o código do automóvel
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Obtém a marca do automóvel
	 * 
	 * @return Retorna uma <code>String</code> contendo a marca do automóvel
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Altera a marca do automóvel
	 * 
	 * @param marca Marca do automóvel
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Obtém o modelo do automóvel
	 * 
	 * @return Retorna uma <code>String</code> contendo o modelo do automóvel
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Altera o modelo do automóvel
	 * 
	 * @param modelo Modelo do automóvel
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Obtém o ano modelo do automóvel
	 * 
	 * @return Retorna um <code>int</code> contendo o ano modelo do automóvel
	 */
	public int getAnoModelo() {
		return anoModelo;
	}

	/**
	 * Altera o ano modelo do automóvel
	 * 
	 * @param anoModelo Ano modelo do automóvel
	 */
	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	/**
	 * Obtém o tipo de combustível do automóvel
	 * 
	 * @return Retorna uma <code>String</code> contendo o tipo de combustível do automóvel
	 */
	public String getCombustivel() {
		return combustivel;
	}

	/**
	 * Altera o tipo de combustível do automóvel
	 * 
	 * @param combustivel O tipo de combustível do automóvel
	 */
	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	/**
	 * Obtém a placa do veículo
	 * 
	 * @return Retorna uma <code>String</code> contendo a placa do automóvel
	 */
	public String getPlaca() {
		return placa;
	}

	/**
	 * Altera a placa do automóvel
	 * 
	 * @param placa Placa do automóvel
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}

	/**
	 * Obtém a quilometragem do automóvel
	 * 
	 * @return Retorna uma <code>String</code> contendo a quilometragem do automóvel
	 */
	public int getQuilometragem() {
		return quilometragem;
	}

	/**
	 * Altera a quilometragem do automóvel
	 * 
	 * @param quilometragem Quilometragem do automóvel
	 */
	public void setQuilometragem(int quilometragem) {
		this.quilometragem = quilometragem;
	}
}
