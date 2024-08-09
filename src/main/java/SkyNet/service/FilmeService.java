package SkyNet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SkyNet.entity.Filme;
import SkyNet.entityDTO.FilmeDTO;
import SkyNet.repository.FilmeRepository;
import SkyNet.utils.FilmeMapper;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private FilmeMapper filmeMapper;

	public String create(FilmeDTO dto) {
		if (dto == null) {
			throw new IllegalArgumentException("Passe um filme valido");
		} else {
			Filme entity = getFilmeMapper().convertToEntity(dto);

			getFilmeRepository().save(entity);

			String mensagem = "Filme : " + entity.getTitulo() + " Adicionado com sucesso";
			return mensagem;
		}

	}

	public String update(FilmeDTO dto) {
		if (dto == null) {
			throw new IllegalArgumentException("Passe um filme valido");
		} else if (dto.getId() == null) {
			throw new IllegalArgumentException("Passe um id de algum filme");
		} else {
			Filme entity = getFilmeRepository().findById(dto.getId())
					.orElseThrow(() -> new IllegalArgumentException("Nenhum filme correspondente"));

			entity.setTitulo(dto.getTitulo() != null ? dto.getTitulo() : entity.getTitulo());
			entity.setGenero(dto.getGenero() != null ? dto.getGenero() : entity.getGenero());
			entity.setAnoLancamento(
					dto.getAnoLancamento() != null ? dto.getAnoLancamento() : entity.getAnoLancamento());
			entity.setDescricao(dto.getDescricao() != null ? dto.getDescricao() : entity.getDescricao());
			entity.setTipo(dto.getTipo() != null ? dto.getTipo() : entity.getTipo());

			getFilmeRepository().save(entity);

			String mensagem = "Filme : " + entity.getTitulo() + " Alterado com sucesso";
			return mensagem;
		}
	}
	
	public String delete(Long id) {
		if(id == null) {
			throw new IllegalArgumentException("passe um id");
		}else {
			Filme entity = getFilmeRepository().findById(id).orElseThrow(() -> new IllegalArgumentException("Nenhum filme correspondente"));
			getFilmeRepository().deleteById(id);
			String mensagem  ="O filme : " + entity.getTitulo() + " foi deletado com sucesso" ;
			return mensagem;
		}
	}
	
	public List<FilmeDTO> getAll() {
		List<Filme> entityList= getFilmeRepository().findAll();
		if(!entityList.isEmpty()) {
			
			List<FilmeDTO> dtoList = entityList.stream().map(entity -> FilmeDTO.convertToDTO(entity)).toList();
			return dtoList;
		}
		throw new IllegalArgumentException("Lista Vazia");
	}

	public FilmeRepository getFilmeRepository() {
		return filmeRepository;
	}

	public FilmeMapper getFilmeMapper() {
		return filmeMapper;
	}

}
