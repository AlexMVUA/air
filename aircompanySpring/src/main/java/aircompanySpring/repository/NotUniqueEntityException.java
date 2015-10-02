package aircompanySpring.repository;

@SuppressWarnings("serial")
public class NotUniqueEntityException extends Exception {
	
	public NotUniqueEntityException() {		
	}
	
    public NotUniqueEntityException(String message)
    {
       super(message);
    }
}
