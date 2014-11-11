package logic;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Controller {
	private Gson gson;
	private UserInfo userInfo;

	public void userInfoGet(){
		
		gson = new GsonBuilder().create();
		userInfo = new UserInfo();
				
				userInfo.setAuthUserEmail(email);
				userInfo.setAuthUserPassword(password);
				userInfo.setAuthUserIsAdmin(false);
				String gsonString = gson.toJson(userInfo);
		
	}

	
}
