package entity;

import weapons.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Player implements ActionsPlayer {

    private String name;
    private ArrayList<Weapon> weapons;
    private double money;

    public Player(String name) {
        this.name = name;
        this.money = 50;
        this.weapons = new ArrayList<Weapon>();
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
    // Ajouter une arme dans l'inventaire de Player
    public void addWeapon(Weapon w) {
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
