package controller.model.members;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilias on 4/18/2016.
 */
public class PersonKeeper implements Component {

    private List<Member> listOfLeaders;

    public PersonKeeper(List<Member> listOfLeaders) {
        this.listOfLeaders = listOfLeaders;
    }

    public List<Member> getListOfChild(Leader leader){
        return leader.getListOfChilds();
    }

    public Member searchLeaderByName(String name, String lastName){
        for(Member c : listOfLeaders){
            Leader l = (Leader) c;
            if(name.equals(l.getFirstName()) && lastName.equals(l.getLastName())){
                return l;
            }
        }
        return null;
    }

    @Override
    public void Add(Member c) {
        listOfLeaders.add(c);
    }

    @Override
    public void Remove(Member c) {
        listOfLeaders.add(c);
    }
}
