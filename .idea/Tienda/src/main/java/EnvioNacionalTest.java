package.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;


/**
 * Clase para probar el envío nacional
 * @author Yinireth Erazo Rendón
 * @since 2026-10
 *
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */


class EnvioNacionalTest {
    /**
     * Instancia para el manejo de logs
     */
    private static final Logger LOG = Logger.getLogger(EnvioNacionalTest.class.getName());
    @BeforeAll
    public void inicializar(){

    }

    @org.junit.jupiter.api.Test
    void calcularCosto() {
        LOG.info("Inicio de prueba nombrePrueba...");
        // codigo de la prueba

        EnvioNacional envio = new EnvioNacional("1234","JorgePro", 10, "Quimbaya", true);

        double actual = envio.CalcularCosto();
        double esperado = 120_000;

        assertNotEquals(esperado,actual);

        LOG.info("Fin de prueba registrarJugadorEquipo...");

    }
}