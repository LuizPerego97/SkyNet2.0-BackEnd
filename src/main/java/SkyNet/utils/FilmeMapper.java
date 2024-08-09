package SkyNet.utils;

import org.springframework.stereotype.Component;

import SkyNet.entity.Filme;
import SkyNet.entityDTO.FilmeDTO;

@Component
public class FilmeMapper {

	public Filme convertToEntity(FilmeDTO dto) {
		Filme entity = new Filme();
		
		entity.setTitulo(dto.getTitulo());
		entity.setGenero(dto.getGenero());
		entity.setAnoLancamento(dto.getAnoLancamento());
		entity.setDescricao(dto.getDescricao());
		entity.setTipo(dto.getTipo());
	
		return entity;
	}
}
