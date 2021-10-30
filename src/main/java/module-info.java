module com.example.aventurasdemarcoyluis {
    requires javafx.controls;
    requires javafx.fxml;


    exports AventurasdeMarcosyLuis.Characters.Heroes;
    opens AventurasdeMarcosyLuis.Characters.Heroes to javafx.fxml;
    exports AventurasdeMarcosyLuis.Characters.Wicked;
    opens AventurasdeMarcosyLuis.Characters.Wicked to javafx.fxml;
    exports AventurasdeMarcosyLuis.Characters;
    opens AventurasdeMarcosyLuis.Characters to javafx.fxml;
    exports AventurasdeMarcosyLuis.Items;
    opens AventurasdeMarcosyLuis.Items to javafx.fxml;
}