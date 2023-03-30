package Harvest.Controllers;

import Harvest.Models.FarmerProduct;
import Harvest.Models.OrderItem;
import Harvest.Models.Product;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;


import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController

public class StripeSessionController {

    public StripeSessionController(@Value("${API_TEST_KEY}") String secretStripeKey) {
        Stripe.apiKey = secretStripeKey;
    }



    @PostMapping("/api/create/session")
    public ResponseEntity<?> createSession(@RequestBody List<OrderItem> orderItems) {
        ArrayList<Object> lineItems = new ArrayList<>();

        for (OrderItem item : orderItems) {
            FarmerProduct product = getFarmerProductById(item.getProductId());
            HashMap<String, Object> lineItem = new HashMap<>();
            lineItem.put("price", product.getPrice().toString());
            lineItem.put("quantity", item.getQuantity());
            lineItems.add(lineItem);
        }





}

