package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.ProfileInterest;
import com.example.MatrimonyManagement.exception.DataBaseException;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.ProfileInterestRespository;
import com.example.MatrimonyManagement.service.ProfileInterestService;

@Service
public class ProfileInterestIMPL implements ProfileInterestService {

    @Autowired
    private ProfileInterestRespository profileInterestRespository;

    @Override
    public ProfileInterest saveProfileInterest(ProfileInterest profileInterest) {

        try {

            return profileInterestRespository.save(profileInterest);

        } catch (Exception e) {

            throw new DataBaseException("Failed to save profile interest due to database error");
        }
    }

    @Override
    public List<ProfileInterest> getAllProfileInterest() {

        try {

            return profileInterestRespository.findAll();

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch profile interests due to database error");
        }
    }

    @Override
    public ProfileInterest gertProfileInterestById(int id) {

        try {

            return profileInterestRespository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Profile interest not found with id " + id));

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch profile interest due to database error");
        }
    }

    @Override
    public void deleteProfileInterestById(int id) {

        try {

            ProfileInterest profileInterest = profileInterestRespository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Profile interest not found with id " + id));

            profileInterestRespository.delete(profileInterest);

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to delete profile interest due to database error");
        }
    }

}