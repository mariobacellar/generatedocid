package br.com.mariobacellar.geradordocid.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.mariobacellar.geradordocid.util.CPFHandler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/mariobacellar")
public class GeradorDocIdController {

	@RequestMapping("/cpf")
	@ResponseBody
	public String getCPF() {
		String cpf = CPFHandler.generateCPF()[0]; 
		String json = "{\"autor\":\"https://www.linkedin.com/in/mariobacellar/\",\"aviso\":\"Gerador de CPFs inválidos. Este CPF não tem o DV válido. CPF usado somente para teste de massa de daos\",\"cpf\":\""+cpf+"\"}";
		return json;
	}


	@RequestMapping("/cpf/formatado")
	@ResponseBody
	public String getCPF_Fmt() {
		String cpf = CPFHandler.generateCPF()[1]; 
		String json = "{\"autor\":\"https://www.linkedin.com/in/mariobacellar/\",\"aviso\":\"Gerador de CPFs inválidos. Este CPF não tem o DV válido. CPF usado somente para teste de massa de daos\",\"cpf\":\""+cpf+"\"}";
		return json;
	}


	@RequestMapping("/cnpj")
	@ResponseBody
	public String getCNPJ() {
		return "Returning CNPJ";
	}
	


}