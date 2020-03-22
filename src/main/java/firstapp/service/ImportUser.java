package firstapp.service;

import firstapp.models.User;
import firstapp.store.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImportUser {

    private final Storage storage;

    @Autowired
    public ImportUser(@Qualifier("jdbc") final Storage storage) {
        this.storage = storage;
    }

    void addUser(User user) {
        storage.add(user);
    }

    List<User> getAll() {
        return storage.findAll();
    }
}
