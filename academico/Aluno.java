package academico;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Aluno {
    private String matricula;
    private String nome;
    private final List<Matricula> matriculas = new ArrayList<>();

    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    /** Matricula o aluno em uma turma (um aluno pode cursar várias disciplinas). */
    public Matricula matricular(Turma turma) {
        Matricula nova = new Matricula(this, turma);
        matriculas.add(nova);
        turma.adicionarMatricula(nova);
        return nova;
    }

    /** Calcula a média do aluno na disciplina: M = (n1 + n2 + n3) / 3. */
    public double calcularMedia(Disciplina disciplina) {
        return buscarMatricula(disciplina).calcularMedia();
    }

    /** Obtém o total de faltas do aluno na disciplina. */
    public int obterFaltas(Disciplina disciplina) {
        return buscarMatricula(disciplina).obterFaltas();
    }

    public void exibirMedia(Disciplina disciplina) {
        System.out.println(String.format(Locale.forLanguageTag("pt-BR"),
                "Aluno: %s | Disciplina: %s | Média: %.2f",
                nome, disciplina.getNome(), calcularMedia(disciplina)));
    }

    public void exibirFaltas(Disciplina disciplina) {
        System.out.println(String.format(
                "Aluno: %s | Disciplina: %s | Faltas: %d",
                nome, disciplina.getNome(), obterFaltas(disciplina)));
    }

    private Matricula buscarMatricula(Disciplina disciplina) {
        for (Matricula m : matriculas) {
            if (m.getTurma().getDisciplina().equals(disciplina)) {
                return m;
            }
        }
        throw new IllegalArgumentException(
                "Aluno " + nome + " não está matriculado em " + disciplina.getNome());
    }

    public String getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public List<Matricula> getMatriculas() { return new ArrayList<>(matriculas); }

    @Override
    public String toString() { return nome; }
}
