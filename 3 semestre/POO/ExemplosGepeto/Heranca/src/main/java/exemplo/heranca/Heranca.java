/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package exemplo.heranca;

/**
 *
 * @author RoboQueVaiDominarOMundo
 */
public abstract class DispositivoDeArmazenamento {
   private String marca;
   private long capacidade;
   
   public DispositivoDeArmazenamento(String marca, long capacidade) {
      this.marca = marca;
      this.capacidade = capacidade;
   }
   
   public String getMarca() {
      return marca;
   }
   
   public long getCapacidade() {
      return capacidade;
   }
   
   public abstract boolean estaConectado();
}

public class DiscoRigido extends DispositivoDeArmazenamento {
   private int velocidadeRotacao;
   
   public DiscoRigido(String marca, long capacidade, int velocidadeRotacao) {
      super(marca, capacidade);
      this.velocidadeRotacao = velocidadeRotacao;
   }
   
   public int getVelocidadeRotacao() {
      return velocidadeRotacao;
   }
   
   public boolean estaConectado() {
      // Verifica se o disco rígido está conectado
      return true;
   }
}

public class PenDrive extends DispositivoDeArmazenamento {
   private String tipoConector;
   
   public PenDrive(String marca, long capacidade, String tipoConector) {
      super(marca, capacidade);
      this.tipoConector = tipoConector;
   }
   
   public String getTipoConector() {
      return tipoConector;
   }
   
   public boolean estaConectado() {
      // Verifica se o pen drive está conectado
      return true;
   }
}

