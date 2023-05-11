#ifndef aviao_file
#define aviao_file

#include <string>

using namespace std;

class Aviao{
      private:
             int iCodigo;
             string sDestino;              
      public:            
            Aviao(int iCodigo);
            string Voa();            
            void setsDestino(string sDestino);
            /*No código C++ não temos Aviao usando Passageiro como no exemplo
              Java, isso pois C++ não permite (diretamente) referências cruzadas
              (cross include). No caso, não é possível que Aviao inclua Passageiro
              e Passageiro inclua Aviao; aqui temos apenas Passageiro incluindo Aviao*/
};
#endif
