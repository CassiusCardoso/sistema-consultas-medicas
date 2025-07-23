package cassius.projeto.spring.consultas_medicas_clean_arch.application.dto.request.paciente;

public record CadastrarPacienteRequest(
        String nome,
        String cpf,
        String email,
        String senha,
        String plano,
        EnderecoRequest endereco
) {
}
