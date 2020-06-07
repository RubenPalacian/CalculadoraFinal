package CalculadoraFinal;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;
    private Calculator calculatorNull;
    private static Calculator calculatorStatic;
    @BeforeAll
    public static void beforeAllTests(){
         calculatorStatic=new Calculator ();
         System.out.println ("BeforeAll->beforeAllTests()");

    }

    @BeforeEach
    public void setUp(){
        calculator=new Calculator ();
        System.out.println ("BeforeEach->setUp()");
    }
    @AfterEach
    public void tearDown(){
        calculator=null;
        System.out.println ("AfterEach->tearDown()");
    }
    @AfterAll
    public static void AfterAllTest(){
        calculatorStatic=null;
        System.out.println ("AfterAll->AfterAllTest()");
    }

    @Test
    public void calculatorNotNullTest(){
        assertNotNull (calculatorStatic,"Calculator de ser not null");
        assertNotNull (calculator,"Calculator de ser not null");
        System.out.println ("Test->calculatorNotNullTest()");
    }
    @Test
    public void calculatorNullTest(){
        assertNull (calculatorNull);
        System.out.println ("Test->calculatorNullTest()");
    }
    @Test
    public void sumarAssertTest(){
        //1setup

        int resultadoEsperado=30;
        int resultadoActual;
        //2action
        resultadoActual=calculator.sumar (10,20);
        //3assert
        assertEquals (resultadoEsperado,resultadoActual,"");
        System.out.println ("Test->sumarAssertTest()");
    }
    @Test
    public void sumarTest(){
        assertEquals (30,calculator.sumar (10,20));
    }
    @Test
    public void assertTypes(){
        assertTrue (1==1);
        //assertTrue (1==2);
        assertNull (calculatorNull);
        assertNotNull (calculator);
        Calculator calculator1=new Calculator ();
        Calculator calculator2=new Calculator ();
        Calculator calculator3= calculator1;
        assertSame (calculator1,calculator3);
        //assertSame (calculator1,calculator2);
        assertNotSame (calculator1,calculator2);
        //assertNotSame (calculator1,calculator3);
        assertEquals ("alberto","alberto");
        //assertEquals ("alberto","albert","Ha fallado nuestro metodo String");
        //assertEquals (1,1.4,0.5);

    }
    @Test
    public void sumarValidInputValidExpected(){
        assertEquals (11, calculator.sumar (7,4));
    }
    @Test
    public void restarValidInputValidExpected(){
        assertEquals (11, calculator.restar (15,4));
    }
    @Test
    public void restarValidInputValidNegativeResultExpected(){
        assertEquals (-10, calculator.restar (10,20));
    }
    /*@Test
    public void dividirValidInputValidResultExpectedTest(){
        assertEquals (2, calculator.dividir (10,5));
    }

     */
    @Disabled("Desabilitado por Bug por dividir por 0")
    @Test
    public void dividirInvalidInputTest(){
        fail ("Fallo detectado manualmente- No se puede dividir por cero");
        assertEquals (2, calculator.dividir (10,0));

    }
    @Test
    public void dividirInvalidInputExpectedExceptionTest(){
       assertThrows (ArithmeticException.class,()->calculator.dividirPorCero (2,0), "No se puede dividir por cero");

    }
    /*@Disabled("Deshabilitado por bug division")
    @Test
    public void dividirInvalidInputTest(){
        assertEquals (2,calculator.dividir (10,0));
    }
     */
    @Test
    @DisplayName ("Metodo dividir->Funciona")
    public void dividirValidInputValidResultExpectedTest(){
        assertEquals (2, calculator.dividir (10,5));
    }
    @Test
    public void sumarAssertAllTest(){
        assertAll(
                ()->assertEquals (31,calculator.sumar (11,20)),
                ()->assertEquals (20,calculator.sumar (10,10)),
                ()->assertEquals (2,calculator.sumar (1,1))
        );
    }
    @Nested
    class sumarTest{
        @Test
        public void sumarPositivosTest(){
            assertEquals (30,calculator.sumar (15,15));
        }
        @Test
        public void sumarNegativosTest(){
            assertEquals (-30,calculator.sumar (-15,-15));
        }
        @Test
        public void sumarZeroTest(){
            assertEquals (0,calculator.sumar (0,0));
        }
    }
        @ParameterizedTest(name="{index}=>a={0},b={1},sum={2}")
        @MethodSource("addProviderData")
        public void sumarParameterizedTest(int a,int b,int sum){
            assertEquals (sum,calculator.sumar (a,b));
        }
        public static Stream<Arguments>addProviderData(){
            return Stream.of (
                    Arguments.of (6,2,8),
                    Arguments.of (-6,-2,-8),
                    Arguments.of (6,-2,4),
                    Arguments.of (-6,2,-4),
                    Arguments.of (6,0,6)

            );
        }
        @Test
        public void timeOutTest(){
            assertTimeout (Duration.ofMillis (5000),()->{
                calculator.longTaskOperation ();});
        }
}