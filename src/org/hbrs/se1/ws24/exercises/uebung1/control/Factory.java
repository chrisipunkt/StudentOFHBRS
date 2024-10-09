package org.hbrs.se1.ws24.exercises.uebung1.control;


public class Factory {



    public static Translator createGermanTranslator() {
        Translator translator = new GermanTranslator();
        //Polymorphismus wird verwendet, Objekt GermanTranslator ist vom Typ Translator

        ((GermanTranslator) translator).setDate("08-10-2024"); //oder Okt/2024
        //Cast, weil sonst kein Datum gesetzt werden kann.
        //Grund setDate() Methode in Interface fehlt und hinzufügen nicht erlaubt war
        return translator;
    }

}
