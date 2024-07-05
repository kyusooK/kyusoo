
package industrialaccident.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;


@FeignClient(name = "assessment", url = "${api.url.assessment}")
 
public interface CreateSickLeaveService {
    @GetMapping(path="/createSickLeaves")
    public List<CreateSickLeave> getCreateSickLeave();

    @GetMapping(path="/createSickLeaves/{id}")
    public CreateSickLeave getCreateSickLeave(@PathVariable("id")  id);
}


