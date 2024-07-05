package industrialaccident.external;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Date;
import java.util.List;
@FeignClient(name = "notification", url = "${api.url.notification}")
public interface NotifyService {
    @GetMapping(path="/notifies")
    public List<Notify> getNotify();
    @GetMapping(path="/notifies/{id}")
    public Notify getNotify(@PathVariable("id")  id);
    @GetMapping(path="/notifies")
    public List<Notify> getNotify();
    @GetMapping(path="/notifies/{id}")
    public Notify getNotify(@PathVariable("id")  id);
}