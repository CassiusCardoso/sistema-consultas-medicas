package java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.repositories;

import java.cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities.MedicoEndereco;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicoEnderecoRepository {
    MedicoEndereco salvar(MedicoEndereco medicoEndereco);
    Optional<MedicoEndereco> buscarPorId(UUID medicoEnderecoId);
    List<MedicoEndereco> buscarPorMedicoId(UUID medicoId);
    List<MedicoEndereco> buscarPorCep(String cep);
}
