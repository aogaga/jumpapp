package jumpapp.demo.controller;

import jumpapp.demo.model.CurrencyResponse;
import jumpapp.demo.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class AppController {

    @Autowired
    private ConverterService converterService;

    @GetMapping("/")
    public ResponseEntity<CurrencyResponse>  convertCurrency(){
        return ResponseEntity.ok(converterService.getCurrency());
    }
}
