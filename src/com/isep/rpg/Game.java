package com.isep.rpg;

import com.isep.rpg.gentils.*;
import com.isep.rpg.items.Armor;
import com.isep.rpg.items.Weapon;
import com.isep.rpg.items.consumables.Food;
import com.isep.rpg.items.consumables.Potion;
import com.isep.utils.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public Game(InputParser inputParser) {
        //CREATION DE TOUTES LES ARMES DISPONIBLES DU JEU!
        marketWeapon = new ArrayList<>();

        warriorWeapon = new ArrayList<>();
        hunterWeapon = new ArrayList<>();
        mageWeapon = new ArrayList<>();
        healerWeapon = new ArrayList<>();
        //ARMES DU WARRIOR
        warriorWeapon.add(new Weapon("Eppee de FEU", "Warrior", 30));
        warriorWeapon.add(new Weapon("Marteau étincelant", "Warrior", 45));
        warriorWeapon.add(new Weapon("ULTRA Sabre", "Warrior", 70));
        warriorWeapon.add(new Weapon("MIDNIGHTREAPER", "Warrior", 99));
        //ARMES DU HUNTER
        hunterWeapon.add(new Weapon("Arbalète", "Hunter", 35));
        hunterWeapon.add(new Weapon("Glock 9mm", "Hunter", 55));
        hunterWeapon.add(new Weapon("AK-47", "Hunter", 80));
        hunterWeapon.add(new Weapon("M82 Calibre.50", "Hunter", 5));
        //ARMES DU MAGE
        mageWeapon.add(new Weapon("Baton de bois", "Mage", 5));
        mageWeapon.add(new Weapon("Baton de pierre", "Mage", 10));
        mageWeapon.add(new Weapon("Nokia 3310", "Mage", 12));
        //ARMES DU HEALER
        healerWeapon.add(new Weapon("Sceptre ordinaire", "Healer", 10));
        healerWeapon.add(new Weapon("Sceptre tranchant", "Healer", 15));
        healerWeapon.add(new Weapon("Akimbo desert Eagle de Healer", "Healer", 40));
        //CREATION DU MARCHEE D'ARMES
        marketWeapon = new ArrayList<>();
        marketWeapon.add(warriorWeapon);
        marketWeapon.add(hunterWeapon);
        marketWeapon.add(mageWeapon);
        marketWeapon.add(healerWeapon);
        //

        //ces listes serviront d'inventaire a consommable
        foodInventory = new ArrayList<>();
        potionInventory = new ArrayList<>();

        //LISTE DES CONSUMMABLES INITIAUX
        //food
        foodInventory.add(new Food("couscous", 30, 2));
        foodInventory.add(new Food("lembas", 40, 2));
        foodInventory.add(new Food("Bonbon", 100, 1));
        //potions
        potionInventory.add(new Potion("Potion de Mana", 20, 2));
        potionInventory.add(new Potion("Canette de Monster", 40, 2));
        potionInventory.add(new Potion("white Spirit", 100, 1));
        //

        System.out.println("JE DOIS METTRE UNE INTRO ICI!!!");

        this.inputParser = inputParser;

        // Il faut normalement 5 héros de types différents...
        heros = new ArrayList<>();
        Scanner sc = new Scanner (System.in);
        do {
            System.out.println("Avec combien de héros voulez vous partir a l'aventure? : ");
            nbrHero = sc.nextInt(); // On lit la réponse de l'utilisateur
            // Si l'utilisateur a choisi un nombre qui n'est pas entre 1 et 4,
            // on affiche un message d'erreur et on recommence la boucle
            if (nbrHero < 1 || nbrHero > 4) {
                System.out.println("Vous ne pouvez avoir qu'1 a 4 héros maximum !");
            }
        } while (nbrHero < 1 || nbrHero > 4);

        Scanner sc2 = new Scanner (System.in);

        for (int i = 0; i<nbrHero; i++) {//cette boucle de test va juste nous permettre de donner un nom et des pv aux guerriers
            System.out.println("Hero n°"+(i+1)+" - Quel Héros souhaitez vous ajouter a votre équipe? :\n- Warrior\n- Hunter\n- Mage\n- Healer\n");
            typeHero = sc2.nextLine();
            switch (typeHero.toLowerCase()) {
                case "warrior":
                    System.out.println("C'est quoi son p'tit nom? : ");
                    name = sc2.nextLine();
                    tempWarrior = new Warrior(name);
                    tempWarrior.take(new Weapon("Eppee en bois", "Warrior", 20));
                    tempWarrior.take(new Armor("Pull ordinaire", "Warrior", 0));
                    System.out.println(tempWarrior.getName()+" rejoint l'aventure\nIl possède une "+
                            tempWarrior.getWeaponName()+" : "+tempWarrior.getWeaponDamage()+" DMG"+
                            "\nEt un "+tempWarrior.getArmorName()+" : "+tempWarrior.getArmorPoint()+" DEF\n");
                    heros.add(tempWarrior);

                    break;
                case "hunter":
                    System.out.println("C'est quoi son p'tit nom? : ");
                    name = sc2.nextLine();
                    tempHunter = new Hunter(name);
                    tempHunter.take(new Weapon("Arc", "Hunter", 25));
                    tempHunter.take(new Armor("Veste ordinaire", "Hunter", 0));
                    System.out.println(tempHunter.getName()+" rejoint l'aventure\nIl possède un "+
                            tempHunter.getWeaponName()+" : "+tempHunter.getWeaponDamage()+" DMG"+
                            "\nEt un "+tempHunter.getArmorName()+" : "+tempHunter.getArmorPoint()+" DEF\n");
                    heros.add(tempHunter);

                    break;
                case "mage":
                    System.out.println("C'est quoi son p'tit nom? : ");
                    name = sc2.nextLine();
                    tempMage = new Mage(name, 100);
                    tempMage.take(new Weapon("Baton en carton", "Mage", 3));
                    tempMage.take(new Armor("Robe ordinaire", "Mage", 0));
                    System.out.println(tempMage.getName()+" rejoint l'aventure\nIl possède un "+
                            tempMage.getWeaponName()+" : "+tempMage.getWeaponDamage()+" DMG"+
                            "\nEt un "+tempMage.getArmorName()+" : "+tempMage.getArmorPoint()+" DEF\n");
                    heros.add(tempMage);

                    break;
                case "healer":
                    System.out.println("C'est quoi son p'tit nom? : ");
                    name = sc2.nextLine();
                    tempHealer = new Healer(name, 100);
                    tempHealer.take(new Weapon("cure dent", "Healer", 3));
                    tempHealer.take(new Armor("Tunique de soie", "Healer", 0));
                    System.out.println(tempHealer.getName()+" rejoint l'aventure\nIl possède un "+
                            tempHealer.getWeaponName()+" : "+tempHealer.getWeaponDamage()+" DMG"+
                            "\nEt un "+tempHealer.getArmorName()+" : "+tempHealer.getArmorPoint()+" DEF\n");
                    heros.add(tempHealer);

                    break;
                default:
                    System.out.println("C'est pas un type de héros ça, recommence");
                    i -= 1;//on recommence l'itérarion de la boucle.
            }
        }

        for (int i = 0; i < heros.size(); i++){
            heros.get(i).Status();
        }

        /*
        Hero ronal = new Warrior("Ronal");
        ronal.take( new Weapon("knife","Warrior", 1) );
        heros.add(ronal);
        //
        Hero conan = new Warrior("Conan");
        conan.take( new Weapon("sword", "Warrior", 2) );
        heros.add(conan);

        // Il faut normalement 5 ennemis de types différents...
        enemies = new ArrayList<>();
        enemies.add( new Dragon("Dracofeu") );
        enemies.add( new Dragon("Smaug") );
        */
    }


    public void start() {

        int ixHero = 0;

        // Boucle de jeu
        while (true) {

            displayStatus(heros, enemies);

            Combatant goodOne = heros.get(ixHero);
            Combatant badOne = enemies.get(0);

            // Attaque de l'ennemi
            displayMessage("Le méchant " + badOne.getName()
                    + " attaque le gentil " + goodOne.getName() + "...");
            badOne.attack(goodOne);
            if (goodOne.getHealthPoint() <= 0) {
                displayMessage
                        ("Le pauvre " + goodOne.getName() + " a été vaincu...");
                heros.remove(ixHero);
                ixHero--; // Correction: évite que le suivant perde son tour
            } else {

                // Riposte du gentil, s'il n'est pas vaincu
                displayMessage("Le gentil " + goodOne.getName()
                        + " attaque le méchant " + badOne.getName() + "...");
                goodOne.attack(badOne);
                if (badOne.getHealthPoint() <= 0) {
                    displayMessage("Bravo, " + goodOne.getName()
                            + " a vaincu " + badOne.getName() + " !!!");
                    enemies.remove(0);
                }

            }

            // Tests de fin du jeu
            if (heros.size() == 0) {
                displayMessage("Les héros ont perdu, c'est la fin du monde...");
                break;
            }
            if (enemies.size() == 0) {
                displayMessage("BRAVO, les héros ont gagné, le monde est sauvé !!!");
                break;
            }

            // Au tour du héro suivant
            ixHero = (ixHero + 1) % heros.size();
        }
    }

    public void choixAction(Combatant combatant){//cette methode va permettre en bref de traduire le choix de l'utilisateur
        int choix = combatant.actionChoice();
        String returnedChoice = combatant.actionMethodSwithcher(choix);

        actionMaker(returnedChoice, combatant);//l'action va être effectuée dans cette methode
    }

    public Combatant actionMaker(String choice, Combatant combatant){
        //déclarations de variables pour provoquer une action
        String menuEnnemis;
        String menuHeros;
        String menuConsumables;
        int nbreEnnemy = enemies.size();
        int nbreHeros = heros.size();
        int choixAttaque;
        int choixAllie;
        int choixConsumable;
        //Debut du switch donnant permettant d'effectuer l'action choisie
        switch(choice){
            // si le héro choisis d'attaquer
            case "attack":
                Scanner sc2 = new Scanner (System.in);
                do{
                    menuEnnemis = "";
                    displayMessage("Qui souhaitez vous attaquer? :");
                    for (int i = 0; i < nbreEnnemy;i++){
                        menuEnnemis += "["+(i+1)+"] - "+enemies.get(i).getName()+"\n";
                    }
                    displayMessage(menuEnnemis);
                    choixAttaque = sc2.nextInt();
                    if (choixAttaque < 1 || choixAttaque > nbreEnnemy) {
                        displayMessage("Ennemis selectionné non existant. Recommmencez");
                    }
                }while(choixAttaque < 1 || choixAttaque > nbreEnnemy);

                tempHarmedEnnemy = enemies.get((choixAttaque-1));//Je prend l'ennemi, je le met dans une variable
                combatant.attack(tempHarmedEnnemy);//je le frappe
                enemies.set((choixAttaque-1), tempHarmedEnnemy);//puis je le remet dans sa liste.
                break;
            // si le héro choisis de se défendre
            case "defend":
                combatant.setIfInDefense(true);
                displayMessage(combatant.getName()+" se met en garde!\n");
                break;
            // si un Mage décide de lancer un sort
            case "spell":
                int spellChoice;
                Scanner sc3 = new Scanner (System.in);
                do{
                displayMessage("Quel sort souhaitez vous lancer ? :\n" +
                        "[1] - FireBall : -20 MANA\n" +
                        "[2] - LightningBolt : -30 MANA\n" +
                        "[3] - ULTRALASER : -100 MANA\n" +
                        "[4] - Concentrate : +20 MANA");

                    spellChoice = sc3.nextInt();
                    if (spellChoice < 1 || spellChoice > 4) {
                        displayMessage("Sort selectionné non existant. Recommmencez");
                    }
                }while(spellChoice < 1 || spellChoice > 4);

                switch (spellChoice) {
                    case 1:
                        do{
                            menuEnnemis = "";
                            displayMessage("Sur qui souhaitez vous lancer ce sort ? :");
                            for (int i = 0; i < nbreEnnemy;i++){
                                menuEnnemis += "["+(i+1)+"] - "+enemies.get(i).getName()+"\n";
                            }
                            displayMessage(menuEnnemis);
                            choixAttaque = sc3.nextInt();
                            if (choixAttaque < 1 || choixAttaque > nbreEnnemy) {
                                displayMessage("Ennemis selectionné non existant. Recommmencez");
                            }
                        }while(choixAttaque < 1 || choixAttaque > nbreEnnemy);

                        tempHarmedEnnemy = enemies.get((choixAttaque-1));//Je prend l'ennemi, je le met dans une variable
                        ((Mage)combatant).castFireball(tempHarmedEnnemy);//je lui lance mon sort
                        enemies.set((choixAttaque-1), tempHarmedEnnemy);//puis je le remet dans sa liste.
                        break;
                    case 2:
                        do{
                            menuEnnemis = "";
                            displayMessage("Sur qui souhaitez vous lancer ce sort ? :");
                            for (int i = 0; i < nbreEnnemy;i++){
                                menuEnnemis += "["+(i+1)+"] - "+enemies.get(i).getName()+"\n";
                            }
                            displayMessage(menuEnnemis);
                            choixAttaque = sc3.nextInt();
                            if (choixAttaque < 1 || choixAttaque > nbreEnnemy) {
                                displayMessage("Ennemis selectionné non existant. Recommmencez");
                            }
                        }while(choixAttaque < 1 || choixAttaque > nbreEnnemy);

                        tempHarmedEnnemy = enemies.get((choixAttaque-1));//Je prend l'ennemi, je le met dans une variable
                        ((Mage)combatant).castLightningBolt(tempHarmedEnnemy);//je lui lance mon sort
                        enemies.set((choixAttaque-1), tempHarmedEnnemy);//puis je le remet dans sa liste.

                        break;
                    case 3:
                        do{
                            menuEnnemis = "";
                            displayMessage("Sur qui souhaitez vous lancer ce sort ? :");
                            for (int i = 0; i < nbreEnnemy;i++){
                                menuEnnemis += "["+(i+1)+"] - "+enemies.get(i).getName()+"\n";
                            }
                            displayMessage(menuEnnemis);
                            choixAttaque = sc3.nextInt();
                            if (choixAttaque < 1 || choixAttaque > nbreEnnemy) {
                                displayMessage("Ennemis selectionné non existant. Recommmencez");
                            }
                        }while(choixAttaque < 1 || choixAttaque > nbreEnnemy);

                        tempHarmedEnnemy = enemies.get((choixAttaque-1));//Je prend l'ennemi, je le met dans une variable
                        ((Mage)combatant).ultralaser(tempHarmedEnnemy);//je lui lance mon sort
                        enemies.set((choixAttaque-1), tempHarmedEnnemy);//puis je le remet dans sa liste.
                        break;
                    case 4:
                        ((Mage)combatant).concentrate();
                    default:
                        displayMessage("Le code a un problème de fonctionnement !");
                }
            case "heal":
                Scanner sc4 = new Scanner (System.in);
                do{
                    menuHeros = "";
                    displayMessage("Qui souhaitez vous soigner ? :");
                    for (int i = 0; i < nbrHero;i++){
                        menuHeros += "["+(i+1)+"] - "+heros.get(i).getName()+"\n";
                    }
                    displayMessage(menuHeros);
                    choixAllie = sc4.nextInt();
                    if (choixAllie < 1 || choixAllie > nbrHero) {
                        displayMessage("Allie selectionné non existant. Recommmencez");
                    }
                }while(choixAllie < 1 || choixAllie > nbrHero);
                tempHealedHero = heros.get((choixAllie-1));//Je prend l'allie, je le met dans une variable
                ((Healer)combatant).Heal(tempHealedHero);//je le soigne
                heros.set((choixAllie-1), tempHealedHero);//puis je le remet dans sa liste.
                break;
            case "consume":
                Scanner sc5 = new Scanner (System.in);
                menuConsumables ="";
                do{
                    displayMessage("Que souhaitez vous consommer ? :");
                    for (int i = 0; i < foodInventory.size();i++){
                        menuConsumables += "["+(i+1)+"] - "+foodInventory.get(i).info()+"\n";
                    }
                    if (combatant instanceof SpellCaster){
                        for (int i = foodInventory.size(); i < (foodInventory.size()+ potionInventory.size());i++){
                            menuConsumables += "["+(i+1)+"] - "+potionInventory.get(i-foodInventory.size()).getName()+"\n";
                        }
                    }
                    displayMessage(menuConsumables);
                    choixConsumable = sc5.nextInt();
                    if (choixConsumable < 1 || choixConsumable > (foodInventory.size() + ((combatant instanceof SpellCaster)?potionInventory.size():0))) {
                        displayMessage("Allie selectionné non existant. Recommmencez");
                    }
                }while(choixConsumable < 1 || choixConsumable > (foodInventory.size() + ((combatant instanceof SpellCaster)?potionInventory.size():0)));

                if (choixConsumable > foodInventory.size()){//alors cela signifie qu'on aura choisis une potion
                    potionInventory.get(choixConsumable- foodInventory.size() -1).usePotion((SpellCaster) combatant);
                }else{
                    foodInventory.get(choixConsumable-1).eat((Hero) combatant);
                }

                break;

            default:
                displayMessage("Il y'a un problème dans le actionMaker");
        }
        return combatant;//on retourne le combatant pour le remettre ensuite dans sa liste.
    }


    private InputParser inputParser;

    private List<ArrayList> marketWeapon;
    private ArrayList<Weapon> warriorWeapon;
    private ArrayList<Weapon> hunterWeapon;
    private ArrayList<Weapon> mageWeapon;
    private ArrayList<Weapon> healerWeapon;

    private ArrayList<Food> foodInventory;
    private ArrayList<Potion> potionInventory;

    private List<Combatant> heros;
    private List<Combatant> enemies;

    private Warrior tempWarrior;
    private Hunter tempHunter;
    private Mage tempMage;
    private Healer tempHealer;

    private Combatant tempHarmedEnnemy;
    private Combatant tempHealedHero;

    // Méthodes d'affichage
    // (STATIQUES pour pouvoir les appeler depuis n'importe où dans le programme)
    //
    // => pourraient éventuellement être déplacées dans le package
    //    "com.isep.utils", en s'inspirant de "InputParser" (méthodes de saisie)

    public static void displayStatus(List<Combatant> h, List<Combatant> e) {
        System.out.println("#########################");
        for (Combatant c: h) {
            System.out.print(c.getName() + "(" + c.getHealthPoint() + ") ");
        }
        System.out.println();
        for (Combatant c: e) {
            System.out.print(c.getName() + "(" + c.getHealthPoint() + ") ");
        }
        System.out.println();
    }
    private static void Delay() {
        System.out.println("\n" +
                "v       PRESS ENTER TO SKIP");
        Scanner scan = new Scanner(System.in);
        String delay = scan.nextLine();
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }
    private String name;
    private int nbrHero;
    private String typeHero;
}
