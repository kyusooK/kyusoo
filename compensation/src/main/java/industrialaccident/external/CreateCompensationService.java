
package industrialaccident.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;


@FeignClient(name = "compensation", url = "${api.url.compensation}")
 
public interface CreateCompensationService {
    @GetMapping(path="/createCompensations")
    public List<CreateCompensation> getCreateCompensation();

    @GetMapping(path="/createCompensations/{id}")
    public CreateCompensation getCreateCompensation(@PathVariable("id")  id);
}


