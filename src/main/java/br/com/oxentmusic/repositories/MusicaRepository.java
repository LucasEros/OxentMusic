package br.com.oxentmusic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.oxentmusic.domain.Musica;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long>{

}
