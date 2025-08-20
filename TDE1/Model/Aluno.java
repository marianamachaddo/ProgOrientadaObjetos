package model;

public class Aluno {
    private int matricula;
    private String nome;
    private Curso curso;

    public Aluno(int matricula, String nome, Curso curso) throws ModelException {
        this.setMatricula(matricula);
        this.setNome(nome);
        this.setCurso(curso);
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) throws ModelException {
        if (matricula <= 0) {
            throw new ModelException("A matrícula deve ser maior que zero!");
        }
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ModelException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ModelException("O nome do aluno não pode ser vazio!");
        }
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) throws ModelException {
        if (curso == null) {
            throw new ModelException("O aluno deve estar matriculado em um curso!");
        }
        this.curso = curso;
    }
}
