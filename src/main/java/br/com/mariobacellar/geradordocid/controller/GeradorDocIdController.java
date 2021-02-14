package br.com.mariobacellar.geradordocid.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.mariobacellar.geradordocid.util.CPFCNPJHandler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/mariobacellar")
public class GeradorDocIdController {

	@RequestMapping("/cpf")
	@ResponseBody
	public String getCPF() {
		String[]  cpf     = CPFCNPJHandler.generateCPF();
		String    cpf_num =  cpf[0];
		String    cpf_fmt = cpf[1]; 
		return    getJSONCPF(cpf_num,cpf_fmt);
	}

	@RequestMapping("/cnpj")
	@ResponseBody
	public String getCNPJ() {
		String[] cnpj     = CPFCNPJHandler.generateCNPJ();
		String   cnpj_num = cnpj[0];
		String   cnpj_fmt = cnpj[1]; 
		return   getJSONCNPJ(cnpj_num, cnpj_fmt);
	}
	
	
	private String getJSONCPF(String cpf, String cpf_fmt) {
		return 	"{"
				+ "\"autor\":\"https://www.linkedin.com/in/mariobacellar/\","
				+ "\"gtihub\":\"https://github.com/mariobacellar/generatedocid\","						
				+ "\"aviso\":\"Gerador de CPFs inválidos. Este CPF não tem o DV válido. CPF usado somente para teste de massa de dados\","
				+ "\"cpf_fmt\":\""+cpf_fmt+"\","
				+ "\"cpf_num\":\""+cpf+"\""
				+ "}";
	}
	
	private String getJSONCNPJ(String cnpj, String cnpj_fmt) {
		return 	"{"
				+ "\"autor\":\"https://www.linkedin.com/in/mariobacellar/\","
				+ "\"gtihub\":\"https://github.com/mariobacellar/generatedocid\","
				+ "\"aviso\":\"Gerador de CNPJs inválidos. Este CNPJ não tem o DV válido. CNPJ usado somente para teste de massa de dados\","
				+ "\"cnpj_fmt\":\""+cnpj_fmt+"\","
				+ "\"cnpj_num\":\""+cnpj+"\""
				+ "}";
	}	
}