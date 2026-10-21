package academico;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private String semestre;
    private Disciplina disciplina;
    private Professor professor;
    private final List<Matricula> matriculas = new ArrayList<>();

    Turma(String codigo, String semestre, Disciplina disciplina, Professor professor) {
        this.codigo = codigo;
        this.semestre = semestre;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    void adicionarMatricula(Matricula matricula) {
        matriculas.add(matricula);
    }

    public String getCodigo() { return codigo; }
    public String getSemestre() { return semestre; }
    public Disciplina getDisciplina() { return disciplina; }
    public Professor getProfessor() { return professor; }
    public List<Matricula> getMatriculas() { return new ArrayList<>(matriculas); }

    @Override
    public String toString() { return disciplina.getNome() + " - turma " + codigo + " (" + semestre + ")"; }
}
