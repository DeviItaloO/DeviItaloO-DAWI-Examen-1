package pe.edu.i202224460.cl1_jpa_data_espinoza_italo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "country")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @Column(name="Code")
    private String code;

    @Column(name="Name")
    private String name;

    @Column(name="Continent")
    private String continent;

    @Column(name = "Region")
    private String region;

    @Transient
    @Column(name = "SurfaceArea")
    private Double surfaceArea;

    @Transient
    @Column(name = "IndepYear")
    private Integer indepYear;

    @Column(name = "Population")
    private Integer population;

    @Transient
    @Column(name = "LifeExpectancy")
    private Double lifeExpectancy;

    @Column(name = "GNP")
    private Double gnp;

    @Column(name = "GNPOld")
    private Double gnpOld;

    @Transient
    @Column(name = "LocalName")
    private String localName;

    @Transient
    @Column(name = "GovernmentForm")
    private String governmentForm;

    @Transient
    @Column(name = "HeadOfState")
    private String headOfState;

    @Column(name = "Capital")
    private Integer capital;

    @Column(name = "Code2")
    private String code2;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<City> cities;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CountryLanguage> countryLanguages;
}
