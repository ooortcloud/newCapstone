package dev.capstone.domain;

import dev.capstone.domain.enumerated.Level;
import dev.capstone.domain.enumerated.YesOrNo;
import dev.capstone.domain.jointable.MenuReview;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FoodMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menu_id;

    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;

    @OneToMany(mappedBy = "foodMenu")
    private List<MenuReview> menuReviews = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Level menu_type;
    private String menu_image;  // 외부 DB에 저장한 경로를 저장 -> DTO에 넣을 것은 아닌듯.

    @Column(nullable = false)
    private String menu_name;

    @Column(nullable = false)
    private String menu_description;

    @Column(nullable = false)
    private Float price;
    private Float discount_price;  // 할인가는 update에서만 변경할 수 있게 할 것.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private YesOrNo in_stock;

    @Type(JsonType.class)
    @Column(columnDefinition = "longtext")
    private Map<String, Object> options;

    @PrePersist
    public void prePersist(){
        this.in_stock = this.in_stock == null ? YesOrNo.valueOf("Yes") : this.in_stock;
    }


}