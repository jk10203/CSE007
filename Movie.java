public abstract class Movie {
    private String title;
    private String rating;
    private double length;
    private static int numMovies = 0;

    protected Movie(String title, String rating, double length){ //protected because abstract class
        this.title = title; //relating parameters to the class members above
        this.rating = rating;
        this.length = length;
        numMovies++; //increments to keep track of movies
    }
    //getters/setters
    public String getTitle(){//getter for title
        return title;
    }
    public String getRating(){//getter for Rating
        return rating;
    }
    public double getLength(){//getter for Length
        return length;
    }
    public void setTitle(String title){ //set title
        this.title = title;
    }
    public void setRating(String rating){//set rating
        this.rating= rating;
    }
    public void setLength(double length){ //set length
        this.length = length;
    }
    public double getNumMovies(){
        return numMovies;
    }

    public abstract String getType();
    
    public String toString(){ //string formatting so it is readable
        return "Title: " + getTitle() + "; rating: " + getRating() + "; Length: " + getLength() + "; type: " + getType();
    } 

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Movie){  //if obj found, cast as Movie
            Movie f = (Movie) obj;
            return f.getTitle().equals(title);
        }
        return false; //if not found then false
    }
    /*Include a block comment explaining what the purpose of the 
    instanceof command is, and how it is used within the equals method 
    that was overridden in Movie. 
    
    the purpose of the instanceof command is to make sure that whatever object is put into the 
    equals() is under the jurisdiction/scope of the Movie class. This makes sure that when comparing two things,
    it can be done within the movie program and its children/subclasses. Because the original object class does not extend 
    over the movie parent class and its children / subclasses.
    */


}
