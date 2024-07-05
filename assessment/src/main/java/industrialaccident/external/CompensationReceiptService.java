
package industrialaccident.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;


@FeignClient(name = "compensation", url = "${api.url.compensation}")
 
public interface CompensationReceiptService {
    @GetMapping(path="/compensationReceipts")
    public List<CompensationReceipt> getCompensationReceipt();

    @GetMapping(path="/compensationReceipts/{id}")
    public CompensationReceipt getCompensationReceipt(@PathVariable("id")  id);
}


