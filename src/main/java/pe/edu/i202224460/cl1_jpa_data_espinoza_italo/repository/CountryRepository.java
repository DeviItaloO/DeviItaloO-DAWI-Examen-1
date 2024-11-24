package pe.edu.i202224460.cl1_jpa_data_espinoza_italo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.i202224460.cl1_jpa_data_espinoza_italo.entity.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {

}


