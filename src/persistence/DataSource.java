package persistence;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Clase que maneja la conexión a la base de datos
 */
public class DataSource
{
    /**
     * Referencia a la clase
     */
    private static DataSource dataSource = null;

    /**
     * Referencia de la conexión
     */
    private Connection con;

    /**
     * Construye una nueva conexión a la base de datos.<br>
     * Lee un archivo con las credenciales necesarias para conectarse.
     * <b>post: </b> Se conectó satisfactoriamente a la base de datos.
     * @throws Exception Si la conexión no logra ser establecida
     */
    private DataSource()
    {
        Properties conProperties = new Properties();

        try
        {
            conProperties.load(new FileInputStream("src/persistence/connection.properties"));

            String url = conProperties.getProperty("url");
            String user = conProperties.getProperty("user");
            String password = conProperties.getProperty("password");

            con = DriverManager.getConnection(url, user, password);

            System.out.println("Successful connection");

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Retorna una instancia de la clase
     * @return La instancia de la clase, si no está creada la construye
     */
    public static DataSource getInstance()
    {
        if (dataSource == null){
            dataSource = new DataSource();
        }
        return dataSource;
    }

    /**
     * Retorna el estado de una ejecución de la instrucción SQL recibida por parámetro.
     * @param sql Instrucción SQL. sql != "" && sql != null.
     * @return True si se logró ejecutar correctamente, false de lo contrario.
     */
    public boolean runExecuteUpdate(String sql)
    {
        int rows=0;
        try {
            Statement statement = con.createStatement();
            rows = statement.executeUpdate(sql);
            System.out.println("Successful query: "+sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Query error: "+e.getMessage());
            return false;
        }
    }
}
