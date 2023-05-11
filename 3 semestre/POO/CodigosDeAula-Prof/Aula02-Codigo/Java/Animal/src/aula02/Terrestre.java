/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aula02;

/**
 *
 * @author 2373891
 */
public class Terrestre extends Animal{
    private int iNroPatas;
    private float fVelCorrida;
    
    public Terrestre() {
    }

    public Terrestre(int iNroPatas, float fVelCorrida, String sEspecie, float fPeso) {
        super(sEspecie, fPeso);
        this.iNroPatas = iNroPatas;
        this.fVelCorrida = fVelCorrida;
    }

    public Terrestre(int iNroPatas, float fVelCorrida) {
        this.iNroPatas = iNroPatas;
        this.fVelCorrida = fVelCorrida;
    }
    
    public void correr(){
        System.out.println("Terrestre correndo.");
    }
}
