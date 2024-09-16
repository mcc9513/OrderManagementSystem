package org.example.ordermangementsystem;
import org.example.ordermangementsystem.model.Product;
import org.example.ordermangementsystem.repo.ProductRepo;
import org.example.ordermangementsystem.service.ProductService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import java.util.Optional;

public class ProductServiceTest {

    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private ProductService productService;

    public ProductServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setProductId(1L);
        when(productRepo.save(any(Product.class))).thenReturn(product);

        Product savedProduct = productService.createProduct(product);
        assertNotNull(savedProduct);
        assertEquals(1, savedProduct.getProductId());
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setProductId(1L);
        when(productRepo.findById(1L)).thenReturn(Optional.of(product));

        Product foundProduct = productService.getProductById(1L);
        assertNotNull(foundProduct);
        assertEquals(1, foundProduct.getProductId());
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        product.setProductId(1L);
        product.setProductName("Original Name");

        Product updatedProductDetails = new Product();
        updatedProductDetails.setProductName("Updated Name");

        when(productRepo.findById(1L)).thenReturn(Optional.of(product));
        when(productRepo.save(any(Product.class))).thenReturn(updatedProductDetails);

        Product updatedProduct = productService.updateProduct(1L, updatedProductDetails);
        assertEquals("Updated Name", updatedProduct.getProductName());
    }

    @Test
    public void testDeleteProduct() {
        doNothing().when(productRepo).deleteById(1L);
        productService.deleteProduct(1L);
        verify(productRepo, times(1)).deleteById(1L);
    }
}
