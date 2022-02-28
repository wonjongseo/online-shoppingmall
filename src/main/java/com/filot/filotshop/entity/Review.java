package com.filot.filotshop.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.filot.filotshop.dto.ReviewForm;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static com.fasterxml.jackson.annotation.ObjectIdGenerators.*;

@Entity
@Getter
@Setter
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private Long id;

    @Column(columnDefinition = "int(2) default 1")
    private int rate;

    @Column(nullable = false)
    private String title;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "REVIEW_USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REVIEW_PRODUCT_ID")
    private Product product;

    public void setUser(User user) {
        this.user = user;
        if (!user.getReviews().contains(this)) {
            user.getReviews().add(this);
        }
    }

    public void setProduct(Product product) {
        this.product = product;
        if (!product.getReviews().contains(this)) {
            product.getReviews().add(this);
        }
    }
}
