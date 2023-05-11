/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exemplo4heranca;

/**
 *
 * @author Junio
 */
/*           Terrestre   é um   Animal*/
public class Terrestres extends Animal{
    int iNrPatas;
    Terrestres(String saNome, int umNroPatas){
        super(saNome);
        iNrPatas = umNroPatas;
    }

    Terrestres(int umNroPatas){
        super("Terrestre");
        iNrPatas = umNroPatas;
    }    
    
    public int getiNrPatas() {
        return iNrPatas;
    }
    
    /*Sobreescrita = override*/    
    public String getsNome() {
        return "Eu sou um animal terrestre chamado " + sNome;
    }  
    
}
