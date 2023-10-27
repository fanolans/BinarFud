package org.binarfud.service;

import org.binarfud.dto.ProductEntityDTO;
import org.binarfud.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAvailable(Pageable pageable);
    Map findById(UUID id);
    Map save(ProductEntityDTO product);
    Map update(UUID id, ProductEntityDTO product);
    Map delete(UUID id);

}
