package se.thinkcode.memory.steps.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import se.thinkcode.memory.Main;
import se.thinkcode.memory.notes.Note;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class BrowserNoteHelper implements NoteHelperImplementation {
    private WebDriver browser;

    BrowserNoteHelper() {
        URL url = getClass().getResource("/geckodriver");
        String geckoDriverPath = url.getFile();
        System.setProperty("webdriver.gecko.driver", geckoDriverPath);
        browser = new FirefoxDriver();

        Main.main();

        browser.get("http://localhost:4567");
    }

    @Override
    public void addNote(String user, String note) {
        System.out.println();
        WebElement userNameField = browser.findElement(By.id("userName"));
        userNameField.sendKeys(user);

        WebElement noteField = browser.findElement(By.id("noteField"));
        noteField.sendKeys(note);
    }

    @Override
    public void save() {
        // not done explicit in the web application
    }

    @Override
    public List<Note> getNotes(String currentUser) {
        WebElement notesField = browser.findElement(By.id("notes"));

        String text = notesField.getText();
        Note note = new Note(text);

        List<Note> notes = new ArrayList<>();
        notes.add(note);

        return notes;
    }

    @Override
    public void clean() {
        browser.quit();
    }
}