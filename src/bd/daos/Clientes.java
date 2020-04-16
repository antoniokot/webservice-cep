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

    public static boolean emailCadastrado(String email) throws Exception
    {
        boolean retorno = false;

        try
        {
            String sql = "";

            sql = "SELECT * FROM Cliente_ArqServ WHERE email = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setString(1, email);

            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery();

            retorno = resultado.first();
        }
        catch (SQLException erro)
        {
            throw new Exception("Erro ao procurar cliente");
        }

        return retorno;
    }

    public static void incluir (Cliente cliente) throws Exception
    {
        if(cliente == null)
            throw new Exception("Cliente não fornecido");
        if(emailCadastrado(cliente.getEmail()))
            throw new Exception("Email já em uso");
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

    public static void excluir (int codCliente) throws Exception
    {
        try
        {
            String sql = "";

            sql = "DELETE FROM Cliente_ArqServ WHERE codCliente = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1,codCliente);

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao excluir cliente");
        }

    }

    public static void alterar (Cliente cliente, int codigo) throws Exception
    {
        if (cliente==null)
            throw new Exception ("Cliente não fornecido");

        if (!cadastrado (codigo))
            throw new Exception ("Cliente não está cadastrado");

        try
        {
            String sql = "";

            sql = "UPDATE Cliente_ArqServ " +
                    "SET NOME = ? " +
                    ", TELEFONE = ? " +
                    ", EMAIL = ? " +
                    ", CEP = ? " +
                    ", NUMEROIMOVEL = ? " +
                    ", COMPLEMENTO = ? " +
                    "WHERE codCliente = ?";
            
            BDSQLServer.COMANDO.prepareStatement (sql);
            
            BDSQLServer.COMANDO.setString(1, cliente.getNome());
            BDSQLServer.COMANDO.setString(2, cliente.getTelefone());
            BDSQLServer.COMANDO.setString(3, cliente.getEmail());
            BDSQLServer.COMANDO.setString(4, cliente.getCep());
            BDSQLServer.COMANDO.setInt(5, cliente.getNumeroImovel());
            BDSQLServer.COMANDO.setString(6, cliente.getComplemento());
            BDSQLServer.COMANDO.setInt(7, codigo);	
            
            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao atualizar dados do cliente");
        }
    }

    public static Cliente getCliente (int codCliente) throws Exception
    {
        Cliente cliente = null;
        try
        {
            String sql = "";

            sql = "SELECT * FROM Cliente_ArqServ WHERE codCliente = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setInt(1,codCliente);
            
            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Cliete não cadastrado");

            cliente = new Cliente(resultado.getString("nome"),
                                    resultado.getString("telefone"),
                                    resultado.getString("email"),
                                    resultado.getString("cep"),
                                    resultado.getInt("numeroImovel"),
                                    resultado.getString("complemento"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar cliente");
        }

        return cliente;
    }

    public static MeuResultSet getClientes () throws Exception
    {
        MeuResultSet resultado = null;

        try
        {
            String sql;

            sql = "SELECT * " +
                    "FROM Cliente_ArqServ";

            BDSQLServer.COMANDO.prepareStatement (sql);

            resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar clientes");
        }

        return resultado;
    }
    
    public static Cliente getClienteByEmail (String email) throws Exception
    {
        Cliente cliente = null;
        try
        {
            String sql = "";

            sql = "SELECT * FROM Cliente_ArqServ WHERE email = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setString(1, email);
            
            MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();

            if (!resultado.first())
                throw new Exception ("Email não cadastrado");

            cliente = new Cliente(resultado.getString("nome"),
                                    resultado.getString("telefone"),
                                    resultado.getString("email"),
                                    resultado.getString("cep"),
                                    resultado.getInt("numeroImovel"),
                                    resultado.getString("complemento"));
        }
        catch (SQLException erro)
        {
            throw new Exception ("Erro ao recuperar cliente");
        }

        return cliente;
    }

}


