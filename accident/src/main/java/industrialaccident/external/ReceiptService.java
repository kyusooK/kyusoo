
package industrialaccident.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;


@FeignClient(name = "assessment", url = "${api.url.assessment}")
 
public interface ReceiptService {
    @GetMapping(path="/receipts")
    public List<Receipt> getReceipt();

    @GetMapping(path="/receipts/{id}")
    public Receipt getReceipt(@PathVariable("id")  id);
}


