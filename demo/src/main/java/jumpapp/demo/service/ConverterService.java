package jumpapp.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jumpapp.demo.model.CurrencyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConverterService {

    private final String APIURL = "https://open.er-api.com/v6/latest/USD";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();


    private final CacheManager cacheManager;

    ConverterService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public CurrencyResponse getCurrency(){
        CurrencyResponse currencyResponse = cacheManager.getCache("USD").get("USD", CurrencyResponse.class);

        if(currencyResponse == null){
           try{
               currencyResponse = getCurrencyFromURL();
               cacheManager.getCache("USD").put("USD", currencyResponse);
           }catch (Exception e){
               e.printStackTrace();
               return null;
           }
        }
        return currencyResponse;
    }

    public CurrencyResponse getCurrencyFromURL() throws  Exception{
        String json = restTemplate.getForObject(APIURL, String.class);
        return objectMapper.readValue(json, CurrencyResponse.class);
    }


    @Scheduled(fixedRate = 60000)
    public void  refreshCurrency() throws JsonProcessingException {
       try {
           CurrencyResponse response = getCurrencyFromURL();
           cacheManager.getCache("USD").put("USD", response);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

}
