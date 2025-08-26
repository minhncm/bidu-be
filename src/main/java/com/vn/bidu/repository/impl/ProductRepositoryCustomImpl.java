package com.vn.bidu.repository.impl;

import com.vn.bidu.dto.request.ProductFilterRequest;
import com.vn.bidu.entity.Product;
import com.vn.bidu.entity.Shop;
import com.vn.bidu.entity.Ward;
import com.vn.bidu.repository.ProductRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {
    private final EntityManager entityManager;
    @Override
    public List<Product> filterMultiCriteria(ProductFilterRequest request) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);

        Root<Product> product = criteriaQuery.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();
        if(StringUtils.hasText(request.getKeyword())) {
            predicates.add(criteriaBuilder.like(product.get("name"), "%" + request.getKeyword() + "%"));
        }

        if(!request.getCity().isEmpty()) {
            Join<Product, Shop> shopJoin = product.join("shop");
            Join<Shop, Ward> wardJoin = shopJoin.join("ward");

            CriteriaBuilder.In<String> inClause = criteriaBuilder.in(wardJoin.get("province_code"));
            request.getCity().forEach(inClause::value);
            predicates.add(inClause);
        }

        if(!request.getSize().isEmpty()) {
            CriteriaBuilder.In<String> inClause = criteriaBuilder.in(product.get("size"));
            request.getSize().forEach(inClause::value);
            predicates.add(inClause);
        }

        if(!request.getGender().isEmpty()){
            CriteriaBuilder.In<String> inClause = criteriaBuilder.in(product.get("gender"));
            request.getSize().forEach(inClause::value);
            predicates.add(inClause);
        }

        return null;
    }
}
