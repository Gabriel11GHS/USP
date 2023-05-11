/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package associacao;

/**
 *
 * @author Junio
 */
public class Passageiro {
    private String sNome;
    private String sLocal;

    public Passageiro(String sNome, String sLocal) {
        this.sNome = sNome;
        this.sLocal = sLocal;
    }

    public String getsLocal() {
        return sLocal;
    }

    public String getsNome() {
        return sNome;
    }

    public void setsLocal(String sLocal) {
        this.sLocal = sLocal;
    }

    public void setsNome(String sNome) {
        this.sNome = sNome;
    }

    /*Aqui Passageiro usa Aviao, mas não é composto de Aviao,
      portanto há uma associação - indicado por uma flecha saindo de
     Aviao e chegando em Passageiro*/
    public void Viaja(Aviao umAviao){
        sLocal = umAviao.Voa();
    }

    /*Aqui Passageiro usa Math, mas não é composto de Math,
      portanto há uma associação - indicado por uma flecha saindo de
     Math e chegando em Passageiro*/
    public float CalculaQuadradoDeCabeca(int iNum){
        return (float) Math.pow(iNum, 2);
    }

}
