package pe.edu.i202224460.cl1_jpa_data_espinoza_italo;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202224460.cl1_jpa_data_espinoza_italo.entity.Country;
import pe.edu.i202224460.cl1_jpa_data_espinoza_italo.repository.CountryRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataEspinozaItaloApplication implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataEspinozaItaloApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		/**
		 * 1. Consulta -> ifPresentOrElse
		 * */
		Optional<Country> countryArgentina = countryRepository.findById("ARG");
		countryArgentina.ifPresentOrElse(
				argentina -> argentina.getCountryLanguages()
						.forEach(language -> System.out.println("MESSI XD -> "+language.getLanguage())),
				() -> {
					Optional<Country> countryPeru = countryRepository.findById("PER");
					countryPeru.ifPresent(peru -> peru.getCountryLanguages()
							.forEach(language -> System.out.println("PAOLO XD -> "+language.getLanguage())));
				}
		);

		/**
		 * 2. Eliminar -> deleteAllById
		 * */
		List<String> ids = List.of("COL", "ARG");

		countryRepository.deleteAllById(ids);
		System.out.println("Eliminado COL y ARG.");



		/**
		 * 3. la primera consulta pero ya no hay messi xd solo Paolo :D
		 * */
		countryArgentina = countryRepository.findById("ARG");
		countryArgentina.ifPresentOrElse(
				argentina -> argentina.getCountryLanguages()
						.forEach(language -> System.out.println("MESSI XD -> "+language.getLanguage())),
				() -> {
					Optional<Country> countryPeru = countryRepository.findById("PER");
					countryPeru.ifPresent(peru -> peru.getCountryLanguages()
							.forEach(language -> System.out.println("PAOLO XD -> "+language.getLanguage())));
				}
		);
	}
}