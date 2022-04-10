package myller.trabalho1.oficina;

import java.util.List;

/**
 * Define métodos para calcular as receitas da oficina
 * 
 * @author Luiz Myller Vidal
 * @version 0.1
 */
public interface Receita {

	/**
	 * Calcula a receita total dos serviços
	 * 
	 * @param valorServicosList Uma lista contendo o valor de cada serviço
	 * @return Retorna um <code>float</code> com o valor total dos serviços
	 */
	float receitaComServicos(List<Float> valorServicosList);
	
	/**
	 * Calcula a receita total das peças
	 * 
	 * @param valorPecasList Uma lista contendo o valor total de cada peça
	 * @return Retorna um <code>float</code> com o valor total das peças
	 */
	float receitaComPecas(List<Float> valorPecasList);
	
	/**
	 * Calcula a receita total 
	 * 
	 * @param valorTotalPecas O valor total da peças
	 * @param valorTotalServicos O valor total dos serviços
	 * @return Retorna um <code>float</code> com o valor total de vendas
	 */
	float receitaTotal(float valorTotalPecas, float valorTotalServicos);
}
