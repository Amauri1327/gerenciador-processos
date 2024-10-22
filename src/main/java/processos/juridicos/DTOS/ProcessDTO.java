package processos.juridicos.DTOS;

import processos.juridicos.model.Process.Process;

public record ProcessDTO(Long id, Integer code, String description, String area, String expiration ) {

    public ProcessDTO(Process proc) {
        this(
                proc.getId(),
                proc.getCode(),
                proc.getDescription(),
                proc.getArea(),
                proc.getExpiration()
        );
    }
}
