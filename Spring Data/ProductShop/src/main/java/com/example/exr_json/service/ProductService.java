package com.example.exr_json.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;

public interface ProductService {

    void seedProducts() throws FileNotFoundException;

    void findProductsInRange(BigDecimal valueOf, BigDecimal valueOf1) throws IOException;

}
