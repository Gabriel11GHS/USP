/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AgregacaoComposicao;

/**
 *
 * @author Junio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArvoreComposta aaComposta = new ArvoreComposta("Carnauba");
        aaComposta  = null; /*Este comando indica que a Árvore Composta pode ser
         deletada e, junto com ela, seu tronco e sua raíz*/
        
        Tronco tTronco = new Tronco();
        Raiz rRaiz = new Raiz();

        ArvoreAgregada aaArvoreAg = new ArvoreAgregada("PauBrasil", tTronco, rRaiz);
        aaArvoreAg = null; /*Este comando indica que a Árvore Composta pode ser
         deletada mas, neste caso, o tronco e a raíz são preservados e podem ser
         usados em outra instância de Árvore Agregada*/
        ArvoreAgregada aaArvoreAg2 = new ArvoreAgregada("PauBrasil", tTronco, rRaiz);
    }

}
