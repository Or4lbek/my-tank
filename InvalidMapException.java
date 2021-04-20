

class InvalidMapException extends Throwable
{
    private String message;

    public InvalidMapException(String some_message)
    {
        this.message = some_message;
    }

    public String getMessage()
    {
        return message;
    }
}