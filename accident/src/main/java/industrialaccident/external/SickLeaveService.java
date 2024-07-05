package industrialaccident.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "assessment", url = "${api.url.assessment}")
public interface SickLeaveService {
    @RequestMapping(method = RequestMethod.POST, path = "/sickLeaves/{id}")
    public void requestSickLeaveBenefit(
        @PathVariable("id") Long id,
        @RequestBody RequestSickLeaveBenefitCommand requestSickLeaveBenefitCommand
    );
}
