package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.AuthService;

public class DummyJsonTest extends BaseTest {

    String token;
    int userId;

    @Test
    public void testFlow() {

        // Step 1: Login
        Response loginRes = AuthService.login("emilys", "emilyspass");
        token = loginRes.jsonPath().getString("token");
        userId = loginRes.jsonPath().getInt("id");

        // Step 2: Get Cart
        Response cartRes = CartService.getUserCart(token, userId);
        Assert.assertEquals(cartRes.getStatusCode(), 200);

        // Step 3: Add Product
        Response addRes = CartService.addProduct(userId);

        // Assertions
        Assert.assertTrue(addRes.getStatusCode() == 200 || addRes.getStatusCode() == 201);

        int quantity = addRes.jsonPath().getInt("products[0].quantity");
        int price = addRes.jsonPath().getInt("products[0].price");
        int total = addRes.jsonPath().getInt("products[0].total");

        Assert.assertEquals(quantity, 2);
        Assert.assertEquals(total, price * quantity);
    }
}