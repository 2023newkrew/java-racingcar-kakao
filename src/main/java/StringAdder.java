public class StringAdder {
    public int add(String text) {
        int number = -1;
        if(isNullOrBlank(text))
            return 0;
        try{
            number = Integer.parseInt(text);
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
            throw e;
        }
        return number;
    }

    public boolean isNullOrBlank(String text){
        return text == null || text.isBlank();
    }


    public String[] split(String text) {
        return text.split(",|;");
    }
}
