package sg.edu.np.mad.madpractical;

import java.util.ArrayList;

public class UserListSingleton
{
    private static UserListSingleton uList;

    public static ArrayList<User> UserList = new ArrayList<User>();

    public static UserListSingleton getInstance()
    {
        if(uList == null){
            uList = new UserListSingleton();
        }

        return uList;

    }
}