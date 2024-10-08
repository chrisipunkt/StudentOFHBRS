package org.hbrs.se1.ws24.tests.uebung1;
import static org.junit.jupiter.api.Assertions.*;
import org.hbrs.se1.ws24.exercises.uebung1.control.GermanTranslator;
import org.hbrs.se1.ws24.exercises.uebung1.control.Translator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GermanTranslatorTest {

          Translator translator = null;

          //Arrange
        @BeforeEach
        void setUp() {
            this.translator = new GermanTranslator();
        }
        //Act
        @Test
        void translateNumberTest() { //Assert
            // Test für gÄK ist im Intervall 0<x<11
            assertEquals("sechs", this.translator.translateNumber(6));

            // Test für 455 ist Teil von uÄK1 und scheitert
            String test = "Übersetzung der Zahl 455 nicht möglich, Version " + Translator.version;
            assertEquals(test, this.translator.translateNumber(455));

            // Test für -30 ist Teil von uÄK2 und scheitert
            String test2 = "Übersetzung der Zahl -30 nicht möglich, Version " + Translator.version;
            assertEquals(test2, this.translator.translateNumber(-30));
            // uÄK0 = ungültiger Fall für 0
            String testZero = "Übersetzung der Zahl 0 nicht möglich, Version " + Translator.version;
            assertEquals(testZero, this.translator.translateNumber(0));
        }



}