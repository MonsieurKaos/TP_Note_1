import fr.morin.frais.FraisDeDeplacement;

public class Main {
    public static void main(String[] args) {
        //Création du premier Frais pour John Smith
        FraisDeDeplacement f1 = new FraisDeDeplacement("08/02/2024","John Smith", "train",125.5F,178);
        //Création du second Frais pour Emma
        FraisDeDeplacement f2 = new FraisDeDeplacement("12/12/2023","Emma","a pieds",0,8);

        //Affichage du descriptif des 2 Frais classique
        System.out.println(f1);
        System.out.println(f2);

        //Affichage du descriptif des 2 Frais avec conversion en dollar
        System.out.println(f1.toStringDollars());
        System.out.println(f2.toStringDollars());

    }
}