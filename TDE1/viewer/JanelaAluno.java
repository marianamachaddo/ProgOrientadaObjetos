package viewer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import model.Aluno;
import model.Curso;
import model.ModelException;
import model.dao.DaoAluno;
import model.dao.DaoCurso;
import java.awt.event.*;

public class JanelaAluno extends JFrame {
    private JPanel contentPane;
    private JTextField tfMatricula;
    private JTextField tfNome;
    private JComboBox<Curso> cbCurso;

    public JanelaAluno() {
        setTitle("Cadastro de Aluno");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 420, 280);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblMatricula = new JLabel("Matrícula:");
        lblMatricula.setBounds(30, 40, 80, 14);
        contentPane.add(lblMatricula);

        tfMatricula = new JTextField();
        tfMatricula.setBounds(120, 40, 100, 20);
        contentPane.add(tfMatricula);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(30, 80, 80, 14);
        contentPane.add(lblNome);

        tfNome = new JTextField();
        tfNome.setBounds(120, 80, 250, 20);
        contentPane.add(tfNome);

        JLabel lblCurso = new JLabel("Curso:");
        lblCurso.setBounds(30, 120, 80, 14);
        contentPane.add(lblCurso);

        cbCurso = new JComboBox<>(new DaoCurso().obterTodos().toArray(new Curso[0]));
        cbCurso.setBounds(120, 120, 250, 22);
        contentPane.add(cbCurso);

        JButton btOk = new JButton("OK");
        btOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int matricula = Integer.parseInt(tfMatricula.getText());
                    String nome = tfNome.getText();
                    Curso curso = (Curso) cbCurso.getSelectedItem();
                    Aluno novo = new Aluno(matricula, nome, curso);
                    new DaoAluno().adicionar(novo);
                    JOptionPane.showMessageDialog(btOk, "Aluno cadastrado!");
                    setVisible(false);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(btOk, "Matrícula deve ser um número inteiro!");
                } catch (ModelException ex) {
                    JOptionPane.showMessageDialog(btOk, ex.getMessage());
                }
            }
        });
        btOk.setBounds(120, 180, 80, 25);
        contentPane.add(btOk);

        JButton btCancelar = new JButton("Cancelar");
        btCancelar.addActionListener(e -> setVisible(false));
        btCancelar.setBounds(240, 180, 100, 25);
        contentPane.add(btCancelar);

        this.setVisible(true);
    }
}
