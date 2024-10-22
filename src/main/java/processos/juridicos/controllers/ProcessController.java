package processos.juridicos.controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{id}")
    public ResponseEntity<ProcessDTO> findById(@PathVariable Long id){
        ProcessDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<ProcessDTO> insert(@RequestBody ProcessDTO dto){
        ProcessDTO proc = service.insert(dto);
        return ResponseEntity.ok().build();
    }

}
