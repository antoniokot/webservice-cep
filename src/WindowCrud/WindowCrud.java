package WindowCrud;

import javax.swing.*;

import bd.daos.Clientes;
import bd.dbos.Cliente;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

import webservice.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *Classe que constitui a janela para um programa CRUD.
 * Nesta classe cria-se a tela e seus componentes que serão usados na
 * implementação de uma aplicação CRUD que utiliza de  uma <a href="https://postmon.com.br/">API externa</a>
 * para pegar endereços completos através do CEP dado.
 * @see javax.swing
 * @see java.awt
 * @author Matheus Seiji Noda and Antônio Hideto Borges Kotsubo
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
    private JTextField fieldTelefone = new JTextField(20);

    private JTextField fieldCEP = new JTextField(20);
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
     * @since 2020
     * */
    public WindowCrud()
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
            		
            		Logradouro logradouro = getLogradouro(fieldCEP.getText());
            		
            		fieldRua.setText(logradouro.getLogradouro());
    				fieldBairro.setText(logradouro.getBairro());
    				fieldCidade.setText(logradouro.getCidade());
    				fieldEstado.setText(logradouro.getEstado()); 
    				
    				btnAdicionar.setEnabled(false);
        		}
        		catch(Exception erro)
        		{
        			JOptionPane.showMessageDialog(null,"Cliente não pode ser resgatado.","Erro ao recuperar cliente", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
        });
        
        btnCancelar.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent arg0)
        	{
        		fieldId.setEnabled(true);
        		
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
        		
        		btnAdicionar.setEnabled(true);
        	}
        });
        
        btnAdicionar.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		if(fieldNome.getText() == "" )//|| fieldTelefone.getText() == "" || fieldEmail.getText() == "" ||
        				//fieldCEP.getText() == "" || fieldComplemento.getText() == "" || fieldNumeroImovel.getText() == "")
        		{
        			System.out.println("APERTO");
        			JOptionPane.showMessageDialog(null,"Um ou mais campos enconrtam-se vazios.","Erro ao adicionar", JOptionPane.INFORMATION_MESSAGE);
        		}
        		System.out.println("S");
        	}
        });
        
        fieldCEP.addKeyListener(new KeyAdapter() 
        {
        	@Override
        	public void keyTyped(KeyEvent arg0)
        	{
        		try
        		{
        			if(fieldCEP.getText().length() == 9)
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
        			JOptionPane.showMessageDialog(null,erro.getMessage(),"Erro ao recuperar cliente", JOptionPane.INFORMATION_MESSAGE);
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
        		catch(Exception erro)
        		{
        			JOptionPane.showMessageDialog(null,erro.getMessage(),"Erro ao deletar cliente", JOptionPane.INFORMATION_MESSAGE);
        		}
        	}
        });
    }
    
    protected Logradouro getLogradouro(String cep)
    {
    	cep = fieldCEP.getText().replaceAll("-", "");
    	Logradouro logradouro = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "http://api.postmon.com.br/v1/cep", cep);
    	
    	return logradouro;
    }
    
}

