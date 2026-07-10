package com.devmoxy.store.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "id")
    private long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "password")
    private String password;

    public void addAddress(Addresses address){
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Addresses address){
        addresses.remove(address);
        address.setUser(null);
    }

    public void addTag(String tagName){
        var tag = new tags(tagName);
        tags.add(tag);
        tag.getUser().add(this);
    }

    @OneToMany(mappedBy = "user")
    @Builder.Default
    @ToString.Exclude
    private List<Addresses> addresses = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user_tags",
    joinColumns = @JoinColumn(name  = "user_id"),
    inverseJoinColumns = @JoinColumn(name  = "tag_id")
    )

    @Builder.Default
    private Set<tags> tags = new HashSet<>();

    @OneToOne(mappedBy = "user")
    private profiles profile;

    @ManyToMany
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> favouriteProducts = new HashSet<>();
}