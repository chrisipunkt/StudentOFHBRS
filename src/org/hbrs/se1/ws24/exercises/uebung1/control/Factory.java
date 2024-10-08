package org.hbrs.se1.ws24.exercises.uebung1.control;

public class Factory {



    public static Translator createGermanTranslator() {
        Translator translator = new GermanTranslator();  //Polymorphismus Objekt ist Typ Translator
        return translator;  //alternativ return new GermanTranslator();
    }

}
