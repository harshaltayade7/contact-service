package client;

import com.contact.entity.Contact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-api", url = "http://localhost:9090/contact", configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface ContactApiClient {
    @GetMapping()
    Contact getContact(@RequestParam String userId);
}
