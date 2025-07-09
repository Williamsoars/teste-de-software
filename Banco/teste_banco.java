package banco;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteBancoUnidade {
    private Banco banco;
    private RepositorioContas repoMock;

    @BeforeEach
    void setUp() {
        repoMock = mock(RepositorioContas.class);
        banco = new Banco(repoMock);
    }

    @Test
    void adicionarConta_novaConta_sucesso() {
        Conta conta = new Conta("1", 100);
        when(repoMock.existe("1")).thenReturn(false);

        banco.adicionarConta(conta);

        verify(repoMock).inserir(conta);
    }

    @Test
    void adicionarConta_contaJaExiste_excecao() {
        Conta conta = new Conta("1", 100);
        when(repoMock.existe("1")).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> banco.adicionarConta(conta));
    }

    @Test
    void sacar_contaExiste_saldoSuficiente() {
        Conta conta = new Conta("1", 200);
        when(repoMock.procurar("1")).thenReturn(conta);

        banco.sacar("1", 50);

        assertEquals(150, conta.getSaldo());
        verify(repoMock).atualizar(conta);
    }

    @Test
    void sacar_contaInexistente_excecao() {
        when(repoMock.procurar("1")).thenReturn(null);

        assertThrows(NoSuchElementException.class, () -> banco.sacar("1", 50));
    }
}
