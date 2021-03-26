package br.com.animais.sistemacadastroanimais.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* Controller responsável pela mensagem de apresentação do sistema */
@RestController
public class HelloController {
	
	@RequestMapping("/")
	public String hello() {
		return "Bem-vindo ao sistema de cadastro de animais!";
	}
	
}
