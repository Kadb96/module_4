package com.codegym.phonemanagementajaxwebservice.repository;

import com.codegym.phonemanagementajaxwebservice.model.Smartphone;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ISmartphoneRepository extends PagingAndSortingRepository<Smartphone, Long> {
}
