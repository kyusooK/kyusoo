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
public interface AssessmentService {
    @RequestMapping(method= RequestMethod., path="/assessments/{id}")
    public void investigationCreated(@PathVariable("id") Long id, @RequestBody InvestigationCreatedCommand investigationCreatedCommand );
    @RequestMapping(method= RequestMethod., path="/assessments/{id}")
    public void investigationApproved(@PathVariable("id") Long id, @RequestBody InvestigationApprovedCommand investigationApprovedCommand );
    @RequestMapping(method= RequestMethod., path="/assessments/{id}")
    public void investigationDisapproved(@PathVariable("id") Long id, @RequestBody InvestigationDisapprovedCommand investigationDisapprovedCommand );
    @RequestMapping(method= RequestMethod.POST, path="/assessments/{id}")
    public void createInvestigation(@PathVariable("id") Long id, @RequestBody CreateInvestigationCommand createInvestigationCommand );
}