package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

/**
 * A classe Clientes é uma classe singleton que realiza operações no banco de dados
 * Instâncias desta classe, singleton, permitem a relização de operações no banco de dados relacionadas com a tabela Cliente_ArqServ, como obter valores da tabela, inserir valores, excluir valores e alterar valres
 * Nela encontramos, por exemplo, métodos para incluir, selecionar, excluir e alterar valores da tabela
 * @author Antônio Kotsubo(19162), Marcelo Sícoli(19185), Matheus Seiji(19190)
 * */

public class Clientes
{
    /**
     *Este metodo verifica se um usuario está ou não cadastrado retornando um boolean com a resposta
     * @param codigo o código do cliente
     * @return boolean sendo true se estiver cadastrado e false se não
     * @throws Exception
     */
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
    /**
     *Este metodo verifica se um email já foi cadastrado retornando um boolean com a resposta
     * @param email o email do cliente
     * @return boolean sendo true se o email estiver cadastrado e false se não
     * @throws Exception
     */
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

    /**
     * Insere um cliente na tabela Cliente_ArqServ
     * @param cliente o cliente a incluir
     * @throws Exception
     */
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

    /**
     * Exclui um cliente da tabela Cliente_ArqServ
     * @param codCliente o código do cliente a ser excluído
     * @throws Exception
     */
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

    /**
     * Altera os dados de um determinado cliente da tabela Cliente_ArqServ
     * @param cliente os novos dados do cliente
     * @param codigo o codigo do cliente que vai ser alterado
     * @throws Exception
     */
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

    /**
     * Recupera os dados de um determinado cliente da tabela Cliente_ArqServ
     * @param codCliente o código do cliente a ser pesquisado
     * @return os dados do cliente pesquisado
     * @throws Exception
     */
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
                throw new Exception ("Cliente não cadastrado");

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

    /**
     * Recupera todos os clientes da tabela Cliente_ArqServ
     * @return os clientes da tabela na forma de MeuResultset
     * @throws Exception
     */
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
    
    /*
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
                throw new Exception ("Email n�o cadastrado");

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
    */

}


