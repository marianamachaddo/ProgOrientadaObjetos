package model.dao;

import java.util.ArrayList;
import model.Aluno;

public class DaoAluno {
    private static ArrayList<Aluno> listaAlunos;

    static {
        listaAlunos = new ArrayList<Aluno>();
    }

    public boolean adicionar(Aluno novo) {
        return listaAlunos.add(novo);
    }

    public ArrayList<Aluno> obterTodos() {
        return new ArrayList<>(listaAlunos);
    }
}
