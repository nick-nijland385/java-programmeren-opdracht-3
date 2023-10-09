import java.util.Formatter;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class SpaarHypotheek extends Hypotheek implements Product {

    public String getProductnaam() {
        return "Spaar hypotheek";
    }

    public int getProductnummer() {
        return 2;
    }

    public Formatter getTableHeader() {
        Formatter fmt = new Formatter();
        fmt.format("%-15s%-15s%-15s\n", "Inleg", "Gespaard", "Rente");
        return fmt;
    }

    public Formatter getTableRow(int jaar) throws Exception {
        return this.getRow(jaar);
    }

    SpaarHypotheek(int hypotheekSom, int looptijd) {
        super(hypotheekSom, looptijd);
        getInleg();
    }

    private double rentePercentage = 4;
    private int inleg;
    private double gespaard;
    private int gespaardRounded;

    private void getInleg() {
        double inlegX = calculateInlegX();
        double inlegY = this.getHypotheekSom() / inlegX;
        BigDecimal inlegRounded = new BigDecimal(inlegY).setScale(2, RoundingMode.FLOOR);
        this.inleg = inlegRounded.intValue();
    }

    private double calculateInlegX() {
        double inlegInitial = 1 + this.rentePercentage / 100;
        double inleg = 0;
        for (int i = 0; i < getLooptijd(); i++) {
            inleg = inleg + Math.pow(inlegInitial, i);
        }
        return inleg;
    }

    public Formatter getRow(int jaar) throws Exception {
        this.looptijdErrorHandler(jaar);
        Formatter fmt = new Formatter();
        if (jaar == 0) {
            this.gespaard = this.inleg;
            this.gespaardRounded = this.inleg;
        } else {
            double renteBedrag = (this.gespaard / 100 * 4);
            BigDecimal renteBedragRounded = new BigDecimal(renteBedrag).setScale(2, RoundingMode.FLOOR);
            double renteBedragTotaal = this.gespaard + renteBedragRounded.doubleValue();
            BigDecimal renteBedragTotaalRounded = new BigDecimal(renteBedragTotaal).setScale(2, RoundingMode.FLOOR);
            double gespaardTotaal = renteBedragTotaalRounded.doubleValue() + this.inleg;
            int gespaardRounded = (int) Math.round(gespaardTotaal);
            this.gespaard = gespaardTotaal;
            this.gespaardRounded = gespaardRounded;
            this.huidigeHypotheekSomdErrorHandler(this.gespaardRounded);
        }
        return fmt.format("%-15s%-15s%-15s\n", this.inleg, this.gespaardRounded, getRenteBedrag());
    }

}
