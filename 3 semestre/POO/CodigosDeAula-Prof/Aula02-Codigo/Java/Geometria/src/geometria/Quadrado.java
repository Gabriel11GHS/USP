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
public class Quadrado extends Forma{
    private float fLado;

    public Quadrado(float fLado, String sNome) {
        super(sNome);
        this.fLado = fLado;
    }
    
    public float calculaArea(){
        System.out.println("Sou um quadrado, minha area é " + (fLado*fLado));
        return fLado*fLado;
    }
   
}
