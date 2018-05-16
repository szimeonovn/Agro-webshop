package hu.unideb.inf.web.rest.controllers.rest.response;

/**
 * This class gives information about the user.
 */

public class UserResponse {
    private String key;
    private String value;

    /**
     * Represents a key value pair.
     *
     * @param key   the key
     * @param value the value
     */
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
     * Returns the key.
     *
     * @return the key
     */
    public String getValue() {

        return value;
    }

    /**
     * Sets the value of the key.
     *
     * @param value sets the value of the key
     */
    public void setValue(String value) {

        this.value = value;
    }
}
