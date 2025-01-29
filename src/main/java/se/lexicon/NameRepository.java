package se.lexicon;

import java.util.Arrays;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0]; // element format should be ["firstName lastName", "firstName lastName"]


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param names The array of names to set.
     */
    public static void setNames(final String[] names) {
        NameRepository.names = names;
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        NameRepository.names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        String[] newNames = new String[NameRepository.names.length];
        for (int i = 0; i < newNames.length; i++) {
            newNames[i] = NameRepository.names[i];
        }
        return newNames;
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(final String fullName) {

        for (int i = 0; i < NameRepository.names.length; i++) {
            if (NameRepository.names[i].equalsIgnoreCase(fullName)) {
                return NameRepository.names[i];
            }
        }
        return null;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(final String fullName) {
        if (NameRepository.find(fullName) == null) {
            String[] newNames = new String[NameRepository.names.length + 1];
            for (int i = 0; i < NameRepository.names.length; i++) {
                newNames[i] = NameRepository.names[i];
            }
            newNames[newNames.length - 1] = fullName;
            NameRepository.names = newNames;
            return true;
        }
        return false;
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(final String firstName) {
        String[] result = new String[0];
        for (int i = 0; i < NameRepository.names.length; i++) {
            if (NameRepository.names[i].substring(0, NameRepository.names[i].indexOf(" ")).equalsIgnoreCase(firstName)) {
                // System.arraycopy(result, 0, result, result.length+1, result.length+1);
                result = Arrays.copyOf(result,result.length + 1);
                result[result.length-1]=NameRepository.names[i];

            }
        }
        return result;
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(final String lastName) {
        String[] result = new String[0];
        for (int i = 0; i < NameRepository.names.length; i++) {
            if (NameRepository.names[i].substring(NameRepository.names[i].indexOf(" ")+1).equalsIgnoreCase(lastName)) {
                result = Arrays.copyOf(result,result.length + 1);
                result[result.length-1]=NameRepository.names[i];
            }
        }
        return result;
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(final String original, final String updatedName) {
        for (int i = 0; i < NameRepository.names.length; i++) {
            if (NameRepository.names[i].equalsIgnoreCase(original)) {
              NameRepository.names[i]=updatedName;
                return true;
            }
        }
        return false;
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(final String fullName) {
        int index = -1;
        for (int i = 0; i < NameRepository.names.length; i++) {
            if (NameRepository.names[i].equalsIgnoreCase(fullName)) {
                System.out.println("ind" + i);
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        String[] temp = new String[names.length - 1];
        System.arraycopy(names, 0, temp, 0, index);
        System.arraycopy(names, +1, temp, index, names.length - index - 1);
        NameRepository.names = temp;

        return true;

    }


}