package com.example.community.controller;

import com.example.community.dto.AccessTokenDTO;
import com.example.community.dto.GithubUser;
import com.example.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Value;
>>>>>>> immplent github login
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shkstart
 * @create 2020-09-18 14:46
 */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

<<<<<<< HEAD
=======
    @Value("#{github.client_id}")
    private String client_id;

    @Value("#{github.client_secret}")
    private String client_secret;

    @Value("#{github.redirectUri}")
    private String redirectUri;

>>>>>>> immplent github login
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code")String code,
                           @RequestParam(name="state")String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
<<<<<<< HEAD
        accessTokenDTO.setClient_id("5eb88998127cb0628cba");
        accessTokenDTO.setClient_secret("c7f8d3ec236a13c8c8d4faab84364cde88e2b7a2");
=======
        accessTokenDTO.setClient_id("client_id");
        accessTokenDTO.setClient_secret("client_secret");
>>>>>>> immplent github login
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);

<<<<<<< HEAD
        System.out.println(user);
=======
        //System.out.println(user);
>>>>>>> immplent github login
        return "index";
    }
}
