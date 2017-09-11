package ua.bus.dao;

import org.springframework.data.repository.CrudRepository;
import ua.bus.model.User;

public interface UserRepository  extends CrudRepository<User, Long>{
}
