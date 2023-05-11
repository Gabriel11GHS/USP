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
public class TriangRet extends Forma{
    float fCateloA, fCatetoO;

    public TriangRet(float fCateloA, float fCatetoO, String sNome) {
        super(sNome);
        this.fCateloA = fCateloA;
        this.fCatetoO = fCatetoO;
    }
    public float calculaArea(){
                System.out.println("Sou um triangulo");
        return fCateloA*fCatetoO/2;
    }
}
