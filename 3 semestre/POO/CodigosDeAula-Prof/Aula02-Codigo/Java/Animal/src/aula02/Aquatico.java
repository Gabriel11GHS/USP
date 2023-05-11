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
public class Aquatico extends Animal{
    private float FprofMax;

    public Aquatico(float FprofMax, String sEspecie, float fPeso) {
        super(sEspecie, fPeso);
        this.FprofMax = FprofMax;
    }

    public Aquatico(float FprofMax) {
        this.FprofMax = FprofMax;
    }

    public void nadar(){
        System.out.println("Aquatico nadando.");
    }
}
