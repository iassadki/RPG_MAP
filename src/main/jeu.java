package main;

import java.util.Scanner;

import destructible.Destructible;
import destructible.Monster;
import destructible.Obstacle;
import map.Map;
import entity.*;
import weapons.*;
import zone.WeaponStore;

public class jeu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Entity e = new Entity();
        Map map = new Map();
        WeaponStore store = new WeaponStore();
        Player p = new Player("Ilias");

        System.out.println("Bienvenue dans le RPG");
        p.characterChoice();
        System.out.println(" ");
        System.out.println("Menu");
        System.out.println("1. Aller au magasin d'armes");
        System.out.println("2. Quitter le jeu");

        // Vérifier si l'entrée est un chiffre (option du menu)
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // Option pour aller au magasin d'armes
                System.out.println("--- MAGASIN D'ARMES ---");
                System.out.println("Voici les armes disponibles :");
                store.printWeaponsList();
                System.out.println("Choisissez une arme :");
                int choixArme = scanner.nextInt();
                Weapon w = store.getWeapon(choixArme);
                p.buyWeapon(w);
                System.out.println("Vous avez acheté " + w.getName());
                System.out.println("Vous avez " + p.getMoney() + " pieces");
                break;
            case 2:
                // Option pour quitter le jeu
                System.out.println("--- VOUS AVEZ QUITTE LE JEU ---");
                System.exit(0);
                break;
            default:
                System.out.println("Choix invalide");
                System.exit(0);
                break;
        }

        // Affichage de la map
        map.displayMap();

        // Boucle infinie, tant que le joueur n'a pas atteint la case de sortie, qui est la case 'E'
        while (p.getNextCell() != 'E') {

            // Menu affiché tout le temps
            System.out.println("Appuyez sur une touche (z pour haut, s pour bas, q pour gauche, d pour droite, ou 'q' pour gauche) :");
            System.out.println("Menu -- Vous avez " + p.getMoney() + " pieces");
            System.out.println("1. Aller au magasin d'armes");
            System.out.println("2. Changer d'arme");
            System.out.println("3. Quitter le jeu");

            // Lire l'entrée de l'utilisateur sous forme de chaîne
            String userInput = scanner.next();

            // Vérifier si l'entrée est un chiffre (option du menu)
            if (userInput.matches("\\d+")) {
                int choix = Integer.parseInt(userInput);
                switch (choix) {
                    case 1:
                        // Option pour aller au magasin d'armes
                        System.out.println("--- MAGASIN D'ARMES ---");
                        System.out.println("Voici les armes disponibles :");
                        store.printWeaponsList();
                        System.out.println("Choisissez une arme :");
                        int choixArme = scanner.nextInt();
                        Weapon w = store.getWeapon(choixArme);
                        p.buyWeapon(w);
                        System.out.println("Vous avez acheté " + w.getName());
                        System.out.println("Vous avez " + p.getMoney() + " pieces");
                        break;
                    case 2:
                        // Option pour changer d'arme
                        System.out.println(p.getWeapons());
                        if (p.getWeapons().size() > 1) {
                            p.changeWeapon();
                        } else {
                            System.out.println("Vous n'avez pas d'arme");
                        }
                        break;
                    case 3:
                        // Option pour quitter le jeu
                        System.out.println("--- VOUS AVEZ QUITTE LE JEU ---");
                        System.exit(0);
                        break;
                    default:
                        // reprendre la boucle si l'utilisateur n'a pas saisi un chiffre entre 1 et 3
                        System.out.println("Choix invalide");
                        System.exit(0);
                        break;
                }
            } else {
                // L'utilisateur a saisi un caractère zqsd pour se déplacer
                char input = userInput.charAt(0);
                p.deplacementOnMap(input, map, e);
            }

            // Afficher la carte après l'action
            map.displayMap();
        }

        // Fin du jeu
        System.out.println("Vous avez fini le jeu !");
    }
}
