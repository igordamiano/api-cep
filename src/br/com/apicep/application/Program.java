package br.com.apicep.application;

import br.com.apicep.domain.Endereco;
import br.com.apicep.service.ServicoDeCep;

public class Program {

	public static void main(String[] args) throws Exception {

		System.setProperty("file.encoding", "ISO-8859-1");
		String cep = "05367080";
		
		Endereco endereco = ServicoDeCep.buscaEnderecoPelo(cep);
		
		System.out.println("Logradouro: " + endereco.getLogradouro());
		System.out.println("Bairro: " + endereco.getBairro());
		System.out.println("Localidade: " + endereco.getLocalidade());
		
	}

}
