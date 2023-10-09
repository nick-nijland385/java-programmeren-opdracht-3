import java.util.Formatter;

public class LineaireHypotheek extends Hypotheek implements Product {

    public String getProductnaam() {
        return "Lineaire hypotheek";
    }
    public int getProductnummer() {
        return 1;
    }

    public Formatter getTableHeader() {
        Formatter fmt = new Formatter();
        fmt.format("%-15s%-15s%-15s\n", "restSomHuidig", "aflossing", "renteBedrag");
        return fmt;
    }

    public Formatter getTableRow(int jaar) throws Exception {
        return this.getRow(jaar);
    }

    private int aflossing;
    private int hypotheekSom;
    private int rentePercentage = 4;

    LineaireHypotheek(int hypotheekSom, int looptijd) {
        super(hypotheekSom, looptijd);
        this.hypotheekSom = hypotheekSom;

        // Calculeer de jaarlijke aflossing
        aflossing = hypotheekSom / looptijd;
    }

    public Formatter getRow(int jaar) throws Exception {
        this.looptijdErrorHandler(jaar);
        Formatter fmt = new Formatter();
        int restSom = hypotheekSom - (aflossing * jaar);
        int renteBedrag = restSom / 100 * rentePercentage;
        int restSomHuidig = restSom - aflossing;
        this.huidigeHypotheekSomdErrorHandler(restSomHuidig);
        return fmt.format("%-15s%-15s%-15s\n", restSomHuidig, aflossing, renteBedrag);
    }

}
