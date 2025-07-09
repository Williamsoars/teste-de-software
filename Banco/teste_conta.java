package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteConta {

    @Test
    void depositar_valorPositivo_aumentaSaldo() {
        Conta conta = new Conta("1", 100);
        conta.depositar(50);
        assertEquals(150, conta.getSaldo());
    }

    @Test
    void depositar_valorNegativo_excecao() {
        Conta conta = new Conta("1", 100);
        assertThrows(IllegalArgumentException.class, () -> conta.depositar(-10));
    }

    @Test
    void sacar_valorValido_diminuiSaldo() {
        Conta conta = new Conta("1", 100);
        conta.sacar(40);
        assertEquals(60, conta.getSaldo());
    }

    @Test
    void sacar_valorExcedente_excecao() {
        Conta conta = new Conta("1", 100);
        assertThrows(IllegalArgumentException.class, () -> conta.sacar(200));
    }
}
