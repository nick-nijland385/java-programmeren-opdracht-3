import java.util.Formatter;

public interface Product {
    public String getProductnaam();
    public int getProductnummer();
    public Formatter getTableHeader();
    public Formatter getTableRow(int jaar) throws Exception;


}
