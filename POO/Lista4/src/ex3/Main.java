package ex3;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
        
		Turma turma1 = new Turma("T001", "Matemática", "Prof. Carlos");
        Turma turma2 = new Turma("T002", "História", "Prof. Ana");

        Aluno aluno1 = new Aluno("João", 20, "A001");
        Aluno aluno2 = new Aluno("Maria", 19, "A002");
        Aluno aluno3 = new Aluno("Lucas", 21, "A003");

        aluno1.adicionarTurma(turma1);
        aluno2.adicionarTurma(turma1);
        aluno2.adicionarTurma(turma2);
        aluno3.adicionarTurma(turma2);
        
        List<Turma> turmas = new ArrayList<>();
        turmas.add(turma1);
        turmas.add(turma2);
        
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);

        System.out.println("Alunos por turma:");
        for (Turma turma : turmas) {
            System.out.println(turma.imprimirDados() + ":");
            for (Aluno aluno : turma.getAlunos()) {
                System.out.println(aluno.imprimirDados());
            }
        }
        
        System.out.println();

        System.out.println("Turmas por aluno:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno.imprimirDados() + ":");
            for (Turma turma : aluno.getTurmas()) {
                System.out.println(turma.imprimirDados());
            }
        }

	}
}
