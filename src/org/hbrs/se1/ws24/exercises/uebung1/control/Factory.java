package org.hbrs.se1.ws24.exercises.uebung1.control;


public class Factory {



    public static Translator createGermanTranslator() {
        Translator translator = new GermanTranslator();  //Polymorphismus Objekt ist Typ Translator

        ((GermanTranslator) translator).setDate("08-10-2024");
        return translator;  //alternativ return new GermanTranslator();
    }

}
