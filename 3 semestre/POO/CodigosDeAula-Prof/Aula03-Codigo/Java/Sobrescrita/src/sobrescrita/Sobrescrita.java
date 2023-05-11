/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sobrescrita;

/**
 *
 * @author Junio
 */
public class Sobrescrita {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MeuPlayer[] tocadores = new MeuPlayer[3];
        tocadores[0] = new MeuPlayerDeMusica();
        tocadores[1] = new MeuPlayerDeVideo();
        tocadores[2] = new PlayerDeVinil();
        
        tocadores[0].Toca("StarWars60.wav");
        tocadores[1].Toca("MomAndBaby.mov");        
        tocadores[2].Toca("disco.vni");

    }


}
