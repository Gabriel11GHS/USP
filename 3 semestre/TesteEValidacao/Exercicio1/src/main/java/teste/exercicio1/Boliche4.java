/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste.exercicio1;

/**
 *
 * @author gabriel
 */
public class Boliche4 {
    public int computaPlacar(String s) {
        int[] frames = new int[21];
        int frameIndex = 0;

        // Transforma a string em um array de inteiros representando os pinos derrubados
        for (char c : s.toCharArray()) {
            if (c == 'X') {
                frames[frameIndex] = 10;
                frameIndex++;
            } else if (c == '/') {
                frames[frameIndex] = 10 - frames[frameIndex - 1];
                frameIndex++;
            } else if (c == '-') {
                // Não faz nada, mantém o valor zero para o frame atual
            } else {
                frames[frameIndex] = Character.getNumericValue(c);
                frameIndex++;
            }
        }

        int score = 0;
        frameIndex = 0;

        // Calcula a pontuação total
        for (int i = 0; i < 10; i++) {
            if (frames[frameIndex] == 10) {
                // Strike
                score += 10 + frames[frameIndex + 1] + frames[frameIndex + 2];
                frameIndex++;
            } else if (frames[frameIndex] + frames[frameIndex + 1] == 10) {
                // Spare
                score += 10 + frames[frameIndex + 2];
                frameIndex += 2;
            } else {
                // Nenhum bônus
                score += frames[frameIndex] + frames[frameIndex + 1];
                frameIndex += 2;
            }
        }

        return score;
    }
}

public class BolicheTeste4 {
    private Boliche4 boliche = new Boliche4();

    public void testJogoSemPontuacao() {
        assertEquals(0, boliche.computaPlacar("--------------------"));
    }

    public void testJogoSemBonus() {
        assertEquals(90, boliche.computaPlacar("9-9-9-9-9-9-9-9-9-9-"));
    }

    public void testSpareSimples() {
        assertEquals(150, boliche.computaPlacar("5/5/5/5/5/5/5/5/5/5/5"));
    }

    public void testStrikeSimples() {
        assertEquals(300, boliche.computaPlacar("X-X-X-X-X-X-X-X-X-X-X"));
    }

    public void testSpareFinal() {
        assertEquals(149, boliche.computaPlacar("9-9-9-9-9-9-9-9-9/9-"));
    }

    public void testStrikeFinal() {
        assertEquals(200, boliche.computaPlacar("X-X-X-X-X-X-X-X-X-XX"));
    }

    public void testJogoPerfeito() {
        assertEquals(300, boliche.computaPlacar("XXXXXXXXXXXX"));
    }

    public void testJogoInvalido() {
        assertThrows("Erro", () -> boliche.computaPlacar(" !@!@#$%@");
    }
}
