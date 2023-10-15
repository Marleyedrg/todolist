package com.marley.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.marley.todolist.user.IUserRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                var servletPath = request.getServletPath();

                if(servletPath.startsWith("/tasks/")){
                //take authorization (user and password)
                    var authorization = request.getHeader("Authorization");

                    var authEncoded = authorization.substring("Basic".length()).trim();
                //takes size from the word and remove, that is, it excludes the word and then removes white spaces.
                    byte[] authDecode = Base64.getDecoder().decode(authEncoded);

                    var authString = new String(authDecode);

                    String[] credential = authString.split(":");
                    String username = credential[0];
                    String password = credential[1];
                //user validate 
                        var validateCurrUser = this.userRepository.findByUsername(username);
                        if(validateCurrUser == null){
                            response.sendError(401);
                        }else{
                        //validate password
                            var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(),validateCurrUser.getPassword());

                            if(passwordVerify.verified){
                                //continue
                                request.setAttribute("idUser", validateCurrUser.getId());
                                filterChain.doFilter(request, response);
                            }else{
                                response.sendError(401);
                            }
                        }
                }else{
                    filterChain.doFilter(request, response);
                }
            } 
}
