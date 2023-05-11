/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio01.celular;

/**
 *
 * @author gabriel
 */
public class SistemaComunicacao {
    private boolean redeWifiConectada;
        
        public SistemaComunicacao() {
            this.redeWifiConectada = false;
        }
        
        public void conectarRedeWifi() {
            this.redeWifiConectada = true;
        }
        
        public void desconectarRedeWifi() {
            this.redeWifiConectada = false;
        }

}
    

