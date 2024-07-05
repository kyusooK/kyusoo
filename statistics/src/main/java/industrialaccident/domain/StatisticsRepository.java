package industrialaccident.domain;

import industrialaccident.domain.*;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "statistics",
    path = "statistics"
)
public interface StatisticsRepository
    extends PagingAndSortingRepository<Statistics, Long> {}
