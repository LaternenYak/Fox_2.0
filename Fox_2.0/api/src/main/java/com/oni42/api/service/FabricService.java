package com.oni42.api.service;

import org.springframework.stereotype.Service;

@Service
public class FabricService {

    public String performCalculation(double length, double width) {
        // Beispiel-Berechnungslogik: Stofffläche berechnen
        double area = length * width;

        // Ergebnis zurückgeben
        return String.format("Die berechnete Stofffläche beträgt %.2f Quadratmeter.", area);
    }
}
