#include <string>
#include "Raiz.hpp"
#include "Tronco.hpp"

using namespace std;

class ArvoreComposta {
    private:
            string sSpecie;
            Tronco* tTronco;
            Raiz* rRaiz;

    public:
       ArvoreComposta(string sSpecie) {
        /*Como o tronco e a raiz são responsabilidade exclusiva de cada instancia
         de Árvore Composta, eles não poderiam ser passados para outras instancias
         de Árvore Composta caso uma dada instancia fosse deletada - Composição*/
        this->sSpecie = sSpecie;
        this->tTronco = new Tronco();
        this->rRaiz = new Raiz();
       };
       ~ArvoreComposta(){
           delete tTronco;
           delete rRaiz;              
       };
};
