package SkyNet.utils;

import org.springframework.stereotype.Component;

import SkyNet.entity.Avaliacao;
import SkyNet.entityDTO.AvaliacaoDTO;

@Component
public class AvaliacaoMapper {

	
	public Avaliacao convertToEntity(AvaliacaoDTO dto) {
		Avaliacao entity = new Avaliacao();
		entity.setNomeUsuario(dto.getNomeUsuario());
		entity.setNota(dto.getNota());
		entity.setComentario(dto.getComentario());
		entity.setDataAvaliacao(dto.getDataAvaliacao());
		
		
		return entity;
	}

}
