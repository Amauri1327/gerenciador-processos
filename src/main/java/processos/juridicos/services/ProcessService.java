package processos.juridicos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import processos.juridicos.DTOS.ProcessDTO;
import processos.juridicos.model.Process.Process;
import processos.juridicos.repositories.ProcessRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessService {

    @Autowired
    private ProcessRepository repository;

    public List<ProcessDTO> findAll(){
        List<Process> proc = repository.findAll();
        return proc.stream()
                .map(process -> new ProcessDTO(process.getId(), process.getCode(), process.getDescription(), process.getArea(), process.getExpiration()))
                .collect(Collectors.toList());
    }



}
