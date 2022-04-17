package com.example.jsonprocessing.Service;

import com.example.jsonprocessing.Model.Dto.ProductShopDtos.ProductNameAndPriceDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
  void  seedProducts() throws IOException;

    List<ProductNameAndPriceDto> findAllProductsIndRange(BigDecimal valueOf, BigDecimal valueOf1);

}
