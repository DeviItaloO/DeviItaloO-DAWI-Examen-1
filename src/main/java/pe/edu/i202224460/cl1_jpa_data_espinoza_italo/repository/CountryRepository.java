package pe.edu.i202224460.cl1_jpa_data_espinoza_italo.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202224460.cl1_jpa_data_espinoza_italo.entity.Country;

public interface CountryRepository extends CrudRepository<Country, String> {
}


