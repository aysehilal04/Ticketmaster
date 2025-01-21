package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class gebeKonzertAusTest {

    // erstellen eines Testobjektes
    Konzert testKonzert = new Konzert("TheWeeknd",2025,148.99,false);

    @Test
    // Die Ausgabe, die für die Testdaten des Testobjekts gewollt ist, wird zuerst definiert.
    // Danach wird diese mit der echten Ausgabe der Methode "gebeKonzertAus" verglichen. Dabei ist der Input für die Methode "gebeKonzertAus" das Testobjekt "testKonzert".
    // Durch assertEquals wird die gewollte Ausgabe mit der wirklichen Ausgabe der Methode "gebeKonzertAus" auf Übereinstimmung verglichen.
    // Stimmt beides überein, ist der Test bestanden.
    void gebeKonzertAus() {
        assertEquals("Kuenstlername:" + "TheWeeknd" + "Jahr: " + 2025 + "Eintrittspreis: " + 148.99 + "" + "ausverkauft: " + false, testKonzert.gebeKonzertAus());
    }
}