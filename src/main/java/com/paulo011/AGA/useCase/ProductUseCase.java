package com.paulo011.AGA.useCase;

import com.paulo011.AGA.domain.constants.Status;
import com.paulo011.AGA.domain.entities.Category;
import com.paulo011.AGA.domain.entities.Product;
import com.paulo011.AGA.domain.repositories.ProductRepository;
import com.paulo011.AGA.useCase.DTO.ProductRequestDTO;
import com.paulo011.AGA.useCase.DTO.ProductResponseDTO;
import com.paulo011.AGA.useCase.DTO.UpdateRequestDTO;

import java.util.List;
import java.util.UUID;

public class ProductUseCase {
    private final ProductRepository productRepository;
    private final CategoryUseCase categoryUseCase;
    private final HistoricUseCase historicUseCase;

    public ProductUseCase(ProductRepository productRepository,
                          CategoryUseCase categoryUseCase,
                          HistoricUseCase historicUseCase){
        this.productRepository = productRepository;
        this.categoryUseCase = categoryUseCase;
        this.historicUseCase = historicUseCase;
    }

    public void createProduct(ProductRequestDTO productRequestDTO){
        Category category = categoryUseCase.createCategory(productRequestDTO.category().type());

        Product product = new Product(
                null,
                productRequestDTO.name(),
                productRequestDTO.description(),
                productRequestDTO.price(),
                productRequestDTO.weight(),
                productRequestDTO.width(),
                productRequestDTO.height(),
                category,
                productRequestDTO.status());

        historicUseCase.createHistoric(
                productRequestDTO.cpfUser(),
                product,
                productRequestDTO.descriptionForHistoric());

        productRepository.save(product);
    }

    public List<ProductResponseDTO> findAllProducts(){
        return productRepository.findAll().stream()
                .map(ProductResponseDTO::new)
                .toList();
    }

    public ProductResponseDTO findProductByCode(UUID code){
        Product product = productRepository.findById(code);
        return new ProductResponseDTO(product);
    }

    public void updateProduct(UUID code, UpdateRequestDTO updateRequestDTO){
        Product product = productRepository.findById(code);
        updateRequestDTO.requestedUserList().forEach((key, value) -> {
            switch (key) {
                case "name": product.setName(value);
                break;
                case "description": product.setDescription(value);
                break;
                case "price": product.setPrice(Double.valueOf(value));
                break;
                case "weight": product.setWeight(Float.valueOf(value));
                break;
                case "width": product.setWidth(Float.valueOf(value));
                break;
                case "height": product.setHeight(Float.valueOf(value));
                break;
                case "category": product.setCategory(categoryUseCase.findCategoryByType(value));
                break;
                case "status": product.setStatus(Status.MODIFIED);
                break;
                default: throw new RuntimeException("List for updates empty");
            }
        });
    }

    public void deleteProduct(UUID code){
        Product product = productRepository.findById(code);
        product.setStatus(Status.REMOVED);
        productRepository.saveAndFlush(product);
    }
}
