/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio02.sistemaoper;

/**
 *
 * @author gabriel
 */
public class Drivers extends SistOperacional{
    public String nome;
    private boolean estado;
    private boolean vStatus;
    
    
    
    public void ligaDispositivo{
        estado = true;
    }
    
    public void desligaDispositivo{
        estado = false;
    }
    
    public void verificaStatus{       
        if (estado == true) {
            vStatus = true;
            return true;                
        }
    }
    
    public void executaTeste{
        if(vStatus == true){
            System.out.println("Teste Executado!");
        }
    }
}
