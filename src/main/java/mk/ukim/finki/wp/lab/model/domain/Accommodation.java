package mk.ukim.finki.wp.lab.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mk.ukim.finki.wp.lab.model.enums.AccommodationCategory;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="accommodations")
@NamedEntityGraph(
        name = "Accommodation.withHostAndCountry",
        attributeNodes = {
                @NamedAttributeNode(value = "host", subgraph = "host-subgraph")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "host-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("country")
                        }
                )
        }
)
public class Accommodation extends BaseAuditableEntity{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccommodationCategory accommodationCategory;

    @ManyToOne
    @JoinColumn(name="host_id", nullable = false)
    private Host host;

    @Column(nullable = false)
    private Integer numRooms;

    private Boolean isRented;

    public Accommodation(String name,AccommodationCategory accommodationCategory,Host host, Integer numRooms){
        this.name=name;
        this.accommodationCategory=accommodationCategory;
        this.host=host;
        this.numRooms=numRooms;
        this.isRented=false;
    }
}
