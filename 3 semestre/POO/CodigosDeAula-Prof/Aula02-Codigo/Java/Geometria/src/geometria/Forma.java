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
public class Forma {
    private String sNome;

    public Forma(String sNome) {
        this.sNome = sNome;
    }

    public String getsNome() {
        return sNome;
    }

    public void setsNome(String sNome) {
        this.sNome = sNome;
    }
    
    public float calculaArea(){
        System.out.println("Sou uma forma desconhecida");
        return -1;
    }
}
