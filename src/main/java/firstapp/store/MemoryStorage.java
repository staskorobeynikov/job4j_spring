package firstapp.store;

import firstapp.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(value = "memory")
public class MemoryStorage implements Storage {

    private final Map<Integer, User> storage = new HashMap<>();

    @Override
    public void add(User user) {
        storage.putIfAbsent(user.getId(), user);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(storage.values());
    }
}
