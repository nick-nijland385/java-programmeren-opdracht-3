//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.Formatter;
//
//public class AnnuïteitenHypotheek extends Hypotheek implements Product {
//    public String getProductnaam() {
//        return "Annuïteiten hypotheek";
//    }
//    public int getProductnummer() {
//        return 3;
//    }
//
//    public Formatter getTableHeader() {
//        Formatter fmt = new Formatter();
//        fmt.format("%-15s%-15s%-15s\n", "restSomHuidig", "aflossing", "renteBedrag");
//        return fmt;
//    }
//
//    public Formatter getTableRow(int jaar) {
//        return this.getRow(jaar);
//    }
//    private double rentePercentage = 4;
//
//    AnnuïteitenHypotheek(int hypotheekSom, int looptijd) {
//        super(hypotheekSom, looptijd);
//
//        // calculeer rentevoet
//        double renteVoet = this.rentePercentage / 100;
//        System.out.println(renteVoet);
//        System.out.println(this.getHypotheekSom());
//
//        // calculeer annuïteit
//
//        double an1 = (1 - (1 + 0.04)) - 10;
//        double an2 = 0.04;
//
//        System.out.println(an1/an2);
//
//
//
//        System.out.println((4 / (1 -((1 + 4) - Math.pow(-5, -5))) * 100000));
//
//
//
//
//
//
//
//    }
//
//    public Formatter getRow(int jaar) {
//        Formatter fmt = new Formatter();
//        int restSom = 0 - (0 * jaar);
//        int renteBedrag = restSom / 100 * 0;
//        int restSomHuidig = restSom - 0;
//        return fmt.format("%-15s%-15s%-15s\n", restSomHuidig, 0, renteBedrag);
//    }
//}
