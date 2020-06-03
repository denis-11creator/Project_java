package entity;


/**
 * ModelNotReadyException
 *
 * Raises an 'ModelNotReadyException' exception.
 * Given the exception message.
 * @author      Denis Destin 
 * @since       2020-05-22
 */
public class ModelNotReadyException extends Exception {
    /**
     * Class constructor
     *
     * @param  message  Exception backtrace message
     */
    public ModelNotReadyException(String message) {
        super(message);
    }
}
