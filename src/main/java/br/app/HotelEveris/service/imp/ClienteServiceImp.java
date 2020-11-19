package br.app.HotelEveris.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.app.HotelEveris.model.Cliente;
import br.app.HotelEveris.repository.ClienteRepository;
import br.app.HotelEveris.request.ClienteRequest;
import br.app.HotelEveris.response.BaseResponse;
import br.app.HotelEveris.response.ClienteResponse;
import br.app.HotelEveris.service.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService {

	@Autowired
	ClienteRepository repository;


	public BaseResponse criar(ClienteRequest request) {
		BaseResponse response = new BaseResponse();
		Cliente cliente = new Cliente();

		if (request.getNome() == "") {
			response.message = "insira um nome  e tente novamente";
			response.statusCode = 400;
			return response;
		}
		if (request.getCpf() == "") {
			response.message = "insira um cpf e tente novamente";
			response.statusCode = 400;
			return response;
			
		}
		if (request.getHash() == "") {
			response.message = "insira um hash e tente novamente";
			response.statusCode = 400;
			return response;
		}

	
		cliente.setNome(request.getNome());
		cliente.setCpf(request.getCpf());
		cliente.setHash(request.getHash());

		repository.save(cliente);

		response.message = "Cliente foi criado com sucesso";
		response.statusCode = 201;
		
		

		return response;
		
		
	}

	public ClienteResponse obter(Long id) {
		
		
		Optional<Cliente> cliente = repository.findById(id);

		ClienteResponse response = new ClienteResponse();


		if (!cliente.isPresent()) {
			response.statusCode = 400;
			response.message = "Id inexistente tente novamente";
			return response;
		}

		response.setId(cliente.get().getId());
		response.setNome(cliente.get().getNome());
		response.setCpf(cliente.get().getCpf());

		response.statusCode = 200;
		response.message = "Conta obtida com sucesso.";
		
		return response;
	}
}