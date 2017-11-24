package controller;

import java.util.HashMap;
import java.util.Map.Entry;

import model.User;
import view.View;

public class RegisterController {
	
	public static boolean validatePassword(String password, String passwordConfirm)
	{
		if (password.equals(passwordConfirm))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void create(HashMap<String,String> params)
	{
		User user = new User(params);
		if (user.save())
		{
			View.redirectTo("HOME");
			View.flash(View.FLASHINFO, "register completed! Please Login");
		}
		else
		{
			View.flash(View.FLASHINFO, user.error);
		}
	}
	
	public static void register(HashMap<String, String> params)
	{
		if (validatePassword(params.get("password"), params.get("passwordConfirm")))
		{
			params.remove("passwordConfirm");
			create(params);
		}
		else
		{
			View.flash(View.FLASHERROR, "Password not same");
		}
	}

}
