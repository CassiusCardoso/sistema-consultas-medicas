package java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.repositories;

import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities.Horario;
import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.enums.StatusHorario;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HorarioRepository {
    Horario salvar (Horario horario);
    Optional<Horario> buscarPorId(UUID horarioId);
    List<Horario> buscarPorHorarioDisponivel(StatusHorario horarioDisponivel);

}
