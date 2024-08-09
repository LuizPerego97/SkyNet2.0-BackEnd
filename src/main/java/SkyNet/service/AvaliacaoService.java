package SkyNet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SkyNet.entity.Avaliacao;
import SkyNet.entity.Filme;
import SkyNet.entityDTO.AvaliacaoDTO;
import SkyNet.repository.AvaliacaoRepository;
import SkyNet.repository.FilmeRepository;
import SkyNet.utils.AvaliacaoMapper;

@Service
public class AvaliacaoService {
	
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private AvaliacaoMapper avaliacaoMapper;
	
	public String create(AvaliacaoDTO dto) {
		if (dto == null) {
			throw new IllegalArgumentException("Passe uma avaliacao valido");
		} else if(dto.getIdFilme() == null){
			throw new IllegalArgumentException("Passe um id referente ao filme");
		}else {
			
			Filme entityFilme = getFilmeRepository().findById(dto.getIdFilme())
					.orElseThrow(() -> new IllegalArgumentException("Nenhum filme correspondente"));
			
			Avaliacao entity = getAvaliacaoMapper().convertToEntity(dto);
			
			entity.setFilme(entityFilme);

			getAvaliacaoRepository().save(entity);

			String mensagem = "Comentario adicionado com sucessso";
			return mensagem;
		}

	}
	
	public String update(AvaliacaoDTO dto) {
		if (dto == null) {
			throw new IllegalArgumentException("Passe uma Avaliacao valida");
		} else if (dto.getId() == null) {
			throw new IllegalArgumentException("E necessario o id da avaliação");
		} else {
			Avaliacao entity = getAvaliacaoRepository().findById(dto.getId())
					.orElseThrow(() -> new IllegalArgumentException("Nenhum avalção correspondente"));
			
			if(dto.getIdFilme() != null) {
				Filme entityFilme = getFilmeRepository().findById(dto.getIdFilme())
						.orElseThrow(() -> new IllegalArgumentException("Nenhum filme correspondente"));
				
				entity.setFilme(entityFilme);

			}
			
			entity.setNomeUsuario(dto.getNomeUsuario() != null ? dto.getNomeUsuario() : entity.getNomeUsuario());
			entity.setNota(dto.getNota() != null ? dto.getNota() : entity.getNota());
			entity.setComentario(dto.getComentario() != null ? dto.getComentario() : entity.getComentario());
			entity.setDataAvaliacao(dto.getDataAvaliacao() != null ? dto.getDataAvaliacao() : entity.getDataAvaliacao());
	

			getAvaliacaoRepository().save(entity);

			String mensagem = "Avaliacao fo usuario : " + entity.getNomeUsuario() + ". Alterado com sucesso";
			return mensagem;
		}
	}
	
	public String delete(Long id) {
		if(id == null) {
			throw new IllegalArgumentException("Passe um id");
		}else {
			Avaliacao entity = getAvaliacaoRepository().findById(id).orElseThrow(() -> new IllegalArgumentException("Nenhuma avaliação correspondente"));
			getAvaliacaoRepository().deleteById(id);
			String mensagem  ="A avaliacao do : " + entity.getNomeUsuario() + " foi deletado com sucesso" ;
			return mensagem;
		}
	}
	
	public List<AvaliacaoDTO> getAll() {
		List<Avaliacao> entityList= getAvaliacaoRepository().findAll();
		if(!entityList.isEmpty()) {
			
			List<AvaliacaoDTO> dtoList = entityList.stream().map(entity -> AvaliacaoDTO.convertToDTO(entity)).toList();
			return dtoList;
		}
		throw new IllegalArgumentException("Lista Vazia");
	}


	public AvaliacaoRepository getAvaliacaoRepository() {
		return avaliacaoRepository;
	}
	
	public AvaliacaoMapper getAvaliacaoMapper() {
		return avaliacaoMapper;
	}

	public FilmeRepository getFilmeRepository() {
		return filmeRepository;
	}

}
