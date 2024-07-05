package industrialaccident.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "assessment", url = "${api.url.assessment}")
public interface AverageSalaryAppliedService {
    @GetMapping(path = "/averageSalaryApplieds")
    public List<AverageSalaryApplied> getAverageSalaryApplied();

    @GetMapping(path = "/averageSalaryApplieds/{id}")
    public AverageSalaryApplied getAverageSalaryApplied(
        @PathVariable("id") Long id
    );
}
