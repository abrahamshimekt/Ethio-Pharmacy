// package com.EthioPharmacy.EthioPharmacy.controllers;


// import com.EthioPharmacy.EthioPharmacy.models.Catagory;
// import com.EthioPharmacy.EthioPharmacy.models.Medicine;
// import com.EthioPharmacy.EthioPharmacy.repository.CatagoryRepository;
// import com.EthioPharmacy.EthioPharmacy.repository.MedicineRepository;
// import com.EthioPharmacy.EthioPharmacy.service.MedicineService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.util.StringUtils;
// import org.springframework.validation.Errors;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.ModelAndView;

// import javax.validation.Valid;
// import java.io.IOException;
// import java.util.Base64;
// import java.util.Optional;


// @Controller
// @RequestMapping(value="/")
// public class AdminDashBoardController {

//     @Autowired
//     private MedicineRepository medicineRepository;

//     @Autowired
//     private CatagoryRepository catagoryRepository;


//     @Autowired
//     private MedicineService medicineService;


//     @GetMapping("/admindashboard")
//     public String displayAdminDashBoard(Model model) {
//         model.addAttribute("title", "DashBoard");
//         model.addAttribute("medicines", medicineRepository.findAll());
//         model.addAttribute("catagories", catagoryRepository.findAll());
//         return "meds/admindashboard";
//     }



//     @GetMapping(path = "/add")
//     public String displayAddForm(Model model) {

//         model.addAttribute("catagories", catagoryRepository.findAll());
//         model.addAttribute("title", "Add Medicine");
//         model.addAttribute(  new Medicine());
//         model.addAttribute("catagories", catagoryRepository.findAll());
//         return "meds/addmedform";
//     }

//     @PostMapping("/add")
//     public String processAddForm(@ModelAttribute   Medicine newMed, Errors errors, Model model,
//                                  @RequestParam int catagoryId,

//                                  @RequestParam("file") MultipartFile file){
//         if(errors.hasErrors()) {
//             model.addAttribute("title", "Add Medicine");
//             model.addAttribute("catagories", catagoryRepository.findAll());
//             return "meds/addMedForm";
//         }

//         String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//         if (fileName.contains("...")) {
//             System.out.println("not a valid file");
//         }

//         Optional<Catagory> newCat = catagoryRepository.findById(catagoryId);
//         Catagory cat = newCat.get();
//         newMed.setCatagory(cat);
//         try {
//             newMed.setMedImage(Base64.getEncoder().encodeToString(file.getBytes()));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         medicineRepository.save(newMed);
//         return "redirect:/admindashboard";
//     }

//     @GetMapping("/addedProduct")
//     public String showAddedProducts(Model model) {
//         model.addAttribute("medicines", medicineRepository.findAll());
//         model.addAttribute("selected" , new Medicine());
//         model.addAttribute("catagories", catagoryRepository.findAll());

//         return "admindashboard";
//     }



//     @PostMapping("/admindashboard")
//     public String processRemovedProduct(  @RequestParam int[] medIds) {
//         for(int medId : medIds) {
//             medicineRepository.deleteById(medId);
//         }
//         return "redirect:admindashboard";
//     }


//     @GetMapping("/update{id}")
//     public String displayUpdate(@PathVariable(name = "id") int id, Model model ) {
//         Medicine update = medicineRepository.findById(id).get();
//         Medicine newMed = new Medicine();
//         newMed.setId(update.getId());
//         newMed.setMedName(update.getMedName());
//         newMed.setMedPrice(update.getMedPrice());
//         newMed.setMedDescription(update.getMedDescription());
//         model.addAttribute("catagories", catagoryRepository.findAll());
//         model.addAttribute("medicine", newMed);
//         return "meds/update";
//     }


//     @PostMapping("/update")
//     public String processUpdate( @ModelAttribute("medicine") Medicine newMed,
//                                  @RequestParam(name = "id") int id,
//                                  @RequestParam int catagoryId,
//                                  @RequestParam("file") MultipartFile file) {

//         String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//         if (fileName.contains("...")) {
//             System.out.println("not a valid file");
//         }

//         try {
//             newMed.setMedImage(Base64.getEncoder().encodeToString(file.getBytes()));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         Optional<Catagory> newCat = catagoryRepository.findById(catagoryId);
//         Catagory cat = newCat.get();
//         newMed.setCatagory(cat);



