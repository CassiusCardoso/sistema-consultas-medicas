package cassius.projeto.spring.consultas_medicas_clean_arch.application.dto.request.paciente;

public record EnderecoRequest(
        String logradouro,
        int numero,
        String bairro,
        String cidade,
        String uf,
        String cep
) {
}
