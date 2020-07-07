package br.com.interview.guilherme.Repository;

import br.com.interview.guilherme.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByName (String name);
}
