package br.com.animais.sistemacadastroanimais.config.validacao;

/* Classe que contém os detalhes de erro personalizados que podem ocorrer em alguma requisição, substituindo o JSON padrão */
public class ErroDeFormularioDto {

	private String campo; // Atributo que contém o campo do erro 
	private String erro; // Atributo que contém a mensagem de erro
	
	public ErroDeFormularioDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	
	
}
