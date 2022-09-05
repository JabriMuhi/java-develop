package com.itmo.lab3.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "beast_master")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class BeastMaster implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "date_of_born")
    private LocalDateTime dateOfBorn;
    @OneToMany(mappedBy = "beastMaster", cascade = CascadeType.ALL)
    private List<Cat> beastMasterCats;

    @Override
    public String toString() {
        return "BeastMaster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBorn=" + dateOfBorn +
                ", beastMasterCats=" + beastMasterCats.toString() +
                '}';
    }
}
