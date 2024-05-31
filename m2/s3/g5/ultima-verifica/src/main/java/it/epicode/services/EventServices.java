package it.epicode.services;

import it.epicode.entities.Event;
import it.epicode.entities.User;
import it.epicode.repositories.EventRepository;
import it.epicode.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServices {

    @Autowired
    private EventRepository eventRepository;

    public Event savesEvent(Event event){
        return eventRepository.save(event);
    }

    public List<Event> getAllEvent(){
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id){
        if(eventRepository.findById(id).isPresent()){
            return eventRepository.findById(id);
        }else {
            return Optional.empty();
        }
    }
    public Event updateEvent(Event event,Long id){
        var foundedEvent = eventRepository.findById(id);
        if (foundedEvent.isPresent()){
            var definedEvent = foundedEvent.get();
            var updateEvent = definedEvent.builder()

                            .withData(event.getData())
                            .withDescrizione(event.getDescrizione())
                            .withDisponibilita(event.isDisponibilita())
                            .withLuogo(event.getLuogo())
                            .withPostiDisponibili(event.getPostiDisponibili())
                            .withPostiPrenotati(event.getPostiPrenotati())
                            .withTitolo(event.getTitolo())
                    .build();
            updateEvent.setId(definedEvent.getId());
            return eventRepository.save(updateEvent);
        }else {
            throw new RuntimeException("Invalid");
        }
    }

    public Event delete(Long id){
        var foundedEvent = eventRepository.findById(id);
        if (foundedEvent.isPresent()){
            eventRepository.delete(foundedEvent.get());
            return foundedEvent.get();
        }else {
            throw new RuntimeException("Invalid");
        }
    }
}
