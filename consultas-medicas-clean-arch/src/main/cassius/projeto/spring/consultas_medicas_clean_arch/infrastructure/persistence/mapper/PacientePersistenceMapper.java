package cassius.projeto.spring.consultas_medicas_clean_arch.infrastructure.persistence.mapper;

import cassius.projeto.spring.consultas_medicas_clean_arch.domain.entities.Paciente;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.valueobjects.Cpf;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.valueobjects.Email;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.valueobjects.Endereco;
import cassius.projeto.spring.consultas_medicas_clean_arch.domain.valueobjects.Senha;
import cassius.projeto.spring.consultas_medicas_clean_arch.infrastructure.persistence.model.PacienteModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EnderecoPersistenceMapper.class}) // <-- Adicione 'uses'
public interface PacientePersistenceMapper {
    @Mapping(target = "id", source = "id")
    // O MapStruct usará automaticamente o EnderecoPersistenceMapper para este campo
    @Mapping(source = "endereco", target = "endereco")
    PacienteModel toModel(Paciente paciente);

    @Mapping(source = "endereco", target = "endereco")
    Paciente toDomain(PacienteModel model);
    default String mapCpfToString(Cpf cpf) { return cpf == null ? null : cpf.getCpf(); }
    default Cpf mapStringToCpf(String cpf) { return cpf == null ? null : new Cpf(cpf); }

    default String mapEmailToString(Email email) { return email == null ? null : email.getEmail(); }
    default Email mapStringToEmail(String email) { return email == null ? null : new Email(email); }

    default String mapSenhaToString(Senha senha) { return senha == null ? null : senha.getSenhaHash(); }
    default Senha mapStringToSenha(String senha) {
        return senha == null ? null : Senha.carregar(senha);
    }

}
