/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto2_web.repositorio;

import Reto2_web.interfaces.InterfaceUser;
import Reto2_web.modelo.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * User Repositorio
 * @author laura
 * Diciembre 2021
 */
@Repository
public class UserRepositorio {
    @Autowired
    private InterfaceUser userCrudRepository;
     
    /**
     * Retorna lista de usuarios
     * @return 
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    
    /**
     * Retorna id
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    /**
     * Se crea un usuario
     * @param user
     * @return 
     */
    public User create(User user) {
        return userCrudRepository.save(user);
    }
    /**
     * Se actualiza usuario
     * @param user 
     */
    public void update(User user) {
        userCrudRepository.save(user);
    }
    /**
     * Se elimina usuario
     * @param user 
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }
    /**
     * Se registra email
     * @param email
     * @return 
     */
    public boolean emailExists(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    /**
     * Auteticar email
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    /**
     * Registrar fehca de cumpleaños
     * @param month
     * @return 
     */
    public List<User> getByMonthBirthDay(String month){
        return userCrudRepository.findByMonthBirthtDay(month);
    }
    
}
