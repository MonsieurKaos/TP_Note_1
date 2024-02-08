package fr.morin.frais;

public class FraisDeDeplacement {
    //Création des attribut d'un Frais avec attribution de valeur pas défaut
    private String date = "01/01/1970";
    private String personne = "Jane Smith";
    //La définition des transports valides se fait avec un tableau de String static et final car il n'a pas lieu d'être modifié
    private static final String[] transports = {"voiture electrique", "voiture thermique", "voiture hybride", "train", "RER", "tram", "metro", "vélo", "a pieds"};
    private String transport = "a pieds";
    private float montant = 0;
    private int kms = 0;
    private static final float taux = 1.0763F;

    /*Getter non utile pour l'exercice
    public static String[] getTransports() {
        return transports;
    }
    */

    //Ensemble des getter et setter pour les attributs de la classe
    public static float getTaux() {
        return taux;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPersonne() {
        return personne;
    }

    public void setPersonne(String personne) {
        this.personne = personne;
    }

    public String getTransport() {
        return transport;
    }

    //Ce setter appel la méthode isValidTransport qui vérifie si le transport est bien dans la liste donnée. Si ce n'est pas le cas une erreur s'affiche
    public void setTransport(String transport) {
        if (isValidTransport(transport)){
            this.transport = transport;
        } else {
            throw new IllegalArgumentException("Le transport indiqué ne fait pas partit de la liste des transports disponibles");
        }
    }

    public float getMontant() {
        return montant;
    }

    //Ce setter vérifie que le montant ne peux pas être inférieur à 0 si c'est le cas une erreur s'affiche
    public void setMontant(float montant) {
        if (montant<0)
            throw new IllegalArgumentException("Le montant des frais ne peut pas être inférieur à 0");
        this.montant = montant;
    }

    public int getKms() {
        return kms;
    }

    //Ce setter vérifie que le nombre de kms parcourus ne peux pas être égale ou inférieur à 0 si c'est le cas une erreur s'affiche
    public void setKms(int kms) {
        if (kms<=0)
            throw new IllegalArgumentException("Les kms ne peuvent pas être égale ou inférieur à 0");
        this.kms = kms;
    }

    //Constructeur de la classe. Les setter vérifiant des conditions sont placé en premier
    public FraisDeDeplacement(String date, String personne, String transport, float montant, int kms) {
        this.setTransport(transport);
        this.setMontant(montant);
        this.setKms(kms);
        this.setDate(date);
        this.setPersonne(personne);
    }

    //Méthode permettant de vérifier que le transport donné au setter setTransport fais partit de la liste fournie
    private static boolean isValidTransport(String transport) {
        for (String transportValide : transports) {
            if (transportValide.equals(transport)) {
                return true;
            }
        }
        return false;
    }

    //Redéfinition de la méthode toString pour la classe FraisDeDeplacement
    public String toString(){
        return getPersonne() + " a effectué un déplacement de " + getKms() + "kms le " + getDate() + ".\n" + "La personne a voyagé en " + getTransport() + " pour un coût de " + getMontant() + " Euros.\n";
    }

    //Méthode permettant de convertir le montant d'euro en dollar
    public float getMontantDollars(){
        return getMontant()*getTaux();
    }

    //Méthode renvoyant la même chose que toString() mais avec conversion en dollar
    public String toStringDollars(){
        return getPersonne() + " a effectué un déplacement de " + getKms() + "kms le " + getDate() + ".\n" + "La personne a voyagé en " + getTransport() + " pour un coût de " + getMontantDollars() + " Dollars.\n";
    }
}

