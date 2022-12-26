public class StringAdder {
    public int add(String text) {
        int number = -1;
        try{
            number = Integer.parseInt(text);
        }
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }
        return number;


    }
}
