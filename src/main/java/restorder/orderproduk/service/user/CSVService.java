package restorder.orderproduk.service.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.repositories.UserRepository;
import restorder.orderproduk.util.CSVHelper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class CSVService {

    private UserRepository userRepository;

    public void save(MultipartFile file) {
        try {
            final List<User> userList = CSVHelper.transformCSVToList(file.getInputStream());
            userRepository.saveAll(userList);
        }catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<User> userList = userRepository.findAll();

        ByteArrayInputStream inputStream = CSVHelper.userToCSV(userList);

        return inputStream;
    }
}
