package br.com.nomedaempresa.iniciandojava.service.impl;

import br.com.nomedaempresa.iniciandojava.exceptions.NotFoundException;
import br.com.nomedaempresa.iniciandojava.model.Conference;
import br.com.nomedaempresa.iniciandojava.repository.ConferenceRepository;
import br.com.nomedaempresa.iniciandojava.service.interfac.InterfaceConferenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceServiceImpl implements InterfaceConferenceService {
    private final ConferenceRepository repository;

    public ConferenceServiceImpl(ConferenceRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Conference addConference(Conference conference) {
        return repository.save(conference);
    }

    @Override
    public Conference getConferenceById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Conference " + id + " not found.")
        );
    }

    @Override
    public List<Conference> getAllConferences() {
        return repository.findAll();
    }
}
