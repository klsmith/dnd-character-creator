package io.github.klsmith.dnd.serialization;

import java.util.Optional;

import com.google.gson.Gson;

/**
 * A Serializer that handles serialization and deserialization between Objects
 * and JSON.<br/>
 * <br/>
 * <strong>This implementation is thread safe.</strong>
 * 
 * @author Kooper Smith
 */
public class JsonSerializer implements Serializer<String> {

	private static final JsonSerializer INSTANCE = new JsonSerializer();

	private final Gson gson;

	private JsonSerializer() {
		this.gson = new Gson();
	}

	public static JsonSerializer get() {
		return INSTANCE;
	}

	@Override
	public String serialize(Object obj) {
		return gson.toJson(obj);
	}

	@Override
	public <T> Optional<T> deserialize(String json, Class<T> type) {
		return Optional.ofNullable(gson.fromJson(json, type));
	}

	@Override
	public byte[] serializeBytes(Object obj) {
		return serialize(obj).getBytes();
	}

	@Override
	public <T> Optional<T> deserializeBytes(byte[] data, Class<T> type) {
		return deserialize(new String(data), type);
	}

}
