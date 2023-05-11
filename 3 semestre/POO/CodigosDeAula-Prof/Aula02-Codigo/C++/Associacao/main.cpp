#include <cstdlib>
#include <iostream>
#include "Aviao.hpp"
#include "Passageiro.hpp"

using namespace std;

int main(int argc, char *argv[])
{
        Passageiro *pPass = new Passageiro("Adenilso","EUA");

        Aviao *aMeuAviao = new Aviao(888);
        aMeuAviao->setsDestino("Cuba");
        
        cout << pPass->getsLocal() << "\n";
        pPass->Viaja(aMeuAviao);
        cout << pPass->getsLocal() << "\n";

        cout << "Quadrado " << pPass->CalculaQuadradoDeCabeca(12) << "\n";
}
