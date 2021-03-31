package com.chaoyue.java;

/**
 * @author chaoyue
 * @data2021-03-31 19:47
 */
public class
EqualsOverride {

}
class User{
    String name;
    int age;

    public boolean equals(Object obj){
        if (obj == this){
            return true;
        }
        if (obj instanceof User){
            User user = (User)obj;
            return this.age == user.age && this.name.equals(user.name);
        }
        return false;
    }
}
