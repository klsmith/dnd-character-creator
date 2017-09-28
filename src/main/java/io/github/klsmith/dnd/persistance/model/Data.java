package io.github.klsmith.dnd.persistance.model;

import java.util.Objects;
import java.util.Optional;

import io.github.klsmith.dnd.util.Copyable;

public final class Data<T> implements Copyable<Data<T>> {

	private final T data;
	private final Class<T> type;

	private Data(T data, Class<T> type) {
		this.data = data;
		this.type = type;
	}

	public static <T> Data<T> get(T data, Class<T> type) {
		Objects.requireNonNull(data);
		Objects.requireNonNull(type);
		return new Data<>(data, type);
	}

	public T getData() {
		return data;
	}

	public Class<T> getType() {
		return type;
	}

	@Override
	public Data<T> getCopy() {
		final Optional<Copyable<?>> copyableData = getCopyableData();
		if (copyableData.isPresent()) {
			final Object obj = copyableData.get().getCopy();
			if (isCorrectType(obj)) {
				return get(type.cast(obj), type);
			}
		}
		return this;
	}

	private Optional<Copyable<?>> getCopyableData() {
		if (isDataCopyable()) {
			return Optional.of((Copyable<?>) data);
		}
		return Optional.empty();
	}

	private boolean isDataCopyable() {
		return Copyable.class.isInstance(data.getClass());
	}

	private boolean isCorrectType(Object obj) {
		return type.isInstance(obj.getClass());
	}
}
