package map;

import java.util.Random;

public class Map {

    // Carte 6X6

    private char[][] map;

    public Map() {
        map = new char[6][6];  // Correction ici : utilisez la variable de classe plutôt qu'une variable locale
        Random random = new Random();

        // Génération aléatoire de la carte
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                // Générer aléatoirement Monstre (#), Obstacle (O) ou un espace vide ( )
                int choix = random.nextInt(3);
                if (choix == 0) {
                    map[i][j] = '#'; // Monstre
                } else if (choix == 1) {
                    map[i][j] = 'O'; // Obstacle
                } else {
                    map[i][j] = ' '; // Espace vide
                }
            }
        }

        // Placer la sortie en haut à gauche de la carte
        map[0][1] = 'E'; // E pour sortie
    }

    public void displayMap() {
        System.out.println("--- MAP ---");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("[ " + map[i][j] + " ]");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }



}
