package dev.capstone.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodMenu is a Querydsl query type for FoodMenu
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodMenu extends EntityPathBase<FoodMenu> {

    private static final long serialVersionUID = -1689265019L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFoodMenu foodMenu = new QFoodMenu("foodMenu");

    public final StringPath description = createString("description");

    public final NumberPath<Float> discount_price = createNumber("discount_price", Float.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath image = createString("image");

    public final EnumPath<dev.capstone.domain.enumerated.YesOrNo> in_stock = createEnum("in_stock", dev.capstone.domain.enumerated.YesOrNo.class);

    public final QMarket market;

    public final StringPath name = createString("name");

    public final StringPath options = createString("options");

    public final NumberPath<Float> price = createNumber("price", Float.class);

    public final EnumPath<dev.capstone.domain.enumerated.Level> type = createEnum("type", dev.capstone.domain.enumerated.Level.class);

    public QFoodMenu(String variable) {
        this(FoodMenu.class, forVariable(variable), INITS);
    }

    public QFoodMenu(Path<? extends FoodMenu> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFoodMenu(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFoodMenu(PathMetadata metadata, PathInits inits) {
        this(FoodMenu.class, metadata, inits);
    }

    public QFoodMenu(Class<? extends FoodMenu> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.market = inits.isInitialized("market") ? new QMarket(forProperty("market"), inits.get("market")) : null;
    }

}

