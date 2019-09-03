package za.co.joshuabakerg.auth.authservice.core.impl;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import za.co.joshuabakerg.auth.authservice.domain.entities.ClientDetailsImpl;
import za.co.joshuabakerg.auth.authservice.domain.repositories.ClientDetailsRepository;

/**
 * @author Joshua Baker on 03/09/2019
 */
@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

    private final ClientDetailsRepository clientDetailsRepository;

    public ClientDetailsServiceImpl(final ClientDetailsRepository clientDetailsRepository) {
        this.clientDetailsRepository = clientDetailsRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(final String clientId) throws ClientRegistrationException {
        final ClientDetailsImpl client = clientDetailsRepository.findByClientId(clientId);
        if (client == null) {
            throw new ClientRegistrationException("Client not found");
        }
        return client;
    }
}
