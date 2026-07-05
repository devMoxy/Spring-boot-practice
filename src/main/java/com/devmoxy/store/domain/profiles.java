package com.devmoxy.store.domain;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "profiles")
public class profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "id")
    private long id;

    @Column(nullable = false, name = "bio")
    private String bio;

    @Column(nullable = false, name = "phone_number")
    private String phone_number;

    @Column(name = "date_of_birth")
    private long date_of_birth;

    @Column(name = "loyalty_points")
    private String loyalty_points;

    @Column(name = "user_id")
    private long user_id;
}
