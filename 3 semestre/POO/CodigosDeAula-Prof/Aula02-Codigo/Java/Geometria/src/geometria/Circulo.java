/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package geometria;

/**
 *
 * @author 2373891
 */
public class Circulo extends Forma{
    float fRaio;

    public Circulo(float fRaio, String sNome) {
        super(sNome);
        this.fRaio = fRaio;
    }
    
    public float calculaArea(){        
                System.out.println("Sou um circulo");
        return (float)Math.PI*fRaio*fRaio;
    }
}
