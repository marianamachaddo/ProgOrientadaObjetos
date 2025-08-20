package viewer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class JanelaPrincipal extends JFrame {
    private JPanel contentPane;

    public JanelaPrincipal() {
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btCurso = new JButton("Curso");
        btCurso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new JanelaCurso();
            }
        });
        btCurso.setBounds(50, 50, 120, 60);
        contentPane.add(btCurso);

        JButton btAluno = new JButton("Aluno");
        btAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new JanelaAluno();
            }
        });
        btAluno.setBounds(190, 50, 120, 60);
        contentPane.add(btAluno);

        JButton btFechar = new JButton("Fechar");
        btFechar.addActionListener(e -> System.exit(0));
        btFechar.setBounds(330, 50, 120, 60);
        contentPane.add(btFechar);

        this.setVisible(true);
    }
}
