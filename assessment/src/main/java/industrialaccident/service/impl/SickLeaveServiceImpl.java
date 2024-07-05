package industrialaccident.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import industrialaccident.domain.ApplySalaryCommand;
import industrialaccident.domain.CreateSickLeaveBenefitCommand;
import industrialaccident.domain.RequestSickLeaveBenefitCommand;
import industrialaccident.domain.SickLeave;
import industrialaccident.domain.SickLeaveRepository;
import industrialaccident.service.SickLeaveService;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("sickLeaveService")
@Transactional
public class SickLeaveServiceImpl extends EgovAbstractServiceImpl implements SickLeaveService {

     private static final Logger LOGGER = LoggerFactory.getLogger(SickLeaveServiceImpl.class);

    @Autowired
    SickLeaveRepository sickLeaveRepository;

    @Override
    public List<SickLeave> getAllSickLeaves() throws Exception {
        // Get all sickLeaves
        return StreamSupport.stream(sickLeaveRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<SickLeave> getSickLeaveById(Long id) throws Exception {
        // Get a sickLeave by ID
        return sickLeaveRepository.findById(id);
    }

    @Override
    public SickLeave createSickLeave(SickLeave sickLeave) throws Exception {
        // Create a new sickLeave
        return sickLeaveRepository.save(sickLeave);
    }    

    @Override
    public SickLeave updateSickLeave(SickLeave sickLeave)  throws Exception {
        // Update an existing sickLeave via SickLeaveService
        if (sickLeaveRepository.existsById(sickLeave.getId())) {
            return sickLeaveRepository.save(sickLeave);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteSickLeave(Long id) throws Exception {
        // Delete a sickLeave
        sickLeaveRepository.deleteById(id);
    }

    @Override
	public SickLeave requestSickLeaveBenefit(RequestSickLeaveBenefitCommand requestSickLeaveBenefitCommand) throws Exception {        

        // You can implement logic here, or call the domain method of the SickLeave.
        
        /** Option 1-1:  implement logic here     
            RequestSickLeaveBenefit requestSickLeaveBenefit = new RequestSickLeaveBenefit();
            requestSickLeaveBenefit.(Command);
            requestSickLeaveBenefitRepository.save(requestSickLeaveBenefit);     
        */
        
        Optional<SickLeave> optionalSickLeave = sickLeaveRepository.findById(requestSickLeaveBenefitCommand.getSickLeaveId());

        if (optionalSickLeave.isPresent()) {
            RequestSickLeaveBenefit requestSickLeaveBenefit = optionalRequestSickLeaveBenefit.get();
            requestSickLeaveBenefit.(Command);
            return requestSickLeaveBenefitRepository.save(requestSickLeaveBenefit);
        } else {
            throw processException("info.nodata.msg");
        }
    }
}
