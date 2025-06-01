package ex3;

import java.util.ArrayList;
import java.util.List;

public class Turma {
	
	private String codigo;
    private String nomeDisciplina;
    private String professor;
    private List<Aluno> alunos;
    
	public Turma() {
		super();
		this.codigo = "";
		this.nomeDisciplina = "";
		this.professor = "";
		this.alunos = new ArrayList<>();
	}

	public Turma(String codigo, String nomeDisciplina, String professor) {
		super();
		this.codigo = codigo;
		this.nomeDisciplina = nomeDisciplina;
		this.professor = professor;
		this.alunos = new ArrayList<>();
	}
	

	public String getCodigo() {
		return codigo;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public String getProfessor() {
		return professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
    
	public void adicionarAluno(Aluno aluno) {
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
            aluno.adicionarTurma(this);
        }
    }
	
	public String imprimirDados() {
        return nomeDisciplina + " (Código: " + codigo + ", Professor: " + professor + ")";
    }
}
