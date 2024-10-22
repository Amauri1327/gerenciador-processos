package processos.juridicos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import processos.juridicos.model.Process.Process;

public interface ProcessRepository extends JpaRepository<Process, Long> {
}
