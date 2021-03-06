package br.com.apicep.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import br.com.apicep.domain.Endereco;
import br.com.apicep.util.Util;

public class ServicoDeCep {
	
	static String webService = "http://viacep.com.br/ws/";
	static int codigoSucesso = 200;
	
	public static Endereco buscaEnderecoPelo(String cep) throws Exception {
		
		String urlParaChamada = webService + cep + "/json";
		System.out.println(urlParaChamada);
		
		
		try {
			
			URL url = new URL(urlParaChamada);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
			
			if (conexao.getResponseCode() != codigoSucesso) {
				throw new RuntimeException("HTTP error code: " + conexao.getResponseCode());
			}
			
			BufferedReader resposta = new BufferedReader(new InputStreamReader(conexao.getInputStream(),  "UTF-8"));
			String jsonEmString = Util.converteJsonEmString(resposta);
			
			Gson gson = new Gson();
			Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);
			
			return endereco;
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}		
		
	}

}
