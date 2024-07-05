package industrialaccident.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "compensation", url = "${api.url.compensation}")
public interface CompensationCreatedService {
    @GetMapping(path = "/compensationCreateds")
    public List<CompensationCreated> getCompensationCreated();

    @GetMapping(path = "/compensationCreateds/{id}")
    public CompensationCreated getCompensationCreated(
        @PathVariable("id") Long id
    );
}
