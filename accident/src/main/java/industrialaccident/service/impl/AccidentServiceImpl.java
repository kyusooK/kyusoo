package industrialaccident.service.impl;

import industrialaccident.domain.Accident;
import industrialaccident.domain.AccidentRepository;
import industrialaccident.domain.ApplyMedicalBenefitCommand;
import industrialaccident.domain.ApplySickLeaveBenefitCommand;
import industrialaccident.service.AccidentService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accidentService")
@Transactional
public class AccidentServiceImpl
    extends EgovAbstractServiceImpl
    implements AccidentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        AccidentServiceImpl.class
    );

    @Autowired
    AccidentRepository accidentRepository;

    @Override
    public List<Accident> getAllAccidents() throws Exception {
        // Get all accidents
        return StreamSupport
            .stream(accidentRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Accident> getAccidentById(Long id) throws Exception {
        // Get a accident by ID
        return accidentRepository.findById(id);
    }

    @Override
    public Accident createAccident(Accident accident) throws Exception {
        // Create a new accident
        return accidentRepository.save(accident);
    }

    @Override
    public Accident updateAccident(Accident accident) throws Exception {
        // Update an existing accident via AccidentService
        if (accidentRepository.existsById(accident.getId())) {
            return accidentRepository.save(accident);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteAccident(Long id) throws Exception {
        // Delete a accident
        accidentRepository.deleteById(id);
    }

    @Override
    public Accident applyMedicalBenefit(
        ApplyMedicalBenefitCommand applyMedicalBenefitCommand
    ) throws Exception {
        // You can implement logic here, or call the domain method of the Accident.
        Accident accident = new Accident();
        accident.applyMedicalBenefit(applyMedicalBenefitCommand);
        accidentRepository.save(accident);
        /** Option 1-1:  implement logic here 
        Optional<Accident> optionalAccident = accidentRepository.findById(applyMedicalBenefitCommand.getAccidentId());

        if (optionalAccident.isPresent()) {
            Accident accident = optionalAccident.get();
            accident.applyMedicalBenefit(applyMedicalBenefitCommand);
            return accidentRepository.save(accident);
        } else {
            throw processException("info.nodata.msg");
        }
        */
    }

    @Override
    public Accident applySickLeaveBenefit(
        ApplySickLeaveBenefitCommand applySickLeaveBenefitCommand
    ) throws Exception {
        // You can implement logic here, or call the domain method of the Accident.

        /** Option 1-1:  implement logic here     
            Accident accident = new Accident();
            accident.applySickLeaveBenefit(applySickLeaveBenefitCommand);
            accidentRepository.save(accident);   
        */

        Optional<Accident> optionalAccident = accidentRepository.findById(
            applySickLeaveBenefitCommand.getAccidentId()
        );

        if (optionalAccident.isPresent()) {
            Accident accident = optionalAccident.get();
            accident.applySickLeaveBenefit(applySickLeaveBenefitCommand);
            return accidentRepository.save(accident);
        } else {
            throw processException("info.nodata.msg");
        }
    }
}
