package com.codegym.test.formatter;

import com.codegym.test.model.ProductType;
import com.codegym.test.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProductTypeFormatter implements Formatter<ProductType> {
    private final IProductTypeService productTypeService;

    @Autowired
    public ProductTypeFormatter(IProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        Optional<ProductType> productTypeOptionalOptional = productTypeService.findById(Long.parseLong(text));
        return productTypeOptionalOptional.orElse(null);
    }

    @Override
    public String print(ProductType object, Locale locale) {
        return "[" + object.getId() + ", " + object.getName() + "]";
    }
}
