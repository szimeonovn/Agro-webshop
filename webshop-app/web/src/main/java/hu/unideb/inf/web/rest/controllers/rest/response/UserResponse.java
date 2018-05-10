package hu.unideb.inf.web.rest.controllers.rest.response;

/**
 * This class gives information about the user.
 */

public class UserResponse {
    private String key;
    private String value;

    public UserResponse(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns a key.
     *
     * @return the set key
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the key as parameter.
     *
     * @param key key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Returns the value of the key.
     *
     * @return the set value
     */
    public String getValue() {

        return value;
    }

    /**
     * Sets the parameter value.
     *
     * @param value sets the value of the key
     */
    public void setValue(String value) {

        this.value = value;
    }
}
