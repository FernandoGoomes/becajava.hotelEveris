package br.app.HotelEveris.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.HotelEveris.model.Comodidade;
import br.app.HotelEveris.model.Quarto;
import br.app.HotelEveris.model.QuartoComodidade;
import br.app.HotelEveris.model.TipoQuarto;
//import br.app.HotelEveris.repository.ComodidadeRepository;
import br.app.HotelEveris.repository.QuartoComodidadeRepository;
import br.app.HotelEveris.repository.QuartoRepository;
import br.app.HotelEveris.request.ComodidadeRequest;
import br.app.HotelEveris.request.QuartoRequest;
import br.app.HotelEveris.request.SituacaoQuartoRequest;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.response.QuartoListResponse;
import br.app.HotelEveris.response.QuartoResponse;
import br.app.HotelEveris.service.QuartoService;

@Service
public class QuartoServiceImp implements QuartoService {

//	@Autowired
//	private ComodidadeRepository repocomo;

	@Autowired
	private QuartoRepository repository;

	@Autowired
	private QuartoComodidadeRepository _repository;

	public BaseResponse inserir(QuartoRequest request) {

		BaseResponse response = new BaseResponse();

		Quarto quarto = new Quarto();

		quarto.setAndar(request.getAndar());
		quarto.setNquarto(request.getNquarto());
		quarto.setSituacao(request.getSituacao());

		TipoQuarto o = new TipoQuarto();

		o.setId(request.getIdTipoquarto());
		quarto.setTipoquarto(o);

		repository.save(quarto);

		response.statusCode = 201;
		response.message = "Quarto obtido";

		Optional<Quarto> getquarto = repository.findBynquarto(request.getNquarto());

		Long quartoId = getquarto.get().getId();

//		Long idQuarto = repository.findBynquarto(request.getNquarto()).get().getId();

		for (ComodidadeRequest item : request.getComodidade()) {

			Quarto quart = new Quarto();
			quart.setId(quartoId);

			Comodidade c = new Comodidade();
			c.setId(item.getId());

			QuartoComodidade quartoComodidade = new QuartoComodidade();

			quartoComodidade.setComodidade(c);
			quartoComodidade.setQuarto(quart);

			_repository.save(quartoComodidade);

		}

		response.statusCode = 201;
		response.message = "Quarto obtido";
		return response;

	}

	public QuartoResponse obter(Long id) {

		Optional<Quarto> lista = repository.findById(id);

		QuartoResponse response = new QuartoResponse();

		response.setId(lista.get().getId());
		response.setAndar(lista.get().getNquarto());
		response.setNquarto(lista.get().getNquarto());
		response.setSituacao(lista.get().getSituacao());
		response.setQuartoid(lista.get().getTipoquarto().getId());

		response.statusCode = 200;
		response.message = "Quarto obtidos com sucesso";

		return response;

	}

	public QuartoListResponse obterlista(Long id) {

		List<Quarto> lista = repository.findByTipoQuartos(id);

		QuartoListResponse response = new QuartoListResponse();
		response.setQuarto(lista);

		response.message = "Lista Obtida";
		response.statusCode = 200;

		return response;

	}

	public BaseResponse atualizar(Long id, SituacaoQuartoRequest request) {

		Optional<Quarto> quarto = repository.findById(id);

		BaseResponse response = new BaseResponse();

		if (request.getSituacao() == "") {
			response.statusCode = 400;
			response.message = "Situação do quarto não pode ser vazia";
			return response;

		}

		if (!quarto.isPresent()) {
			response.statusCode = 400;
			response.message = "id nao encontrado tente novamente";
			return response;
		}

		quarto.get().setSituacao(request.getSituacao());

		repository.save(quarto.get());

		response.message = "Situação Atulizada Com sucesso";
		response.statusCode = 200;

		return response;

	}

}
