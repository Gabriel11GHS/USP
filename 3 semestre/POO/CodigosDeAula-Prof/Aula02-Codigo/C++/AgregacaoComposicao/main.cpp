#include <cstdlib>
#include <iostream>
#include "ArvoreComposta.hpp"
#include "ArvoreAgregada.hpp"

using namespace std;

int main(int argc, char *argv[])
{
        ArvoreComposta* aaComposta = new ArvoreComposta("Carnauba");
        delete aaComposta; /*Este comando indica que a Árvore Composta pode ser
         deletada e, junto com ela, seu tronco e sua raíz*/
        
        Tronco* tTronco = new Tronco();
        Raiz* rRaiz = new Raiz();

        ArvoreAgregada* aaArvoreAg = new ArvoreAgregada("PauBrasil", tTronco, rRaiz);
        delete aaArvoreAg; /*Este comando indica que a Árvore Composta pode ser
         deletada mas, neste caso, o tronco e a raíz são preservados e podem ser
         usados em outra instância de Árvore Agregada*/
        ArvoreAgregada* aaArvoreAg2 = new ArvoreAgregada("PauBrasil", tTronco, rRaiz);
}
