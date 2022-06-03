package transaction;

import java.sql.SQLException;

public interface TransactionManager {

    public void beginTransaction();
    public void commit();
    public void rollback();

}
