package academico;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String matricula;
    private String nome;
    private final List<Disciplina> disciplinas = new ArrayList<>();

    public Professor(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    /** Um professor pode lecionar várias disciplinas. */
    public void lecionar(Disciplina disciplina) {
        if (!disciplinas.contains(disciplina)) {
            disciplinas.add(disciplina);
            disciplina.adicionarProfessor(this);
        }
    }

    public String getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public List<Disciplina> getDisciplinas() { return new ArrayList<>(disciplinas); }

    @Override
    public String toString() { return nome; }
}
