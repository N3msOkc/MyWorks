package com.nems.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nems.socialmedia.models.Profile;
@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer>{

}
