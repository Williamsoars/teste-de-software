package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteRepositorioContasArray {
    private RepositorioContasArray repo;

    @BeforeEach
    void setUp() {
        repo = new RepositorioContasArray(10);
    }

    @Test
    void inserirEProcurarConta_sucesso() {
        Conta c = new Conta("1", 100);
        repo.inserir(c);
        assertEquals(c, repo.procurar("1"));
    }

    @Test
    void removerConta_sucesso() {
        Conta c = new Conta("2", 200);
        repo.inserir(c);
        repo.remover("2");
        assertNull(repo.procurar("2"));
    }
}
