/*
package at.spengergasse.fhirstarter.controller;


import at.spengergasse.fhirstarter.entity.At1PLF;
import at.spengergasse.fhirstarter.entity.Patient;
import at.spengergasse.fhirstarter.repository.At1PLFRepository;
import at.spengergasse.fhirstarter.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class At1PLFController {
    @Autowired
    At1PLFRepository at1PLFRepository;

    @GetMapping("/at1plf")
    public Iterable<At1PLF> getAllAt1PLF()
    {
        return at1PLFRepository.findAll();
    }

    @GetMapping("/at1plf/{id}")
    Optional<At1PLF> ReturnAt1PLFById(@PathVariable String id){
        return at1PLFRepository.findById(id);
    }

    @PostMapping("/addat1plf")
    At1PLF AddAt1PLF(@RequestParam At1PLF at1PLF ){
        at1PLFRepository.save(at1PLF);
        return at1PLF;
    }

    @PutMapping("/updateat1plf/{id}")
        At1PLF UpdateAt1PLF(@PathVariable String id, @RequestParam At1PLF at1PLFPar){
            Optional<At1PLF> at1plfOpt =  at1PLFRepository.findById(id);

            if(at1plfOpt != null){
                at1PLFRepository.deleteById(id);
                at1PLFRepository.save(at1PLFPar);
                return at1PLFPar;
        }else{
                return null;
            }
    }

    @DeleteMapping("/deleteat1plf/{id}")
    At1PLF DeleteAt1PLF(@PathVariable String id){
        Optional<At1PLF> at1PLFOpt = at1PLFRepository.findById(id);
        at1PLFRepository.deleteById(id);
        return at1PLFOpt.get();
    }
}
*/
