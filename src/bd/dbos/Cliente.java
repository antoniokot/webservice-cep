package bd.dbos;

import bd.core.*;
import bd.daos.*;

public class Cliente implements Cloneable
{
    //protected int codigo;
    protected String nome;
    protected String telefone;
    protected String email;
    protected String cep;
    protected int numeroImovel;
    protected String complemento;

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

    public void setNome(String nome) throws Exception
    {
        if(nome == " ")
            throw new Exception("Nome inválido!");

        this.nome = nome;
    }

    public void setTelefone(String tel) throws Exception
    {
        if(tel == " " || tel.length() < 15 || tel.length() > 15)
            throw  new Exception("Telefone inválido!");

        this.telefone = tel;
    }

    public void setEmail(String email) throws Exception
    {
        if(email == "")
            throw new Exception("E-mail inválido!");

        this.email = email;
    }

    public void setCep(String cep) throws Exception
    {
        if(cep == " " || cep.length() < 9 || cep.length() > 9)
            throw new Exception("CEP inválido!");

        this.cep = cep;
    }

    public void setNumeroImovel(int nImovel) throws Exception
    {
        if(nImovel <= 0)
            throw new Exception("Número de imóvel inválido!");

        this.numeroImovel = nImovel;
    }

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

    public String getNome()
    {
        return this.nome;
    }

    public String getTelefone()
    {
        return this.telefone;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getCep()
    {
        return this.cep;
    }

    public int getNumeroImovel()
    {
        return this.numeroImovel;
    }

    public String getComplemento()
    {
        return this.complemento;
    }

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
