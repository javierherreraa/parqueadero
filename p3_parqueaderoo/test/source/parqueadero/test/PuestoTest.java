package parqueadero.test;

import junit.framework.TestCase;
import parqueadero.mundo.Carro;
import parqueadero.mundo.Puesto;

/**
 * Pruebas para la clase Puesto
 */
public class PuestoTest extends TestCase
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * El puesto para el escenario 1
     */
    private Puesto puesto1;

    /**
     * El carro para escenario 1
     */
    private Carro carro1;

    /**
     * El puesto para el escenario 2
     */
    private Puesto puesto2;

    /**
     * El carro para el escenario 2
     */
    private Carro carro2;

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Inicializa el escenario 1: un puesto y un carro, pero el puesto est� vac�o
     */
    private void setupEscenario1( )
    {
        carro1 = new Carro( "aaa111", 6 );
        puesto1 = new Puesto( 1 );
    }

    /**
     * Inicializa el escenario 2: un puesto y un carro parqueado en el puesto
     */
    private void setupEscenario2( )
    {
        carro2 = new Carro( "bbb222", 6 );
        puesto2 = new Puesto( 2 );
        puesto2.parquearCarro( carro2 );
    }

    /**
     * Probar que el m�todo darCarro retorna lo esperado para un puesto vac�o
     */
    public void testDarCarro1( )
    {
        setupEscenario1( );

        assertNull( "El puesto1 est� vac�o pero darCarro no retorn� null", puesto1.darCarro( ) );
    }

    /**
     * Probar que el m�todo darCarro retorna lo esperado para un puesto ocupado
     */
    public void testDarCarro2( )
    {
        setupEscenario2( );

        assertTrue( "El puesto 2 no retorn� el carro que se esperaba", carro2 == puesto2.darCarro( ) );
    }

    /**
     * Probar el m�todo darNumeroPuesto
     */
    public void testDarNumeroPuesto( )
    {
        setupEscenario1( );

        assertEquals( "El n�mero retornado es incorrecto", 1, puesto1.darNumeroPuesto( ) );
    }

    /**
     * Probar el m�todo estaOcupado
     */
    public void testEstaOcupado( )
    {
        setupEscenario1( );
        setupEscenario2( );

        assertFalse( "El puesto 1 deber�a estar desocupado", puesto1.estaOcupado( ) );
        assertTrue( "El puesto 2 deber�a estar ocupado", puesto2.estaOcupado( ) );
    }

    /**
     * Probar a parquear un carro en un puesto vac�o
     */
    public void testParquearCarro( )
    {
        setupEscenario1( );

        assertNull( "El puesto 1 est� vac�o pero darCarro no retorn� null", puesto1.darCarro( ) );
        puesto1.parquearCarro( carro1 );
        assertTrue( "El puesto 1 no retorn� el carro que se esperaba: el carro no qued� parqueado", carro1 == puesto1.darCarro( ) );
        assertTrue( "El puesto 1 deber�a estar ocupado", puesto1.estaOcupado( ) );
    }

    /**
     * Probar a sacar un carro del puesto
     *  
     */
    public void testSacarCarro( )
    {
        setupEscenario2( );

        assertTrue( "El puesto 2 no retorn� el carro que se esperaba", carro2 == puesto2.darCarro( ) );
        puesto2.sacarCarro( );
        assertNull( "El puesto 2 deber�a estar vac�o pero darCarro no retorn� null", puesto2.darCarro( ) );
        assertFalse( "El puesto 2 deber�a estar desocupado", puesto2.estaOcupado( ) );
    }

    /**
     * Probar el m�todo tieneCarroConPlaca
     *  
     */
    public void testTieneCarroConPlaca( )
    {
        setupEscenario2( );

        assertFalse( "El puesto encontr� la placa de un carro que no est� parqueado ah�", puesto2.tieneCarroConPlaca( "aaa111" ) );
        assertTrue( "El puesto no encontr� la placa del carro que est� parqueado ah�", puesto2.tieneCarroConPlaca( "bbb222" ) );
    }

    private void assertTrue(String el_puesto_2_no_retorn_el_carro_que_se_esp, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void assertNull(String el_puesto_1_est_vaco_pero_darCarro_no_ret, Carro darCarro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
