package pe.isil.EP1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class, args);

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EP1",
                "root","");

        CallableStatement callableStatement = conexion.prepareCall("{call listarRegistros()}");
        ResultSet resultSet = callableStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString("tipDoc"));
            System.out.println(resultSet.getString("nroDoc") + "\n");
        }

        PreparedStatement preparedStatement = conexion.prepareStatement("update users set name= ? where name = ?");
        preparedStatement.setString(1,"Juan");
        preparedStatement.setString(2,"Bruno");
        int resultSet1 = preparedStatement.executeUpdate();
        System.out.println("Filas afectadas: " + resultSet1 + "\n");

        Statement statement = conexion.createStatement();
        int filasAfectadas = statement.executeUpdate("delete from users where id= 2");
        System.out.println("Filas afectadas: " + filasAfectadas);
    }
}
