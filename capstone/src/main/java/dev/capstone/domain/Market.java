package dev.capstone.domain;

import dev.capstone.domain.enumerated.YesOrNo;
import dev.capstone.domain.jointable.OrderList;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

// @Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "market_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private YesOrNo certified;

    @ManyToOne(fetch = FetchType.LAZY)  // 양방향(주인)
    @JoinColumn(name = "id", nullable = false)
    private MainUser mainUser;

    @OneToMany(mappedBy = "market", orphanRemoval = true)  // 양방향(노예)
    private List<Guest> guests = new ArrayList<>();

    @OneToMany(mappedBy = "market", orphanRemoval = true)  // 양방향(노예)
    private List<OrderList> orderLists = new ArrayList<>();

    @OneToMany(mappedBy = "market")  // 양방향(노예)
    private List<FoodMenu> foodMenus = new ArrayList<>();

    @Column(name = "market_name", nullable = false)
    private String marketname;

    @Column(name ="market_location", nullable = false)
    private String location;

    @PrePersist
    public void prePersist(){
        this.certified = this.certified == null ? YesOrNo.valueOf("No") : this.certified;
    }
}


