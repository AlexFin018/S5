package Common;

/**
 * Класс для выброса ошибки при указании некорректной позиции
 */
public class InvalidPositionException extends RuntimeException{
    public InvalidPositionException(){
        super("Некорректная позиция!");
    }
}
