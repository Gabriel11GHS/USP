/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package associacao;

/**
 *
 * @author Junio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Passageiro pPass = new Passageiro("Adenilso","EUA");

        Aviao aMeuAviao = new Aviao(888);
        aMeuAviao.setsDestino("Cuba");
        
        System.out.println(pPass.getsLocal());
        pPass.Viaja(aMeuAviao);
        System.out.println(pPass.getsLocal());
        System.out.println(aMeuAviao.DizNomeDoUltimoPassageiro(pPass));

        System.out.println("Quadrado " + pPass.CalculaQuadradoDeCabeca(12));
    }

}
