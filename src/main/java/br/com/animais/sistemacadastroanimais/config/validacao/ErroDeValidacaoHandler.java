package br.com.animais.sistemacadastroanimais.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/* Classe que é acionada quando ocorre algum resultado inesperado em uma requisição */
@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource; // Objeto que contém a mensagem de erro obtida
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST) // Notação para o sistema devolver o código 400 quando ocorre algum tipo de erro na requisição (por padrão, o erro tenta ser tratado e o código 200 é devolvido)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception) {
		
		List<ErroDeFormularioDto> dto = new ArrayList<>(); // Objeto que será responsável por formatar os erros de uma forma que os mesmos fiquem mais legíveis no arquivo JSON
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors(); // O objeto "exception" contém todos os erros ocorridos nos campos na tentativa de requisição
		
		//Para cada erro contido na lista "fieldErrors", a mensagem é traduzida para o idioma local (no caso, português) e é formatada de acordo as especificações da classe erro de formulário DTO
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
		
	}
	
}
