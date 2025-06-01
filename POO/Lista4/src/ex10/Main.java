package ex10;

public class Main {
    public static void main(String[] args) {
        Curso curso = new Curso("Analise e Desenvolvimento de Sistemas", "Tecnologia");

        Professor prof1 = new Professor("Fernanda", "Banco de Dados", 45);
        Professor prof2 = new Professor("Orozco", "Redes", 45);

        DisciplinaPresencial d1 = new DisciplinaPresencial("Modelagem de Dados", 40, prof1, "Sala Lab Redes");
        DisciplinaOnline d2 = new DisciplinaOnline("Infraestrutura de Redes", 40, prof2, "https://meet.com/aula-online");

        curso.adicionarDisciplina(d1);
        curso.adicionarDisciplina(d2);

        System.out.println("Curso:");
        System.out.println(curso.imprimirDados());

        System.out.println("\nDisciplinas:");
        for (Disciplina d : curso.getDisciplinas()) {
            System.out.println("- " + d.imprimirDados());
        }
    }
}
