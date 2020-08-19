package caceres.leonel.genericsandlambdas.repository;

import caceres.leonel.genericsandlambdas.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
