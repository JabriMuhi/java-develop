package com.tutor.bvs.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Data
public class Cat {

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