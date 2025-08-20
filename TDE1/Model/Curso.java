package model;

public class Curso {
    private int codigo;
    private String nome;

    public Curso(int codigo, String nome) throws ModelException {
        this.setCodigo(codigo);
        this.setNome(nome);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws ModelException {
        if (codigo <= 0) {
            throw new ModelException("O código do curso deve ser maior que zero!");
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ModelException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ModelException("O nome do curso não pode ser vazio!");
        }
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome; // importante para exibir no JComboBox
    }
}
