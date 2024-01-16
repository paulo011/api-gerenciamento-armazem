package com.paulo011.AGA.application.gateways;

import com.paulo011.AGA.domain.entities.Category;
import com.paulo011.AGA.domain.entities.Product;
import com.paulo011.AGA.infrastructure.schemes.CategoryScheme;
import com.paulo011.AGA.infrastructure.schemes.ProductScheme;
import org.springframework.stereotype.Component;

@Component
public class ProductGateway {
    public static Product toProduct(ProductScheme productScheme){
        return new Product(
                productScheme.getCode(),
                productScheme.getName(),
                productScheme.getDescription(),
                productScheme.getPrice(),
                productScheme.getWeight(),
                productScheme.getWidth(),
                productScheme.getHeight(),
                new Category(productScheme.getCategory().getTYPE()),
                productScheme.getStatus()
        );
    }

    public static ProductScheme toProductScheme(Product product){
        return new ProductScheme(
                product.getCode(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getWeight(),
                product.getWidth(),
                product.getHeight(),
                new CategoryScheme(product.getCategory().type()),
                product.getStatus()
        );
    }
}
