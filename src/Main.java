import com.isep.rpg.*;
import com.isep.rpg.gentils.Healer;
import com.isep.rpg.gentils.Hunter;
import com.isep.rpg.gentils.Mage;
import com.isep.rpg.gentils.Warrior;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Il faudra initialiser un "InputParser"...
        Game game = new Game(null);
        game.start();
    }
    public static void CreateHeros(){
        Scanner sc = new Scanner (System.in);

        Warrior warrior1 = new Warrior("");
        Warrior warrior2 = new Warrior("");
        Warrior warrior3 = new Warrior("");
        Warrior warrior4 = new Warrior("");//on initialise les guerrier

        ArrayList<Warrior> WarriorList = new ArrayList<Warrior>();
        WarriorList.add(warrior1);
        WarriorList.add(warrior2);
        WarriorList.add(warrior3);
        WarriorList.add(warrior4);//on intègre les guerrier dans un vecteur pour pouvoir parcourir la liste de guerrier

        Hunter hunter1 = new Hunter("");
        Hunter hunter2 = new Hunter("");
        Hunter hunter3 = new Hunter("");
        Hunter hunter4 = new Hunter("");//on initialise les hunters

        ArrayList<Hunter> HunterList = new ArrayList<Hunter>();
        HunterList.add(hunter1);
        HunterList.add(hunter2);
        HunterList.add(hunter3);
        HunterList.add(hunter4);//on intègre les hunters dans un vecteur pour pouvoir parcourir la liste de hunter

        Mage mage1 = new Mage("", 0);
        Mage mage2 = new Mage("",0);
        Mage mage3 = new Mage("",0);
        Mage mage4 = new Mage("", 0);//on initialise les Mages

        ArrayList<Mage> MageList = new ArrayList<Mage>();
        MageList.add(mage1);
        MageList.add(mage2);
        MageList.add(mage3);
        MageList.add(mage4);//on intègre les Mages dans un vecteur pour pouvoir parcourir la liste de mages

        Healer healer1 = new Healer("",0);
        Healer healer2 = new Healer("",0);
        Healer healer3 = new Healer("",0);
        Healer healer4 = new Healer("",0);//on initialise les healer

        ArrayList<Healer> HealerList = new ArrayList<Healer>();
        HealerList.add(healer1);
        HealerList.add(healer2);
        HealerList.add(healer3);
        HealerList.add(healer4);//on intègre les guerrier dans un vecteur pour pouvoir parcourir la liste de guerrier

        System.out.println("Combien de héros voulez vous intégrer a l'aventure? : ");
        int nbrHero = sc.nextInt();

        Scanner sc2 = new Scanner (System.in);
        String typeHero;
        String name;
        int cntWarrior = 0;
        int cntHunter = 0;
        int cntMage = 0;
        int cntHealer = 0;

        for (int i = 0; i<nbrHero; i++){//cette boucle de test va juste nous permettre de donner un nom et des pv aux guerriers
            System.out.println("Quel Héros souhaitez vous ajouter a votre équipe? :\nWarrior\nHunter\nMage\nHealer");
            typeHero = sc2.nextLine();
            switch (typeHero){
                case "Warrior":
                    System.out.println("C'est quoi son petit nom? : ");
                    name = sc2.nextLine();
                    WarriorList.set(cntWarrior, new Warrior(name)); //,pvMax = 30, force =10));
                    cntWarrior += 1;
                    break;
                case "Hunter":
                    System.out.println("C'est quoi son petit nom? : ");
                    name = sc2.nextLine();
                    HunterList.set(cntHunter, new Hunter(name)); //,pvMax = 30, force =10));
                    cntHunter += 1;
                    break;
                case "Mage":
                    System.out.println("C'est quoi son petit nom? : ");
                    name = sc2.nextLine();
                    MageList.set(cntMage, new Mage(name, 30)); //,pvMax = 30));
                    cntMage += 1;
                    break;
                case "Healer":
                    System.out.println("C'est quoi son petit nom? : ");
                    name = sc2.nextLine();
                    HealerList.set(cntHealer, new Healer(name,30));
                    cntHealer += 1;
                    break;
                default:
                    System.out.println("C'est pas un type de héros ça, recommence");
                    i -=1;//on recommence l'itérarion de la boucle.
            }
        }
        for(int i =0; i<4; i++){//on va supprimer les guerrier qui n'ont pas été demandé. cruel :(
            if(WarriorList.get(i).getHealthPoint() == 0){
                WarriorList.set(i, null); //ça reviens plus ou moins a supprimer la variable.
            }
            if(HunterList.get(i).getHealthPoint() == 0){
                HunterList.set(i, null); //ça reviens plus ou moins a supprimer la variable.
            }
            if(MageList.get(i).getHealthPoint() == 0){
                MageList.set(i, null); //ça reviens plus ou moins a supprimer la variable.
            }
            if(HealerList.get(i).getHealthPoint() == 0){
                HealerList.set(i, null); //ça reviens plus ou moins a supprimer la variable.
            }
        }

        warrior1 = WarriorList.get(0);
        warrior2 = WarriorList.get(1);
        warrior3 = WarriorList.get(2);
        warrior4 = WarriorList.get(3);

        hunter1 = HunterList.get(0);
        hunter2 = HunterList.get(1);
        hunter3 = HunterList.get(2);
        hunter4 = HunterList.get(3);

        mage1 = MageList.get(0);
        mage2 = MageList.get(1);
        mage3 = MageList.get(2);
        mage4 = MageList.get(3);

        healer1 = HealerList.get(0);
        healer2 = HealerList.get(1);
        healer3 = HealerList.get(2);
        healer4 = HealerList.get(3);

        WarriorList=null;
        HunterList=null;
        MageList=null;
        HealerList=null;//on supprime les listes, elles ne servent plus a rien

        /*
        //Juste pour tester le bon fonctionnement
        System.out.println("Les warrior: ");
        System.out.println(warrior1);
        System.out.println(warrior2);
        System.out.println(warrior3);
        System.out.println(warrior4);

        System.out.println("Les hunters: ");
        System.out.println(hunter1);
        System.out.println(hunter2);
        System.out.println(hunter3);
        System.out.println(hunter4);

        System.out.println("Les mage: ");
        System.out.println(mage1);
        System.out.println(mage2);
        System.out.println(mage3);
        System.out.println(mage4);

        System.out.println("Les healer: ");
        System.out.println(healer1);
        System.out.println(healer2);
        System.out.println(healer3);
        System.out.println(healer4);
         */
    }
}