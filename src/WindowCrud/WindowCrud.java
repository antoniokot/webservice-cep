package WindowCrud;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import bd.daos.Clientes;
import bd.dbos.Cliente;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.text.ParseException;

import webservice.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 *Classe que constitui a janela para um programa CRUD.
 * Nesta classe cria-se a tela e seus componentes que serão usados na
 * implementação de uma aplicação CRUD que utiliza de  uma <a href="https://postmon.com.br/">API externa</a>
 * para pegar endereços completos através do CEP dado.
 * @see javax.swing
 * @see java.awt
 * @author Matheus Seiji Noda, Marcelo Sícoli and Antônio Hideto Borges Kotsubo
 * */
public class WindowCrud extends JFrame
{
    private JLabel lblId = new JLabel("Código: ");
    private JLabel lblNome = new JLabel("Nome: ");
    private JLabel lblEmail = new JLabel("Email: ");
    private JLabel lblTelefone = new JLabel("Telefone: ");

    private JLabel lblCEP = new JLabel("CEP: ");
    private JLabel lblNumeroImovel = new JLabel("Número imóvel: ");
    private JLabel lblComplemento = new JLabel("Complemento: ");
    private JLabel lblRua = new JLabel("Rua: ");
    private JLabel lblBairro = new JLabel("Bairro: ");
    private JLabel lblCidade = new JLabel("Cidade: ");
    private JLabel lblEstado = new JLabel("Estado: ");

