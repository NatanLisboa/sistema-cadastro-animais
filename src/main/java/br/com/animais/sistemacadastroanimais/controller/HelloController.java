package br.com.animais.sistemacadastroanimais.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* Controller responsável pela mensagem de apresentação do sistema */
@RestController
@RequestMapping("/")
public class HelloController {
	
	@GetMapping("")
	public String hello() {
		return "Bem-vindo ao sistema de cadastro de animais!";
	}
	
}