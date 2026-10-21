package academico;

/**
 * Vínculo entre um Aluno e uma Turma. Guarda as três notas e as faltas
 * do aluno naquela disciplina.
 */
public class Matricula {
    private Aluno aluno;
    private Turma turma;
    private double n1;
    private double n2;
    private double n3;
    private int faltas;

    Matricula(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
    }

    public void lancarNotas(double n1, double n2, double n3) {
        validarNota(n1);
        validarNota(n2);
        validarNota(n3);
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    /** Registra uma falta. */
    public void registrarFalta() {
        faltas++;
    }

    /** Registra várias faltas de uma vez. */
    public void registrarFaltas(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade de faltas não pode ser negativa.");
        }
        faltas += quantidade;
    }

    /** M = (n1 + n2 + n3) / 3 */
    public double calcularMedia() {
        return (n1 + n2 + n3) / 3;
    }

    public int obterFaltas() {
        return faltas;
    }

    private void validarNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10: " + nota);
        }
    }

    public Aluno getAluno() { return aluno; }
    public Turma getTurma() { return turma; }
    public double getN1() { return n1; }
    public double getN2() { return n2; }
    public double getN3() { return n3; }
}
