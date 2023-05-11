#include "Aviao.hpp"

using namespace std;
           
Aviao::Aviao(int iCodigo) {
    this->iCodigo = iCodigo;
};
string Aviao::Voa(){
    return sDestino;
};

void Aviao::setsDestino(string sDestino) {
    this->sDestino = sDestino;
};



