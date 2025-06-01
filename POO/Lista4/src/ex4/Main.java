package ex4;

public class Main {
    public static void main(String[] args) {
    	
        Curso curso = new Curso("Análise e Desenolvimento de Sistemas", "ADS001", 36);

        Disciplina d1 = new Disciplina("Programação Orientada a Objetos", "POO001", 40);
        Disciplina d2 = new Disciplina("Banco de Dados", "BD002", 40);

        Professor p1 = new Professor("Remor", "P001", "Programação");
        Professor p2 = new Professor("Fernanda", "P002", "Banco de Dados");

        d1.setProfessor(p1);
        d2.setProfessor(p2);

        curso.adicionarDisciplina(d1);
        curso.adicionarDisciplina(d2);

        System.out.println("Disciplinas do curso:");
        for (Disciplina d : curso.getDisciplinas()) {
            System.out.println(d.imprimirDados());
            System.out.println("Professor: " + d.getProfessor().imprimirDados());
        }

        System.out.println();

        System.out.println("Resumo do curso:");
        System.out.println(curso.imprimirDados());
        for (Disciplina d : curso.getDisciplinas()) {
            System.out.println("- " + d.getNome() + " | Professor: " + d.getProfessor().getNome());
        }
    }
}

