package io.github.klsmith.dnd.serialization;

/**
 * An interface representing the generic ability to serialize Objects to and
 * from Strings. <br/>
 * <br/>
 * <strong>Classes that implement this interface must be thread safe.</strong>
 * 
 * @param DATA
 *            is the type to serialize the data to.
 * 
 * @author Kooper Smith
 */
public interface Serializer<DATA> {

    /**
     * Serialize any Object into a DATA representation.
     * 
     * @param obj
     *            the Object to serialize.
     * @return a DATA representation of the Object.
     */
    DATA serialize(Object obj);

    /**
     * Deserialize DATA into an Object of the given TYPE.
     * 
     * @param data
     *            the DATA to deserialize.
     * @param type
     *            the Class object used to denote the TYPE that should be
     *            created.
     * @return an Object of TYPE representing the DATA.
     */
    <TYPE> TYPE deserialize(DATA data, Class<TYPE> type);

    /**
     * Serialize any Object into a byte array.
     * 
     * @param obj
     *            the Object to serialize.
     * @return a byte array representation of the Object.
     */
    byte[] serializeBytes(Object obj);

    /**
     * Deserialize a byte array into an Object of the given TYPE.
     * 
     * @param data
     *            the byte array to deserialize.
     * @param type
     *            the Class object used to denote the TYPE that should be
     *            created.
     * @return an Object of TYPE representing the byte array data.
     */
    <TYPE> TYPE deserializeBytes(byte[] data, Class<TYPE> type);

}
