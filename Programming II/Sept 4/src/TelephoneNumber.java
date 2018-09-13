public class TelephoneNumber {
    //region Variables
    int area;
    //endregion
    //region Constructors
    public TelephoneNumber(int area, int exchange, int extension){

    }

    public TelephoneNumber(int area, int number){

    }

    public TelephoneNumber(String number){

    }
    //endregion

    public boolean isTollFree(){
        switch(area){
            case 800:
            case 866:
            case 877:
            case 880:
            case 881:
            case 882:
            case 888:
                return true;
            default: return false;
        }

    }
}
