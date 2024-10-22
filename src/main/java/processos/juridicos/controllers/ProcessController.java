package processos.juridicos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import processos.juridicos.DTOS.ProcessDTO;
import processos.juridicos.services.ProcessService;

import java.util.List;

@RestController
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    private ProcessService service;

    @GetMapping
    public ResponseEntity<List<ProcessDTO>> findAll(){
        List<ProcessDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
