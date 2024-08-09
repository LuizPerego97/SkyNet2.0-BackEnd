package SkyNet.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="FILME")
public class Filme {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="TITULO", unique= true, nullable = false )
	private String titulo;
	
	@Column(name="GENERO", nullable = false )
	private String genero;
	
	@Column(name="ANO_LANCAMENTO", nullable = false )
	private Long anoLancamento;
	
	@Column(name="DESCRICAO", unique= true, nullable = false )
	private String descricao;
	
	@Column(name="TIPO", nullable = false )
	private String tipo;
	
	@OneToMany(mappedBy="filme")
    private Set<Avaliacao> avaliacoes;

	//GEtters e Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Long getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Long anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Set<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(Set<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

	
	

}
