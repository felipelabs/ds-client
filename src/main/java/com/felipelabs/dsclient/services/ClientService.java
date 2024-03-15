package com.felipelabs.dsclient.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipelabs.dsclient.dtos.ClientDTO;
import com.felipelabs.dsclient.entities.Client;
import com.felipelabs.dsclient.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client client = clientRepository.findById(id).orElseThrow();
		return new ClientDTO(client);
	}
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable){
		Page<Client> client = clientRepository.findAll(pageable);
		return client.map(x -> new ClientDTO(x));
	}

}
