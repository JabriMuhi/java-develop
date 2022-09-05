package com.itmo.lab3.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Data
public class Cat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String name;
    @Column(name = "date_of_born")
    private LocalDateTime dateOfBorn;
    @Column(name = "breed")
    private String breed;
    @Enumerated(EnumType.ORDINAL)
    private Color color;
    @ManyToMany
    @JoinTable(name = "cats_friends",
            joinColumns = @JoinColumn(name = "cats_owner_id"),
            inverseJoinColumns = @JoinColumn(name = "cats_friend_id"))
    List<Cat> catList = new ArrayList<>();

    public Cat(String name, LocalDateTime dateOfBorn, String breed, Color color, BeastMaster beastMaster) {
        this.name = name;
        this.dateOfBorn = dateOfBorn;
        this.breed = breed;
        this.color = color;
        this.catList = catList;
        this.beastMaster = beastMaster;
    }

    @ManyToOne()
    @JoinColumn(name = "beast_master_id")
    private BeastMaster beastMaster;

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBorn=" + dateOfBorn +
                ", breed='" + breed + '\'' +
                ", color=" + color +
                ", catList=" + catList +
                //", beastMaster=" + beastMaster +
                '}';
    }
}