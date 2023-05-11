/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javainterfaceexemplo;

/**
 *
 * @author Jose F Rodrigues-Jr
 */
public class Marmita implements Pagavel{
    int iQtd;

    public Marmita(int iQtd) {
        this.iQtd = iQtd;
    }
    
    public int getValorDoPagamento() {
        return this.iQtd*5;
    }
    
}
