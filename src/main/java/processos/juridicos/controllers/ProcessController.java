package processos.juridicos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import processos.juridicos.DTOS.ProcessDTO;
import processos.juridicos.repositories.ProcessRepository;

import java.util.List;

@RestController
@RequestMapping(name = "/process")
public class ProcessController {

    @Autowired
    private ProcessRepository repository;

    public ResponseEntity<List<ProcessDTO>> findAll(){

        return null;
    }

}
