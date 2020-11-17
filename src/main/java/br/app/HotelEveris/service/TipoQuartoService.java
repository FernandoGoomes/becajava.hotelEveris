package br.app.HotelEveris.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.HotelEveris.model.TipoQuarto;
import br.app.HotelEveris.repository.TipoQuartoRepository;
import br.app.HotelEveris.request.TipoQuartoRequest;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.response.TipoQuartoListResponse;
import br.app.HotelEveris.response.TipoQuartoResponse;

@Service
public class TipoQuartoService {

	@Autowired
	private TipoQuartoRepository repository;

	public BaseResponse inserir(TipoQuartoRequest tipodequartoreq) {

		BaseResponse response = new BaseResponse();
		
		if (tipodequartoreq.getDescricao() == "") {

			response.message = "Descricao vazia tente novamente";
			response.statusCode = 400;
            return response;
		}

		if (tipodequartoreq.getValor() == 0) {

			response.message = "Valor incopartivel tente novamente";
			response.statusCode = 400;
			return response;

		}


		
		TipoQuarto tipoquarto = new TipoQuarto(tipodequartoreq.getDescricao(), tipodequartoreq.getValor());


		repository.save(tipoquarto);
		response.statusCode = 201;

		response.message = "tipo de quarto inserido.";

		return response;

	}

	public TipoQuartoResponse obter(Long id) {

		Optional<TipoQuarto> tipoquarto = repository.findById(id);

		TipoQuartoResponse response = new TipoQuartoResponse();

	
		
		if(!tipoquarto.isPresent()) {
			
			response.statusCode = 400;
			response.message = "Id não encontrado tente novamente";
			return response;
		}
		
		

		response.setDescricao(tipoquarto.get().getDescricao());
		response.setValor(tipoquarto.get().getValor());

		response.message = "Lista Tipo quarto efetuada com sucesso";
		response.statusCode = 200;

		return response;

	}

	public TipoQuartoListResponse listar() {

		List<TipoQuarto> listando = repository.findAll();
		


		TipoQuartoListResponse response = new TipoQuartoListResponse();
  
		response.setTipoquarto(listando);
		
		response.statusCode = 200;
		response.message = "Serviços obtidos com sucesso.";

		return response;

	}

}
