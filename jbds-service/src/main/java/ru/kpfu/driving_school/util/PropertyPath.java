package ru.kpfu.driving_school.util;

/**
 * Created by etovladislav on 04.04.16.
 */
public final class PropertyPath {

    //Имя папки, где будут хранится картинки вопросов
    public static String questionImageDir;

    //Корневая директория хранения файлов, загружаемых на сервер, задается в applications.properties
    public static String userDirectory;

    public void setQuestionImageDir(String questionImageDir) {
        PropertyPath.questionImageDir = questionImageDir;
    }

    public void setUserDirectory(String userDirectory) {
        this.userDirectory = userDirectory;
    }
}
