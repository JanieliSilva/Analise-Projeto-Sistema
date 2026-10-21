package academico;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String codigo;
    private String nome;
    private int cargaHoraria;
    private final List<Turma> turmas = new ArrayList<>();
    private final List<Professor> professores = new ArrayList<>();

    public Disciplina(String codigo, String nome, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    /** Cadastra uma nova turma desta disciplina (uma disciplina tem várias turmas). */
    public Turma criarTurma(String codigoTurma, String semestre, Professor professor) {
        Turma turma = new Turma(codigoTurma, semestre, this, professor);
        turmas.add(turma);
        return turma;
    }

    void adicionarProfessor(Professor professor) {
        if (!professores.contains(professor)) {
            professores.add(professor);
        }
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public int getCargaHoraria() { return cargaHoraria; }
    public List<Turma> getTurmas() { return new ArrayList<>(turmas); }
    public List<Professor> getProfessores() { return new ArrayList<>(professores); }

    @Override
    public String toString() { return codigo + " - " + nome; }
}
