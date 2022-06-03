package util;

import java.sql.ResultSet;
import java.util.List;

public interface RowMapper {
    public Object mapRow(ResultSet rs) throws Exception;
}
