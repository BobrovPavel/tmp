package Commons;

public class Constants {

    public static final String VALID_LOGIN = "Raindropslolzz";
    public static final String VALID_PASSWORD = "winda7";
    public static final String INVALID_LOGIN = "R1a2i3n4d5r6o7p8s9l0olzz";
    public static final String INVALID_PHONE_NUMBER = "+123123123123";
    public static final String INVALID_PASSWORD = "123qwe";
    public static final String TEXT_NO_LOHIN_ERROR = "Логин не указан";
    public static final String TEXT_NO_PASSWORD_ERROR = "Пароль не указан";
    public static final String TEXT_INVALID_PASSWORD_ERROR = "Неверный пароль";
    public static final String TEXT_NO_SOUCH_ACCOUNT_ERROR = "Такого аккаунта нет";

    public static final String RECENT_TAB_URL = "https://disk.yandex.ru/client/recent";
    public static final String FILE_TAB_URL = "https://disk.yandex.ru/client/disk";
    public static final String PHOTO_TAB_URL = "https://disk.yandex.ru/client/photo";
    public static final String HISTORY_TAB_URL = "https://disk.yandex.ru/client/journal";
    public static final String ARCHIVE_TAB_URL = "https://disk.yandex.ru/client/mail";
    public static final String TRASH_TAB_URL = "https://disk.yandex.ru/client/trash";
    public static final String SHARED_TAB_URL = "https://disk.yandex.ru/client/shared";
    public static final String PUBLISHED_TAB_URL = "https://disk.yandex.ru/client/published";

    public static final String DOCK_TEXT = "SomeTextHere";
    public static final String DOCK_NAME = "Hello World!";
    public static final String DOCK_FILE_NAME = "Hello World!.docx";
    public static final String DOCK_STATUS_SAVE = "Сохранение...";

    public static String getUriveTabsUrl(String tabName) {
        return "https://disk.yandex.ru/client/"+tabName;
    }
}
