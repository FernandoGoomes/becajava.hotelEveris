package br.app.HotelEveris.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.app.HotelEveris.model.Ocupacao;
import br.app.HotelEveris.repository.ClienteRepository;
import br.app.HotelEveris.repository.OcupacaoRepository;
import br.app.HotelEveris.repository.QuartoRepository;
import br.app.HotelEveris.repository.TipoQuartoRepository;
import br.app.HotelEveris.request.TransferenciaRequest;
import br.app.HotelEveris.response.BaseResponse;


@Service
public class FaturaService  {
	
	@Autowired
	private OcupacaoRepository ocupacaoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TipoQuartoRepository tipoQuartoRepository;
	
	@Autowired
	private QuartoRepository quartoRepository;
	
	 
	public  BaseResponse inserir(){	
		

		BaseResponse response = new BaseResponse();
	
		String hashContaHotel = "c7959779-d787-40ac-945c-1b0c4ad2b666";

		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8081/operacao/transferencia";
		
		List<Ocupacao> lista = ocupacaoRepository.findBySituacao("N");		
		
		
		for (Ocupacao ocupacao : lista) {
			
			double valor = ocupacao.getQuarto().getTipoquarto().getValor() * ocupacao.getQtdiarias();
			
			TransferenciaRequest transferencia = new TransferenciaRequest();
			transferencia.setHashDestino(hashContaHotel);
			transferencia. setHashOrigem(ocupacao.getCliente().getHash());
            
			
			transferencia.setValor(valor);
		    

		 restTemplate.postForObject(uri, transferencia, BaseResponse.class);
		

			ocupacao.setSituacao("P");
			ocupacaoRepository.save(ocupacao);

	
	}
		
		response.statusCode = 200;
		response.message = "Transferencia completa";
		
		return response;
		
	}

}