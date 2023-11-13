package entity;

import weapons.*;
import map.Map;

import java.util.ArrayList;
import java.util.Scanner;

public class Player implements ActionsPlayer {

    private String name;
    private ArrayList<Weapon> weapons;
    private double money;

    // Position actuelle du joueur sur la carte
    private int playerRow;
    private int playerCol;

    public Player(String name) {
        this.name = name;
        this.money = 50;
        this.weapons = new ArrayList<Weapon>();

        // Initialiser la position du joueur (en bas de la carte)
        this.playerRow = 5;
        this.playerCol = 2;
    }

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return this.money;
    }

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }

    @Override
    public void buyWeapon(Weapon w) {
        // Choix d'une arme dans le magasin d'armes, avec les chiffres du clavier
        // Ajout de l'arme dans l'inventaire du joueur
        // Retrait de l'argent du joueur
        if (this.money >= w.getPrice()) {
            this.weapons.add(w);
            this.money -= w.getPrice();
        } else {
            System.out.println("You don't have enough money to buy this weapon.");
        }
    }

    @Override
    public void addWeapon(Weapon w) {
        // Ajouter une arme dans l'inventaire de Player
        this.weapons.add(w);
        System.out.println("Vous avez choisi " + w.getName());
    }

    @Override
    public void changeWeapon() {
        System.out.println("--- ARMES DANS L'INVENTAIRE ---");
        for (int index = 0; index < this.getWeapons().size(); index++) {
            Weapon weapon = this.getWeapons().get(index);
            System.out.println((index + 1)+ "." + " " + weapon.getName() + " " + weapon.getDamage());
        }
        System.out.println("Choisissez une arme :");
        Scanner scanner = new Scanner(System.in);
        int choixInventaire = scanner.nextInt();
        if (choixInventaire >= 1 && choixInventaire <= this.getWeapons().size()) {
            Weapon weap = this.getWeapons().get(choixInventaire - 1);
            // Utilisez l'objet w comme nécessaire
            System.out.println("Vous avez choisi " + weap.getName());
        } else {
            System.out.println("Choix invalide");
        }
    }

    @Override
    public void deplacementOnMap(char direction, Map map) {
        // Condition pour vérifier si la case suivante est vide ou remplie
        char nextCell = ' ';

        switch (direction) {
            case 'z':
                if (playerRow > 0) {
                    nextCell = map.getMap()[playerRow - 1][playerCol];
                } else {
                    System.out.println("Vous ne pouvez pas sortir de la limite supérieure de la carte.");
                    return;
                }
                break;
            case 's':
                if (playerRow < 5) {
                    nextCell = map.getMap()[playerRow + 1][playerCol];
                } else {
                    System.out.println("Vous ne pouvez pas sortir de la limite inférieure de la carte.");
                    return;
                }
                break;
            case 'q':
                if (playerCol > 0) {
                    nextCell = map.getMap()[playerRow][playerCol - 1];
                } else {
                    System.out.println("Vous ne pouvez pas sortir de la limite gauche de la carte.");
                    return;
                }
                break;
            case 'd':
                if (playerCol < 5) {
                    nextCell = map.getMap()[playerRow][playerCol + 1];
                } else {
                    System.out.println("Vous ne pouvez pas sortir de la limite droite de la carte.");
                    return;
                }
                break;
            default:
                System.out.println("Commande invalide.");
                return;
        }

        // Vérifier la case suivante et afficher le message approprié
        if (nextCell == 'O') {
            System.out.println("--- DETRUIRE CET OBSTACLE ---");
        } else if (nextCell == '#') {
            System.out.println("--- COMBAT CONTRE MONSTRE ---");
            // TODO combat contre un monstre
            // tant que le heros ou le monstre à plus de 100 HP, continuer le combat
            // attaquer le monstre avec la methode attack de la classe Hero
            //while (Hero.HP > 0 && Monster.HP > 0) {
            //    Hero.attack(this.monster);
            //}
        } else if (nextCell == 'E') {
            System.out.println("--- VOUS AVEZ FINI LE JEU ---");
            System.exit(0);
        } else {
            // Déplacer le joueur
            map.getMap()[playerRow][playerCol] = ' ';  // Effacer la position actuelle
            switch (direction) {
                case 'z':
                    playerRow--;
                    break;
                case 's':
                    playerRow++;
                    break;
                case 'q':
                    playerCol--;
                    break;
                case 'd':
                    playerCol++;
                    break;
            }
            map.getMap()[playerRow][playerCol] = 'P';  // Mettre à jour la nouvelle position
        }
    }




    @Override
    public void characterChoice(Entity h) {
        // choix du personnage avec les chiffres du clavier
        // TODO parcourir la liste des personnages existants

        System.out.println("Choisissez votre personnage :");
        Scanner scanner = new Scanner(System.in);
        int choixPersonnage = scanner.nextInt();
        switch (choixPersonnage) {
            case 1:
                System.out.println("Vous avez choisi " + h.getName());
                break;

            case 2:
                System.out.println("Vous avez choisi " + h.getName());
                break;

            default:
                System.out.println("Choix invalide");
                break;
        }
    }

    @Override
    public void fight(Entity h) {

    }


}
