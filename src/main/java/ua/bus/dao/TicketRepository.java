package ua.bus.dao;

import org.springframework.data.repository.CrudRepository;
import ua.bus.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long>{
}
