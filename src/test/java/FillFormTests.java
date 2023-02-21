import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Test");
        $("#lastName").setValue("Testovich");
        $("#userEmail").setValue("test@mail.com");
        $("#gender-radio-3").parent().click();
        $("#userNumber").setValue("9999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("November")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1999")).click();
        $(".react-datepicker__month").$(byText("22")).click();
        $("#subjectsInput").setValue("Donec vel vestibulum neque. Mauris pretium purus nunc, vitae aliquam ex scelerisque quis.ementum libero.");
        $("#hobbies-checkbox-2").parent().click();
//        $("#uploadPicture").uploadFromClasspath("images/photo.jpg");
        $("#currentAddress").setValue("Aliquam id auctor risus. Sed sit amet venenatis risus, rutrum lobortis erat.");
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Test Testovich"));
        $(".modal-body").shouldHave(text("test@mail.com"));
        $(".modal-body").shouldHave(text("Other"));
        $(".modal-body").shouldHave(text("9999999999"));
        $(".modal-body").shouldHave(text("22 November,1999"));
        $(".modal-body").shouldHave(text("Donec vel vestibulum neque. Mauris pretium purus nunc, vitae aliquam ex scelerisque quis.ementum libero."));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave(text("photo.jpg"));
        $(".modal-body").shouldHave(text("Aliquam id auctor risus. Sed sit amet venenatis risus, rutrum lobortis erat."));
        $(".modal-body").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();

    }
}
