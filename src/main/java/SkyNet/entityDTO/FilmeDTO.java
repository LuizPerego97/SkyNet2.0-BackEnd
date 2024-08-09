package SkyNet.entityDTO;

import org.modelmapper.ModelMapper;

import SkyNet.entity.Filme;

public class FilmeDTO {

	private Long id;
	
	private String titulo;
	
	private String genero;
	
	private Long anoLancamento;
	
	private String descricao;
	
	private String tipo;

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
	
	static ModelMapper getModelMapper() {
		return new ModelMapper();
	}

	public static FilmeDTO convertToDTO(Filme entity) {
		return getModelMapper().map(entity, FilmeDTO.class);
	}
	
	
}
