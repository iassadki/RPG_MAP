package main;

import entity.Entity;
import entity.Monster;
import entity.Player;
import weapons.*;
import zone.WeaponStore;

import java.util.Scanner;

public class jeu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeaponStore store = new WeaponStore();
        Player p = new Player("Ilias");
        Entity h = new Entity("Heros");
        Monster m1 = new Monster("Monster 1");
        Monster m2 = new Monster("Monster 2");
        Monster m3 = new Monster("Monster 3");
        // Elf elf = new Elf("Elf");
        // Sorcerer sorcerer = new Sorcerer("Sorcerer");

        // Ajout d'instances d'armes dans la liste d'armes du joueur
        p.buyWeapon(new Axe());

        System.out.println("Bienvenue dans le RPG");
        System.out.println("Vous etes un "+ h.getName());
        // p.characterChoice(c);

        System.out.println("Menu");
        System.out.println("1. Aller au magasin d'armes");
        System.out.println("2. Changer d'arme");
        System.out.println("2. Combattre un monstre");
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
                System.out.println("--- ARMES DANS L'INVENTAIRE ---");
                for (int index = 0; index < p.getWeapons().size(); index++) {
                    Weapon weapon = p.getWeapons().get(index);
                    System.out.println((index + 1)+ "." + " " + weapon.getName() + " " + weapon.getDamage());
                }
                System.out.println("Choisissez une arme :");
                int choixInventaire = scanner.nextInt();
                if (choixInventaire >= 1 && choixInventaire <= p.getWeapons().size()) {
                    Weapon weap = p.getWeapons().get(choixInventaire - 1);
                    // Utilisez l'objet w comme nécessaire
                    System.out.println("Vous avez choisi " + weap.getName());
                } else {
                    System.out.println("Choix invalide");
                }
                break;

            case 3:
                System.out.println("--- COMBAT CONTRE UN MONSTRE ---");


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