//         Medicine update = medicineRepository.findById(id).get();
//         update.setId(newMed.getId());
//         update.setMedName(newMed.getMedName());
//         update.setMedPrice(newMed.getMedPrice());
//         update.setMedDescription(newMed.getMedDescription());
//         update.setCatagory(newMed.getCatagory());
//         update.setMedImage(newMed.getMedImage());
//         medicineRepository.save(update);
//         return "redirect:admindashboard";


//     }



// }

package com.EthioPharmacy.EthioPharmacy.controllers;


import com.EthioPharmacy.EthioPharmacy.models.Catagory;
import com.EthioPharmacy.EthioPharmacy.models.Medicine;
import com.EthioPharmacy.EthioPharmacy.repository.CatagoryRepository;
import com.EthioPharmacy.EthioPharmacy.repository.MedicineRepository;
import com.EthioPharmacy.EthioPharmacy.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;


@Controller
@RequestMapping(value="/")
public class AdminDashBoardController {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private CatagoryRepository catagoryRepository;


    @GetMapping("/admindashboard")
    public String displayAdminDashBoard(Model model) {
        model.addAttribute("title", "DashBoard");
        model.addAttribute("medicines", medicineRepository.findAll());
        model.addAttribute("catagories", catagoryRepository.findAll());
        return "meds/admindashboard";
    }



    @GetMapping(path = "/add")
    public String displayAddForm(Model model) {

        model.addAttribute("catagories", catagoryRepository.findAll());
        model.addAttribute("title", "Add Medicine");
        model.addAttribute(  new Medicine());
        model.addAttribute("catagories", catagoryRepository.findAll());
        return "meds/addmedform";
    }

    @PostMapping("/add")
    public String processAddForm(@Valid @ModelAttribute Medicine newMed, Errors errors, Model model,
                                 @RequestParam int catagoryId,

                                 @RequestParam("file") MultipartFile file){
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Medicine");
            model.addAttribute("catagories", catagoryRepository.findAll());
            return "meds/addMedForm";
        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("...")) {
            System.out.println("not a valid file");
        }

        Optional<Catagory> newCat = catagoryRepository.findById(catagoryId);
        Catagory cat = newCat.get();
        newMed.setCatagory(cat);
        try {
            newMed.setMedImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        medicineRepository.save(newMed);
        return "redirect:/admindashboard";
    }

    @GetMapping("/addedProduct")
    public String showAddedProducts(Model model) {
        model.addAttribute("medicines", medicineRepository.findAll());
        model.addAttribute("selected" , new Medicine());
        model.addAttribute("catagories", catagoryRepository.findAll());

        return "admindashboard";
    }



    @PostMapping("/admindashboard")
    public String processRemovedProduct(  @RequestParam int[] medIds) {
        for(int medId : medIds) {
            medicineRepository.deleteById(medId);
        }
        return "redirect:admindashboard";
    }


    @GetMapping("/update{id}")
    public String displayUpdate(@PathVariable(name = "id") int id, Model model ) {
        Medicine update = medicineRepository.findById(id).get();
        Medicine newMed = new Medicine();
        newMed.setId(update.getId());
        newMed.setMedName(update.getMedName());
        newMed.setMedPrice(update.getMedPrice());
        newMed.setMedDescription(update.getMedDescription());
        model.addAttribute("catagories", catagoryRepository.findAll());
        model.addAttribute("medicine", newMed);
        return "meds/update";
    }
@PostMapping("/update")
    public String processUpdate( @ModelAttribute("medicine") Medicine newMed,
                                 @RequestParam(name = "id") int id,
                                 @RequestParam int catagoryId,
                                 @RequestParam("file") MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("...")) {
            System.out.println("not a valid file");
        }

        try {
            newMed.setMedImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Optional<Catagory> newCat = catagoryRepository.findById(catagoryId);
        Catagory cat = newCat.get();
        newMed.setCatagory(cat);



        Medicine update = medicineRepository.findById(id).get();
        update.setId(newMed.getId());
        update.setMedName(newMed.getMedName());
        update.setMedPrice(newMed.getMedPrice());
        update.setMedDescription(newMed.getMedDescription());
        update.setCatagory(newMed.getCatagory());
        update.setMedImage(newMed.getMedImage());
        medicineRepository.save(update);
        return "redirect:admindashboard";


    }



}
