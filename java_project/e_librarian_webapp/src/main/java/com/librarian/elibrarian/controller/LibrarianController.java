package com.librarian.elibrarian.controller;

import com.librarian.elibrarian.dao.LibrarianDao;
import com.librarian.elibrarian.model.Librarian;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/Librarian")
public class LibrarianController {

    @GetMapping("AddLibrarian")
    public String addLibrarianPage(@RequestParam(value = "status", required = false) String status, Model model) {
        if (status != null) {
            if (status.equals("true")) {
                model.addAttribute("successStatus", true);
            } else {
                model.addAttribute("failStatus", "Created librarian failed.");
            }
        }

        return "add-librarian";
    }

    @PostMapping("AddLibrarian")
    public String createLibrarian(@RequestParam("librarian_name") String librarianName,
                                  @RequestParam("librarian_email") String librarianEmail,
                                  @RequestParam("librarian_password") String librarianPassword,
                                  @RequestParam("librarian_phone") String librarianPhone,
                                  RedirectAttributes redirectAttributes) {

        Librarian librarian = new Librarian(librarianName, librarianEmail, librarianPassword, librarianPhone);

        int saveStatus = LibrarianDao.save(librarian);
        redirectAttributes.addAttribute("status", (saveStatus > 0));

        return "redirect:/Librarian/AddLibrarian";
    }

    @GetMapping("ViewLibrarian")
    public String viewLibrarianPage(@RequestParam(value = "status", required = false) String status, Model model) {

        if (status != null) {
            switch (status) {
                case "true" -> model.addAttribute("successStatus", "Delete librarian success.");
                case "updateSuccess" -> model.addAttribute("successStatus", "Librarian update success.");
                case "updateFailed" -> model.addAttribute("failStatus", "Librarian updated failed.");
                default -> model.addAttribute("failStatus", "Delete librarian failed.");
            }
        }

        List<Librarian> librarianList = LibrarianDao.view();
        if (librarianList != null & !librarianList.isEmpty()) {
            model.addAttribute("librarians", librarianList);
        } else {
            model.addAttribute("librarians", null);
        }

        return "view-librarian";
    }

    @GetMapping("EditLibrarian")
    public String editLibrarianPage(@RequestParam("id") int libId, Model model) {

        Librarian librarian = LibrarianDao.viewById(libId);
        if (librarian != null) {
            model.addAttribute("librarian", librarian);
            return "edit-librarian";
        } else {
            return "redirect:/Librarian/ViewLibrarian";
        }
    }

    @PostMapping("EditLibrarian")
    public String editLibrarian(@ModelAttribute Librarian librarian, RedirectAttributes redirectAttributes) {
        int updated = LibrarianDao.update(librarian);

        if (updated > 0) {
            redirectAttributes.addAttribute("status", "updateSuccess");
        } else {
            redirectAttributes.addAttribute("status", "updateFailed");
        }

        // 3. Redirect to the view page after update
        return "redirect:/Librarian/ViewLibrarian";
    }

    @GetMapping("DeleteLibrarian")
    public String deleteLibrarian(@RequestParam("id") String id, RedirectAttributes redirectAttributes) {
        int lib_id = Integer.parseInt(id);

        int status = LibrarianDao.delete(lib_id);
        redirectAttributes.addAttribute("status", (status > 0));

        return "redirect:/Librarian/ViewLibrarian";
    }
}
