package restorder.orderproduk.service.user;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import restorder.orderproduk.entity.User;
import restorder.orderproduk.repositories.UserRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public User findById(long userId) {
        return userRepository.findById(userId);
    }


/*
    ini untuk excel upload from DB
*/

    @Override
    public void saveUsersToDatabase(MultipartFile file) {
        if (UserUploadService.isValidExcelFile(file)) {
            try {
                List<User> users = UserUploadService.getUsersDataFromExcel(file.getInputStream());
                this.userRepository.saveAll(users);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file", e);
            }
        } else {
            throw new IllegalArgumentException("The file is not a valid excel file");
        }
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }


/*
    ini untuk Download Excel from DB
*/

    @Override
    public boolean isValidExcelFile(MultipartFile file) {
        return file.getOriginalFilename().endsWith(".xls") || file.getOriginalFilename().endsWith(".xlsx");
    }

    @Override
    public List<User> getUsersDataFromExcel(InputStream inputStream) {
        List<User> users = new ArrayList<>();
        try {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue; // skip the header row
                }
                User user = new User();
                user.setUsername(row.getCell(0).getStringCellValue());
                user.setAlamat(row.getCell(1).getStringCellValue());
                user.setEmail(row.getCell(2).getStringCellValue());
                user.setTelepon(row.getCell(2).getStringCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
//
//
//    @Override
//    public boolean isValidExcelFile(MultipartFile file) {
//        return file.getOriginalFilename().endsWith(".xls") || file.getOriginalFilename().endsWith(".xlsx");
//    }
//
//    @Override
//    public List<User> getUsersDataFromExcel(InputStream inputStream) {
//        List<User> users = new ArrayList<>();
//        try {
//            Workbook workbook = WorkbookFactory.create(inputStream);
//            Sheet sheet = workbook.getSheetAt(0);
//            for (Row row : sheet) {
//                if (row.getRowNum() == 0) {
//                    continue; // skip the header row
//                }
//                User user = new User();
//                user.setUsername(row.getCell(0).getStringCellValue());
//                user.setAlamat(row.getCell(1).getStringCellValue());
//                user.setEmail(row.getCell(2).getStringCellValue());
//                user.setTelepon(row.getCell(2).getStringCellValue());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return users;
//    }




//
//
//    @Override
//    public void saveUsersToDatabase(MultipartFile file) {
//        if (isValidExcelFile(file)) {
//            try {
//                List<User> users = getUsersDataFromExcel(file.getInputStream());
//                this.userRepository.saveAll(users);
//            } catch (IOException e) {
//                throw new IllegalArgumentException("The file is not a valid excel file");
//            }
//        }
//    }
//
//    @Override
//    public List<User> getUsers() {
//        return userRepository.findAll();
//    }
//
//    public static boolean isValidExcelFile(MultipartFile file) {
//        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//    }
//
//    public static List<User> getUsersDataFromExcel(InputStream inputStream) {
//        List<User> users = new ArrayList<>();
//
//        try (XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
//            XSSFSheet sheet = workbook.getSheet("customers");
//
//            int rowIndex = 0;
//            for (Row row : sheet) {
//                if (rowIndex == 0) {
//                    rowIndex++;
//                    continue;
//                }
//                Iterator<Cell> cellIterator = row.iterator();
//                int cellIndex = 0;
//                User customer = new User();
//                while (cellIterator.hasNext()) {
//                    Cell cell = cellIterator.next();
//                    switch (cellIndex) {
//                        case 0 -> customer.setId((long) cell.getNumericCellValue());
//                        case 1 -> customer.setUsername(cell.getStringCellValue());
//                        case 2 -> customer.setAlamat(cell.getStringCellValue());
//                        case 3 -> customer.setEmail(cell.getStringCellValue());
//                        case 4 -> customer.setTelepon(cell.getStringCellValue());
//                        default -> {
//                        }
//                    }
//                    cellIndex++;
//                }
//                customers.add(customer);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return customers;
//    }
//







}












//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    public User getUserById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//
//    public User updateUser(Long id, User user) {
//        userRepository.save(user);
//        return user;
//    }
//
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    public User createUser(User user) {
//        userRepository.save(user);
//        return user;
//    }


