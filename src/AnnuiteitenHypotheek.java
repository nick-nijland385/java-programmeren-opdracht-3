import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Formatter;

public class AnnuiteitenHypotheek extends Hypotheek implements Product {

    private final double rentePercentage = 4;
    private int hypotheekSom;
    private double annuiteit = 0.0;

    public String getProductnaam() {
        return "Annuïteiten hypotheek";
    }

    public int getProductnummer() {
        return 3;
    }

    AnnuiteitenHypotheek(int hypotheekSom, int looptijd) {
        super(hypotheekSom, looptijd);
        this.hypotheekSom = hypotheekSom;

        // calculeer rentevoet
        double renteVoet = this.rentePercentage / 100;

        // calculeer annuiteit
        double an1 = (1 - (Math.pow(1 + renteVoet, -looptijd)));
        double an2 = renteVoet / an1;
        double an3 = an2 * hypotheekSom;
        BigDecimal annuiteitRounded = new BigDecimal(an3).setScale(0, RoundingMode.DOWN);
        this.annuiteit = annuiteitRounded.doubleValue();
    }

    public Formatter getTableHeader() {
        Formatter fmt = new Formatter();
        fmt.format("%-15s%-15s%-15s\n", "restSomHuidig", "aflossing", "rente");
        return fmt;
    }

    public Formatter getTableRow(int jaar) throws Exception {
        return this.getRow(jaar);
    }

    public Formatter getRow(int jaar) throws Exception {
        this.looptijdErrorHandler(jaar);
        Formatter fmt = new Formatter();
        double rente = this.hypotheekSom / 100 * rentePercentage;
        double aflossing = this.annuiteit - rente;
        BigDecimal aflossingRounded = new BigDecimal(aflossing).setScale(0, RoundingMode.DOWN);
        double restSom = this.hypotheekSom - aflossing;
        BigDecimal restSomRounded = new BigDecimal(restSom).setScale(0, RoundingMode.DOWN);
        this.hypotheekSom = restSomRounded.intValue();
        this.huidigeHypotheekSomdErrorHandler(this.hypotheekSom);
        return fmt.format("%-15s%-15s%-15s\n", restSomRounded, aflossingRounded, rente);
    }

}