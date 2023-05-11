/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exemplo4heranca;

/**
 *
 * @author Junio
 */
public class Cachorro extends Terrestres{
    public String sRaca;
    Cachorro(String saNome, int umNroPatas, String sARaca){
        super(saNome,umNroPatas);
        sRaca = sARaca;
    }

    public String getsRaca() {
        return sRaca;
    }
    
}