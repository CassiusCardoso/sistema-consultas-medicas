package cassius.projeto.spring.consultas_medicas_clean_arch.infrastructure.persistence.mapper;

import cassius.projeto.spring.consultas_medicas_clean_arch.domain.valueobjects.Endereco;
import cassius.projeto.spring.consultas_medicas_clean_arch.infrastructure.persistence.model.EnderecoEmbeddable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnderecoPersistenceMapper {
    EnderecoEmbeddable toEmbeddable(Endereco endereco);
    Endereco toDomain(EnderecoEmbeddable embeddable);
}
