package banco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteContaImposto {
    @Test
    void sacar_valorComImposto_aplicaDesconto() {
        ContaImposto c = new ContaImposto("1", 200);
        c.sacar(100);
        assertEquals(99, c.getSaldo()); // 100 + 1 de imposto
    }
}
