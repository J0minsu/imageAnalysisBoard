package io.lunit.exam.Service;

import io.lunit.exam.Domain.Slide;
import io.lunit.exam.Repository.SlideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlideServiceImpl implements SlideService{

    @Autowired
    SlideRepository repository;

    @Override
    public void save(Slide slide) {
        repository.save(slide);
    }
}
