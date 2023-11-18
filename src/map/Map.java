package map;

import entity.Entity;

import java.util.Random;

public class Map {

    // Carte 6X6

    private char[][] map;
    private char nextCell;  // Nouvelle variable pour stocker la valeur de nextCell

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

        // Placer le joueur en bas de la carte
        int playerRow = 5;
        int playerCol = 2;
        map[playerRow][playerCol] = 'P'; // P pour joueur
    }


    public void displayMap() {
        System.out.println(" ");
        System.out.println(" ");
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

    // Condition pour que si le joueur est dans la matrice map[0][1] de la map, fin du jeu et message
    public boolean playerOnExit(int playerRow, int playerCol) {
        if (playerRow == 0 && playerCol == 1) {
            System.out.println("Vous avez atteint la soqZDrtie!");
            return true;
        }
        return false;
    }

}
