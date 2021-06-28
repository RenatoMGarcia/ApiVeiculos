package br.com.gerenciadorVeiculos.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	private MessageSource messageSource;
	
	public List<ErroDeFormDto> handle(MethodArgumentNotValidException exception) {
		
		List<ErroDeFormDto> dto = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErroDeFormDto erro = new ErroDeFormDto(e.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
	}

}
