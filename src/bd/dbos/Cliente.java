package bd.dbos;

import bd.core.*;
import bd.daos.*;

/**
 * A classe Cliente é uma classe que armazena valores de uma tabela.
 * Instâncias desta classe, permitem o armazenamento de um dado da tabela Cliente_ArqServ do banco de dados.
 * @author Antônio Kotsubo(19162), Marcelo Sícoli(19185), Matheus Seiji(19190)
 */
public class Cliente implements Cloneable
{
    //protected int codigo;
    protected String nome;
    protected String telefone;
    protected String email;
    protected String cep;
    protected int numeroImovel;
    protected String complemento;

    /**
     * Consturtor da classe cliente que pede como parâmetro todos os elementos da tabela Cliente_ArqServ exceto o código
     * @param nome
     * @param tel
     * @param email
     * @param cep
     * @param nImovel
     * @param comp
     * @throws Exception
     */
    public Cliente (String nome, String tel, String email, String cep, int nImovel, String comp) throws Exception
    {
        //setCodigo(cod);
        setNome(nome);
        setTelefone(tel);
        setEmail(email);
        setCep(cep);
        setNumeroImovel(nImovel);
        setComplemento(comp);
    }

    /*public void setCodigo(int cod) throws Exception
    {
        if(cod <= 0)
            throw new Exception("Código inválido!");

        this.codigo = cod;
    }*/

    /**
     * Muda o valor do atributo nome
     * @param nome o nome do cliente
     * @throws Exception
     */
    public void setNome(String nome) throws Exception
    {
        if(nome == " ")
            throw new Exception("Nome inválido!");

        this.nome = nome;
    }

    /**
     * Muda o valor do atributo telefone
     * @param tel o telefone do cliente
     * @throws Exception
     */
    public void setTelefone(String tel) throws Exception
    {
        if(tel == " " || tel.length() < 15 || tel.length() > 15)
            throw  new Exception("Telefone inválido!");

        this.telefone = tel;
    }

    /**
     * Muda o valor do atributo email
     * @param email o email do cliente
     * @throws Exception
     */
    public void setEmail(String email) throws Exception
    {
        if(email == "")
            throw new Exception("E-mail inválido!");

        this.email = email;
    }

    /**
     * Muda o valor do atributo cep
     * @param cep o cep do cliente
     * @throws Exception
     */
    public void setCep(String cep) throws Exception
    {
        if(cep == " " || cep.length() < 9 || cep.length() > 9)
            throw new Exception("CEP inválido!");

        this.cep = cep;
    }

    /**
     * Muda o valor do atributo numero do imovel
     * @param nImovel o numero do imovel do cliente
     * @throws Exception
     */
    public void setNumeroImovel(int nImovel) throws Exception
    {
        if(nImovel <= 0)
            throw new Exception("Número de imóvel inválido!");

        this.numeroImovel = nImovel;
    }

    /**
     * Muda o valor do atributo complemento do endereço
     * @param comp o complemento do endereço do cliente
     * @throws Exception
     */
    public void setComplemento(String comp) throws Exception
    {
        if(comp == " ")
            throw new Exception("Complemento inválido!");

        this.complemento = comp;
    }

    /*public int getCodigo()
    {
        return this.codigo;
    }*/

    /**
     * Retorna o nome do cliente
     * @return o nome do cliente
     */
    public String getNome()
    {
        return this.nome;
    }

    /**
     * Retorna o telefone do cliente
     * @return o telefone do cliente
     */
    public String getTelefone()
    {
        return this.telefone;
    }

    /**
     * Retorna o email do cliente
     * @return o email do cliente
     */
    public String getEmail()
    {
        return this.email;
    }

    /**
     * Retorna o cep do cliente
     * @return o cep do cliente
     */
    public String getCep()
    {
        return this.cep;
    }

    /**
     * Retorna o numero do imovel do cliente
     * @return o numero do imovel do cliente
     */
    public int getNumeroImovel()
    {
        return this.numeroImovel;
    }

    /**
     * Retorna o complemento do endereço do cliente
     * @return o complemento do endereço do cliente
     */
    public String getComplemento()
    {
        return this.complemento;
    }

    /**
     * Transforma todo o conteudo da classe cliente em uma string e a retorna
     * @return uma string com todos os valores do cliente
     */
    public String toString()
    {
        String ret = "";

        //ret += "CÓDIGO: " + this.getCodigo() + "\n";
        ret += "NOME: " + this.getNome() + "\n";
        ret += "TELEFONE: " + this.getTelefone() + "\n";
        ret += "E-MAIL: " + this.getEmail() + "\n";
        ret += "CEP: " + this.getCep() + "\n";
        ret += "NÚMERO IMÓVEL: " + this.getNumeroImovel() + "\n";
        ret += "COMPLEMENTO: " + this.getComplemento() + "\n";

        return ret;
    }

    /**
     * Compara dois clientes e retorna um boolean com o resultado da comparação
     * @param obj o cliente a ser comparado
     * @return um boolean com o resultad da comparação
     */
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;

        if(obj == this)
            return true;

        if(obj.getClass() != this.getClass())
            return false;

        Cliente cli = (Cliente)obj;
        if(cli.getNome() != this.getNome() || cli.getTelefone() != this.getTelefone() || cli.getEmail() != this.getEmail()
            || cli.getCep() != this.getCep() || cli.getNumeroImovel() != this.getNumeroImovel()
                || cli.getComplemento() != this.getComplemento())
            return false;

        return true;
    }

    /**
     * Gera o código de hash da classe cliente
     * @return o código de hash
     */
    public int hashCode()
    {
        int ret = 666;

        //ret = ret * 11 + new Integer(this.codigo).hashCode();
        ret = ret * 11 + this.nome.hashCode();
        ret = ret * 11 + this.telefone.hashCode();
        ret = ret * 11 + this.email.hashCode();
        ret = ret * 11 + this.cep.hashCode();
        ret = ret * 11 + new Integer(this.numeroImovel).hashCode();
        ret = ret * 11 + this.complemento.hashCode();

        return ret;
    }

    /**
     * Clona a classe cliente
     * @return um cliente identico ao desta instancia
     */
    public Object clone()
    {
        Cliente ret = null;

        try
        {
            ret = new Cliente(this);
        }
        catch(Exception erro)
        {
            // sei que não vai dar erro
        }

        return ret;
    }

    /**
     * Construtor da classe cliente a partir de outra instancia desta classe
     * @param modelo a instancia desta classe
     * @throws Exception
     */
    public Cliente(Cliente modelo) throws Exception
    {
        if(modelo == null)
            throw new Exception("Modelo inválido!");

        //this.codigo = modelo.codigo;
        this.nome = modelo.nome;
        this.telefone = modelo.telefone;
        this.email = modelo.email;
        this.cep = modelo.cep;
        this.numeroImovel = modelo.numeroImovel;
        this.complemento = modelo.complemento;
    }

}
