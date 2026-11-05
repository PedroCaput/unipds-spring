package br.com.nomedaempresa.iniciandojava.service.interfac;

import br.com.nomedaempresa.iniciandojava.model.Conference;

import java.util.List;

public interface InterfaceConferenceService {
    public Conference addConference(Conference conference);
    public Conference getConferenceById(Integer id);
    public List<Conference> getAllConferences();
}
