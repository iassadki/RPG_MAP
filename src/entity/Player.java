package entity;

import destructible.Destructible;
import destructible.Monster;
import destructible.Obstacle;
import map.Map;
import weapons.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class Player implements ActionsPlayer {

    private String name;
    private ArrayList<Weapon> weapons;
    private double money;
    private Entity e;
    private Elfe elfe;
    private Mage mage;
    private Warrior warrior;
    private Map map;

    // Position actuelle du joueur sur la carte
    private int playerRow;
    private int playerCol;
    private char nextCell;  // Nouvelle variable pour stocker la valeur de nextCell

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

    public char getNextCell() {
        return nextCell;
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
            System.out.println((index + 1) + "." + " " + weapon.getName() + " " + weapon.getDamage());
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
    public void deplacementOnMap(char direction, Map map, Entity e) {
        // Condition pour vérifier si la case suivante est vide ou remplie
        nextCell = ' ';

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

        // Appelle des méthodes spécifiques en fonction du contenu de la case suivante
        handleNextCellContent(map, e, direction);
        //return nextCell;
    }

    // Nouvelle méthode pour gérer le contenu de la case suivante
    private void handleNextCellContent(Map map, Entity e, char direction) {
        //Destructible d;
        if (nextCell == 'O') {
            //map.getMap()[playerRow][playerCol] = ' ';
            // transformer nextCell en P/O pour afficher le joueur dans la case de l'obstacle
            Destructible o1 = new Obstacle();
            handleObstacleCombat(map, e, o1);
            //movePlayer(map, direction);
        } else if (nextCell == '#') {
            //map.getMap()[playerRow][playerCol] = ' ';
            Destructible m1 = new Monster();
            handleMonsterCombat(map, e, m1);
            //movePlayer(map, direction);
        } else {
            movePlayer(map, direction);
        }
    }

    // Méthode pour gérer le combat contre un obstacle
    private void handleObstacleCombat(Map map, Entity e, Destructible d) {
        System.out.println("--- DETRUIRE CET OBSTACLE ---");
        System.out.println("Obstacle HP: " + d.getLife());

        //Map map;

        while (d.getLife() > 0 && e.getCurrentHP() > 0) {
            System.out.println("Hero HP: " + e.getCurrentHP() + " " + "Obstacle HP: " + d.getLife());
            System.out.println("Que voulez vous faire ?");
            System.out.println("1. Attaquer");
            System.out.println("2. Attaque spéciale");
            System.out.println("3. Fuir");

            Scanner scanner = new Scanner(System.in);
            int choixDuJoueur = scanner.nextInt();
            switch (choixDuJoueur) {
                case 1:
                    System.out.println("--- ATTAQUE NORMALE ---");
                    d.hit(this.getWeapons().get(0).getDamage());
                    break;
                case 2:
                    System.out.println("--- ATTAQUE SPECIALE ---");
                    switch (this.e.getName()) {
                        case "Elfe" -> this.e.specialAttack(this, d); // elfe.specialAttack(d);
                        case "Mage" -> this.e.specialAttack(this, d); // mage.specialAttack(d);
                        case "Warrior" -> this.e.specialAttack(this, d); // warrior.specialAttack(d);
                    }
                    //d.hit(this.getWeapons().get(0).getDamage());
                    break;
                case 3:
                    System.out.println("--- FUITE ---");
                    // Gerer la fuite du Player du combat
                    //movePlayer(map, direction);
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        }

        // Afficher le résultat du combat
        if (e.getCurrentHP() > 0) {
            System.out.println("Vous avez détruit l'obstacle!");
            map.clearCell(playerRow, playerCol); // Effacer la position actuelle du joueur
            map.placePlayer(playerRow, playerCol); // Afficher le joueur dans la nouvelle position
        } else {
            System.out.println("Vous etes mort!");
            System.exit(0);
        }
    }


    // Méthode pour gérer le combat contre un monstre
    private void handleMonsterCombat(Map map, Entity e, Destructible d) {
        System.out.println("--- COMBAT CONTRE MONSTRE ---");
        //Player p = null;

        boolean tourHeros = true;

        while (d.getLife() > 0 && e.getCurrentHP() > 0) {
            System.out.println(this.e.getName() + " : " + e.getCurrentHP() + " " + "Monster HP: " + d.getLife());

            if (tourHeros) {
                System.out.println("Que voulez vous faire ?");
                System.out.println("1. Attaquer");
                System.out.println("2. Attaque spéciale");
                System.out.println("3. Fuir");

                Scanner scanner = new Scanner(System.in);
                int choixDuJoueur = scanner.nextInt();
                switch (choixDuJoueur) {
                    case 1:
                        System.out.println("--- ATTAQUE NORMALE ---");
                        d.hit(this.getWeapons().get(0).getDamage());
                        break;
                    case 2:
                        System.out.println("--- ATTAQUE SPECIALE ---");
                        switch (this.e.getName()) {
                            case "Elfe" -> this.e.specialAttack(this, d); // elfe.specialAttack(d);
                            case "Mage" -> this.e.specialAttack(this, d); // mage.specialAttack(d);
                            case "Warrior" -> this.e.specialAttack(this, d); // warrior.specialAttack(d);
                        }
                        //d.hit(this.getWeapons().get(0).getDamage());
                        break;
                    case 3:
                        System.out.println("--- FUITE ---");
                        // Gerer la fuite du Player du combat
                        //movePlayer(map, direction);
                        break;
                    default:
                        System.out.println("Choix invalide");
                        break;
                }
            }

            // Afficher le résultat du combat
            if (d.getLife() <= 0) {
                System.out.println("Vous avez vaincu le monstre!");
                //char currentCell = map.getMap()[playerRow][playerCol];
                // Effacer la position actuelle
                //map.clearCell(playerRow - 1, playerCol);


            } else if (e.getCurrentHP() <= 0) {
                System.out.println("Vous êtes mort!");
                System.out.println(e.getCurrentHP());
                System.exit(0);
            }
            tourHeros = !tourHeros; // Inverser la valeur de tourHeros
        }
    }


    // Méthode pour déplacer le joueur
    private void movePlayer(Map map, char direction) {
        // Stocker la valeur actuelle de la cellule
        char currentCell = map.getMap()[playerRow][playerCol];

        // Effacer la position actuelle
        map.getMap()[playerRow][playerCol] = ' ';

        // Mettre à jour la nouvelle position
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

        // Vérifier si la nouvelle position contient un obstacle
        if (currentCell == 'O') {
            map.getMap()[playerRow][playerCol] = 'P';
        } else {
            map.getMap()[playerRow][playerCol] = 'P';
        }
    }

    @Override
    public void characterChoice() {
        // Choix du personnage avec les chiffres du clavier
        System.out.println("Choisissez votre personnage :");
        System.out.println("1. Elfe");
        System.out.println("2. Mage");
        System.out.println("3. Warrior");
        Scanner scanner = new Scanner(System.in);
        int choixPersonnage = scanner.nextInt();

        switch (choixPersonnage) {
            case 1:
                // Option pour choisir le personnage Elfe
                this.e = new Elfe();
                this.e.setName("Elfe");
                System.out.println("Vous avez choisi la classe " + this.e.getName());
                break;
            case 2:
                // Option pour choisir le personnage Mage
                this.e = new Mage();
                this.e.setName("Mage");
                System.out.println("Vous avez choisi la classe " + this.e.getName());
                break;
            case 3:
                // Option pour choisir le personnage Warrior
                this.e = new Warrior();
                this.e.setName("Warrior");
                System.out.println("Vous avez choisi la classe " + this.e.getName());
                break;
            default:
                System.out.println("Choix invalide");
                break;
        }
    }


    @Override
    public void attack(Destructible d) {
        // TODO Auto-generated method stub
        // si c'est une instance de monstre, on affiche le message monstre
        if (d instanceof Monster) {
            System.out.println("monstre");
        } else if (d instanceof Obstacle) {
            System.out.println("Vous avez frappé un obstacle");
        }

        d.life -= this.getWeapons().get(0).getDamage();
    }
}

