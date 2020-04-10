package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Clientes
{
    public static boolean cadastrado (int codigo) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql = "";

            sql = "SELECT * FROM Cliente_ArqServ WHERE codCliente = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1, codigo);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

            retorno = resultado.first();
        }
        catch(SQLException erro)
        {
            throw  new Exception("Erro ao procurar cliente");
        }

        return retorno;
    }

    public static void incluir (Cliente cliente) throws Exception
    {
        if(cliente == null)
            throw new Exception("Cliente não fornecido");

        try
        {
            String sql = "";

            sql = "INSERT INTO Cliente_ArqServ VALUES (?,?,?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setString(1, cliente.getNome());
            BDSQLServer.COMANDO.setString(2, cliente.getTelefone());
            BDSQLServer.COMANDO.setString(3, cliente.getEmail());
            BDSQLServer.COMANDO.setString(4, cliente.getCep());
            BDSQLServer.COMANDO.setInt(5, cliente.getNumeroImovel());
            BDSQLServer.COMANDO.setString(6, cliente.getComplemento());

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao inserir cliente");
        }

    }

}


