package main;

import java.util.Scanner;
import map.Map;
import entity.*;
import weapons.*;
import zone.WeaponStore;

import java.util.Scanner;

public class jeu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map map = new Map();
        WeaponStore store = new WeaponStore();
        Player p = new Player("Ilias");
        Entity h = new Entity("Heros");
        Monster m1 = new Monster("Monster 1");
        Monster m2 = new Monster("Monster 2");
        Monster m3 = new Monster("Monster 3");
        // Weapon awe = new Axe();
        //Axe axe = new Axe();
        //Hammer hammer = new Hammer();
        //Bow bow = new Bow();
        // Elf elf = new Elf("Elf");
        // Sorcerer sorcerer = new Sorcerer("Sorcerer");

        // TODO choix de l'arme par le joueur, et this.getDamage()
        //p.addWeapon(hammer);
        //System.out.println("Le joueur a choisi : " +p.getWeapons());
        //System.out.println("Damage Ratio de l'arme : " +axe.getDamage()); // recuperation du damage ratio de l'arme

        // Ajout d'instances d'armes dans la liste d'armes du joueur


        System.out.println("Bienvenue dans le RPG");
        System.out.println("Vous etes un "+ h.getName());
        map.displayMap();
        // p.characterChoice(c);


        System.out.println(" ");
        System.out.println("Menu");
        System.out.println("1. Aller au magasin d'armes");
        System.out.println("2. Changer d'arme");
        System.out.println("3. Combattre un monstre");
        System.out.println("4. Quitter le jeu");
        int choix = scanner.nextInt();
        switch (choix) {
            case 1:
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
                // Si y'a plus d'une arme dans l'inventaire du joueur, alors on peut changer d'arme
                if (p.getWeapons().size() > 1) {
                    p.changeWeapon();
                } else {
                    System.out.println("Vous n'avez pas d'arme");
                }
                break;

            case 3:
                System.out.println("--- COMBAT CONTRE UN MONSTRE ---");
                break;

            case 4:
                System.out.println("--- VOUS AVEZ QUITTE LE JEU ---");
                System.exit(0);
                break;

            default:
                System.out.println("Choix invalide");
                break;
        }





    }
}
