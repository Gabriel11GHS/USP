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
public class Geometria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Forma[] formas = new Forma[4];
        
        formas[0] = new Forma("desconhecida");
        formas[1] = new Quadrado(5, "quadrado");
        formas[2] = new Circulo(3, "circulo");
        formas[3] = new TriangRet(4,6,"triangulo retangulo");
        
        for(int i = 0; i <= 3; i++)
            formas[i].calculaArea();
        
    }
    
}
