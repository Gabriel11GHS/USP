/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AgregacaoComposicao;

/**
 *
 * @author Junio
 */
public class ArvoreAgregada {
    private String sSpecie;
    Tronco tTronco;
    Raiz rRaiz;

    public ArvoreAgregada(String sSpecie, Tronco tTronco, Raiz rRaiz) {
        /*Aqui, o tronco e a raíz da Árvore Agregada são passados como parâmetros
          já instanciados para uma dada instância de Árvore Agregada; se uma dada
          instância for deletada, o tronco e a raíz podem ser atribuídos a outra
          Árvore Agregada.*/
        this.sSpecie = sSpecie;
        this.tTronco = tTronco;
        this.rRaiz = rRaiz;
    }

}
