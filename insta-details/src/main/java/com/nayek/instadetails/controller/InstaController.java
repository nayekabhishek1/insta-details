package com.nayek.instadetails.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nayek.instadetails.model.User;

@Controller
@RequestMapping("/insta-app")
public class InstaController {

	private static final String username = "<your instagram username>";
	private static final String password = "<your password>";

	@GetMapping("/home")
	public ModelAndView showHomePage() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("user", new User());
		return mav;
	}

	@PostMapping("/user")
	public ModelAndView showUserDetails(@ModelAttribute User user) throws ClientProtocolException, IOException {

		ModelAndView mav = new ModelAndView("details");

		// Login to instagram
		Instagram4j instagram = Instagram4j.builder().username(username).password(password).build();
		instagram.setup();
		instagram.login();

		// search user by instagram handle
		InstagramSearchUsernameResult userResult = instagram
				.sendRequest(new InstagramSearchUsernameRequest(user.getUsername()));

		User u = new User();
		u.setUsername(user.getUsername());
		u.setId(userResult.getUser().getPk());
		u.setEmail(userResult.getUser().getPublic_email());
		u.setBio(userResult.getUser().getBiography());
		u.setUrl(userResult.getUser().getProfile_pic_url());
		u.setBusinessContact(userResult.getUser().getBusiness_contact_method());
		u.setFollowersCount(userResult.getUser().getFollower_count());
		u.setFollowingCount(userResult.getUser().getFollowing_count());

		mav.addObject("user", u);
		return mav;

	}

}
