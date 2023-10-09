import java.util.Formatter;

public interface Product {
    String getProductnaam();
    Formatter getTableHeader();
    Formatter getTableRow(int jaar) throws Exception;

}
