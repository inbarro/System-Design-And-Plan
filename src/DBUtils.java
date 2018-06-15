import java.sql.*;
import java.util.HashMap;
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

    public static List<HashMap<String,String>> executeQuery(String query)
    {
        System.out.println(query);
        try {
            return convertResultSetToList(stat.executeQuery(query));
        }
        catch (Exception e)
        {
            if(!e.toString().contains("query does not return ResultSet")) {
                System.out.println("There was an error when executing " + query);
                e.printStackTrace();
            }
        }

        return null;

    }

    public static List<HashMap<String,String>> convertResultSetToList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

        while (rs.next()) {
            HashMap<String,String> row = new HashMap<String, String>(columns);
            for(int i=1; i<=columns; ++i) {
                row.put(md.getColumnName(i),rs.getObject(i).toString());
            }
            list.add(row);
        }

        return list;
    }


}
