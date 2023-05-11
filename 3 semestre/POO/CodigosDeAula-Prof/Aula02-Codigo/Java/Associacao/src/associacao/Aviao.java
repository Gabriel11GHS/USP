/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package associacao;

/**
 *
 * @author Junio
 */
public class Aviao {
  private int iCodigo;
  private String sDestino;

    public Aviao(int iCodigo) {
        this.iCodigo = iCodigo;
    }

    public String Voa(){
        return sDestino;
    }

    public void setsDestino(String sDestino) {
        this.sDestino = sDestino;
    }
    /*Aqui Aviao usa Passageiro, mas não é composto de Passageiro,
      portanto há uma associação - indicado por uma flecha saindo de
     Passageiro e chegando em Aviao*/
    public String DizNomeDoUltimoPassageiro(Passageiro umPass){
       return umPass.getsNome();
    }

}
