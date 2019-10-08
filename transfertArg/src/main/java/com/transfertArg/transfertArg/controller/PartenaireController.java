
package com.transfertArg.transfertArg.controller;
import com.transfertArg.transfertArg.model.*;
import com.transfertArg.transfertArg.repository.CompteRepository;
import com.transfertArg.transfertArg.repository.PartenaireRepository;
import com.transfertArg.transfertArg.repository.RoleRepository;
import com.transfertArg.transfertArg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user")
public class PartenaireController {

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;



    /******************************************************************************/
    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> liste(){
        return userRepository.findAll();
    }
    /******************************************************************************/
    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User add(@RequestBody(required = false) User s){
        s.setPassword(encoder.encode(s.getPassword()));
        return userRepository.save(s);
    }
    /********************************Ajout partenaire*****************************************/
    @Autowired
    private PartenaireRepository partenaireRepository;
    @PostMapping(value = "/addP",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Partenaire add(@RequestBody(required = false) Partenaire s){
        s.getComptes().get(0).setPartenaire(s);
        s.getUsers().get(0).setPassword(encoder.encode(s.getUsers().get(0).getPassword()));
        s.getUsers().get(0).setPartenaire(s);
        return partenaireRepository.save(s);
    }

    /********************************Ajout compte*****************************************/
    @Autowired
    private CompteRepository compteRepository;
    @PostMapping(value = "/addC",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Compte add(@RequestBody(required = false) Compte c){
        return compteRepository.save(c);}
    /////////////////////////////////////////////////////////////////////////////
    @Autowired
    private CompteRepository cptRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PartenaireRepository partRepository;
    @Autowired
    private UserRepository uRepository;
    @PostMapping(value = "/addpar",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void run(@RequestBody PartenaireAt partenaireAt) throws Exception {

        /***************************************************/
        Partenaire partenaire = new Partenaire();
        partenaire.setAdresse(partenaireAt.getAdresse());
        partenaire.setEmailP(partenaireAt.getEmailP());
        partenaire.setNinea(partenaireAt.getNinea());
        partenaire.setNom_entreprise(partenaireAt.getNom_entreprise());
        partenaire.setTel(partenaireAt.getTel());

        partRepository.save(partenaire);
        /**************************************/
        User user = new User();
        user.setEmail(partenaireAt.getEmail());
        user.setName(partenaireAt.getName());
        user.setPassword(encoder.encode(partenaireAt.getPassword()));
        user.setUsername(partenaireAt.getUsername());
        user.setPartenaire(partenaire);
        Role userRole = roleRepository.findByName(RoleName.ROLE_PARTENAIRE)
                .orElseThrow(() -> new ApplicationContextException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        uRepository.save(user);

        /**************************************/
        Compte compte = new Compte();
        compte.setNum_compte(partenaireAt.getNum_compte());
        compte.setSolde(partenaireAt.getSolde());
        /**Link des 3 tables*/
        compte.setPartenaire(partenaire);
        cptRepository.save(compte);
    }
}