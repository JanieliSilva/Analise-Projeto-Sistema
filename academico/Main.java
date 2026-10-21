package academico;

public class Main {
    public static void main(String[] args) {
        Professor prof = new Professor("P001", "Carlos Lima");
        Disciplina poo = new Disciplina("PEX1001", "Programação Orientada a Objetos", 60);
        prof.lecionar(poo);
        Turma turma = poo.criarTurma("01", "2026.2", prof);

        Aluno aluno = new Aluno("20260001", "Maria Souza");
        Matricula m = aluno.matricular(turma);
        m.lancarNotas(7.0, 8.0, 9.0);
        m.registrarFalta();
        m.registrarFaltas(2);

        aluno.exibirMedia(poo);
        aluno.exibirFaltas(poo);
    }
}
