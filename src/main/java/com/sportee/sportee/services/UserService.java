package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.User;
import com.sportee.sportee.data.DTO.UserDTO;
import com.sportee.sportee.data.repositories.MemberRepository;
import com.sportee.sportee.data.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;

@Service("iUserService")
@AllArgsConstructor
public class UserService implements IUserService {

    private UserRepository userRepository;
    private MemberRepository memberRepository;
//    private JavaMailSender javaMailSender;


    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<UserDTO>();
        Iterable<User> all = userRepository.findAll();
        all.forEach(u -> users.add(new UserDTO(u)));
        return users;
    }

//    @Override
//    public void sendMail(Integer userId, String subject, String content) {
//        Optional<User> user = userRepository.findById(userId);
//        user.ifPresent(u -> {
//            SimpleMailMessage mail = new SimpleMailMessage();
//            mail.setTo(u.getEmail());
//            mail.setFrom("ralured1979@gmail.com");
//            mail.setSubject(subject);
//            mail.setText(content);
//            javaMailSender.send(mail);
//        });
//    }

    @Override
    public void modifyUser(Integer id, Optional<String> name, Optional<String> password) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(u -> {
            name.ifPresent(n -> u.setUserName(n));
            password.ifPresent(e -> u.setPassword(e));
            userRepository.save(u);
        });
    }

    @Override
    public void insertUser(String name, String password) {

        User user = User.builder().userName(name).password(password).build();
        userRepository.save(user);


    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

//    @Override
//    public void changeAddress(Integer userId, Optional<String> city, Optional<String> country, Optional<String> street) {
//        Optional<User> user = userRepository.findById(userId);
//        user.ifPresent(u -> {
//            Address address = getUserAddress(u);
//            city.ifPresent(c -> address.setCity(c));
//            country.ifPresent(c -> address.setCountry(c));
//            street.ifPresent(s -> address.setStreet(s));
//            Address updatedAddress = addressRepository.save(address);
//            u.setAddress(updatedAddress);
//            userRepository.save(u);
//        });
//
//    }

//    @Override
//    public String getServiceTitle(Integer id) throws NotFoundException {
//
//        Optional<User> user = userRepository.findById(id);
//        if (user.isPresent()) {
//            User u = user.get();
//            RestTemplate template = new RestTemplate();
//            String url = "https://jsonplaceholder.typicode.com/todos/" + u.getId();
//            String response = template.getForObject(url, String.class);
//
//            try {
//                ObjectMapper mapper = new ObjectMapper();
//                JsonNode root = mapper.readTree(response);
//                return root.path("title").asText();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//       throw new NotFoundException();
//    }

//    private Address getUserAddress(User u) {
//        Address address = u.getAddress();
//        if (address == null) {
//            address = new Address();
//            address.setUser(u);
//        }
//        return address;
//    }

    public String getUserName (Integer userId) throws NotFoundException{
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User u = user.get();
            return u.getUserName();
        }
        throw new NotFoundException();
    }

}