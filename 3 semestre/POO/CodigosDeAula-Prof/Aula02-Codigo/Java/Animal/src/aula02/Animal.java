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
public class Animal {
    private String sEspecie;
    private float fPeso;

    
    
    public String getsEspecie() {
        return sEspecie;
    }

    public void setsEspecie(String sEspecie) {
        this.sEspecie = sEspecie;
    }

    public float getfPeso() {
        return fPeso;
    }

    public void setfPeso(float fPeso) {
        this.fPeso = fPeso;
    }


    public Animal(String sEspecie, float fPeso) {
        this.sEspecie = sEspecie;
        this.fPeso = fPeso;
    }    

    public Animal() {
    }
    
    public void comer(){
        System.out.println("Animal comendo.");
    }
    
}
