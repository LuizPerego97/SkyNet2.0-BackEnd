package SkyNet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import SkyNet.entityDTO.FilmeDTO;
import SkyNet.service.FilmeService;

@Controller
@RequestMapping(value="/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeService filmeService; 
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody FilmeDTO dto){
		try {
			String mensagem = getFilmeService().create(dto);
			return ResponseEntity.status(HttpStatus.OK).body(mensagem);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody FilmeDTO dto){
		try {
			String mensagem = getFilmeService().update(dto);
			return ResponseEntity.status(HttpStatus.OK).body(mensagem);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		try {
			
			String mensagem = getFilmeService().delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(mensagem);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		try {
			
			List<FilmeDTO> response = getFilmeService().getAll();
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}
	}

	public FilmeService getFilmeService() {
		return filmeService;
	}
}
