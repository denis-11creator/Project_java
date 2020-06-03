package entity;


/**
 * UnknownModelException
 *
 * Raises an 'UnknownSpriteException' exception.
 * Given the exception message.
 *  @author      Denis Destin 
 * @since       2020-05-22
 */
public class UnknownModelException extends Exception {
	/**
	 * Class constructor
	 *
	 * @param  message  Exception backtrace message
	 */
	public UnknownModelException(String message) {
		super(message);
	}
}
