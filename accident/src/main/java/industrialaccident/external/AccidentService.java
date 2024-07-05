package industrialaccident.external;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
@FeignClient(name = "accident", url = "${api.url.accident}")
public interface AccidentService {
    @RequestMapping(method= RequestMethod., path="/accidents/{id}")
    public void sickLeaveBenefitApplieda(@PathVariable("id") Long id, @RequestBody SickLeaveBenefitAppliedaCommand sickLeaveBenefitAppliedaCommand );
    @RequestMapping(method= RequestMethod., path="/accidents/{id}")
    public void medicalBenefitApplied(@PathVariable("id") Long id, @RequestBody MedicalBenefitAppliedCommand medicalBenefitAppliedCommand );
}