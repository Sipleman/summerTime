package controller.model.members;

import java.util.List;

/**
 * Created by Ilias on 4/18/2016.
 */
public class Leader extends  Member implements Component{

    String squad;

    public List<Member> listOfChilds;

    public Leader(String firstName, String lastName, String adres, int postalCode, String phoneNumber,
                  String parentPhoneNumber, String birthday, String squad) {
        super(firstName, lastName, adres, postalCode, phoneNumber, parentPhoneNumber, birthday);
        this.squad = squad;
    }

    @Override
    public void Add(Member c) {
        listOfChilds.add(c);
    }
    @Override
    public void Remove(Member c) {
        listOfChilds.remove(c);
    }

    public List<Member> getListOfChilds(){
        return listOfChilds;
    }


}
