package viewer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.Curso;
import model.ModelException;
import model.dao.DaoCurso;
import java.awt.event.*;

public class JanelaCurso extends JFrame {
    private JPanel contentPane;
    private JTextField tfCodigo;
    private JTextField tfNome;

    public JanelaCurso() {
        setTitle("Cadastro de Curso");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(30, 40, 60, 14);
        contentPane.add(lblCodigo);

        tfCodigo = new JTextField();
        tfCodigo.setBounds(100, 40, 100, 20);
        contentPane.add(tfCodigo);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 80, 60, 14);
        contentPane.add(lblNome);

        tfNome = new JTextField();
        tfNome.setBounds(100, 80, 250, 20);
        contentPane.add(tfNome);

        JButton btOk = new JButton("OK");
        btOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(tfCodigo.getText());
                    String nome = tfNome.getText();
                    Curso novo = new Curso(codigo, nome);
                    new DaoCurso().adicionar(novo);
                    JOptionPane.showMessageDialog(btOk, "Curso cadastrado!");
                    setVisible(false);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(btOk, "Código deve ser um número inteiro!");
                } catch (ModelException ex) {
                    JOptionPane.showMessageDialog(btOk, ex.getMessage());
                }
            }
        });
        btOk.setBounds(100, 150, 80, 25);
        contentPane.add(btOk);

        JButton btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener(e -> setVisible(false));
        btCancelar.setBounds(220, 150, 100, 25);
        contentPane.add(btCancelar);

        this.setVisible(true);
    }
}
