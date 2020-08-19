package caceres.leonel.genericsandlambdas.repository;

import caceres.leonel.genericsandlambdas.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
}