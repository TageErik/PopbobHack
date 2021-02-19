package popbobhack.mods;

import net.minecraft.src.Minecraft;
import popbobhack.config.Config;
import popbobhack.main.Category;

public class CustomBook extends Module{

	public CustomBook() {
		super("CustomBook", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}
	public static String TotallyLegitAuthorName = "popbob";
	public static String TotallyLegitTitle = "jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks jared sucks ";
	public static String[] BookList = new String[2];
	public static int BookListLength;
	
	public static void SetListToTxt() {
		BookListLength = Config.SetListToTxt(BookList, BookListLength, "/PopbobHack/CustomBook.txt");
		BookListLength = 2;
		try {
		TotallyLegitAuthorName = BookList[0].substring(8);
		TotallyLegitTitle = BookList[1].substring(7);
		}catch(Exception e) {}
	}
	
	public static void onListUpdated() {
		BookList[0] = "Author:" + TotallyLegitAuthorName;
		BookList[1] = "Title:" + TotallyLegitTitle;
		Config.onListUpdated(BookList, BookListLength, "/PopbobHack/CustomBook.txt");
	}

}
