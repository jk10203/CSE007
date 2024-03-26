
/* Joy Kim
November 7, 2022
CSE007 Fall 2022 Participation 12
JDK 11 */
/*This program is intended to create objects of types of TV shows that extend beyond a local scope
 * by using the modifiers public and private and establishing a class.
*/

// modify to private / getters setters

//java machine looks for "main" and it doesn't have so will not print anything
public class TVShow { //creates object of type TV show
    // class names should start with upper case but variables should be lowercased
    // data fields
    private String name; //class variables - scope is any method in the class
    private String network; //have/should hve modifiers on them 
    private int length;
    //public - visible outside of class
    //private - only visible within the class
    //not static - instance(?) 
    //call to constructor preceded by operator
    
    //modified part (11/9)
    private String stream;
    private String genre;
    private double avgLength;
    private int episodes = 0;
    private static int shows = 0; //number of TVSHOWS objects
    
    public int getEpisodes(){
        return episodes;
    }
    public static int getShows(){ //static - only one copy and relates to entire class
        return shows;
    }
    public String getGenre(){
        return genre;
    }
    public String getStream(){
        return stream;
    }
    public double getAvgLength(){
        return avgLength;
    }
    public String getName(){
        return name;
    }
    public String getNetwork(){
        return network;
    }
    public int getLength(){
        return length;
    }
    public void setEpisodes(int x){ 
        this.episodes = x;
    }   
    public static void setShows(int shows){ 
        //wtf is goin on here
    }        
    public void setGenre(String genre){ 
        this.genre = genre;
    }   
    public void setStream(String stream){ 
        this.stream = stream;
    }   
    public void setAvgLength(int len){ 
        this.avgLength= len;
    }   
    public void setName(String name){ 
        this.name = name;
    }   
    public void setNetwork(String network){ 
        this.network = network;
    }   
    public void setLength(int length){ 
        this.length = length;
    }   


    public TVShow(String name, String stream, String genre, double avgLength){
        this.name = name;
        this.stream = stream;
        this.genre = genre;
        this.avgLength = avgLength;
        
        shows++;
    }

    //created class to define object
    // methods/behaviors
    /** Construct a new default TV show. */
    public TVShow() {
    name = "n/a";
    network = "n/a";
    avgLength = 0; //used to be length = 0;
    shows++;
    }

    public void airEpisodes(){
        episodes++;
    }
    public void airEpisodes(int episodes){
        this.episodes += episodes;
        //if you didn't use episodes as parameter - don't have to use this.
    }

    public double getTotalAirtime(){
        //OR
        //temp = episodes*avgLength;
        //return temp;
        return episodes * avgLength;
    }

    /* (not part of 11/7 participation) 
    * Construct a new TV show with given name, channel,
   and length. */
    /*public TVShow(String aName, String aNetwork, int aLength) {
    name = aName;
    network = aNetwork;
    length = aLength;
    }*/

    /* Return the length of the show in hours. */
    public double getHours() {
    return length / 60.0;
    }

    public void printShow(){
        //print out length and network in formatted way
        System.out.println("TVShow: " + name);
        System.out.println("\tNetwork: " + network);
        System.out.println("\tLength (in mins): " + length);
    }
   }

   
