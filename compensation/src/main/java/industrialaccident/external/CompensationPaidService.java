package industrialaccident.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "compensation", url = "${api.url.compensation}")
public interface CompensationPaidService {
    @GetMapping(path = "/compensationPaids")
    public List<CompensationPaid> getCompensationPaid();

    @GetMapping(path = "/compensationPaids/{id}")
    public CompensationPaid getCompensationPaid(@PathVariable("id") Long id);

    @GetMapping(path = "/compensationPaids")
    public List<CompensationPaid> getCompensationPaid();

    @GetMapping(path = "/compensationPaids/{id}")
    public CompensationPaid getCompensationPaid(@PathVariable("id") Long id);
}
