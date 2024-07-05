package industrialaccident.external;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Date;
import java.util.List;
@FeignClient(name = "assessment", url = "${api.url.assessment}")
public interface ApplySalaryService {
    @GetMapping(path="/applySalaries")
    public List<ApplySalary> getApplySalary();
    @GetMapping(path="/applySalaries/{id}")
    public ApplySalary getApplySalary(@PathVariable("id")  id);
    @GetMapping(path="/applySalaries")
    public List<ApplySalary> getApplySalary();
    @GetMapping(path="/applySalaries/{id}")
    public ApplySalary getApplySalary(@PathVariable("id")  id);
}