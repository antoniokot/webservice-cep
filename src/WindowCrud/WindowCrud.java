package WindowCrud;

import javax.swing.*;
import java.awt.*;

/**
 *Classe que constitui a janela para um programa CRUD.
 * Nesta classe cria-se a tela e seus componentes que serão usados na
 * implementação de uma aplicação CRUD que utiliza de  uma <a href="https://postmon.com.br/">API externa</a>
 * para pegar endereços completos através do CEP dado.
 * @see javax.swing
 * @see java.awt
 * @author Matheus Seiji Noda
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
     * Neste construtor serÃ¡ adicionado e posicionados ao painel principal(mainPainel)
     * todos os outros elementos de dentro do painel.
     * @author Matheus Seiji Noda
     * */
    public WindowCrud()
    {
        super("Consulta de Endereço");

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

        constraints.gridx = 1;
        btnCancelar.setBounds(150,50,80,20);
        btnPainel.add(btnCancelar, constraints);

        constraints.gridx = 0;
        constraints.gridy = 20;
        btnAdicionar.setBounds(10, 170, 76, 20);
        btnPainel.add(btnAdicionar, constraints);

        constraints.gridx = 1;
        btnDeletar.setBounds(100, 170, 75, 20);
        btnPainel.add(btnDeletar, constraints);

        constraints.gridx = 2;
        btnAlterar.setBounds(190, 170, 75, 20);
        btnPainel.add(btnAlterar, constraints);

        //Smaller fieldset
        constraints.insets = new Insets(5,10,5,10);

        //Pessoa
        constraints.gridx = 0;
        constraints.gridy = 0;
        clientePainel.add(lblId, constraints);

        constraints.gridx = 1;
        clientePainel.add(fieldId, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        clientePainel.add(lblNome, constraints);

        constraints.gridx = 1;
        clientePainel.add(fieldNome, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        clientePainel.add(lblTelefone,constraints);

        constraints.gridx = 1;
        clientePainel.add(fieldTelefone, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        clientePainel.add(lblEmail, constraints);

        constraints.gridx = 1;
        clientePainel.add(fieldEmail, constraints);

        //EndereÃ§o
        constraints.gridx = 0;
        constraints.gridy = 0;
        enderecoPainel.add(lblCEP, constraints);

        constraints.gridx = 1;
        enderecoPainel.add(fieldCEP, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        enderecoPainel.add(lblNumeroImovel, constraints);

        constraints.gridx = 1;
        enderecoPainel.add(fieldNumeroImovel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        enderecoPainel.add(lblComplemento, constraints);

        constraints.gridx = 1;
        enderecoPainel.add(fieldComplemento, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        enderecoPainel.add(lblRua, constraints);

        constraints.gridx = 1;
        enderecoPainel.add(fieldRua, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        enderecoPainel.add(lblBairro, constraints);

        constraints.gridx = 1;
        enderecoPainel.add(fieldBairro, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        enderecoPainel.add(lblCidade, constraints);

        constraints.gridx = 1;
        enderecoPainel.add(fieldCidade, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        enderecoPainel.add(lblEstado, constraints);

        constraints.gridx = 1;
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

        add(mainPainel);

        pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
