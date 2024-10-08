package org.hbrs.se1.ws24.exercises.uebung1.control;
import org.hbrs.se1.ws24.exercises.uebung1.control.Translator;

public class Factory {



    public static Translator createGermanTranslator() {
        Translator translator = new GermanTranslator();  //Polymorphismus Objekt ist Typ Translator
        return translator;
    }

}
