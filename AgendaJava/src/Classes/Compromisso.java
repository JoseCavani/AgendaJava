package Classes;
import java.util.Date;
import java.util.List;

public  class Compromisso {
	private String titulo, descricao;
	Date datahorafim;
	Date datahorainicio;
	private List<Notificacao> notificacao;
    @Override
	public String toString() {
		return "[titulo" + titulo + ", descricao=" + descricao + ", datahorainicio=" + datahorainicio
				+ ", datahorafim=" + datahorafim + "]";
	}
	public Compromisso(String titulo, String descricao, Date datahorainicio, Date datahorafim,
			List<Notificacao> notificacao) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.datahorainicio =  datahorainicio;
		this.datahorafim =  datahorafim;
		this.notificacao = notificacao;
	}
	public Compromisso() {
		
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDatahorainicio() {
		return datahorainicio;
	}
	public void setDatahorainicio(Date datahorainicio) {
		this.datahorainicio = datahorainicio;
	}
	public Date getDatahorafim() {
		return datahorafim;
	}
	public void setDatahorafim(Date datahorafim) {
		this.datahorafim = datahorafim;
	}
	public List<Notificacao> getNotificacao() {
		return notificacao;
	}
	public void setNotificacao(List<Notificacao> notificacao) {
		this.notificacao = notificacao;
	}
}
