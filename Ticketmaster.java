import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ticketmaster extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfEingabePreis;
    private JTextField tfJahrEingabe;
    // Array Liste in GUI importieren
    private ArrayList<Konzert> Konzerte = new ArrayList<Konzert>();

    // JComboBox Objekte sind dazu gedacht, Zeichenfolgen (Strings)zu enthalten oder damit zu arbeiten
    // Sie werden beim Nutzen als Zeichenfolgen behandelt, deshlab ""
    private JComboBox<String> comboBox_Kn1;
    private JComboBox<String> comboBox;

    // Liste in der grafischen Benutzeroberfläche
    private JTextArea textArea;





    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ticketmaster frame = new Ticketmaster();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();


                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Ticketmaster() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setFont(new Font("Arial", Font.BOLD, 13));
        //Überschrift der grafischen Benutzeroberfläche
        setTitle("Ticketmaster");
        setAlwaysOnTop(true);
        setBounds(100, 100, 716, 351);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


        setContentPane(contentPane);
        contentPane.setLayout(null);


        // Liste, wo unsere Objekte erscheinen
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 10));
        textArea.setBounds(340, 28, 345, 216);
        contentPane.add(textArea);
        // nach contentPane.add(textArea)einfügen, damit die Liste am Anfang mit den Künstlern angezeigt wird
        initObjekte();



        // Design
        JLabel lblKuenstlername = new JLabel("Künstlername:");
        lblKuenstlername.setFont(new Font("Arial", Font.BOLD, 13));
        lblKuenstlername.setHorizontalAlignment(SwingConstants.LEFT);
        lblKuenstlername.setBounds(10, 28, 132, 28);
        contentPane.add(lblKuenstlername);
        JLabel lblJahr = new JLabel("Jahr:");
        lblJahr.setFont(new Font("Arial", Font.BOLD, 13));
        lblJahr.setBounds(10, 62, 114, 28);
        contentPane.add(lblJahr);
        JLabel lblEintrittspreis = new JLabel("Eintrittspreis:");
        lblEintrittspreis.setFont(new Font("Arial", Font.BOLD, 13));
        lblEintrittspreis.setBounds(10, 97, 154, 28);
        contentPane.add(lblEintrittspreis);
        JLabel lblAusverkauft = new JLabel("Ausverkauft:");
        lblAusverkauft.setFont(new Font("Arial", Font.BOLD, 13));
        lblAusverkauft.setBounds(10, 132, 114, 28);
        contentPane.add(lblAusverkauft);
        //Design



        // Der Haken zeigt, ob das Konzert ausverkauft ist oder nicht...
        //Bei Ja -> Haken / Bei Nein -> kein Haken
        JCheckBox chcJa = new JCheckBox("");
        chcJa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ausgewaehlterKuenstler = (String) comboBox_Kn1.getSelectedItem();

                // Reset der Felder bei neuer Auswahl
                tfEingabePreis.setText("");
                chcJa.setSelected(false);

                // Durchsuchen der Konzerte-Liste, um den Künstler und seinen Ausverkaufsstatus zu finden (passende Konzert)
                for (Konzert konzert : Konzerte) {
                    if (konzert.getKuenstlername().equals(ausgewaehlterKuenstler)) {
                        // Setzen des Preises und des Ausverkaufsstatus basierend auf dem gefundenen Konzert
                        // Übereinstimmung -> Eintrittspreis + Status wird eingesetzt
                        tfEingabePreis.setText(String.valueOf(konzert.getEintrittspreis()));
                        chcJa.setSelected(konzert.isAusverkauft());
                        break; // Die Schleife wird abgebrochen, sobald das passende Konzert gefunden worden ist
                    }
                }
            }
        });
        chcJa.setForeground(new Color(139, 0, 0));
        chcJa.setBackground(new Color(255, 255, 255));
        chcJa.setFont(new Font("Bahnschrift", Font.BOLD, 13));
        chcJa.setBounds(167, 132, 21, 21);
        contentPane.add(chcJa);



        // Alle Künstler befinden sich in dieser Combo Box und können ausgewählt werden
        // + CheckBox wird automatisch mit einem Haken angezeigt, wenn das Konzert ausverkauft ist
        comboBox_Kn1 = new JComboBox<String>();
        comboBox_Kn1.addItem("Bitte wählen Sie aus");
        comboBox_Kn1.addItem("The Weeknd");
        comboBox_Kn1.addItem("Tate Mcrae");
        comboBox_Kn1.addItem("Katy Perry");
        comboBox_Kn1.addItem("Chase Atlantic");
        comboBox_Kn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ausgewählterKünstler = (String) comboBox_Kn1.getSelectedItem();
                if(ausgewählterKünstler.equals(""))
                    tfEingabePreis.setText("");
                chcJa.setSelected(false);
                if (ausgewählterKünstler.equals("The Weeknd")) {
                    tfEingabePreis.setText("148.99");
                    chcJa.setSelected(true);
                } else if (ausgewählterKünstler.equals("Tate Mcrae")) {
                    tfEingabePreis.setText("100.99");
                    chcJa.setSelected(true);
                }else if (ausgewählterKünstler.equals("Katy Perry")) {
                    tfEingabePreis.setText("120.99");
                    chcJa.setSelected(false);
                } else if (ausgewählterKünstler.equals("Chase Atlantic")) {
                    tfEingabePreis.setText("90.99");
                    chcJa.setSelected(true);
                }
            }
        });
        comboBox_Kn1.setBackground(new Color(255, 255, 255));
        comboBox_Kn1.setFont(new Font("Arial", Font.PLAIN, 12));
        comboBox_Kn1.setBounds(167, 32, 147, 21);
        contentPane.add(comboBox_Kn1);



        // Speichert alle eingegebenen Werte und zeigt eine Fehlermeldung an, wenn man die Jahre 2024 && 2025 nicht gewählt sind
        // + "Bitte füllen sie alle Felder aus"
        JButton btnSpeichern = new JButton("Speichern");
        btnSpeichern.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String kuenstlername = (String) comboBox_Kn1.getSelectedItem();
                    String preisString = tfEingabePreis.getText();
                    String jahrString = tfJahrEingabe.getText();
                    boolean ausverkauft = chcJa.isSelected();

                    // Validierung der Eingaben
                    if (kuenstlername.isEmpty() || preisString.isEmpty() || jahrString.isEmpty()) {
                        JOptionPane.showMessageDialog(contentPane, "Bitte füllen Sie alle Felder aus.", "Unvollständige Daten", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    double preis = Double.parseDouble(preisString);
                    int jahr = Integer.parseInt(jahrString);

                    // Überprüfen, ob das Jahr 2025 oder 2026 ist
                    if (jahr != 2025 && jahr != 2026) {
                        JOptionPane.showMessageDialog(contentPane, "Bitte geben Sie nur die Jahre 2024 oder 2025 ein.", "Ungültiges Jahr", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Erstellen eines neuen Konzertobjekts und Hinzufügen zur Liste
                    Konzerte.add(new Konzert(kuenstlername, jahr, preis, ausverkauft));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(contentPane, "Ungültige Eingabe: " + ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }


        });
        btnSpeichern.setForeground(new Color(0, 0, 0));
        btnSpeichern.setBackground(new Color(255, 255, 255));
        btnSpeichern.setFont(new Font("Arial", Font.BOLD, 13));
        btnSpeichern.setBounds(10, 182, 105, 21);
        contentPane.add(btnSpeichern);



        // Durch das drücken auf den Buttonknopf wird eine Liste von den Konzerten angezeigt
        JButton btnListeAnzeigen = new JButton("Liste Anzeigen ");
        btnListeAnzeigen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText(""); // Löschen des vorhandenen Textes
                for (Konzert konzert : Konzerte) {
                    textArea.append("Künstler: " + konzert.getKuenstlername() +
                            " / Jahr: " + konzert.getJahr() +
                            " / Preis: " + konzert.getEintrittspreis() +
                            " / Ausverkauft: " + (konzert.isAusverkauft() ? "Ja" : "Nein") + "\n");
                }
            }
        });
        btnListeAnzeigen.setIcon(null);
        btnListeAnzeigen.setBackground(new Color(255, 255, 255));
        btnListeAnzeigen.setFont(new Font("Arial", Font.BOLD, 13));
        btnListeAnzeigen.setBounds(167, 182, 132, 21);
        contentPane.add(btnListeAnzeigen);



        // Eingabe Löschen, um es von der Liste zu löschen
        JButton btnLöschen = new JButton("Löschen");
        btnLöschen.setForeground(new Color(128, 0, 0));
        btnLöschen.setBackground(new Color(255, 255, 255));
        btnLöschen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 1. Die Namen in der ArrayList werden mit dieser Anweisung gelöscht;
                Konzerte.clear();
                // 2. Mit dem "" wird die TextArea keinen Text anzeigen und somit ist es "leer"!
                textArea.setText("");
            }
        });
        btnLöschen.setFont(new Font("Arial", Font.BOLD, 14));
        btnLöschen.setBounds(78, 223, 114, 21);
        contentPane.add(btnLöschen);



        // In dieser Box kann man zwischen dem Jahr 2025 oder 2026 wählen
        comboBox = new JComboBox<String>();
        comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
        comboBox.setBackground(new Color(255, 255, 255));
        comboBox.setBounds(10, 269, 147, 21);
        comboBox.addItem("Bitte wählen Sie aus");
        comboBox.addItem("2025");
        comboBox.addItem("2026");
        contentPane.add(comboBox);



        // Die Jahre 2024 und 2025 können gefiltert werden
        JButton btnFiltern = new JButton("Filtern");
        btnFiltern.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filtern();
            }
        });
        btnFiltern.setBackground(new Color(255, 255, 255));
        btnFiltern.setFont(new Font("Arial", Font.BOLD, 13));
        btnFiltern.setBounds(200, 270, 114, 21);
        contentPane.add(btnFiltern);



        // Wenn man auf Exit drückt schließt sich das Fenster
        JButton btnExit = new JButton("Exit");
        btnExit.setForeground(new Color(0, 100, 0));
        btnExit.setBackground(new Color(255, 255, 255));
        btnExit.setFont(new Font("Arial", Font.BOLD, 14));
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setBounds(621, 268, 64, 21);
        contentPane.add(btnExit);



        // Beim Auswählen vom Sänger wird der Preis automatisch angezeigt
        // -> Das passiert mit der Eingabe von der comboBox_Kn1: Künstlername
        tfEingabePreis = new JTextField();
        tfEingabePreis.setBackground(new Color(255, 255, 255));
        tfEingabePreis.setFont(new Font("Arial", Font.PLAIN, 12));
        tfEingabePreis.setBounds(167, 99, 105, 21);
        contentPane.add(tfEingabePreis);
        tfEingabePreis.setColumns(10);



        // € Zeichen im Design
        JLabel lblEuro = new JLabel("€");
        lblEuro.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        lblEuro.setBounds(272, 101, 27, 21);
        contentPane.add(lblEuro);



        // Die Jahre 2025 und 2026 erlaubt, ansonsten kommt eine Fehler meldung
        // Try catch Anweisung
        tfJahrEingabe = new JTextField();
        tfJahrEingabe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int eingabeJahr = Integer.parseInt(tfJahrEingabe.getText());

                    // Überprüfen, ob das eingegebene Jahr 2024 oder 2025 ist
                    if (eingabeJahr == 2025 || eingabeJahr == 2026) {
                        // Gültiges Jahr
                    } else {
                        // Ungültiges Jahr, Fehlermeldung anzeigen
                        JOptionPane.showMessageDialog(contentPane, "Bitte geben Sie nur die Jahre 2025 oder 2026 ein.", "Ungültiges Jahr", JOptionPane.ERROR_MESSAGE);
                        tfJahrEingabe.setText(""); // Textfeld leeren
                    }
                } catch (NumberFormatException ex) {
                    // Fehler bei der Konvertierung in eine Zahl, Fehlermeldung anzeigen
                    JOptionPane.showMessageDialog(contentPane, "Bitte geben Sie eine gültige Jahreszahl ein.", "Ungültige Eingabe", JOptionPane.ERROR_MESSAGE);
                    tfJahrEingabe.setText(""); // Textfeld leeren
                }

            }
        });
        tfJahrEingabe.setBackground(new Color(255, 255, 255));
        tfJahrEingabe.setFont(new Font("Arial", Font.PLAIN, 12));
        tfJahrEingabe.setColumns(10);
        tfJahrEingabe.setBounds(167, 66, 105, 21);
        contentPane.add(tfJahrEingabe);



    }

    // aktualisiert die Anzeige der Konzertliste im Textfeld 'textArea'
    // toString() Methode wird aufgerufen
    public void aktualisiereKonzertListe() {
        textArea.setText("");
        for(Konzert konzert : Konzerte) {
            textArea.append(konzert.toString() + "\n");
        }
    }
    // Methode, die die Liste mit den ganzen Künstlern angezeigt
    // Konzertbjekte erstellen + in der Liste Konzerte hinzuzufügen
    public void initObjekte() {

        Konzert k1 = new Konzert ("The Weeknd", 2025, 119.99, true);
        Konzert k2 = new Konzert ("Tate Mcrae", 2025, 249.99, true);
        Konzert k3 = new Konzert ("Katy Perry", 2025, 189.99, false);
        Konzert k4 = new Konzert ("Chase Atlantic", 2026, 219.99, true);


        Konzerte.add(k1);
        Konzerte.add(k2);
        Konzerte.add(k3);
        Konzerte.add(k4);

        textArea.setText("");
        for(Konzert konzert : Konzerte) {
            textArea.append(

                    "Künstler: " + konzert.kuenstlername + " / " + "Jahr: " + konzert.jahr + " / " + "Preis: " + konzert.eintrittspreis + " / " + "Ausverkauft: " + konzert.ausverkauft);
            textArea.append("\n");
        }

    }
    // Methode, womit man die Jahre 2024 und 2025 filtern kann
    // kombiniert mit einer for-each Schleife fängt bei 0 an endet bei 2
    public void filtern (){
        textArea.setText("");
        for (Konzert e : Konzerte) {
            if (comboBox.getSelectedIndex() == 0) {
                textArea.append("Künstler: " + e.kuenstlername + " / " + "Jahr: " + e.jahr + " / " + "Preis: " + e.eintrittspreis + " € / " + "Ausverkauft: " + (e.ausverkauft ? "Ja" : "Nein") + "\n");
            } else if (comboBox.getSelectedIndex() == 1 && e.getJahr() == 2025) {
                textArea.append("Künstler: " + e.kuenstlername + " / " + "Jahr: " + e.jahr + " / " + "Preis: " + e.eintrittspreis + " € / " + "Ausverkauft: " + (e.ausverkauft ? "Ja" : "Nein") + "\n");
            } else if (comboBox.getSelectedIndex() == 2 && e.getJahr() == 2026) {
                textArea.append("Künstler: " + e.kuenstlername + " / " + "Jahr: " + e.jahr + " / " + "Preis: " + e.eintrittspreis + " € / " + "Ausverkauft: " + (e.ausverkauft ? "Ja" : "Nein") + "\n");


            }
        }
    }

    {}


    {

    }
}
