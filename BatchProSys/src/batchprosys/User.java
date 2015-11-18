
package batchprosys;

public class User {
    private String  username;
    private String userID;
    private String password;
    private String userType;
    private String section;
    private String initialusername;
    private String initialpassword;
    private int availability=0;
    
    

    public void setUsername(String username) {
        this.username = username;
        //System.out.println(username);
    }
    public String getUsername() {
        //return username;
        //System.out.println(this.username);
        return this.username;
    }
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return the section
     */
    public String getSection() {
        return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(String section) {
        this.section = section;
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
        //return 0;
    }
    public String getInitialUsername() {
        return initialusername;
    }

    
    public void setInitialUsername(String initialusername) {
        this.initialusername = initialusername;
    }
    
    public String getInitialPassword() {
        return initialpassword;
    }

    
    public void setInitialPassword(String initialpassword) {
        this.initialpassword = initialpassword;
    }
}
