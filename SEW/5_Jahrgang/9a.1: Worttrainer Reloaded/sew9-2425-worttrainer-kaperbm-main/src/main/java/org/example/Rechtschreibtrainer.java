package org.example;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rechtschreibtrainer {
	private List<TrainingsDaten> trainingsDatenListe;
	private TrainingsDaten aktuellesPaar;
	private int richtigeVersuche;
	private int falscheVersuche;
	private int gesamteVersuche;

	public Rechtschreibtrainer() {
		this.trainingsDatenListe = new ArrayList<>();
		this.richtigeVersuche = 0;
		this.falscheVersuche = 0;
		this.gesamteVersuche = 0;
	}

	// Hinzufügen eines neuen Wort-Bild-Paares
	public void addWortBildPaar(String wort, String bildUrl) {
		try {
			URL url = new URL(bildUrl);
			TrainingsDaten paar = new TrainingsDaten(wort, url);
			this.trainingsDatenListe.add(paar);
		} catch (Exception e) {
			System.out.println("Ungültige URL: " + bildUrl);
		}
	}

	// Wählen eines zufälligen Wort-Bild-Paares
	public void waehleZufall() {
		if (this.trainingsDatenListe.isEmpty()) return;
		Random random = new Random();
		int index = random.nextInt(this.trainingsDatenListe.size());
		this.aktuellesPaar = this.trainingsDatenListe.get(index);
	}

	// Überprüfen der Benutzerantwort
	public boolean pruefeAntwort(String wort) {
		if (aktuellesPaar == null) return false;
		gesamteVersuche++;
		if (aktuellesPaar.getWort().equalsIgnoreCase(wort)) {
			richtigeVersuche++;
			return true;
		} else {
			falscheVersuche++;
			return false;
		}
	}

	// Getter und Setter
	public TrainingsDaten getAktuellesPaar() {
		return aktuellesPaar;
	}

	public int getRichtigeVersuche() {
		return richtigeVersuche;
	}

	public int getFalscheVersuche() {
		return falscheVersuche;
	}

	public int getGesamteVersuche() {
		return gesamteVersuche;
	}

	public List<TrainingsDaten> getTrainingsDatenListe() {
		return trainingsDatenListe;
	}

	public void setTrainingsDatenListe(List<TrainingsDaten> liste) {
		this.trainingsDatenListe = liste;
	}

	public void setGesamteVersuche(int gesamteVersuche) {
		this.gesamteVersuche = gesamteVersuche;
	}

	public void setRichtigeVersuche(int richtigeVersuche) {
		this.richtigeVersuche = richtigeVersuche;
	}

	public void setFalscheVersuche(int falscheVersuche) {
		this.falscheVersuche = falscheVersuche;
	}
}
