package industrialaccident.external;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
@FeignClient(name = "compensation", url = "${api.url.compensation}")
public interface CompensationService {
    @RequestMapping(method= RequestMethod., path="/compensations/{id}")
    public void compensationCreated(@PathVariable("id") Long id, @RequestBody CompensationCreatedCommand compensationCreatedCommand );
    @RequestMapping(method= RequestMethod., path="/compensations/{id}")
    public void compensationPaid(@PathVariable("id") Long id, @RequestBody CompensationPaidCommand compensationPaidCommand );
    @RequestMapping(method= RequestMethod., path="/compensations/{id}")
    public void compensationPaid(@PathVariable("id") Long id, @RequestBody CompensationPaidCommand compensationPaidCommand );
    @RequestMapping(method= RequestMethod.POST, path="/compensations/{id}")
    public void createCompensation(@PathVariable("id") Long id, @RequestBody CreateCompensationCommand createCompensationCommand );
}