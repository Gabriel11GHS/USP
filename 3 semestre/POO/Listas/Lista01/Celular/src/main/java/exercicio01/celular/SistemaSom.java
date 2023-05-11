/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio01.celular;

/**
 *
 * @author gabriel
 */
public class SistemaSom {
    public String somModel;
    private int volume;
    
    // Funcionalidades do sistema de som
    public SistemaSom() {
            this.volume = 50;
        }
        
        public void aumentarVolume() {
            this.volume += 10;
        }
        
        public void diminuirVolume() {
            this.volume -= 10;
        }
}
