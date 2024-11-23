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

    @Id
    @Column(name = "Language")
    private String language;

    @Column(name = "IsOfficial")
    private String isOfficial;

    @Column(name = "Percentage")
    private Double percentage;

    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    @ToString.Exclude
    private Country country;

}