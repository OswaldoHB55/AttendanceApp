package org.esfe.controladores;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String index(Model model){
        // Obtener la autenticación actual
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Verificar si el usuario está autenticado
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            String username;

            // Si el principal es una instancia de UserDetails, obtenemos el nombre de usuario
            if (principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            } else {
                // Si no, simplemente obtenemos el nombre
                username = principal.toString();
            }

            // Pasar el nombre de usuario al modelo
            model.addAttribute("username", username);
        } else {
            model.addAttribute("username", "invitado"); // Si no está autenticado
        }
        return "home/index";
    }
}
