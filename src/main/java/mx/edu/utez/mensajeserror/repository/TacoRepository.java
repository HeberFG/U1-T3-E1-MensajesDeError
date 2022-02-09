package mx.edu.utez.mensajeserror.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.mensajeserror.entity.Taco;

@Repository
public interface TacoRepository extends JpaRepository<Taco, Long> {

}
