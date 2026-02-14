package com.quienesquien.quienesquien;

import java.io.*;
import java.util.*;

public class RankingManager {
    private static final File ARCHIVO=new File("ranking.txt");

    public static void guardarPuntuacion(Jugador jugador) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            writer.write(jugador.getNombre() + ":" + jugador.getPuntos());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> obtenerRankingFormateado() {
        List<Jugador> jugadores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(":");
                jugadores.add(new Jugador(partes[0], Integer.parseInt(partes[1])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        jugadores.sort((j1, j2) -> Integer.compare(j2.getPuntos(), j1.getPuntos()));

        List<String> ranking = new ArrayList<>();
        for (Jugador j : jugadores) {
            ranking.add(j.getNombre() + " - " + j.getPuntos());
        }
        return ranking;
    }
}