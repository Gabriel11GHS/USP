/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio01.celular;

/**
 *
 * @author gabriel
 */
public class TelaTouch {
    // Classe interna para a tela
    public String tModel;
    private String tHertz;
    private int brilho;
        
        public TelaTouch() {
            this.brilho = 50;
        }
        
        public void ajustarBrilho(int nivel) {
            this.brilho = nivel;
        }
        
        public void exibirMensagem(String mensagem) {
            // Implementação da funcionalidade para exibir mensagens na tela
        }
}
    

