import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class DBUtils {

    private static DBUtils DBUtilsInstance = null;
    static Statement stat = null;

    private DBUtils()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:DB_Nituz.db");
            stat = conn.createStatement();
            System.out.println("Intializing DBUtils...");
        }
        catch (Exception e)
        {
            System.out.println("There was an error while initialzing the DBUtils");
        }
    }

    public static DBUtils getInstance()
    {
        if (DBUtilsInstance == null)
            DBUtilsInstance = new DBUtils();

        return DBUtilsInstance;
    }

    public static List<HashMap<String,Object>> executeQuery(String query)
    {
        try {
            return convertResultSetToList(stat.executeQuery(query));
        }
        catch (Exception e)
        {
            System.out.println("There was an error when executing " + query);
        }

        return null;

    }

    public static List<HashMap<String,Object>> convertResultSetToList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();

        while (rs.next()) {
            HashMap<String,Object> row = new HashMap<String, Object>(columns);
            for(int i=1; i<=columns; ++i) {
                row.put(md.getColumnName(i),rs.getObject(i));
            }
            list.add(row);
        }

        return list;
    }


}
