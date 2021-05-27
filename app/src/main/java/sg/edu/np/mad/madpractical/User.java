package sg.edu.np.mad.madpractical;

public class User {

    public String name;
    public String description;
    public int id;
    public boolean followed;



    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Boolean getFollowed(){
        return followed;
    }

    public int getId(){
        return id;
    }

    public void setId(int id) {   this.id = id;    }

    public void setDescription(String description) {   this.description = description;    }

    public void setFollowed(Boolean followed) {    this.followed = followed;  }
    public void setName(String name) {    this.name = name;  }




    public String toString() {
        return new StringBuilder()
                .append(name).append("\t")
                .append(description).append("\t")
                .append(id).append("\t")
                .append(followed).toString();
    }
}


