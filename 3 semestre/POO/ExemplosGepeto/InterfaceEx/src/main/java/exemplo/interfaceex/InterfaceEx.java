/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package exemplo.interfaceex;

/**
 *
 * @author RoboQueVaiDominarOMundo
 */
public interface DispositivoDeArmazenamento {
   public long getCapacidade();
   public boolean estaConectado();
   public void conectar();
   public void desconectar();
}

public class DiscoRigido implements DispositivoDeArmazenamento {
   private long capacidade;
   private boolean conectado;

   public DiscoRigido(long capacidade) {
      this.capacidade = capacidade;
      this.conectado = false;
   }

   public long getCapacidade() {
      return this.capacidade;
   }

   public boolean estaConectado() {
      return this.conectado;
   }

   public void conectar() {
      // código para conectar o disco rígido
      this.conectado = true;
   }

   public void desconectar() {
      // código para desconectar o disco rígido
      this.conectado = false;
   }
}
