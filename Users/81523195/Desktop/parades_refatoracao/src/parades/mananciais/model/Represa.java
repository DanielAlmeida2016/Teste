package parades.mananciais.model;

import java.util.ArrayList;

public class Represa {
	public String nome;
	public ArrayList<Medicao> medicoes;
	public Represa() {
		this.nome = "";
		this.medicoes = new ArrayList<>();
	}
	public Represa(String nome, ArrayList<Medicao> medicoes) {
		this.nome = nome;
		this.medicoes = medicoes;
	}

	@Override
	public String toString() {
		return "Represa [nome=" + nome + ", medicoes=" + medicoes + "]";
	}

	
}
