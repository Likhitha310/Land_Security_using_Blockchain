package com.mit.project.service;


import com.mit.project.model.AdministratorDetails;
import com.mit.project.repository.AdministratorDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorDetailsService {

    @Autowired
    private AdministratorDetailsRepository administratorDetailsRepository;

    @Autowired
    private ContractService service;

    public List<AdministratorDetails> getAllDetails(){
        return administratorDetailsRepository.findAll();
    }

    public AdministratorDetails getAdministratorDetails(long id){
        return administratorDetailsRepository.findById(id).get();
    }

    public void addAdministratorDetails(AdministratorDetails administratorDetails){
        administratorDetails=administratorDetailsRepository.save(administratorDetails);
        administratorDetailsRepository.flush();
        try {
            if(administratorDetails.getRole()=="Tahsildar"){
                service.addTahsildar(administratorDetails.getSystemAddress(),administratorDetails.getId());
                System.out.println("Tahsildar is created");
            }
            else if (administratorDetails.getRole()== "templates/Registrar"){
                service.addRegistrar(administratorDetails.getSystemAddress(),administratorDetails.getId());
                System.out.println("Registrar is created");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAdministratorDetails(long id, AdministratorDetails AdministratorDetails){
        administratorDetailsRepository.save(AdministratorDetails);
    }

    public void deleteAdministratorDetails(long id){
        administratorDetailsRepository.deleteById(id);
    }

    //login
    public AdministratorDetails login(String username,String password){
        return administratorDetailsRepository.findByUsernameAndPassword(username,password);
    }

    //filters role and username
    public List<AdministratorDetails> findByRole(String role) {
        return administratorDetailsRepository.findByRole(role);
    }

    public List<AdministratorDetails> findByUsername(String username){
        return administratorDetailsRepository.findByUsername(username);
    }

    public List<AdministratorDetails> findByUsernameAndRole(String username, String role){
        return administratorDetailsRepository.findByUsernameAndRole(username,role);
    }

    //SystemAddress
    public String getSystemAddress(long id){
        return administratorDetailsRepository.findById(id).get().getSystemAddress();
    }
}
