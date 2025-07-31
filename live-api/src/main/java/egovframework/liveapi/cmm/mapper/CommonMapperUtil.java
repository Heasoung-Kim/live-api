package egovframework.liveapi.cmm.mapper;

import org.bson.types.ObjectId;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
public class CommonMapperUtil {

    @Named("objectIdToString")
    public static String objectIdToString(ObjectId objectId) {
        return objectId != null ? objectId.toHexString() : null;
    }

    @Named("stringToObjectId")
    public static ObjectId stringToObjectId(String id) {
        return (id != null && ObjectId.isValid(id)) ? new ObjectId(id) : null;
    }

    @Named("objectIdToObjectId")
    public static ObjectId objectIdToObjectId(ObjectId id) {
        return id == null ? null : new ObjectId(id.toHexString());
    }
}