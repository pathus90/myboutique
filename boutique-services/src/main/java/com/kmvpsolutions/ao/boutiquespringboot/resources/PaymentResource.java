package com.kmvpsolutions.ao.boutiquespringboot.resources;

import com.kmvpsolutions.ao.boutiquespringboot.commons.dtos.PaymentDTO;
import com.kmvpsolutions.ao.boutiquespringboot.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kmvpsolutions.ao.boutiquespringboot.commons.utilities.Web.API;

@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/payments")
public class PaymentResource {

    private final PaymentService paymentService;

    @GetMapping
    public List<PaymentDTO> listAll() {
        return this.paymentService.findAll();
    }

    @GetMapping("/{id}")
    public PaymentDTO findById(@PathVariable Long id) {
        return this.paymentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.paymentService.delete(id);
    }

    @PostMapping
    public PaymentDTO create(PaymentDTO paymentDTO) {
        return this.paymentService.create(paymentDTO);
    }
}
