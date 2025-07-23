package cassius.projeto.spring.consultas_medicas_clean_arch.infrastructure.persistence.jpa;

import cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.StatusPaciente;
import cassius.projeto.spring.consultas_medicas_clean_arch.infrastructure.persistence.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PacienteRepositoryJpa extends JpaRepository<PacienteModel, UUID> {
    Optional<PacienteModel> findByEmail(String email);
    Optional<PacienteModel> findByCpf(String cpf);
    Optional<PacienteModel> findById(UUID pacienteId);

    List<PacienteModel> findByStatus(StatusPaciente status);

    List<PacienteModel> findByNome(String nome);

    // Achar o paciente por consulta
}
