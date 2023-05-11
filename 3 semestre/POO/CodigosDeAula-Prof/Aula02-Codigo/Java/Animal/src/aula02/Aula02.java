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
public class Aula02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Animal a1;
        Animal a2;
        Animal a3;
        
        a1 = new Animal("zzz", 10);
        a2 = new Terrestre(4, 30, "xxx", 25);
        a3 = new Aquatico(1000, "yyy", 15);
        
        a1.comer();
        a2.comer();
        a3.comer();
        
        if(a3 instanceof Terrestre)
           ((Terrestre)a3).correr();
        else
           ((Aquatico)a3).nadar();            
                
    }
    
}
