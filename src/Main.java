public class Main {
    public static void main(String[] args) throws Exception {
        int looptijd = 5;
        int hypotheekSom = 100000;

        // Maak een lineaire hypotheek
        LineaireHypotheek lineaireHypotheek = new LineaireHypotheek(hypotheekSom, looptijd);
        getOverzicht(lineaireHypotheek);

        // Maak een spaar hypotheek
        SpaarHypotheek spaarHypotheek = new SpaarHypotheek(hypotheekSom, looptijd);
        getOverzicht(spaarHypotheek);

        // Maak een spaar hypotheek
        AnnuiteitenHypotheek annuiteitenHypotheek = new AnnuiteitenHypotheek(hypotheekSom, looptijd);
        getOverzicht(annuiteitenHypotheek);
    }

    static void getOverzicht(Hypotheek hypotheek) throws Exception {
        System.out.println(System.lineSeparator());
        System.out.println(hypotheek.getHypotheekInfo());
        System.out.println(System.lineSeparator());
        System.out.println(hypotheek.getTableHeader());
        for (int i = 0; i < hypotheek.getLooptijd(); i++) {
             System.out.println(hypotheek.getTableRow(i));
        }
    }

}


//    JPA
//Hybernate
//Junit