    private JTextField fieldId = new JTextField(4);
    private JTextField fieldNome = new JTextField(20);
    private JTextField fieldEmail = new JTextField(20);
    private JFormattedTextField fieldTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));

    private JFormattedTextField fieldCEP = new JFormattedTextField(new MaskFormatter("#####-###"));
    private JTextField fieldNumeroImovel = new JTextField(20);
    private JTextField fieldComplemento = new JTextField(20);
    private JTextField fieldRua = new JTextField(20);
    private JTextField fieldBairro = new JTextField(20);
    private JTextField fieldCidade = new JTextField(20);
    private JTextField fieldEstado = new JTextField(20);

    private JButton btnAlterar = new JButton("Alterar");
    private JButton btnAdicionar = new JButton("Adicionar");
    private JButton btnDeletar = new JButton("Deletar");
    private JButton btnBuscar = new JButton("Buscar");
    private JButton btnCancelar = new JButton("Cancelar");

    /**
     * Construtor da classe WindowCrud.
     * Neste construtor serão adicionados e posicionados ao painel principal
     * todos os outros elementos de dentro do painel.
     * @author Matheus Seiji Noda and Antônio Hideto Borges Kotsubo
     * @throws ParseException 
     * @since 2020
     * */
    public WindowCrud() throws ParseException
    {
        super("Consulta de Endereço");
        
        fieldRua.setEnabled(false);
        fieldBairro.setEnabled(false);
        fieldCidade.setEnabled(false);
        fieldEstado.setEnabled(false);

        JPanel mainPainel = new JPanel(new GridBagLayout());
        JPanel btnPainel = new JPanel(new GridBagLayout());
        btnPainel.setPreferredSize(new Dimension(275, 240));
        JPanel clientePainel = new JPanel(new GridBagLayout());
        clientePainel.setPreferredSize(new Dimension(300, 240));
        JPanel enderecoPainel = new JPanel(new GridBagLayout());
        enderecoPainel.setPreferredSize(new Dimension(300, 240));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0,0,0,0);

        btnPainel.setLayout(null);

        constraints.gridx = 0;
        constraints.gridy = 0;
        
        btnBuscar.setBounds(45,50,80,20);
        btnPainel.add(btnBuscar, constraints);
        
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0,0,0,0);
        constraints.gridx = 1;
        
        btnCancelar.setBounds(150,50,80,20);
        btnPainel.add(btnCancelar, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0,0,0,0);
        constraints.gridx = 0;
        constraints.gridy = 20;
        
        btnAdicionar.setBounds(10, 170, 76, 20);
        btnPainel.add(btnAdicionar, constraints);
        
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0,0,0,0);
        constraints.gridx = 1;
        constraints.gridy = 20;
        
        btnDeletar.setBounds(100, 170, 75, 20);
        btnPainel.add(btnDeletar, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(0,0,0,0);
        constraints.gridx = 2;
        constraints.gridy = 20;
        
        btnAlterar.setBounds(190, 170, 75, 20);
        btnPainel.add(btnAlterar, constraints);

        //Smaller fieldset
        constraints.insets = new Insets(5,10,5,10);

        //Pessoa
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        clientePainel.add(lblId, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        clientePainel.add(fieldId, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 0;
        constraints.gridy = 1;
        clientePainel.add(lblNome, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 1;
        constraints.gridy = 1;
        
        clientePainel.add(fieldNome, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 0;
        constraints.gridy = 2;
        clientePainel.add(lblTelefone,constraints);
        
        fieldTelefone.setColumns(11);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 1;
        constraints.gridy = 2;
        clientePainel.add(fieldTelefone, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 0;
        constraints.gridy = 3;
        clientePainel.add(lblEmail, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 1;
        constraints.gridy = 3;
        clientePainel.add(fieldEmail, constraints);

        //EndereÃ§o
        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        enderecoPainel.add(lblCEP, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        fieldCEP.setColumns(7);
        
        
        enderecoPainel.add(fieldCEP, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 0;
        constraints.gridy = 1;
        enderecoPainel.add(lblNumeroImovel, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 1;
        constraints.gridy = 1;
        enderecoPainel.add(fieldNumeroImovel, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 0;
        constraints.gridy = 2;
        enderecoPainel.add(lblComplemento, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 1;
        constraints.gridy = 2;
        enderecoPainel.add(fieldComplemento, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 0;
        constraints.gridy = 3;
        enderecoPainel.add(lblRua, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 1;
        constraints.gridy = 3;
        enderecoPainel.add(fieldRua, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 0;
        constraints.gridy = 4;
        enderecoPainel.add(lblBairro, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 1;
        constraints.gridy = 4;
        enderecoPainel.add(fieldBairro, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 0;
        constraints.gridy = 5;
        enderecoPainel.add(lblCidade, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 1;
        constraints.gridy = 5;
        enderecoPainel.add(fieldCidade, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 0;
        constraints.gridy = 6;
        enderecoPainel.add(lblEstado, constraints);

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5,10,5,10);
        constraints.gridx = 1;
        constraints.gridy = 6;
        enderecoPainel.add(fieldEstado, constraints);

        //Final part
        mainPainel.add(btnPainel);

        clientePainel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Cliente"));
        mainPainel.add(clientePainel);

        enderecoPainel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Endereço"));
        mainPainel.add(enderecoPainel);

        mainPainel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Manutenção de Dados"));

        getContentPane().add(mainPainel);

        pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
        
        limparFields();
        
        btnCancelar.setEnabled(false);
        btnAlterar.setEnabled(false);
        
        btnBuscar.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		try
        		{
        			Cliente clienteRetornado = Clientes.getCliente(Integer.parseInt(fieldId.getText()));
        			
        			fieldNome.setText(clienteRetornado.getNome());
        			fieldTelefone.setText(clienteRetornado.getTelefone());
        			fieldEmail.setText(clienteRetornado.getEmail());
        			fieldCEP.setText(clienteRetornado.getCep());
        			fieldComplemento.setText(clienteRetornado.getComplemento());
        			fieldNumeroImovel.setText(new Integer(clienteRetornado.getNumeroImovel()).toString());
        			
        			fieldId.setEnabled(false);
        			btnBuscar.setEnabled(false);
            		
            		Logradouro logradouro = getLogradouro(fieldCEP.getText());
            		
            		fieldRua.setText(logradouro.getLogradouro());
    				fieldBairro.setText(logradouro.getBairro());
    				fieldCidade.setText(logradouro.getCidade());
    				fieldEstado.setText(logradouro.getEstado()); 
    				
    				btnAdicionar.setEnabled(false);
    				btnCancelar.setEnabled(true);
    				btnAlterar.setEnabled(true);
        		}
        		catch(Exception erro)
        		{
        			if(fieldId.getText().equals(""))
        				JOptionPane.showMessageDialog(null, "Código não foi fornecido","Erro ao recuperar cliente", JOptionPane.INFORMATION_MESSAGE);
        			
        			else
        				JOptionPane.showMessageDialog(null, erro.getMessage(),"Erro ao recuperar cliente", JOptionPane.INFORMATION_MESSAGE);
        			
        			limparFields();
        		}
        	}
        });
        
        btnCancelar.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent arg0)
        	{
        		fieldId.setEnabled(true);
        		
        		limparFields();
        		
        		btnAdicionar.setEnabled(true);
        		btnCancelar.setEnabled(false);
        		btnAlterar.setEnabled(false);
        		btnBuscar.setEnabled(true);
        	}
        });
        
        btnAdicionar.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{		       		
        		try
        		{
        			String nome = fieldNome.getText();
        			String telefone = fieldTelefone.getText();
        			String email = fieldEmail.getText();
        			String cep = fieldCEP.getText();
        			int nImovel = Integer.parseInt(fieldNumeroImovel.getText());
        			String comp = fieldComplemento.getText();
        			
        			Clientes.incluir(new Cliente(nome, telefone, email, cep, nImovel, comp));
        			
        			limparFields();
        			
        			JOptionPane.showMessageDialog(null,"Cliente incluído com sucesso!","Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        		}
        		catch(Exception erro)
        		{
        			if(algumVazio())
        				JOptionPane.showMessageDialog(null, "Um ou mais campos encontram-se vazios.","Erro ao adicionar", JOptionPane.INFORMATION_MESSAGE);
        		
        			else
        				JOptionPane.showMessageDialog(null, erro.getMessage(),"Erro ao adicionar", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
        });
        
        
        btnDeletar.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		try
        		{
        			Clientes.excluir(Integer.parseInt(fieldId.getText()));
        			
        			fieldId.setEnabled(true);
        			
        			limparFields();
        			
        			btnAlterar.setEnabled(false);
        			btnAdicionar.setEnabled(true);
        			btnCancelar.setEnabled(false);
        			btnBuscar.setEnabled(true);
        			
        			JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso.","Sucesso!", JOptionPane.INFORMATION_MESSAGE);       			
        		}
        		catch(Exception erro)
        		{
        			if(fieldId.getText().equals(""))
        				JOptionPane.showMessageDialog(null, "Código do cliente não foi fornecido.","Erro ao deletar cliente", JOptionPane.INFORMATION_MESSAGE);
        			
        			else
        				JOptionPane.showMessageDialog(null, erro.getMessage(),"Erro ao deletar cliente", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
        });
        
        btnAlterar.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent arg0) 
        	{
        		try
        		{
        			int id = Integer.parseInt(fieldId.getText());
        			String nome = fieldNome.getText();
    				String telefone = fieldTelefone.getText();
    				String email = fieldEmail.getText();
    				String cep = fieldCEP.getText();
    				int nImovel = Integer.parseInt(fieldNumeroImovel.getText());
    				String comp = fieldComplemento.getText();
    				
    				Cliente novoCliente = new Cliente (nome, telefone, email, cep, nImovel, comp);
    				
    				Clientes.alterar(novoCliente, id);
    				
    				JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso.","Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        		}
        		catch(Exception erro)
        		{
        			if(fieldId.getText().equals(""))
        				JOptionPane.showMessageDialog(null, "Código do cliente não foi fornecido.","Erro ao alterar cliente", JOptionPane.INFORMATION_MESSAGE);
        			
        			else
        			if(algumVazio())
        				JOptionPane.showMessageDialog(null, "Um ou mais campos não foram fornecidos","Erro ao alterar cliente", JOptionPane.INFORMATION_MESSAGE);
        			
        			else
        				JOptionPane.showMessageDialog(null, erro.getMessage(),"Erro ao alterar cliente", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
        });
        
        fieldCEP.addKeyListener(new KeyAdapter() 
        {
        	@Override
        	public void keyTyped(KeyEvent arg0)
        	{
        		try
        		{
        			String padrao = "\\d{5}-\\d{3}";
        			
        			if(fieldCEP.getText().matches(padrao))
        			{
        				Logradouro logradouro = getLogradouro(fieldCEP.getText());
        			
        				fieldRua.setText(logradouro.getLogradouro());
        				fieldBairro.setText(logradouro.getBairro());
        				fieldCidade.setText(logradouro.getCidade());
        				fieldEstado.setText(logradouro.getEstado());        				
        				
        			}
        		}
        		catch(Exception erro)
        		{
        			JOptionPane.showMessageDialog(null, "Não foi possível recuperar as informações através do CEP fornecido.","Erro ao recuperar cep", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
        });
    }
    
    /**
     * Método que retorna um logradouro. 
     * Este método utiliza do CEP para retornar informações sobre uma localização específica, que são retornadas por um WebService.
     * @param cep			É o parâmetro utilizado no WebService para retornar informações de uma localização específica
     * @return logradouro	Retorna uma instância da classe Logradouro, que contém todas as informações vindas do WebService
     */
    
    protected Logradouro getLogradouro(String cep) throws Exception
    {
    	cep = fieldCEP.getText().replaceAll("-", "");    		
    	
    	Logradouro logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "http://api.postmon.com.br/v1/cep", cep);
    	
    	return logradouro;
    }
    
    
    /**
     * Método responsável por limpar os TextFields     
     */     
    
    protected void limparFields()
    {
    	fieldId.setText("");
		fieldNome.setText("");
		fieldTelefone.setText("");
		fieldEmail.setText("");
		fieldCEP.setText("");
		fieldComplemento.setText("");
		fieldNumeroImovel.setText("");
		fieldRua.setText("");
		fieldBairro.setText("");
		fieldCidade.setText("");
		fieldEstado.setText("");
    }
    
    /**
     * Método que confere se o conteúdo de algum TextField é nulo.
     * @return	true se houver algum TextField vazio e false se não houver
     */
    
    protected boolean algumVazio()
    {
    	if(fieldId.getText().equals("") || fieldNome.getText().equals("") || fieldTelefone.getText().equals("") 
    			|| fieldEmail.getText().equals("") || fieldCEP.getText().equals("")
    			|| fieldNumeroImovel.getText().equals("") || fieldComplemento.getText().equals(""))
    		return true;
    	
    	return false;
    }
}

