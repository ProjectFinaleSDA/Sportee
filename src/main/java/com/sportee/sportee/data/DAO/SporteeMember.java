package com.sportee.sportee.data.DAO;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@NoArgsConstructor
@Table(name="sportee_member")
public class SporteeMember {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Id
    private int id;

    private String firstName;
    private String lastName;
    private java.sql.Date birthDate;
    private int height;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

    @OneToMany(mappedBy = "sporteeMember")
    private List<Measurement> measurements;

    @OneToMany(mappedBy = "sporteeMember")
    private List<Subscription> subscriptions;

    @ManyToMany
    @JoinTable(name = "participatio_to_class")
    @JoinColumn(name = "member_id")
    @JoinColumn(name = "gym_class_id")
    List<GymClass> gymClass;

    @Builder
    public SporteeMember(String firstName, String lastName, Date birthDate, int height, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.height = height;
       this.role=role;
    }
}
