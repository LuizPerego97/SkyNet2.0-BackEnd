package SkyNet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SkyNet.entity.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
