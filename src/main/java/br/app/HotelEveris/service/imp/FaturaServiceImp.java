package br.app.HotelEveris.service.imp;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.app.HotelEveris.model.Ocupacao;
//import br.app.HotelEveris.repository.ClienteRepository;
import br.app.HotelEveris.repository.OcupacaoRepository;
//import br.app.HotelEveris.repository.QuartoRepository;
//import br.app.HotelEveris.repository.TipoQuartoRepository;
import br.app.HotelEveris.request.TransferenciaRequest;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.service.FaturaService;


@Service
public class FaturaServiceImp implements FaturaService {
	
	@Autowired
	private OcupacaoRepository ocupacaoRepository;
	
//	@Autowired
//	private ClienteRepository clienteRepository;
//	
//	@Autowired
//	private TipoQuartoRepository tipoQuartoRepository;
//	
//	@Autowired
//	private QuartoRepository quartoRepository;
	
	 
	public  BaseResponse inserir(){	
		

		BaseResponse response = new BaseResponse();
	
		String hashContaHotel = "12345";

		RestTemplate restTemplate = new RestTemplate();
		String uri = "http://localhost:8080/operacao/transferencia";
		
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