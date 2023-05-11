#include "Passageiro.hpp"

using namespace std;

Passageiro::Passageiro(string sNome, string sLocal){
  this->sNome = sNome;
  this->sLocal = sLocal;
};
string Passageiro::getsLocal() {
    return sLocal;
};

string Passageiro::getsNome() {
    return sNome;
};

void Passageiro::setsLocal(string sLocal) {
    this->sLocal = sLocal;
};

void Passageiro::setsNome(string sNome) {
    this->sNome = sNome;
};

/*Aqui Passageiro usa Aviao, mas não é composto de Aviao,
  portanto há uma associação - indicado por uma flecha saindo de
  Aviao e chegando em Passageiro*/
void Passageiro::Viaja(Aviao* umAviao){
    sLocal = umAviao->Voa();
};

/*Aqui Passageiro usa Math, mas não é composto de Math,
  portanto há uma associação - indicado por uma flecha saindo de
  Math e chegando em Passageiro*/
float Passageiro::CalculaQuadradoDeCabeca(int iNum){
    return (float) pow(iNum, 2);
};  

