package pe.edu.i202224460.cl1_jpa_data_espinoza_italo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "countrylanguage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id;

    @Column(name = "IsOfficial")
    private String isOfficial;

    @Column(name = "Percentage")
    private Double percentage;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", insertable = false, updatable = false)
    @MapsId("countryCode")
    @ToString.Exclude
    private Country country;

}