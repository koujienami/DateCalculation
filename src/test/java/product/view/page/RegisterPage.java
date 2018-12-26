package product.view.page;

import com.codeborne.selenide.Selenide;

public class RegisterPage {

	private static final String URL = "http://localhost:8090/register";

	public static RegisterPage open() {
		return Selenide.open(URL, RegisterPage.class);
	}

	public String title() {
		return Selenide.title();
	}

}
