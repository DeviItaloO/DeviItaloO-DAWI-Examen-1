package pe.edu.i202224460.cl1_jpa_data_espinoza_italo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.i202224460.cl1_jpa_data_espinoza_italo.entity.CountryLanguage;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryLanguageRepository extends CrudRepository<CountryLanguage, String> {
    Optional<List<CountryLanguage>> findByCountryCode(String countryCode);
}
