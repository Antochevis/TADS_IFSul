package ex3;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
	private String nome;
    private int idade;
    private String matricula;
    private List<Turma> turmas;
    
	public Aluno() {
		super();
		this.nome = "";
		this.idade = 0;
		this.matricula = "";
		turmas = new ArrayList<>();
	}

	public Aluno(String nome, int idade, String matricula) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.matricula = matricula;
		this.turmas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	public String getMatricula() {
		return matricula;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public void adicionarTurma(Turma turma) {
        if (!turmas.contains(turma)) {
            turmas.add(turma);
            turma.adicionarAluno(this);
        }
    }
	
	public String imprimirDados() {
        return nome + " (Matrícula: " + matricula + ", Idade: " + idade + ")";
    }
}
