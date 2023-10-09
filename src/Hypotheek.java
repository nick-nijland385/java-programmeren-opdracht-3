import java.util.Formatter;

abstract class Hypotheek implements Product {

    private int hypotheekSom;
    private int looptijd;

    private int rente = 4;

    public Hypotheek(int hypotheekSom, int looptijd) {
        this.hypotheekSom = hypotheekSom;
        this.looptijd = looptijd;
    }

    public String getHypotheekInfo() {
        return this.getProductnaam() + " Hoofdsom = " + this.hypotheekSom + " rente " + this.rente + "% looptijd " + this.looptijd + " jaar";
    }

    public int getLooptijd() {
        return  this.looptijd;
    }

    public int getHypotheekSom() {
        return  this.hypotheekSom;
    }

    public int getRenteBedrag() {
        return  this.hypotheekSom / 100 * this.rente;
    }

    public Formatter getTableHeader() {
        return this.getTableHeader();
    }

    public Formatter getTableRow(int jaar) throws Exception {
        return this.getTableRow(jaar);
    }

    public void looptijdErrorHandler (int jaar) throws Exception {
        if (jaar > getLooptijd()) {
            throw new Exception("De huidige calculatie valt niet binnen de looptijd van de hypotheel");
        }
    }

    public void huidigeHypotheekSomdErrorHandler (int restSomHuidig) throws Exception {
        if (restSomHuidig < 0) {
            throw new Exception("De huidige restsom is negatief");
        }  else if (restSomHuidig > getHypotheekSom()) {
            throw new Exception("De huidige restsom is meer dan de totale hypotheekSom");
        }
    }
}
