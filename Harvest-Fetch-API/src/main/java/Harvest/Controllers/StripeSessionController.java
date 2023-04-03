package Harvest.Controllers;

import Harvest.Models.FarmerProduct;
import Harvest.Models.OrderItem;
import Harvest.Models.Product;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;


import com.stripe.model.checkout.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
@ConditionalOnWebApplication
public class StripeSessionController {

    public StripeSessionController(@Value("${API_TEST_KEY}") String secretStripeKey) {
        Stripe.apiKey = secretStripeKey;
    }



    @PostMapping("/api/create/session")
    public ResponseEntity<String> createSession(@RequestBody List<OrderItem> orderItems) {
        ArrayList<Object> lineItems = new ArrayList<>();

        for (OrderItem oi : orderItems) {
            HashMap<String, Object> lineItem = new HashMap<>();
            lineItem.put("price", oi.getPriceCode());
            lineItem.put("quantity", oi.getQuantity());
            lineItems.add(lineItem);
        }
        HashMap<String, Object> sessionParams = new HashMap<>();
        sessionParams.put("success_url", "http://localhost:8080/success");
        sessionParams.put("cancel_url", "http://localhost:8080/cart");
        sessionParams.put("mode", "payment");
        sessionParams.put("line_items", lineItems);

        try {
            Session session = Session.create(sessionParams);
            return new ResponseEntity<>(session.getUrl(), HttpStatus.OK);
        } catch (StripeException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

