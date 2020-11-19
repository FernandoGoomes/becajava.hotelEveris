package br.app.HotelEveris.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.HotelEveris.model.Comodidade;
import br.app.HotelEveris.repository.ComodidadeRepository;
import br.app.HotelEveris.request.ComidadeRequestDoInserir;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.response.ComodidadeResponse;
import br.app.HotelEveris.service.ComodidadeService;

@Service

public class ComodidadeServiceImp implements ComodidadeService {

	@Autowired

	private ComodidadeRepository repository;

	public BaseResponse inserir(ComidadeRequestDoInserir request) {

		BaseResponse response = new BaseResponse();

		Comodidade comodidade = new Comodidade(request.getNome());
		response.statusCode = 400;
		

		if (request.getNome() == "") {
			response.message = "A comodidade não pode ser vazia";
			response.statusCode = 400;
			return response;
		}
		
		
		
		repository.save(comodidade);

		response.message = "Comodidade feito";
		response.statusCode = 201;

		return response;

	}

	public ComodidadeResponse obter(Long id) {

		Optional<Comodidade> comodidade = repository.findById(id);

		ComodidadeResponse response = new ComodidadeResponse();
	//	BaseResponse r = new BaseResponse(); 
		

		if (!comodidade.isPresent()) {
			response.statusCode = 400;
			response.message = "Id não encontrado.";
			return response;
		}
		

		response.setId(comodidade.get().getId());
		response.setNome(comodidade.get().getNome());

		response.statusCode = 200;
		response.message = "Tipo de quarto obtido com sucesso.";
		return response;

	}

}
