package org.hbrs.se1.ws24.exercises.uebung1.control;


public class Factory {



    public static Translator createGermanTranslator() {
        Translator translator = new GermanTranslator();
        //Polymorphismus verwendet Objekt ist vom Typ Translator

        ((GermanTranslator) translator).setDate("08-10-2024");
        //Cast, weil sonst kein Datum gesetzt werden kann.
        //Grund setDate() Methode in Interface fehlt und hinzufügen durften wir nicht
        return translator;
    }

}
