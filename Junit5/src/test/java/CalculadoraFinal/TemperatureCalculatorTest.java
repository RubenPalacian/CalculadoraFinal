package CalculadoraFinal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureCalculatorTest {

    private TemperatureCalculator temperatureCalculator;

    @BeforeEach
    public void setUp(){
        temperatureCalculator=new TemperatureCalculator ();
        System.out.println ("BeforeEach->setUp()");
    }
    @AfterEach
    public void tearDown(){
        temperatureCalculator=null;
        System.out.println ("AfterEach->tearDown()");
    }
    @Test
    public void toFarenheitTest(){
        assertEquals (-9.4,temperatureCalculator.toFarenheit (-23),0.1);
    }

}