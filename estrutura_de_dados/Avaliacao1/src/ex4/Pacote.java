package ex4;

public class Pacote {
	private int id;

	public Pacote(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
    public String toString() {
        return "ID: " + id;
    }
}
