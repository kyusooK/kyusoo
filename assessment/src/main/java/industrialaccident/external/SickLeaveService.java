package industrialaccident.external;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
@FeignClient(name = "assessment", url = "${api.url.assessment}")
public interface SickLeaveService {
    @RequestMapping(method= RequestMethod., path="/sickLeaves/{id}")
    public void sickLeaveBenefitCreated(@PathVariable("id") Long id, @RequestBody SickLeaveBenefitCreatedCommand sickLeaveBenefitCreatedCommand );
    @RequestMapping(method= RequestMethod., path="/sickLeaves/{id}")
    public void sickLeaveBenefitRequested(@PathVariable("id") Long id, @RequestBody SickLeaveBenefitRequestedCommand sickLeaveBenefitRequestedCommand );
    @RequestMapping(method= RequestMethod., path="/sickLeaves/{id}")
    public void averageSalaryApplied(@PathVariable("id") Long id, @RequestBody AverageSalaryAppliedCommand averageSalaryAppliedCommand );
    @RequestMapping(method= RequestMethod.POST, path="/sickLeaves/{id}")
    public void createSickLeaveBenefit(@PathVariable("id") Long id, @RequestBody CreateSickLeaveBenefitCommand createSickLeaveBenefitCommand );
}