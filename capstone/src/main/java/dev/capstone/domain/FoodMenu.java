package dev.capstone.domain;

import dev.capstone.domain.enumerated.Level;
import dev.capstone.domain.enumerated.YesOrNo;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;

// @Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class FoodMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)  // 양방향(주인)
    @JoinColumn(name = "market_id")
    private Market market;

    @Enumerated(EnumType.STRING)
    @Column(name = "menu_type")
    private Level type;
    @Column(name = "menu_image")
    private String image;  // 외부 DB에 저장한 경로를 저장 -> DTO에 넣을 것은 아닌듯.

    @Column(name = "menu_name", nullable = false)
    private String name;

    @Column(name = "menu_description", nullable = false)
    private String description;

    @Column(nullable = false)
    private Float price;
    private Float discount_price;  // 할인가는 update에서만 변경할 수 있게 할 것.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private YesOrNo in_stock;

    @Type(JsonType.class)
    @Column(columnDefinition = "longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci")
    private String options;

    @PrePersist
    public void prePersist(){
        this.in_stock = this.in_stock == null ? YesOrNo.valueOf("Yes") : this.in_stock;
    }


}
