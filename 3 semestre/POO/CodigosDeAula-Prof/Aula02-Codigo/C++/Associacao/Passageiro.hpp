#ifndef pass_file
#define pass_file

#include <math.h>
#include <string>
#include "Aviao.hpp"

using namespace std;

class Passageiro{
      private:
             string sNome;
             string sLocal;              
      public:            
            Passageiro(string sNome, string sLocal);
            string getsLocal();
            string getsNome();        
            void setsLocal(string sLocal);
            void setsNome(string sNome);
            
            /*Aqui Passageiro usa Aviao, mas não é composto de Aviao,
              portanto há uma associação - indicado por uma flecha saindo de
              Aviao e chegando em Passageiro*/
            void Viaja(Aviao* umAviao);
            
            /*Aqui Passageiro usa math.h, mas não é composto de math.h,
              portanto há uma associação - indicado por uma flecha saindo de
              math.h e chegando em Passageiro*/
            float CalculaQuadradoDeCabeca(int iNum);
};
#endif
