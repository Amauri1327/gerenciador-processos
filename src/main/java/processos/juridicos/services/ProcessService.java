package processos.juridicos.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import processos.juridicos.DTOS.ProcessDTO;
import processos.juridicos.model.Process.Process;
import processos.juridicos.repositories.ProcessRepository;

import java.util.List;
import java.util.Optional;
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


    public ProcessDTO findById(Long id) {
        Optional<Process> dto = repository.findById(id);
        Process proc = dto.orElseThrow(() -> new EntityNotFoundException("Usuário nao encontrado"));
        return new ProcessDTO(proc);
    }

    public ProcessDTO insert(ProcessDTO dto) {
        Process obj = new Process();
        obj.setCode(dto.code());
        obj.setDescription(dto.description());
        obj.setArea(dto.area());
        obj.setExpiration(dto.expiration());
        repository.save(obj);
        return new ProcessDTO(obj);
    }

    public ProcessDTO update(Long id, ProcessDTO dto) {
        try {
            Process obj = repository.getReferenceById(id);
            obj.setCode(dto.code());
            obj.setDescription(dto.description());
            obj.setArea(dto.area());
            obj.setExpiration(dto.expiration());
            repository.save(obj);
            return new ProcessDTO(obj);
        }
        catch (EntityNotFoundException e){
            throw new EntityNotFoundException("Id not found: " + id);
        }
    }

    public void delete(Long id) {
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("Id not found: " + id);
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new RuntimeException("Integrity violation");
        }
    }

}
