package banco;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class TesteRepositorioContasArquivoTxt {
    @Test
    void inserirEProcurarConta_emArquivo(@TempDir Path tempDir) throws IOException {
        Path path = tempDir.resolve("contas.txt");
        RepositorioContasArquivoTxt repo = new RepositorioContasArquivoTxt(path.toString());
        Conta c = new Conta("3", 300);
        repo.inserir(c);

        Conta achada = repo.procurar("3");
        assertNotNull(achada);
        assertEquals("3", achada.getNumero());
    }
}
