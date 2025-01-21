import java.util.ArrayList;

public class Konzert {

    //Attributvariable
    //(#protected = vor Zugriffen von außen geschützt, können aber von abgeleiteten Klassen verwendet werden(->Eventim)
    protected String kuenstlername;
    protected int jahr;
    protected double eintrittspreis;
    protected boolean ausverkauft;



    //Konstruktor erstellen
    public Konzert(String kuenstlername, int jahr, double eintrittspreis, boolean ausverkauft) {
        super();
        this.kuenstlername = kuenstlername;
        this.jahr = jahr;
        this.eintrittspreis = eintrittspreis;
        this.setAusverkauft(ausverkauft);
    }
    // ArrayListe die in der GUI importiert ist
    public ArrayList<Konzert> Konzerte = new ArrayList<Konzert>();

    //Methode
    public void gebeKonzertAus() {
        System.out.println("Kuenstlername:" + kuenstlername + "Jahr: " + jahr + "Eintrittspreis: " + eintrittspreis + "" + "ausverkauft: " + isAusverkauft());


    }

    @Override
    public String toString() {
        String ausverkauftText = isAusverkauft() ? "AUSVERKAUFT" : "Verfügbar";
        return "Künstler: " + getKuenstlername() + ", Jahr: " + getJahr() + ", Preis: " + getEintrittspreis() + " €, Status: " + ausverkauftText;

    }


    public boolean isAusverkauft() {
        return ausverkauft;
    }

    public void setAusverkauft(boolean ausverkauft) {
        this.ausverkauft = ausverkauft;
    }

    public double getEintrittspreis() {
        return eintrittspreis;
    }

    public void setEintrittspreis(double eintrittspreis) {
        this.eintrittspreis = eintrittspreis;
    }

    public String getKuenstlername() {
        return kuenstlername;
    }

    public void setKuenstlername(String kuenstlername) {
        this.kuenstlername = kuenstlername;
    }

    public int getJahr() {
        return jahr;


    }

}