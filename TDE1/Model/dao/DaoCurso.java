package model.dao;

import java.util.ArrayList;
import model.Curso;

public class DaoCurso {
    private static ArrayList<Curso> listaCursos;

    static {
        listaCursos = new ArrayList<Curso>();
    }

    public boolean adicionar(Curso novo) {
        return listaCursos.add(novo);
    }

    public ArrayList<Curso> obterTodos() {
        return new ArrayList<>(listaCursos);
    }
}
