/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exemplo4heranca;

/**
 *
 * @author Junio
 */
public class Lambari extends Aquaticos{
    float fPeso;
    Lambari(String saNome, int umMinsDeFolego){
        super(saNome, umMinsDeFolego);
        fPeso = 1;
    }

    public float getfPeso() {
        return fPeso;
    }
    
}
