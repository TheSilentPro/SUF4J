package tsp.suf4j;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import javax.annotation.Nullable;
import java.lang.reflect.Type;
import java.util.function.Function;

public class JsonMapper<T> implements JsonSerializer<T>, JsonDeserializer<T> {

    private Function<T, JsonElement> serializeFunction;
    private Function<JsonElement, T> deserializeFunction;

    public JsonMapper(@Nullable Function<T, JsonElement> serializeFunction, @Nullable Function<JsonElement, T> deserializeFunction) {
        this.serializeFunction = serializeFunction;
        this.deserializeFunction = deserializeFunction;
    }

    public JsonMapper(@Nullable Function<T, JsonElement> serializeFunction) {
        this(serializeFunction, null);
    }

    public JsonMapper() {}

    @Override
    public JsonElement serialize(T src, Type type, JsonSerializationContext context) {
        if (serializeFunction == null) {
            throw new UnsupportedOperationException("Serialization has not been implemented!");
        } else {
            return serializeFunction.apply(src);
        }
    }


    @Override
    public T deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        if (deserializeFunction == null) {
            throw new UnsupportedOperationException("Deserialization has not been implemented!");
        } else {
            return deserializeFunction.apply(json);
        }
    }

    @Nullable
    public Function<T, JsonElement> getSerializeFunction() {
        return serializeFunction;
    }

    @Nullable
    public Function<JsonElement, T> getDeserializeFunction() {
        return deserializeFunction;
    }

    public void setSerializeFunction(@Nullable Function<T, JsonElement> serializeFunction) {
        this.serializeFunction = serializeFunction;
    }

    public void setDeserializeFunction(@Nullable Function<JsonElement, T> deserializeFunction) {
        this.deserializeFunction = deserializeFunction;
    }

}