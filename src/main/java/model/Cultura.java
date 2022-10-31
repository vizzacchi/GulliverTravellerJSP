package model;

public class Cultura extends Ponto{

	private String melhorDia;

	public String getMelhorDia() {
		return melhorDia;
	}

	public void setMelhorDia(String melhorDia) {
		this.melhorDia = melhorDia;
	}

	public Cultura(String melhorDia) {
		super();
		this.melhorDia = melhorDia;
	}

	public Cultura() {
		super();
	}

	@Override
	public String toString() {
		return "Cultura [melhorDia=" + melhorDia + "]";
	}
	
}
