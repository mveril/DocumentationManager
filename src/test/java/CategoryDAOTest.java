import com.mveril.documentationmanager.dao.DAOFactory;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author mikav
 */
public class CategoryDAOTest {
    
  @Test
  public void BuildTable(){
      DAOFactory.getCategoryDAO();
  }
}
