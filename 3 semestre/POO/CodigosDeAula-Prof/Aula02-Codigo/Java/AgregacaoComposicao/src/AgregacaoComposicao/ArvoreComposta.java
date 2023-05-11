/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AgregacaoComposicao;

/**
 *
 * @author Junio
 */
public class ArvoreComposta {
    private String sSpecie;
    Tronco tTronco;
    Raiz rRaiz;

    public ArvoreComposta(String sSpecie) {
        /*Como o tronco e a raiz são responsabilidade exclusiva de cada instancia
         de Árvore Composta, eles não poderiam ser passados para outras instancias
         de Árvore Composta caso uma dada instancia fosse deletada - Composição*/
        this.sSpecie = sSpecie;
        this.tTronco = new Tronco();
        this.rRaiz = new Raiz();
    }
}
