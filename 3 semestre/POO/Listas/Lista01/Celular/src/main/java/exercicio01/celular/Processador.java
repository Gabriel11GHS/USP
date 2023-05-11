/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio01.celular;

/**
 *
 * @author gabriel
 */
public class Processador {
    public String pModel;
    private String pClock;
    
    
    private boolean ligado;
        
        public Processador() {
            this.ligado = false;
        }
        
        public void ligar() {
            this.ligado = true;
        }
        
        public void desligar() {
            this.ligado = false;
        }
    
}
