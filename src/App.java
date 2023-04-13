import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    
    Stage window;
    Scene homeScene, libraryScene, lendScene, favoritesScene, wishScene;

    TableView<Book> table;
    TableView<Library> rentTable;
    TableView<Lend> lendTable;
    TableView<Favorite> favoritesTable;
    TableView<Wish> wishTable;

    TextField 
        titleInput, authorInput, genreInput, yearInput, ratingInput, seriesInput, //homeScene textfields
        rentTitleInput, rentAuthorInput, rentedInput, dueInput, //libraryScene textfields
        lendTitleInput, personInput, lendedInput, lendDueInput, //lendScene textfields
        favoritesTitleInput, favoritesAuthorInput, favoritesGenreInput, favoritesYearInput, favoritesSeriesInput, //favoritesScene textfields
        wishTitleInput, wishAuthorInput, costInput, wishSeriesInput; //wishScene textfields


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
            window = primaryStage;
            window.setTitle("LibTracker");

            window.setOnCloseRequest(e -> {
                e.consume();
                closeProgram();
            });


            //Home Scene


            //Home Menu
            Menu pageMenu = new Menu("Page"); //Page Menu

            // Page Menu Items
            MenuItem home = new MenuItem("Home"); //Home Item
            home.setDisable(true);

            MenuItem library = new MenuItem("Library List"); //Library List Item
            library.setOnAction(e -> window.setScene(libraryScene));

            MenuItem lend = new MenuItem("Lend List"); //Lend List Item
            lend.setOnAction(e -> window.setScene(lendScene));

            MenuItem exit = new MenuItem("Exit"); //Exit Item
            exit.setOnAction(e -> closeProgram());

            pageMenu.getItems().addAll(home, library, lend, new SeparatorMenuItem(),exit);


            Menu listMenu = new Menu("List"); //List Menu

            // List Menu Items
            MenuItem favorites = new MenuItem("Favorites List"); //Favorites List Item
            favorites.setOnAction(e -> window.setScene(favoritesScene));

            MenuItem wish = new MenuItem("WishList"); //WishList Item
            wish.setOnAction(e -> window.setScene(wishScene));

            listMenu.getItems().addAll(favorites, wish);

            // Home Menu Bar
            MenuBar menuBar = new MenuBar();
            menuBar.getMenus().addAll(pageMenu, listMenu);


            //Home Columns
            TableColumn<Book, String> titleColumn = new TableColumn<>("Book Title"); //Title Column
            titleColumn.setMinWidth(100);
            titleColumn.setPrefWidth(200);
            titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

            TableColumn<Book, String> authorColumn = new TableColumn<>("Author"); //Author Column
            authorColumn.setMinWidth(100);
            authorColumn.setPrefWidth(200);
            authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

            TableColumn<Book, String> genreColumn = new TableColumn<>("Genre(s)"); //Genre Column
            genreColumn.setMinWidth(100);
            genreColumn.setPrefWidth(200);
            genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));

            TableColumn<Book, Integer> yearColumn = new TableColumn<>("Year Published"); //Year Published Column
            yearColumn.setMinWidth(100);
            yearColumn.setPrefWidth(200);
            yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
            
            TableColumn<Book, String> ratingColumn = new TableColumn <>("Rating"); //Rating Column
            ratingColumn.setMinWidth(100);
            ratingColumn.setPrefWidth(200);
            ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

            TableColumn<Book, String> seriesColumn = new TableColumn<>("Series"); //Series Column
            seriesColumn.setMinWidth(100);
            seriesColumn.setPrefWidth(200);
            seriesColumn.setCellValueFactory(new PropertyValueFactory<>("series"));


            //Home Inputs
            titleInput = new TextField(); //Title Input
            titleInput.setPromptText("Book Title");
            titleInput.setMinWidth(100);

            authorInput = new TextField(); //Author Input
            authorInput.setPromptText("Author");
            authorInput.setMinWidth(100); // may remove later

            genreInput = new TextField(); //Genre Input
            genreInput.setPromptText("Genre(s)");
            genreInput.setMinWidth(100); // may remove later

            yearInput = new TextField(); //Year Published Input
            yearInput.setPromptText("Year Published");

            ratingInput = new TextField(); //Rating Input
            ratingInput.setPromptText("Rating");

            seriesInput = new TextField(); //Series Input
            seriesInput.setPromptText("Series (if applicable)");
            seriesInput.setMinWidth(100); // may remove later


            //Home Buttons
            Button addButton = new Button("Add"); //Add Button
            addButton.setOnAction(e -> addButtonClicked());

            Button deleteButton = new Button("Delete"); //Delete Button
            deleteButton.setOnAction(e -> deleteButtonClicked());


            // Home Layout
            HBox hb = new HBox(); //HBox Settings
            hb.setPadding(new Insets(10, 10, 10, 10));
            hb.setSpacing(10);
            hb.getChildren().addAll(titleInput, authorInput, genreInput, yearInput, ratingInput, seriesInput, addButton, deleteButton);

            table = new TableView<>(); //Table Settings
            table.setItems(getBook());
            table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            table.getColumns().addAll(titleColumn, authorColumn, genreColumn, yearColumn, ratingColumn, seriesColumn);

            VBox vb = new VBox(10); //VBox Settings
            vb.getChildren().addAll(menuBar,table, hb);





            // Library Scene



            //Library Menu
            Menu pageMenu2 = new Menu("Page"); //Page Menu

            // Page Menu Items
            MenuItem home2 = new MenuItem("Home"); // Home Item
            home2.setOnAction(e -> window.setScene(homeScene));

            MenuItem library2 = new MenuItem("Library List"); //Library List Item (Disabled)
            library2.setDisable(true);

            MenuItem lend2 = new MenuItem("Lend List"); //Lend List Item
            lend2.setOnAction(e -> window.setScene(lendScene));

            MenuItem exit2 = new MenuItem("Exit"); //Exit Item
            exit2.setOnAction(e -> closeProgram());

            pageMenu2.getItems().addAll(home2, library2, lend2, new SeparatorMenuItem(),exit2);

            Menu listMenu2 = new Menu("List"); //List Menu

            //List Menu Items
            MenuItem favorites2 = new MenuItem("Favorites List"); //Favorites List Item
            favorites2.setOnAction(e -> window.setScene(favoritesScene));

            MenuItem wish2 = new MenuItem("WishList"); //WishList Item
            wish2.setOnAction(e -> window.setScene(wishScene));

            listMenu2.getItems().addAll(favorites2, wish2);

            //Library Menu Bar
            MenuBar menuBar2 = new MenuBar();
            menuBar2.getMenus().addAll(pageMenu2, listMenu2);


            //Library Columns
            TableColumn<Library, String> rentTitleColumn = new TableColumn<>("Book Title"); //Rent Title Column
            rentTitleColumn.setMinWidth(100);
            rentTitleColumn.setPrefWidth(200);
            rentTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

            TableColumn<Library, String> rentAuthorColumn = new TableColumn<>("Author");//Rent Author Column
            rentAuthorColumn.setMinWidth(100);
            rentAuthorColumn.setPrefWidth(200);
            rentAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));


            TableColumn<Library, String> rentedColumn = new TableColumn<>("Library Rented From");//Rented Column
            rentedColumn.setMinWidth(100);
            rentedColumn.setPrefWidth(250);
            rentedColumn.setCellValueFactory(new PropertyValueFactory<>("rented"));

            TableColumn<Library, String> dueColumn = new TableColumn<>("Date Due Back");//Due Column
            dueColumn.setMinWidth(100);
            dueColumn.setPrefWidth(200);
            dueColumn.setCellValueFactory(new PropertyValueFactory<>("due"));

            
            //Library Inputs
            rentTitleInput = new TextField(); //Title Input
            rentTitleInput.setPromptText("Book Title");
            rentTitleInput.setMinWidth(100);

            rentAuthorInput = new TextField(); // Rent Author Input
            rentAuthorInput.setPromptText("Author");
            rentAuthorInput.setMinWidth(100); // may remove later

            rentedInput = new TextField(); //Rented Input
            rentedInput.setPromptText("Library Rented From");
            rentedInput.setMinWidth(100); // may remove later

            dueInput = new TextField(); //Due Input
            dueInput.setPromptText("Date Due Back");
            dueInput.setMinWidth(100); // may remove later


            //Library Buttons
            Button addButton2 = new Button("Add"); //Add Button
            addButton2.setOnAction(e -> addButtonClicked2());

            Button deleteButton2 = new Button("Delete"); //Delete Button
            deleteButton2.setOnAction(e -> deleteButtonClicked2());


            //Library Layout
            HBox hb2 = new HBox(); //HBox Settings
            hb2.setPadding(new Insets(10, 10, 10, 10));
            hb2.setSpacing(10);
            hb2.getChildren().addAll(rentTitleInput, rentAuthorInput, rentedInput, dueInput, addButton2, deleteButton2);

            rentTable = new TableView<>(); //Table Settings
            rentTable.setItems(getLibrary());
            rentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            rentTable.getColumns().addAll(rentTitleColumn, rentAuthorColumn, rentedColumn, dueColumn);

            VBox vb2 = new VBox(10); //VBox Settings
            vb2.getChildren().addAll(menuBar2,rentTable, hb2);

            libraryScene = new Scene(vb2); //Scene Settings
            libraryScene.getStylesheets().add("Style.css");





            // Lend Scene



            //Lend Menu
            Menu pageMenu3 = new Menu("Page"); //Page Menu

            // Page Menu Items
            MenuItem home3 = new MenuItem("Home"); //Home Item
            home3.setOnAction(e -> window.setScene(homeScene)); 

            MenuItem library3 = new MenuItem("Library List"); // Library List Item
            library3.setOnAction(e -> window.setScene(libraryScene));

            MenuItem lend3 = new MenuItem("Lend List"); // Lend List Item (Disabled)
            lend3.setDisable(true);

            MenuItem exit3 = new MenuItem("Exit"); //Exit Item
            exit3.setOnAction(e -> closeProgram());

            pageMenu3.getItems().addAll(home3, library3, lend3, new SeparatorMenuItem(), exit3);


            Menu listMenu3 = new Menu("List");//List Menu Items

            //List Menu Items
            MenuItem favorites3 = new MenuItem("Favorites List"); // Favorites List Item
            favorites3.setOnAction(e -> window.setScene(favoritesScene));

            MenuItem wish3 = new MenuItem("WishList"); //WishList Item
            wish3.setOnAction(e -> window.setScene(wishScene));

            listMenu3.getItems().addAll(favorites3, wish3);

            // Lend Menu Bar
            MenuBar menuBar3 = new MenuBar();
            menuBar3.getMenus().addAll(pageMenu3, listMenu3);


            //Lend Columns
            TableColumn<Lend, String> lendTitleColumn = new TableColumn<>("Book Title"); //Lend Title Column
            lendTitleColumn.setMinWidth(100);
            lendTitleColumn.setPrefWidth(225);
            lendTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
            
            TableColumn<Lend, String> personColumn = new TableColumn<>("Rented To"); //Person Column
            personColumn.setMinWidth(100);
            personColumn.setPrefWidth(225);
            personColumn.setCellValueFactory(new PropertyValueFactory<>("person"));
            
            TableColumn<Lend, String> lendedColumn = new TableColumn<>("Date Lended"); //Lended Column
            lendedColumn.setMinWidth(100);
            lendedColumn.setPrefWidth(200);
            lendedColumn.setCellValueFactory(new PropertyValueFactory<>("lended"));
            
            TableColumn<Lend, String> lendDueColumn = new TableColumn<>("Date Due Back"); //Lend Due Column
            lendDueColumn.setMinWidth(100);
            lendDueColumn.setPrefWidth(200);
            lendDueColumn.setCellValueFactory(new PropertyValueFactory<>("due"));


            // Lend Inputs
            lendTitleInput = new TextField(); //Due Title Input
            lendTitleInput.setPromptText("Book Title");
            lendTitleInput.setMinWidth(100);

            personInput = new TextField(); //Person Input
            personInput.setPromptText("Rented To");
            personInput.setMinWidth(100);

            lendedInput = new TextField(); //Lended Input
            lendedInput.setPromptText("Date Lended");
            lendedInput.setMinWidth(100);

            lendDueInput = new TextField(); //Lend Due Input
            lendDueInput.setPromptText("Date Due Back");
            lendDueInput.setMinWidth(100);


            //Lend Buttons
            Button addButton3 = new Button("Add"); //Add Button
            addButton3.setOnAction(e -> addButtonClicked3());

            Button deleteButton3 = new Button("Delete"); //Delete Button
            deleteButton3.setOnAction(e -> deleteButtonClicked3());

            // Lend Layout
            HBox hb3 = new HBox(); //HBox Settings
            hb3.setPadding(new Insets(10, 10, 10, 10));
            hb3.setSpacing(10);
            hb3.getChildren().addAll(lendTitleInput, personInput, lendedInput, lendDueInput, addButton3, deleteButton3);

            lendTable = new TableView<>(); //Table Settings
            lendTable.setItems(getLend());
            lendTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            lendTable.getColumns().addAll(lendTitleColumn, personColumn, lendedColumn, lendDueColumn);

            VBox vb3 = new VBox(10); //VBox Settings
            vb3.getChildren().addAll(menuBar3,lendTable, hb3);

            lendScene = new Scene(vb3); //Scene Settings
            lendScene.getStylesheets().add("Style.css");



            // Favorites Scene


            //Favorites Menu
            Menu pageMenu4 = new Menu("Page"); //Page Menu
            
            //Page Menu Items
            MenuItem home4 = new MenuItem("Home"); //Home Item
            home4.setOnAction(e -> window.setScene(homeScene)); 

            MenuItem library4 = new MenuItem("Library List"); //Library List Item
            library4.setOnAction(e -> window.setScene(libraryScene));

            MenuItem lend4 = new MenuItem("Lend List"); //Lend List Item
            lend4.setOnAction(e -> window.setScene(lendScene));

            MenuItem exit4 = new MenuItem("Exit"); //Exit Item
            exit4.setOnAction(e -> closeProgram());

            pageMenu4.getItems().addAll(home4, library4, lend4, new SeparatorMenuItem(),exit4);
 
            Menu listMenu4 = new Menu("List"); //List Menu

            MenuItem favorites4 = new MenuItem("Favorites List"); //Favorites List Item (Disabled)
            favorites4.setDisable(true);

            MenuItem wish4 = new MenuItem("WishList"); //WishList Item
            wish4.setOnAction(e -> window.setScene(wishScene));

            listMenu4.getItems().addAll(favorites4, wish4);
            
            //Favorites Menu Bar
            MenuBar menuBar4 = new MenuBar();
            menuBar4.getMenus().addAll(pageMenu4, listMenu4);


            //Favorites Columns
            TableColumn<Favorite, String> favoritesTitleColumn = new TableColumn<>("Book Title"); //Favorites Title Column
            favoritesTitleColumn.setMinWidth(100);
            favoritesTitleColumn.setPrefWidth(200);
            favoritesTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

            TableColumn<Favorite, String> favoritesAuthorColumn = new TableColumn<>("Author"); //Favoites Author Column
            favoritesAuthorColumn.setMinWidth(100);
            favoritesAuthorColumn.setPrefWidth(200);
            favoritesAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

            TableColumn<Favorite, String> favoritesGenreColumn = new TableColumn<>("Genre(s)"); //Genre Column
            favoritesGenreColumn.setMinWidth(100);
            favoritesGenreColumn.setPrefWidth(200);
            favoritesGenreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));

            TableColumn<Favorite, Integer> favoritesYearColumn = new TableColumn<>("Year Published"); //Year Published Column
            favoritesYearColumn.setMinWidth(100);
            favoritesYearColumn.setPrefWidth(200);
            favoritesYearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

            TableColumn<Favorite, String> favoritesSeriesColumn = new TableColumn<>("Series"); //Series Column
            favoritesSeriesColumn.setMinWidth(100);
            favoritesSeriesColumn.setPrefWidth(210);
            favoritesSeriesColumn.setCellValueFactory(new PropertyValueFactory<>("series"));


            //Favorites Inputs
            favoritesTitleInput = new TextField(); //Favorites Title Input
            favoritesTitleInput.setPromptText("Book Title");
            favoritesTitleInput.setMinWidth(100);

            favoritesAuthorInput = new TextField(); //Favorites Author Input
            favoritesAuthorInput.setPromptText("Author");
            favoritesAuthorInput.setMinWidth(100); // may remove later

            favoritesGenreInput = new TextField(); //Favorites Genre Input
            favoritesGenreInput.setPromptText("Genre(s)");
            favoritesGenreInput.setMinWidth(100); // may remove later

            favoritesYearInput = new TextField(); //Favorites Year Published Input
            favoritesYearInput.setPromptText("Year Published");

            favoritesSeriesInput = new TextField(); //Favorites Series Input
            favoritesSeriesInput.setPromptText("Series (if applicable)");//
            favoritesSeriesInput.setMinWidth(100); // may remove later


            //Favorites Buttons
            Button addButton4 = new Button("Add"); //Add Button
            addButton4.setOnAction(e -> addButtonClicked4());

            Button deleteButton4 = new Button("Delete"); //Delete Button
            deleteButton4.setOnAction(e -> deleteButtonClicked4());


            //Favorites Layout
            HBox hb4 = new HBox(); //HBox Settings
            hb4.setPadding(new Insets(10, 10, 10, 10));
            hb4.setSpacing(10);
            hb4.getChildren().addAll(favoritesTitleInput, favoritesAuthorInput, favoritesGenreInput, favoritesYearInput, favoritesSeriesInput, addButton4, deleteButton4);

            favoritesTable = new TableView<Favorite>(); //Table Settings
            favoritesTable.setItems(getFavorite());
            favoritesTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            favoritesTable.getColumns().addAll(favoritesTitleColumn, favoritesAuthorColumn, favoritesGenreColumn, favoritesYearColumn, favoritesSeriesColumn);

            VBox vb4 = new VBox(10); //VBox Settings
            vb4.getChildren().addAll(menuBar4,favoritesTable, hb4);

            favoritesScene = new Scene(vb4); //Scene Settings
            favoritesScene.getStylesheets().add("Style.css");





            // Wish Scene



            //Wish Menu
            Menu pageMenu5 = new Menu("Page"); //Page Menu

            // Page Menu Items
            MenuItem home5 = new MenuItem("Home"); //Home Item
            home5.setOnAction(e -> window.setScene(homeScene)); 

            MenuItem library5 = new MenuItem("Library List"); //Library List Item
            library5.setOnAction(e -> window.setScene(libraryScene));

            MenuItem lend5 = new MenuItem("Lend List"); //Lend List Item
            lend5.setOnAction(e -> window.setScene(lendScene));


            MenuItem exit5 = new MenuItem("Exit"); //Exit Item
            exit5.setOnAction(e -> closeProgram());

            pageMenu5.getItems().addAll(home5, library5, lend5, new SeparatorMenuItem(),exit5);

            Menu listMenu5 = new Menu("List"); //List Menu

            //List Menu Items
            MenuItem favorites5 = new MenuItem("Favorites List"); //Favorites List Item
            favorites5.setOnAction(e -> window.setScene(favoritesScene));

            MenuItem wish5 = new MenuItem("WishList"); //WishList Item (Disabled)
            wish5.setDisable(true);
            listMenu5.getItems().addAll(favorites5, wish5);
            
            // Wish Menu Bar
            MenuBar menuBar5 = new MenuBar();
            menuBar5.getMenus().addAll(pageMenu5, listMenu5);


            //Wish Columns
            TableColumn<Wish, String> wishTitleColumn = new TableColumn<>("Book Title"); //Wish Title Column
            wishTitleColumn.setMinWidth(100);
            wishTitleColumn.setPrefWidth(200);
            wishTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

            TableColumn<Wish, String> wishAuthorColumn = new TableColumn<>("Author"); //Wish Author Column
            wishAuthorColumn.setMinWidth(100);
            wishAuthorColumn.setPrefWidth(200);
            wishAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

            TableColumn<Wish, Double> costColumn = new TableColumn<>("Book Price"); //Cost Column
            costColumn.setMinWidth(100);
            costColumn.setPrefWidth(200);
            costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

            TableColumn<Wish, String> wishSeriesColumn = new TableColumn<>("Series"); //Wish Series Column
            wishSeriesColumn.setMinWidth(100);
            wishSeriesColumn.setPrefWidth(230);
            wishSeriesColumn.setCellValueFactory(new PropertyValueFactory<>("series"));


            //Wish Inputs
            wishTitleInput = new TextField(); //Wish Title Input
            wishTitleInput.setPromptText("Book Title");
            wishTitleInput.setMinWidth(100);

            wishAuthorInput = new TextField(); //Wish Author Input
            wishAuthorInput.setPromptText("Author");
            wishAuthorInput.setMinWidth(100); // may remove later

            costInput = new TextField(); //Cost Input
            costInput.setPromptText("Book Price");

            wishSeriesInput = new TextField(); //Wish Series Input
            wishSeriesInput.setPromptText("Series (if applicable)");
            wishSeriesInput.setMinWidth(100); // may remove later


            //Wish Buttons
            Button addButton5 = new Button("Add"); //Add Button
            addButton5.setOnAction(e -> addButtonClicked5());

            Button deleteButton5 = new Button("Delete"); //Delete Button
            deleteButton5.setOnAction(e -> deleteButtonClicked5());


            //Wish Layout
            HBox hb5 = new HBox(); //HBox Settings
            hb5.setPadding(new Insets(10, 10, 10, 10));
            hb5.setSpacing(10);
            hb5.getChildren().addAll(wishTitleInput, wishAuthorInput, costInput, wishSeriesInput, addButton5, deleteButton5);

            wishTable = new TableView<>(); //Table Settings
            wishTable.setItems(getWish());
            wishTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            wishTable.getColumns().addAll(wishTitleColumn, wishAuthorColumn, costColumn, wishSeriesColumn);

            VBox vb5 = new VBox(10); //VBox Settings
            vb5.getChildren().addAll(menuBar5, wishTable, hb5);

            wishScene = new Scene(vb5); //Scene Settings
            wishScene.getStylesheets().add("Style.css");




            //Set Scene
            homeScene = new Scene(vb);
            window.setScene(homeScene);
            homeScene.getStylesheets().add("Style.css");
            window.show();
    }

    //Add Button

    //When Add Button Clicked on Home
    public void addButtonClicked() {
        Book book = new Book();
        book.setTitle(titleInput.getText());
        book.setAuthor(authorInput.getText());
        book.setGenre(genreInput.getText());
        book.setYear(Integer.parseInt(yearInput.getText()));
        book.setRating(ratingInput.getText());
        book.setSeries(seriesInput.getText());
        table.getItems().add(book);
        titleInput.clear();
        authorInput.clear();
        genreInput.clear();
        yearInput.clear();
        ratingInput.clear();
        seriesInput.clear();
    }


    //When Add button clicked on Library
    public void addButtonClicked2() {
        Library book = new Library();
        book.setTitle(rentTitleInput.getText());
        book.setAuthor(rentAuthorInput.getText());
        book.setRented(rentedInput.getText());
        book.setDue(dueInput.getText());
        rentTable.getItems().add(book);
        rentTitleInput.clear();
        rentAuthorInput.clear();
        rentedInput.clear();
        dueInput.clear();
    }


    //When Add button clicked on Lend
    public void addButtonClicked3() {
        Lend book = new Lend();
        book.setTitle(lendTitleInput.getText());
        book.setPerson(personInput.getText());
        book.setLended(lendedInput.getText());
        book.setDue(lendDueInput.getText());
        lendTable.getItems().add(book);
        lendTitleInput.clear();
        personInput.clear();
        lendedInput.clear();
        lendDueInput.clear();
    }


    //When Add Button Clicked on Favorites
    public void addButtonClicked4() {
        Favorite book = new Favorite();
        book.setTitle(favoritesTitleInput.getText());
        book.setAuthor(favoritesAuthorInput.getText());
        book.setGenre(favoritesGenreInput.getText());
        book.setYear(Integer.parseInt(favoritesYearInput.getText()));
        book.setSeries(favoritesSeriesInput.getText());
        favoritesTable.getItems().add(book);
        favoritesTitleInput.clear();
        favoritesAuthorInput.clear();
        favoritesGenreInput.clear();
        favoritesYearInput.clear();
        favoritesSeriesInput.clear();
    }


    //When Add button clicked on wish
    public void addButtonClicked5() {
        Wish book = new Wish();
        book.setTitle(wishTitleInput.getText());
        book.setAuthor(wishAuthorInput.getText());
        book.setCost(Double.parseDouble(costInput.getText()));
        book.setSeries(wishSeriesInput.getText());
        wishTable.getItems().add(book);
        wishTitleInput.clear();
        wishAuthorInput.clear();
        costInput.clear();
        wishSeriesInput.clear();
    }



    //Delete Button 

    //When Delete Button Clicked on Home
    public void deleteButtonClicked() {
        ObservableList<Book> bookSelected, allBooks;
        allBooks = table.getItems();
        bookSelected = table.getSelectionModel().getSelectedItems();

        allBooks.removeAll(bookSelected);
    }


    //When Delete Button Clicked on Library
    public void deleteButtonClicked2() {
        ObservableList<Library> bookSelected, allBooks;
        allBooks = rentTable.getItems();
        bookSelected = rentTable.getSelectionModel().getSelectedItems();

        allBooks.removeAll(bookSelected);
    }


    //When Delete Button Clicked on Lend
    public void deleteButtonClicked3() {
        ObservableList<Lend> bookSelected, allBooks;
        allBooks = lendTable.getItems();
        bookSelected = lendTable.getSelectionModel().getSelectedItems();

        allBooks.removeAll(bookSelected);
    }


    //When Delete Button Clicked on Favorites
    public void deleteButtonClicked4() {
        ObservableList<Favorite> bookSelected, allBooks;
        allBooks = favoritesTable.getItems();
        bookSelected = favoritesTable.getSelectionModel().getSelectedItems();

        allBooks.removeAll(bookSelected);
    }


    //When Delete Button Clicked on Wish
    public void deleteButtonClicked5() {
        ObservableList<Wish> bookSelected, allBooks;
        allBooks = wishTable.getItems();
        bookSelected = wishTable.getSelectionModel().getSelectedItems();

        allBooks.removeAll(bookSelected);
    }



    // Get Info 

    //Get all of the Books on Home
    public ObservableList<Book> getBook() {
        ObservableList<Book> books = FXCollections.observableArrayList();
        books.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K Rowling", "Fantasy, Magic", 1997, "2/5", "Harry Potter Series"));
        books.add(new Book("The Fellowship of the Ring", "JRR Tolkien", "Fantasy", 1954, "4/5", "The Lord of the Rings"));
        books.add(new Book("Brave New World", "Aldous Huxlet", "Sci-FI, Dystopian", 1932, "4/5", "N/A"));
        books.add(new Book("Of Mice and Men", "John SteinBeck", "Fiction, Tradgedy, Novella", 1937, "2/5", "N/A"));
        books.add(new Book("The Historian", "Elizabeth Kostova", "Horror Fiction, Fantasy", 2005, "3/5", "The Historian Series"));
        return books;
    }


    //Get all of the Books on Library
    public ObservableList<Library> getLibrary() {
        ObservableList<Library> books = FXCollections.observableArrayList();
        books.add(new Library("Lord of the Flies", "William Golding", "Independence District Library", "Next Week"));
        books.add(new Library("Pride and Prejudice", "Jane Austen", "Independence District Library", "Next Week"));
        books.add(new Library("A Comprehensive Guide to Poetry", "X.J Kennedy, Dana Gioia", "Springfield Township Library", "05/31/23"));
        return books;
    }


    //Get all of the Books on Lend
    public ObservableList<Lend> getLend() {
        ObservableList<Lend> books = FXCollections.observableArrayList();
        books.add(new Lend("SPYXFAMILY Vol.1", "Aunt Jennie", "02/12/23", "Next Week"));
        books.add(new Lend("The Hunger Games", "Timmy", "Last Christmas", "This Christmas"));
        return books;
    }


    //Get all of the Books on Favorites
    public ObservableList<Favorite> getFavorite() {
        ObservableList<Favorite> books = FXCollections.observableArrayList();
        books.add(new Favorite("Brave New World", "Aldous Huxlet", "Sci-FI, Dystopian", 1932, "N/A"));
        books.add(new Favorite("SPYXFAMILY Vol.1", "Tatsuya Endo", "Manga, Action", 2019, "SPYXFAMILY"));
        books.add(new Favorite("A Comprehensive Guide to Poetry", "X.J Kennedy, Dana Gioia", "Non-Fiction, Analysis", 1998, "Ninth Edition Revision"));
        return books;
    }


    //Get all of the Books on Wish
    public ObservableList<Wish> getWish() {
        ObservableList<Wish> books = FXCollections.observableArrayList();
        books.add(new Wish("How to Cook Well", "Jim Bob", 17.99, "N/A"));
        return books;
    }

    // Close Program
    private void closeProgram() {
        Boolean answer = ExitBox.display("Exit Program", "Are you sure you would like to close the program?");
        if(answer)
            window.close();
    }



}






