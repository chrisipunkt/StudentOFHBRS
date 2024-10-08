package org.hbrs.se1.ws24.exercises.uebung1.control;


public class Factory {



    public static Translator createGermanTranslator() {
        Translator translator = new GermanTranslator();  //Polymorphismus Objekt ist Typ Translator

        ((GermanTranslator) translator).setDate("08-10-2024"); //Cast, weil sonst kein Datum gesetzt werden darf.
                                                               //Weil setDate() Methode in Interface fehlt
        return translator;  //alternativ return new GermanTranslator();
    }

}
