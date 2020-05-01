package firstapp.service;

import firstapp.models.User;
import firstapp.store.MemoryStorage;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ImportUserTest {

    @Test
    public void whenTestObjectImportUserWithStorageJDBC() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        ImportUser users = context.getBean(ImportUser.class);
        User user = new User();
        user.setId(1);
        user.setName("Stas");
        users.addUser(user);

        assertNotNull(users);
        assertThat(users.getAll().get(0).getName(), is("Stas"));
    }

    @Test
    public void whenGetMemoryStorageSpringContextAndCreateObjectImportUserWithThatStorage() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoryStorage memory = (MemoryStorage) context.getBean("memory");
        ImportUser users = new ImportUser(memory);

        User user = new User();
        user.setId(1);
        user.setName("Stas");
        users.addUser(user);
        User user1 = new User();
        user1.setId(2);
        user1.setName("Petr");
        users.addUser(user1);

        List<User> list = users.getAll();
        assertNotNull(memory);
        assertThat(list.get(0).getName(), is("Stas"));
        assertThat(list.get(1).toString(), is("User: id=2, name=Petr."));
        assertThat(list.size(), is(2));
    }
}