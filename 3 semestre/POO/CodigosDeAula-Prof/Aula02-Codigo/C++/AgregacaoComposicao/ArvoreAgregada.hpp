#include <string>
#include "Raiz.hpp"
#include "Tronco.hpp"

using namespace std;

class ArvoreAgregada {
    private:
            string sSpecie;
            Tronco* tTronco;
            Raiz* rRaiz;

    public:
       ArvoreAgregada(string sSpecie, Tronco* tTronco, Raiz* rRaiz) {
        /*Aqui, o tronco e a raíz da Árvore Agregada são passados como parâmetros
          já instanciados para uma dada instância de Árvore Agregada; se uma dada
          instância for deletada, o tronco e a raíz podem ser atribuídos a outra
          Árvore Agregada.*/
        this->sSpecie = sSpecie;
        this->tTronco = tTronco;
        this->rRaiz = rRaiz;
    };
};
