package studiomartins.studiomartins.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studiomartins.studiomartins.model.Empregado;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
}
