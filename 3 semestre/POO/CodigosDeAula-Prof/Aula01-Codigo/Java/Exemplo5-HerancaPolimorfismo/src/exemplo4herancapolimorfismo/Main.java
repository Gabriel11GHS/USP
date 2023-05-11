/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exemplo4herancapolimorfismo;

/**
 *
 * @author Junio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Forma c = new CirculoColorido("Bola", 2);
        System.out.println(c.dizSeuNome());
    
        /*Forma umQuad = new Quadrado("quarteirao", 4);

        Forma formaQualquer = null;
        formaQualquer = umQuad;
        formaQualquer.MostraNome();
        System.out.println(formaQualquer.CalculaArea());
        formaQualquer = umCirc;
        formaQualquer.MostraNome();
        System.out.println(formaQualquer.CalculaArea());*/
        
        /*Forma[] fs = new Forma[3];
        fs[0] = new Circulo("A",2);
        fs[1] = new Quadrado("B",3);
        fs[2] = new Losango("C",4);
        float fTemp;
        for(Forma f: fs){
            fTemp = f.CalculaArea();
            System.out.println(fTemp);  
        }*/
    }

}
