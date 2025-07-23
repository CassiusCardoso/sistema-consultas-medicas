package cassius.projeto.spring.consultas_medicas_clean_arch.application.mapper;
import cassius.projeto.spring.consultas_medicas_clean_arch.application.dto.response.paciente.PacienteResponse;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities.Paciente;
import org.mapstruct.Mapper; // <-- Adicione esta linha
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    @Mapping(source = "cpf.cpf", target = "cpf")
    @Mapping(source = "email.email", target = "email")
    @Mapping(source = "endereco.endereco", target = "endereco")
    PacienteResponse toResponse(Paciente paciente);


}
