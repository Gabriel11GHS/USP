/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package exercicio01.celular;

/**
 *
 * @author gabriel
 */
public class Celular {
    private String mModel;
    Processador pProcessador;
    TelaTouch tTela;
    SistemaSom sSom;
    SistemaComunicacao sComunicacao;
    
    public Celular() {
        this.pProcessador = new Processador();
        this.tTela = new TelaTouch();
        this.sSom = new SistemaSom();
        this.sComunicacao = new SistemaComunicacao();
    }
           
    // Funcionalidades do processador
    private void ligar() {
        pProcessador.ligar();
    }
    
    public void desligar() {
        pProcessador.desligar();
    }
    
    // Funcionalidades da tela
    private void ajustarBrilho(int nivel) {
        tTela.ajustarBrilho(nivel);
    }
    
    public void exibirMensagem(String mensagem) {
        tTela.exibirMensagem(mensagem);
    }
    
    // Funcionalidades do sistema de som
    private void aumentarVolume() {
        sSom.aumentarVolume();
    }
    
    public void diminuirVolume() {
        sSom.diminuirVolume();
    }
    
    // Funcionalidades do sistema de comunicação
    private void conectarRedeWifi() {
        sComunicacao.conectarRedeWifi();
    }
    
    public void desconectarRedeWifi() {
        sComunicacao.desconectarRedeWifi();
    }
    
    // Outras funcionalidades
    public void realizarChamada(String numero) {
        // Implementação da funcionalidade para realizar chamadas
    }
    
    public void receberChamada(String numero) {
        // Implementação da funcionalidade para receber chamadas
    }
   
}
