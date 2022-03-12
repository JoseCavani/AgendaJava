package Classes;

public class Notificacao {
	private byte tempo;
    private char unidade;
    private char tipo;
	public byte getTempo() {
		return tempo;
	}
	public void setTempo(byte tempo) {
		this.tempo = tempo;
	}
	public char getUnidade() {
		return unidade;
	}
	public void setUnidade(char unidade) {
		this.unidade = unidade;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public Notificacao(byte tempo, char unidade, char tipo) {
		super();
		this.tempo = tempo;
		this.unidade = unidade;
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Notificacao [tempo=" + tempo + ", unidade=" + unidade + ", tipo=" + tipo + "]";
	}
    
}
