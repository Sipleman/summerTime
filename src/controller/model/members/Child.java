package controller.model.members;

/**
 * Created by Ilias on 08.03.2016.
 */
public class Child extends Member{

    private String squad;

    public String getSquad() {
        return squad;
    }

    public void setSquad(String squad) {
        this.squad = squad;
    }

    public Child(){
        this(null,null,null,0,null,null,null,null);
    }

    public Child(String firstName, String lastName, String adres, int postalCode, String phoneNumber,
                 String parentPhoneNumber, String birthday, String squad){
        super(firstName,  lastName,  adres,  postalCode,  phoneNumber,
                 parentPhoneNumber,  birthday);
    }

    @Override
    public void Add(Member newMember) {
    }

    @Override
    public void Remove(Member member) {
    }
}
