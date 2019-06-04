package com.kmvpsolutions.ao.boutiquespringboot.resources;

import com.kmvpsolutions.ao.boutiquespringboot.commons.dtos.ReviewDTO;
import com.kmvpsolutions.ao.boutiquespringboot.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kmvpsolutions.ao.boutiquespringboot.commons.utilities.Web.API;

@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/reviews")
public class ReviewResource {

    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDTO> listAll() {
        return this.reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDTO findById(@PathVariable Long id) {
        return this.reviewService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.reviewService.delete(id);
    }

    @PostMapping
    public ReviewDTO create(ReviewDTO reviewDTO) {
        return this.reviewService.create(reviewDTO);
    }
}
